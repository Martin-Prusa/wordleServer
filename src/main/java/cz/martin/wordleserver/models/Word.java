package cz.martin.wordleserver.models;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Word {

    @NotEmpty
    @NotNull
    @Length(min = 5, max = 5)
    private String value;

    public Word() {
    }

    public Word(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
