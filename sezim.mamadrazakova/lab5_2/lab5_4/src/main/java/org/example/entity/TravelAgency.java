package org.example.entity;

import java.time.LocalDate;
import java.util.Objects;

public class TravelAgency {
    private final LocalDate date;
    private final int duration;
    private final int countOfPeople;
    private final int price;

    public TravelAgency(LocalDate date, int duration, int countOfPeople, int price) {

        this.date = date;
        this.duration = duration;
        this.countOfPeople = countOfPeople;
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getDuration() {
        return duration;
    }

    public int getCountOfPeople() {
        return countOfPeople;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TravelAgency)) return false;
        TravelAgency that = (TravelAgency) o;
        return getCountOfPeople() == that.getCountOfPeople() && getPrice() == that.getPrice() && Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getCountOfPeople(), getPrice());
    }

    @Override
    public String toString() {
        return "TravelAgency{" +
                "date=" + date +
                ", duration=" + duration +
                ", countOfPeople=" + countOfPeople +
                ", price=" + price +
                '}';
    }

}
