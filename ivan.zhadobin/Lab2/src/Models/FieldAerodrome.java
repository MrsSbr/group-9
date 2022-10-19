package Models;

import java.util.Objects;

public class FieldAerodrome extends Airport {

    private final int countPilot;
    private final double waterForIrrigation; //вода для полива

    public FieldAerodrome(int countGarage, int lengthStrip, int countPilot, int waterForIrrigation) {
        super(countGarage, lengthStrip);
        this.countPilot = countPilot;
        this.waterForIrrigation = waterForIrrigation;
    }

    @Override
    public void action() {
        System.out.println("Полевой аэродром работает!");
    }

    @Override
    public String toString() {
        return super.toString() + "\nПолевой аэродром:" + "\nКол-во воды для полива = " + waterForIrrigation + "л." +
                "\nКол-во пилотов = " + countPilot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FieldAerodrome that = (FieldAerodrome) o;
        return countPilot == that.countPilot && Objects.equals(waterForIrrigation, that.waterForIrrigation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countPilot, waterForIrrigation);
    }
}
