package models;

import java.util.*;
import java.util.stream.Collectors;
import java.lang.Character;

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
        for (String s : words) {
            if (map.containsKey(s.toLowerCase())) {
                map.put(s.toLowerCase(), map.get(s.toLowerCase()) + 1);
            } else {
                map.put(s.toLowerCase(), 1);
            }
        }
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

        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            res.append(entry);
            res.append("\n");
        }
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
        for (String s : words) {
            if (map.containsKey(s.toLowerCase())) {
                map.put(s.toLowerCase(), map.get(s.toLowerCase()) + 1);
            } else {
                map.put(s.toLowerCase(), 1);
            }
        }
        map.values().removeIf(val -> val < 10);

        int maxLen = 0;
        String maxWord = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 10) {
                if (maxLen < entry.getKey().length()) {
                    maxLen = entry.getKey().length();
                    maxWord = entry.getKey();
                }
            }
        }
        return maxWord;
    }

    public String findSmallestWordWithTwoO(ArrayList<String> words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words) {
            int occurrencesCount = s.length() - s.toLowerCase().replace("o", "").length();
            if (!(map.containsKey(s.toLowerCase())) && occurrencesCount == 2 && Character.isUpperCase(s.charAt(0))) {
                map.put(s.toLowerCase(), s.length());
            }
        }
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
        for (String s : words) {
            if (map.containsKey(s.toLowerCase()) && Character.isUpperCase(s.charAt(0))) {
                map.put(s.toLowerCase(), 1);
            } else {
                if (Character.isUpperCase(s.charAt(0))) {
                    map.put(s.toLowerCase(), 1);
                }
            }

        }
        map.values().removeIf(val -> val < 1);
        return map.size();
    }
}
