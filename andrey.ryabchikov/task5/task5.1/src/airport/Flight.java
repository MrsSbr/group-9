package airport;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Flight {

    final List<Family> family;

    int numberFlight;

    public Flight(int numberFlight) {

        family = new ArrayList<>();
        this.numberFlight = numberFlight;

    }

    @Override
    public String toString() {

        String CountFamily = family.stream().map(value -> value.getCountFamilyMembers() + " ")
                .collect(Collectors.joining("", "", ""));

        return "Рейс{" +
                "Номер рейса=" + numberFlight +
                ",Cписок количества членов семьи " + CountFamily +
                '}';

    }

    public int getSumPeople() {

        return family.stream().mapToInt(Family::getCountFamilyMembers).sum();

    }

    public void addFamily(int countFamilyMembers) {

        if (countFamilyMembers > 0) {

            family.add(new Family(numberFlight, countFamilyMembers));

        }

    }


}
