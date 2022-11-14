package Models;

public class User {
    protected String fio;
    protected String number;

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
    public String toString() {
        return "Models.User{" +
                "FIO='" + fio + '\'' +
                ", Number='" + number + '\'' +
                '}';
    }


}
