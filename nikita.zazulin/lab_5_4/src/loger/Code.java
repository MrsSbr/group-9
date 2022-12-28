package loger;

import java.time.LocalDate;
import java.util.Objects;

public class Code {

    private final LocalDate date;
    private final String resource;

    private final int ip;

    public Code(int ip, LocalDate date, String resource) {

        this.date = date;
        this.resource = resource;
        this.ip = ip;

    }

    @Override
    public String toString() {

        return "Code{" +
                "date=" + date +
                ", resource='" + resource + '\'' +
                ", ip=" + ip +
                '}';

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {

            return true;

        }
        if (o == null || getClass() != o.getClass()){

            return false;

        }

        Code code = (Code) o;

        return ip == code.ip && Objects.equals(date, code.date) && Objects.equals(resource, code.resource);

    }

    @Override
    public int hashCode() {

        return Objects.hash(date, resource, ip);

    }
}
