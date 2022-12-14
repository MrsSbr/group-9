package models;
import java.time.LocalDate;
import java.util.Random;

public class Fluorogram {
    private String name;
    private boolean hasPathology;
    private LocalDate date;
    public Fluorogram( String name,  boolean hasPathology, LocalDate date){
        this.name = name;
        this.hasPathology = hasPathology;
        this.date = date;
    }
    public boolean getPathology(){
        return hasPathology;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Fluorogram{" +
                "name='" + name + '\'' +
                ", hasPathology=" + hasPathology +
                ", date=" + date +
                '}';
    }
}
