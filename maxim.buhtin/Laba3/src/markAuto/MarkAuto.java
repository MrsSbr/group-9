package markAuto;

public enum MarkAuto {
    Audi, Bmw, Marcedes, Bentley, Lexus;
    public static final MarkAuto[] VALUES = values();
    public int count;

    public static MarkAuto getMark(int i) {

        return VALUES[i];

    }

    public String toStr() {

        return this.toString();

    }

}
