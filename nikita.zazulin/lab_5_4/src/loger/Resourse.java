package loger;

import java.time.LocalDate;
import java.util.Objects;

public class Resourse {

    private final LocalDate date;
    private final int code;

    private final int ip;

    public Resourse(int ip, LocalDate date, int code) {

        this.date = date;
        this.code = code;
        this.ip = ip;

    }

    @Override
    public String toString() {

        return "Resourse{" +
                "date=" + date +
                ", code=" + code +
                ", ip=" + ip +
                '}';

    }

    @Override
    public boolean equals(Object o) {

        if (this == o){

            return true;

        }

        if (o == null || getClass() != o.getClass()){

            return false;

        }

        Resourse resourse = (Resourse) o;

        return code == resourse.code && ip == resourse.ip && Objects.equals(date, resourse.date);

    }

    @Override
    public int hashCode() {

        return Objects.hash(date, code, ip);

    }
}
