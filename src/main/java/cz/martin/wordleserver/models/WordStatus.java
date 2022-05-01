package cz.martin.wordleserver.models;

public class WordStatus {
    private boolean isWinnerWord;
    private boolean isValidWord;
    private LetterStatus[] letterStatuses;

    public WordStatus(boolean isWinnerWord, boolean isValidWord, LetterStatus[] letterStatuses) {
        this.isWinnerWord = isWinnerWord;
        this.isValidWord = isValidWord;
        this.letterStatuses = letterStatuses;
    }

    public boolean isWinnerWord() {
        return isWinnerWord;
    }

    public boolean isValidWord() {
        return isValidWord;
    }

    public LetterStatus[] getLetterStatuses() {
        return letterStatuses;
    }
}

