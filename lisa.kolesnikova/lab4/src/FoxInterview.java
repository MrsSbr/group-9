import java.util.*;

public class FoxInterview {
    private final List<Fox> listOfFoxSoundsInterview;

    public FoxInterview() {
        listOfFoxSoundsInterview = new ArrayList<>();
    }

    public void addRecord(Fox foxData) {
        listOfFoxSoundsInterview.add(foxData);
    }

    public String getTheMostPopularAnswerForATowns() {
        // наиболее популярный ответ для городов, название, которых начинается на 'А';
        String res = "Нет ответа";
        Map<String, Integer> soundsRespondsAmount = new HashMap<>();
        for (Fox fox : listOfFoxSoundsInterview) {
            if (fox.getTown().startsWith("А") || fox.getTown().startsWith("а")) {
                if (soundsRespondsAmount.getOrDefault((fox.getSound()), -1) < fox.getAmountRespondents()) {
                    soundsRespondsAmount.put(fox.getSound(), fox.getAmountRespondents());
                }
            }
        }
        int maxResponds = 0;
        for (Map.Entry<String, Integer> entry :
                soundsRespondsAmount.entrySet()) {
            if (entry.getValue() > maxResponds) {
                maxResponds = entry.getValue();
                res = entry.getKey();
            }
        }

        return res;
    }

    public String getTownWithTheMostVariableAnswers() {
        // город, в котором дали больше всего разнообразных ответов;
        String res = "Нет ответа";
        Map<String, Integer> howManyDiffSoundsTownHas = new HashMap<>();
        for (Fox fox : listOfFoxSoundsInterview) {
            howManyDiffSoundsTownHas.put(fox.getTown(), howManyDiffSoundsTownHas.getOrDefault(fox.getTown(), -1) + 1);
        }
        int maxResponds = 0;
        for (Map.Entry<String, Integer> entry :
                howManyDiffSoundsTownHas.entrySet()) {
            if (entry.getValue() > maxResponds) {
                maxResponds = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    public Set<String> getTownNotLikeMoscow() {
        // города, где ни разу не ответили так же, как наиболее часто отвечали в Москве
        Set<String> res = new HashSet<>();
        String mostPopularAnsMsc = "";
        int maxRespondsMsc = 0;
        for (Fox fox : listOfFoxSoundsInterview) {
            if (fox.getTown().equals("москва") && maxRespondsMsc < fox.getAmountRespondents()) {
                maxRespondsMsc = fox.getAmountRespondents();
                mostPopularAnsMsc = fox.getSound();
            }
        }
        Map<String, Set<String>> townListOfSounds = new HashMap<>();
        for (Fox fox : listOfFoxSoundsInterview) {
            if (townListOfSounds.containsKey(fox.getTown())) {
                townListOfSounds.get(fox.getTown()).add(fox.getSound());
            } else {
                Set<String> soundsForTown = new HashSet<>();
                soundsForTown.add(fox.getSound());
                townListOfSounds.put(fox.getTown(), soundsForTown);
            }
        }
        for (Map.Entry<String, Set<String>> entry :
                townListOfSounds.entrySet()) {
            if (!entry.getValue().contains(mostPopularAnsMsc)) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

}
