package horse;

import java.time.LocalDate;
import java.util.Objects;

public class ParticipationInCompetition {

    private final LocalDate date;
    private final int place;

    @Override
    public boolean equals(Object o) {

        if (this == o){

            return true;

        }
        if (o == null || getClass() != o.getClass()){

            return false;

        }
        ParticipationInCompetition that = (ParticipationInCompetition) o;
        return place == that.place && Objects.equals(date, that.date);

    }

    @Override
    public int hashCode() {

        return Objects.hash(date, place);

    }

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
