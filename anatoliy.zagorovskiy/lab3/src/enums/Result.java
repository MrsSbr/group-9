package enums;

public enum Result {
    JUSTIFIED("Оправдан"),
    CONDEMNED("Осуждён");

    private String str;
    Result(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return this.str;
    }
}
