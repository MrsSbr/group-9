package models;

import java.util.Objects;

public class TempleData {
    private final String god;
    private final String temple;
    private final String peopleName;
    private final int amountOfDonation;

    public TempleData(String god, String temple, String peopleName, int amountOfDonation) {
        this.god = god;
        this.temple = temple;
        this.peopleName = peopleName;
        this.amountOfDonation = amountOfDonation;
    }

    public String getGod() {
        return god;
    }

    public String getTemple() {
        return temple;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public int getAmountOfDonation() {
        return amountOfDonation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof TempleData that)) {
            return false;
        }

        return amountOfDonation == that.amountOfDonation
                && god.equals(that.god)
                && temple.equals(that.temple)
                && peopleName.equals(that.peopleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(god, temple, peopleName, amountOfDonation);
    }

    @Override
    public String toString() {
        return "TempleData{" +
                "god='" + god + '\'' +
                ", temple='" + temple + '\'' +
                ", peopleName='" + peopleName + '\'' +
                ", amountOfDonation=" + amountOfDonation +
                '}';
    }
}
