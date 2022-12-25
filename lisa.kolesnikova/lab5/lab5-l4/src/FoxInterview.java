import java.util.*;
import java.util.stream.Collectors;

public class FoxInterview {
    private final List<Fox> listOfFoxSoundsInterview;

    public FoxInterview() {
        listOfFoxSoundsInterview = new ArrayList<>();
    }

    public void addRecord(Fox foxData) {
        listOfFoxSoundsInterview.add(foxData);
    }

    public String getTheMostPopularAnswerForATownsStream() {
        // наиболее популярный ответ для городов, название, которых начинается на 'А';
        String res = "Нет ответа";
        Map<String, Integer> soundsRespondsAmount = new HashMap<>();
        listOfFoxSoundsInterview.stream()
                .filter((fox) -> (fox.getTown().startsWith("А") || fox.getTown().startsWith("а")))
                .filter(fox -> (soundsRespondsAmount.getOrDefault((fox.getSound()), -1) < fox.getAmountRespondents()))
                .forEach(fox -> soundsRespondsAmount.put(fox.getSound(), fox.getAmountRespondents()));
        return Collections.max(soundsRespondsAmount.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    public String getTownWithTheMostVariableAnswersStream() {
        // город, в котором дали больше всего разнообразных ответов;
        final String[] res = {"Нет ответа"};
        // город + кол-во разнообразных ответов
        Map<String, Integer> howManyDiffSoundsTownHas = new HashMap<>();
        listOfFoxSoundsInterview.forEach(fox -> howManyDiffSoundsTownHas.put(fox.getTown(),
                howManyDiffSoundsTownHas.getOrDefault(fox.getTown(), -1) + 1));
        return Collections.max(howManyDiffSoundsTownHas.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    public Set<String> getTownNotLikeMoscowStream() {
        // города, где ни разу не ответили так же, как наиболее часто отвечали в Москве
        Set<String> res = new HashSet<>();
        final String[] mostPopularAnsMsc = {""};
        final int[] maxRespondsMsc = {0};
        // ищем самый популярный ответ в москве
        listOfFoxSoundsInterview.stream()
                .filter(fox -> fox.getTown().equals("москва") && maxRespondsMsc[0] < fox.getAmountRespondents())
                .forEach(fox -> {
                    maxRespondsMsc[0] = fox.getAmountRespondents();
                    mostPopularAnsMsc[0] = fox.getSound();
                });
        // для каждого города список соответствующих звуков
        Map<String, Set<String>> townListOfSounds = new HashMap<>();
        listOfFoxSoundsInterview.forEach(fox -> {
            if (townListOfSounds.containsKey(fox.getTown())) {
                townListOfSounds.get(fox.getTown())
                        .add(fox.getSound());
            } else {
                Set<String> soundsForTown = new HashSet<>();
                soundsForTown.add(fox.getSound());
                townListOfSounds.put(fox.getTown(), soundsForTown);
            }
        });
        // если в собранном множестве есть звук из москвы, то не идет в результат
        return townListOfSounds.entrySet().stream().
                filter((entry) -> (!entry.getValue().contains(mostPopularAnsMsc[0])))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
}
