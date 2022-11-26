package org.example;

import WordComparator.WordComparator;

import java.util.*;


public abstract class WorkWithText implements java.util.Comparator<Word> {


    public static void uniqueWords(List<Word> array) {
        Set<Word> uniqueWords = new HashSet<>(array);
        for (Word word : uniqueWords) {
            System.out.println(word.getWord());
        }
    }

    public static void longestWord(List<Word> array) {

        List<Word> longestWords = new ArrayList<>(array);
        longestWords.sort(new WordComparator());
        int len = longestWords.get(0).getLengthOfWord();
        List<Word> newList = new ArrayList<>();
        int i = 0;
        while (longestWords.get(i).getLengthOfWord() == len) {
            newList.add(longestWords.get(i));
            i++;
        }
        Set<Word> countOfWords = new HashSet<>(newList);
        for (Word key : countOfWords) {
            System.out.println(key.getWord() + ":" + Collections.frequency(newList, key));
        }

    }

    public static void countOfChoiceWord(List<Word> array, Word choiceWord) {
        int count = Collections.frequency(array, choiceWord);
        System.out.println(choiceWord.getWord() + ":" + count);
    }
    public static void task(List<Word> listOfWords, String consoleInput) {
        String[] str = consoleInput.split(" ");
        for (String st : str) {
            listOfWords.add(new Word(st, st.length()));
        }
        long startTime = System.nanoTime();
        System.out.println("Список уникальных слов: ");
        uniqueWords(listOfWords);
        System.out.println("Список самых длинных слов с их частатой: ");
        longestWord(listOfWords);
        Scanner in = new Scanner(System.in);
        System.out.println("Введите слово, чтобы узнать сколько раз он встречается: ");
        String word = in.next();
        countOfChoiceWord(listOfWords, new Word(word, word.length()));
        startTime = System.nanoTime() - startTime;
        System.out.printf("Elapsed %,9.3f ms\n", startTime / 1_000_000.0);
    }


}
