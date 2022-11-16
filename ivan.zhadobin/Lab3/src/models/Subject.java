package models;

public enum Subject {
    MathAn,
    ALgebra,
    Inform,
    ChislMethod,
    DU,
    TerVer,
    FunkAn;
    public static final Subject[] VALUES = values();

    public static Subject getEnum(int i) {
        return VALUES[i];
    }

    public String toStr() {
        return this.toString();
    }
}
