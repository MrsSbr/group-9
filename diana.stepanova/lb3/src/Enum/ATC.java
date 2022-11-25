package Enum;

public enum ATC {
    MTC(78), Tele2(11), Megafon(25), Beeline(46);

    private int numVal;

    ATC(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
