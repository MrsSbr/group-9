package models;

import java.util.List;
import java.util.Objects;


public class Subscription {
    private String region;
    private int amount;
    private List<Journal> listOfJournals;

    Subscription(String region, int amount, List<Journal> listOfJournals){
        this.region = region;
        this.amount = amount;
        this.listOfJournals = listOfJournals;
    }
    Subscription(){
    }

    public String getRegion(){
        return region;
    }
    public List<Journal> getListOfJournals(){
        return listOfJournals;
    }

    @Override
    public String toString() {
        return region + ';' + amount +';'+ listOfJournals.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return amount == that.amount  &&
                Objects.equals(region, that.region) &&
                Objects.equals(listOfJournals, that.listOfJournals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(region, amount, listOfJournals);
    }
}
