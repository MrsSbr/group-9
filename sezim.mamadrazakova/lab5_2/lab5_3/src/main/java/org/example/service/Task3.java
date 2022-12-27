package org.example.service;
import org.example.comparator.WordComparator;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.example.entity.Word;
import org.w3c.dom.ls.LSOutput;

import static java.util.Collections.max;
import static java.util.Collections.sort;

public abstract class Task3 {
    public static Set<Word> uniqueWords(List<Word> array){
        return new HashSet<>(array);
    }
    public static Map<Word, Long> longestWord(List<Word> array) {
        Map<Word, Long> words=array.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Word maxim= Objects.requireNonNull(words.entrySet()
                .stream()
                .max(Map.Entry.comparingByKey(new WordComparator()))
                .orElse(null)).getKey();
        return words.entrySet()
                .stream().filter(x->x.getKey().getLengthOfWord()==maxim.getLengthOfWord())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    public static long countOfChoiceWord(List<Word> array, Word choiceWord){
        return array.stream().filter(x->x.equals(choiceWord)).count();
    }
    public static void task(List<Word> listOfWords, String consoleInput, boolean checkTime) {

        List<String>st= new ArrayList<>(Arrays.asList(consoleInput.split(" ")));
        st.forEach(s->{listOfWords.add(new Word(s,s.length()));});

        long startTime = System.nanoTime();
        System.out.println("Список уникальных слов");
        Set<Word> unique=uniqueWords(listOfWords);
        unique.forEach(x-> System.out.println(x.getWord()));
        System.out.println("Список самых длинных слов с их частатой");
        Map<Word, Long> longestWord=longestWord(listOfWords);
        longestWord.forEach((k,v)-> System.out.println(k.getWord()+": "+v));
        Scanner in = new Scanner(System.in);
        System.out.println("Введите слово, чтобы узнать сколько раз он встречается");
        String word = in.next();
        long count=countOfChoiceWord(listOfWords, new Word(word, word.length()));
        System.out.println(word +": "+count);
        if(checkTime) {
            startTime = System.nanoTime() - startTime;
            System.out.printf("Elapsed %,9.3f ms\n", startTime / 1_000_000.0);
        }
    }
}
