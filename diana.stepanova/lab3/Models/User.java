package Models;
import Enum.ATC;
import Models.UserComparator;
import java.util.*;

public class User {
    public String FIO;
    public String Number;
    User(String fio,String number){
        this.Number=number;
        this.FIO=fio;
    }

    public String getFIO() {
        return FIO;
    }

    public String getNumber() {
        return Number;
    }



    @Override
    public String toString() {
        return "Models.User{" +
                "FIO='" + FIO + '\'' +
                ", Number='" + Number + '\'' +
                '}';
    }


}
