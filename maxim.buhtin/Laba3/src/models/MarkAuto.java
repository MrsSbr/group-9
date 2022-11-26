package models;

public enum MarkAuto {
    Audi, Bmw, Marcedes, Bentley, Lexus;
    private static final MarkAuto[] VALUES = values();
    private int count;

    public static MarkAuto getMark(int i) {

        return VALUES[i];

    }

    public String toStr() {

        return this.toString();

    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        ++count;
    }

}
