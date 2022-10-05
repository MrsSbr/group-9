package checkValidatons;

public enum Months {

    January, February, March,
    April, May, June,
    July, August, September,
    October, November, December;

    public static final Months[] VALUES = values();

    public static Months getMonth(int i) {

        return VALUES[i];

    }

    public String toStr() {

        return this.toString();

    }

}
