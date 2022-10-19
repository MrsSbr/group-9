package Models;

import Interfaces.MilitaryPlane;

import java.util.Objects;

public class MilitaryAerodrome extends Airport implements MilitaryPlane {
    private final int countBomb;
    private final int countFighterJet;

    public MilitaryAerodrome(int countGarage, int lengthStrip, int countBomb, int countfFighterJet) {
        super(countGarage, lengthStrip);
        this.countBomb = countBomb;
        this.countFighterJet = countfFighterJet;
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
        return super.toString() + "\nВоенный аэродром:" + "\nКол-во бомб = " + countBomb + "шт." + "\nКол-во истребителей = " + countFighterJet;
    }


    @Override
    public int getCountFighterJet() {
        return countFighterJet;
    }

    @Override
    public int getCountBomb() {
        return countBomb;
    }
}