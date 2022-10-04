package Class;

import Interfaces.Apliances;

import java.util.Objects;

public class Fridge extends KitchenApliance implements Apliances {
    public int temperature;

    public int getTemperature() {
        return temperature;
    }

    public Fridge(int energy, String brand, boolean status, String color, int temperature) {
        super(energy, brand, status, color);
        this.temperature = temperature;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String power() {
        if (status) {
            return ("Сейчас включен");
        } else {
            return ("Сейчас выключен");
        }
    }

    @Override
    public String toString() {
        return "Холодильник\n" +
                "температура = " + temperature +
                ", мощность = " + energy +
                ", бренд = " + brand +
                ", status = " + status +
                ", color = " + color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Fridge fridge = (Fridge) o;
        return temperature == fridge.temperature;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), temperature);
    }
}
