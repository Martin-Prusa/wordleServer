package cz.martin.wordleserver.services;

import cz.martin.wordleserver.data.WordsLoader;
import cz.martin.wordleserver.interfaces.IWordsService;
import cz.martin.wordleserver.models.ActiveWord;
import cz.martin.wordleserver.models.LetterStatus;
import cz.martin.wordleserver.models.Word;
import cz.martin.wordleserver.models.WordStatus;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class WordsService implements IWordsService {

    private List<String> words;
    private ActiveWord activeWord;

    public WordsService() {
        words = Arrays.asList(new WordsLoader().loadWords());
        selectNewWord();
    }

    @Override
    public void selectNewWord() {
        activeWord = new ActiveWord(words.get(new Random().nextInt(words.size())));
    }

    @Override
    public ActiveWord getWord() {
        return activeWord;
    }

    @Override
    public WordStatus getWordStatus(Word word) {
        String value = word.getValue().toLowerCase().trim();
        if(!words.contains(value)) return new WordStatus(false, false, null);
        char[] letters = value.toCharArray();
        LetterStatus[] statuses = new LetterStatus[value.length()];
        for (int i = 0; i < letters.length; i++) {
            if(activeWord.getWord().charAt(i) == letters[i]) statuses[i] = LetterStatus.Correct;
            else if(activeWord.getWord().contains(letters[i]+"")) statuses[i] = LetterStatus.BadPosition;
            else statuses[i] = LetterStatus.None;
        }

        for (int i = 0; i < statuses.length; i++) {
            if(statuses[i] == LetterStatus.BadPosition) {
                boolean valid = false;
                for (int index = activeWord.getWord().indexOf(value.charAt(i)); index >= 0; index = activeWord.getWord().indexOf(value.charAt(i), index + 1)) {
                    if(statuses[index] != LetterStatus.Correct) {
                        valid = true;
                        break;
                    }
                }
                if(!valid) statuses[i] = LetterStatus.None;
            }
        }

        if(value.equals(activeWord.getWord())) return new WordStatus(true, true, statuses);
        return new WordStatus(false, true, statuses);
    }
}
