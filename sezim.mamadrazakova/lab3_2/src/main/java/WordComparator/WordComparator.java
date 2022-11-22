package WordComparator;

import org.example.Word;

public class WordComparator implements java.util.Comparator<Word> {

    public int compare(Word w1, Word w2) {
        return (w1.getLengthOfWord() < w2.getLengthOfWord() ? 1 : -1);
    }

}
