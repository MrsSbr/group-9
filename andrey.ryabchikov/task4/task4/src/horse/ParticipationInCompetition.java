package horse;

import java.time.LocalDate;

public class ParticipationInCompetition {

    private final LocalDate date;
    private final int place;

    public ParticipationInCompetition(String date, int place) {

        this.date = LocalDate.parse(date);
        this.place = place;

    }

    public String getStatistic() {

        return "\n\rДата соревнования " + date.toString() + "\n\rМесто " + place;

    }

    public int getPoints() {

        return 4 - place;

    }

}
