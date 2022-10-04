package airport;

import java.util.ArrayList;
import java.util.List;

public class Flight {

    final List<Family> family;

    int numberFlight;

    public Flight(int numberFlight) {

        family = new ArrayList<Family>();
        this.numberFlight = numberFlight;

    }

    @Override
    public String toString() {

        String CountFamily = "";

        for (Family value : family) {

            CountFamily += value.getCountFamilyMembers() + " ";

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
            return;
        }

    }


}
