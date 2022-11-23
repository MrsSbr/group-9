package models;

import java.util.Objects;


public class GiantAntTurtle extends Ants {
    private int spikes;

    public GiantAntTurtle(int size, String color, String type, int spikes, String habitat) {
        super(size, color, type, habitat);
        this.spikes = spikes;
    }

    @Override
    public void collectFood() {
        if (typeAnts.equals("рабочий")) {
            System.out.println("Я собрал еду,спасибо!");
        } else {
            System.out.println("Я не могу собрать еду, я не рабочий!");
        }
    }

    public int getSpikes() {
        return spikes;
    }

    public void setSpikes(int spikes) {
        this.spikes = spikes;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) {

            return true;

        }
        if (o == null || getClass() != o.getClass()) {

            return false;

        }
        if (!super.equals(o)) {

            return false;

        }
        GiantAntTurtle ants = (GiantAntTurtle) o;
        return spikes == ants.spikes;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), spikes);

    }

    @Override
    public String toString() {

        return super.toString() + '\n' +
                "; Название->Гигантский муравей-черепаха ";

    }

}


