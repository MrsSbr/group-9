package Models;

import Interfaces.MilitaryPlane;

import java.util.Objects;

public class MilitaryAerodrome extends Airport implements MilitaryPlane {
    int countBomb;
    int countfFighterJet;

    public MilitaryAerodrome(int countGarage, int lengthStrip, int countBomb, int countfFighterJet) {
        super(countGarage, lengthStrip);
        this.countBomb = countBomb;
        this.countfFighterJet = countfFighterJet;
    }

    @Override
    public void action() {
        System.out.println("Военный аэродром работает!");
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof MilitaryAerodrome that)) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }
        return countBomb == that.countBomb;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), countBomb);

    }

    @Override
    public String toString() {
        return super.toString() + "\nВоенный аэродром:" + "\nКол-во бомб = " + countBomb + "шт." + "\nКол-во истребителей = " + countfFighterJet;
    }


    @Override
    public int getCountFighterJet() {
        return countfFighterJet;
    }

    @Override
    public int getCountBomb() {
        return countBomb;
    }
}