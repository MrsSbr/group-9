package Models;

import java.util.Objects;

public class User {
    private String fio;
    private String number;

    User(String fio, String number) {
        this.number = number;
        this.fio = fio;
    }

    public String getFIO() {
        return fio;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(fio, user.fio) && Objects.equals(number, user.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, number);
    }

    @Override
    public String toString() {
        return "Models.User{" +
                "FIO='" + fio + '\'' +
                ", Number='" + number + '\'' +
                '}';
    }


}