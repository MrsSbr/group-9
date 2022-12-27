package models;

import java.util.*;
import java.util.stream.Collectors;
import java.lang.Character;
import java.util.stream.IntStream;

public class Dict {
    private final Map<Integer, String> dict;

    public Dict() {
        dict = new HashMap<>();
    }

    public void addToMap(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            dict.put(i, list.get(i));
        }
    }

    public String countWords(ArrayList<String> words) {
        StringBuilder res = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        IntStream.range(0, words.size())
                .forEach(s -> {
                    if (map.containsKey(words.get(s).toLowerCase())) {
                        map.put(words.get(s).toLowerCase(), map.get(words.get(s).toLowerCase()) + 1);
                    } else {
                        map.put(words.get(s).toLowerCase(), 1);
                    }
                });
        Map<String, Integer> sorted = map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));
        sorted.forEach((key, value) -> {
            res.append(key + " " + value);
            res.append("\n");
        });

        Optional<String> first = sorted.keySet().stream().findFirst();
        String k = "";
        if (first.isPresent()) {
            k = first.get();
            res.append("Самое часто встречающееся слово: ");
            res.append(k);
            res.append("\n");
        }
        return res.toString();
    }

    public String countWordsOverTen(ArrayList<String> words) {
        HashMap<String, Integer> map = new HashMap<>();
        IntStream.range(0, words.size())
                .forEach(s -> {
                    if (map.containsKey(words.get(s).toLowerCase())) {
                        map.put(words.get(s).toLowerCase(), map.get(words.get(s).toLowerCase()) + 1);
                    } else {
                        map.put(words.get(s).toLowerCase(), 1);
                    }
                });
        map.values().removeIf(val -> val < 10);

        final int[] maxLen = {0};
        final String[] maxWord = {""};
        map.forEach((key, value) -> {
            if (value > 10) {
                if (maxLen[0] < key.length()) {
                    maxLen[0] = key.length();
                    maxWord[0] = key;
                }
            }
        });
        return maxWord[0];
    }

    public String findSmallestWordWithTwoO(ArrayList<String> words) {
        HashMap<String, Integer> map = new HashMap<>();
        IntStream.range(0, words.size())
                .forEach(s -> {
                    int occurrencesCount = words.get(s).length() - words.get(s).toLowerCase().replace("o", "").length();
                    if (!(map.containsKey(words.get(s).toLowerCase())) && occurrencesCount == 2 && Character.isUpperCase(words.get(s).charAt(0))) {
                        map.put(words.get(s).toLowerCase(), words.get(s).length());
                    }
                });
        Map<String, Integer> sorted = map.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));
        Optional<String> first = sorted.keySet().stream().findFirst();
        String k = "";
        if (first.isPresent()) {
            k = first.get();
        }
        return k;
    }

    public int countUpperWords(ArrayList<String> words) {
        HashMap<String, Integer> map = new HashMap<>();
        IntStream.range(0, words.size())
                .forEach(s -> {
                    if (map.containsKey(words.get(s).toLowerCase()) && Character.isUpperCase(words.get(s).charAt(0))) {
                        map.put(words.get(s).toLowerCase(), 1);
                    } else {
                        if (Character.isUpperCase(words.get(s).charAt(0))) {
                            map.put(words.get(s).toLowerCase(), 1);
                        }
                    }

                });
        map.values().removeIf(val -> val < 1);
        return map.size();
    }
}
