package сlass;

import interfaces.Apliances;

import java.util.Objects;

public abstract class KitchenApliance implements Apliances {
    // TODO: 12.10.2022 сделать поля приватными (инкапсуляция)
    private int energy;
    private String brand;
    private boolean status;
    private String color;

    // TODO: 12.10.2022 добавить все геттеры
    public int getEnergy() {return energy; }
    public String getBrand() {return brand; }
    public boolean getStatus() {return status; }
    public String getColor() {return color; };

    public KitchenApliance(int energy, String brand, boolean status, String color) {
        this.energy = energy;
        this.brand = brand;
        this.status = status;
        this.color = color;
    }

    @Override
    public String toString() {
        return "KitchenApliance:" +
                "Энергия=" + energy +
                ", Бренд=" + brand +
                ", Статус=" + status +
                ", Цвет=" + color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KitchenApliance that = (KitchenApliance) o;
        return energy == that.energy && status == that.status && Objects.equals(brand, that.brand) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(energy, brand, status, color);
    }
}