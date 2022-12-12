package lab4.src.main.java.ru.pirates.entity;

public enum ShipClass {
    CRUISER("Крейсер"),
    DESTROYER("Эсминец"),
    FRIGATE("Фрегат"),
    CORVETTE("Корвет"),
    SAILING("Парусный");

    private final String str;

    ShipClass(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return this.str;
    }
}
