package loger;

import java.time.LocalDate;
import java.util.Objects;

public class Occasion {

    private final LocalDate date;
    private final String resource;

    private final int code;

    @Override
    public boolean equals(Object o) {

        if (this == o) {

            return true;

        }
        if (o == null || getClass() != o.getClass()) {

            return false;

        }

        Occasion occasion = (Occasion) o;

        return code == occasion.code && Objects.equals(date, occasion.date) &&
                Objects.equals(resource, occasion.resource);

    }

    @Override
    public int hashCode() {

        return Objects.hash(date, resource, code);

    }

    public Occasion(String date, String resource, int code) {

        this.date = LocalDate.parse(date);
        this.resource = resource;
        this.code = code;

    }

    public int getCode() {

        return code;

    }

    public String getResource() {

        return resource;
    }

    public LocalDate getDate() {

        return date;

    }

}
