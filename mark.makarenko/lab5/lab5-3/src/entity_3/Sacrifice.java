package entity_3;

import java.time.LocalDate;

public class Sacrifice {
    private final LocalDate date;
    private final String type;
    private final int daysTillRain;

    public Sacrifice(LocalDate date, String type, int daysTillRain) {
        this.date = date;
        this.type = type;
        this.daysTillRain = daysTillRain;
    }
    public Sacrifice() {
        this.date = null;
        this.type = null;
        this.daysTillRain = 0;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public int getDaysTillRain() {
        return daysTillRain;
    }
}


