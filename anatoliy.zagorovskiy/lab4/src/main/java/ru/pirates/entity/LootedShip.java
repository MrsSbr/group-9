package ru.pirates.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class LootedShip {
    private final LocalDate date;
    private final ShipClass shipClass;
    private final Citizenship citizenship;
    private final BigDecimal goldReceived;
    private final int barrelsOfRumReceived;
    private final boolean wasBoarded;

    public LootedShip(LocalDate date, ShipClass shipClass, Citizenship citizenship, BigDecimal goldReceived, int barrelsOfRumReceived, boolean wasBoarded) {
        this.date = date;
        this.shipClass = shipClass;
        this.citizenship = citizenship;
        this.goldReceived = goldReceived;
        this.barrelsOfRumReceived = barrelsOfRumReceived;
        this.wasBoarded = wasBoarded;
    }

    public Citizenship getCitizenship() {
        return citizenship;
    }

    public boolean isWasBoarded() {
        return wasBoarded;
    }

    public BigDecimal getGoldReceived() {
        return goldReceived;
    }

    public int getBarrelsOfRumReceived() {
        return barrelsOfRumReceived;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LootedShip that = (LootedShip) o;
        return Objects.equals(goldReceived, that.goldReceived)
                && barrelsOfRumReceived == that.barrelsOfRumReceived
                && wasBoarded == that.wasBoarded
                && date.equals(that.date)
                && shipClass == that.shipClass
                && citizenship == that.citizenship;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, shipClass, citizenship, goldReceived, barrelsOfRumReceived, wasBoarded);
    }

    @Override
    public String toString() {
        return "Ограбленный корабль {" +
                "\n\t\tДата нападения -- " + date +
                ",\n\t\tКласс корабля -- " + shipClass +
                ",\n\t\tПодданство -- " + citizenship +
                ",\n\t\tЗолота получено -- " + goldReceived +
                ",\n\t\tБочек с ромом -- " + barrelsOfRumReceived +
                ",\n\t\tБыл ли взят на абордаж -- " + wasBoarded +
                '}';
    }
}
