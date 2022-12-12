package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


public class Subscription {
    private String FIO;
    private String region;
    private String adress;
    private int amount;
    private List<Journal> list_of_journals;

    Subscription(String FIO,String region, String adress, int amount, List<Journal> list_of_journals){
        this.FIO = FIO;
        this.region = region;
        this.adress = adress;
        this.amount = amount;
        this.list_of_journals = list_of_journals;
    }
    Subscription(){
    }

    public String getRegion(){
        return region;
    }
    public List<Journal> getList_of_journals(){
        return list_of_journals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return amount == that.amount &&
                Objects.equals(FIO, that.FIO) &&
                Objects.equals(region, that.region) &&
                Objects.equals(adress, that.adress) &&
                Objects.equals(list_of_journals, that.list_of_journals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FIO, region, adress, amount, list_of_journals);
    }
}
