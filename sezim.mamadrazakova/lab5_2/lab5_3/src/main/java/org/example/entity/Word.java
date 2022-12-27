package org.example.entity;

import java.util.Objects;

public class Word {
    private final String word;
    private final int lengthOfWord;

    public Word(String word, int lengthOfWord) {
        this.word = word;
        this.lengthOfWord = lengthOfWord;
    }

    public String getWord() {
        return word;
    }

    public int getLengthOfWord() {
        return lengthOfWord;
    }

    @Override
    public String toString() {
        return "word{ " + word +
                ",length " + lengthOfWord +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word1 = (Word) o;
        return getLengthOfWord() == word1.getLengthOfWord() && getWord().equals(word1.getWord());
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, lengthOfWord);
    }

}
