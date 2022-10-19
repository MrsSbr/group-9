package сlass;

import interfaces.Apliances;

import java.util.Objects;

public class Blender extends KitchenApliance implements Apliances {

    private int speedOfBlender;

    public int getSpeedOfBlender() {
        return speedOfBlender;
    }

    public Blender(int energy, String brand, boolean status, String color, int speedOfBlender) {
        super(energy, brand, status, color);
        this.speedOfBlender = speedOfBlender;
    }

    @Override
    public String power() {
        if (getStatus()) {
            return ("Сейчас включен");
        } else {
            return ("Сейчас выключен");
        }
    }

    @Override
    public String toString() {// TODO: 12.10.2022 испульзуем super.toString()

        return super.toString() +
                ", Скорость=" + speedOfBlender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Blender blender = (Blender) o;
        return speedOfBlender == blender.speedOfBlender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), speedOfBlender);
    }
}
