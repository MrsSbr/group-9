package loger;

import java.util.Objects;

public class AllSuccess {

    private int all;
    private int succesful;

    public AllSuccess(int all, int successful) {

        this.all = all;
        this.succesful = successful;

    }

    public double howSuccessful(){

        return (double)succesful/all;

    }

    public void incAll() {

        all++;

    }

    public void incSuccesful() {

        incAll();
        succesful++;

    }

    public double getAll() {

        return all;

    }

    public double getSuccesful() {

        return succesful;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {

            return true;

        }
        if (o == null || getClass() != o.getClass()) {

            return false;

        }
        AllSuccess that = (AllSuccess) o;
        return all == that.all && succesful == that.succesful;
    }

    @Override
    public int hashCode() {

        return Objects.hash(all, succesful);

    }
}
