package cz.martin.wordleserver.models;

import java.time.LocalDateTime;

public class ActiveWord {
    private String word;
    private LocalDateTime selectedAt;

    public ActiveWord(String word) {
        this.word = word;
        this.selectedAt = LocalDateTime.now();
    }

    public String getWord() {
        return word;
    }

    public LocalDateTime getSelectedAt() {
        return selectedAt;
    }
}
