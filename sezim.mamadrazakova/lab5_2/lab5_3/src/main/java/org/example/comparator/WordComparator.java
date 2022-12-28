package org.example.comparator;

import org.example.entity.Word;

public class WordComparator implements java.util.Comparator<Word> {
    public int compare(Word w1, Word w2) {
        if (w1.getLengthOfWord() - w2.getLengthOfWord() > 0) {
            return 1;
        } else if (w1.getLengthOfWord() - w2.getLengthOfWord() < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
