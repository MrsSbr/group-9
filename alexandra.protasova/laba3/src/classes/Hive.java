package classes;

import java.util.concurrent.ThreadLocalRandom;

public class Hive {

    protected int number;

    protected int honeyVolume;

    protected int year;

    public Hive(int number, int honeyVolume, int year){
        this.number = number;
        this.honeyVolume = honeyVolume;
        this.year = year;
    }

    public int getHoneyVolume() {
        return honeyVolume;
    }

    public int getYear() {
        return year;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Hive{" +
                "number=" + number +
                ", honeyVolume=" + honeyVolume +
                ", year=" + year +
                '}';
    }
}