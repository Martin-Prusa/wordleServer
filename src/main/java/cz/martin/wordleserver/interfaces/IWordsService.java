package cz.martin.wordleserver.interfaces;

import cz.martin.wordleserver.models.ActiveWord;
import cz.martin.wordleserver.models.Word;
import cz.martin.wordleserver.models.WordStatus;

public interface IWordsService {
    void selectNewWord();
    ActiveWord getWord();
    WordStatus getWordStatus(Word word);
}
