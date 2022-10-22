package airport;

import java.util.ArrayList;
import java.util.List;

public class Flight {

    final List<Family> family;

    int numberFlight;

    public Flight(int numberFlight) {

        family = new ArrayList<>();
        this.numberFlight = numberFlight;

    }

    @Override
    public String toString() {

        StringBuilder CountFamily = new StringBuilder("");

        for (Family value : family) {

            CountFamily.append(value.getCountFamilyMembers());
            CountFamily.append(" ");

        }

        return "Рейс{" +
                "Номер рейса=" + numberFlight +
                ",Cписок количества членов семьи " + CountFamily +
                '}';

    }

    public int getSumPeople() {

        int sum = 0;

        for (Family fam : family) {

            sum += fam.getCountFamilyMembers();

        }

        return sum;

    }

    public void addFamily(int countFamilyMembers) {

        if (countFamilyMembers > 0) {

            family.add(new Family(numberFlight, countFamilyMembers));

        }

    }


}
