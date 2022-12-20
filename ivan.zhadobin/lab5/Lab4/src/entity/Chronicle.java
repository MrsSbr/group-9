package entity;

import java.time.LocalDate;
import java.util.Objects;

public class Chronicle {
    private final LocalDate date;
    private final PlaceBattle placeOfBattle;
    private final Khanate khanate;
    private final int numberOfBrokenBasurman;

    public Chronicle(LocalDate date, PlaceBattle placeOfBattle, Khanate khanate, int numberOfBrokenBasurman) {
        this.date = date;
        this.placeOfBattle = placeOfBattle;
        this.khanate = khanate;
        this.numberOfBrokenBasurman = numberOfBrokenBasurman;
    }

    public LocalDate getDate() {
        return date;
    }

    public PlaceBattle getPlaceOfBattle() {
        return placeOfBattle;
    }

    public Khanate getKhanate() {
        return khanate;
    }

    public int getNumberOfBrokenBasurmant() {
        return numberOfBrokenBasurman;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Chronicle that = (Chronicle) obj;
        return Objects.equals(numberOfBrokenBasurman, that.numberOfBrokenBasurman)
                && khanate == that.khanate
                && placeOfBattle == that.placeOfBattle
                && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, placeOfBattle, khanate, numberOfBrokenBasurman);
    }

    @Override
    public String toString() {
        return "Учёт битых басурман {" +
                " \n\t\tДата нападения -- " + date +
                ",\n\t\tМесто битвы -- " + placeOfBattle +
                ",\n\t\tС каким ханством бились -- " + khanate +
                ",\n\t\tКол-во битых басурман -- " + numberOfBrokenBasurman +
                '}';
    }
}
