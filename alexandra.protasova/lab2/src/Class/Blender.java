package Class;

import Interfaces.Apliances;

import java.util.Objects;

public class Blender extends KitchenApliance implements Apliances {

    public int speedOfBlender;

    public int getSpeedOfBlender() {
        return speedOfBlender;
    }

    public Blender(int energy, String brand, boolean status, String color, int speedOfBlender) {
        super(energy, brand, status, color);
        this.speedOfBlender=speedOfBlender;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String power() {
        if (status) {
            return("Сейчас включен");
        } else {
            return("Сейчас выключен");
        }
    }

    @Override
    public String toString() {
        return "Блендер\n" +
                "скорость = " + speedOfBlender +
                ", мощность = " + energy +
                ", бренд = " + brand +
                ", статус = " + status +
                ", цвет = " + color;
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
