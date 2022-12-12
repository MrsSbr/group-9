package models;

import java.time.LocalDate;

public class Journal {
    private String name;
    private boolean type; //0-newspaper 1-magazine
    private LocalDate startTime;
    private LocalDate stopTime;
    Journal(String name, boolean type, LocalDate startTime, LocalDate stopTime){
        this.name = name;
        this.type = type;
        this.startTime = startTime;
        this.stopTime = stopTime;
    }
    public LocalDate getStartTime(){
        return startTime;
    }

    public LocalDate getStopTime() {
        return stopTime;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ';' + ';' + type + ';' + startTime + ';' + stopTime + ';';
    }
}
