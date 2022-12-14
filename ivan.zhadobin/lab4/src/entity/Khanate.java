package entity;

public enum Khanate {
    GOLDEN_HORD("Золотая Орда"),
    THE_STATE_OF_THE_HULAGUIDS("Государство Хулагуидов"),
    CHAGATAI_ULUS("Чагатайский улус"),
    THE_GREAT_KHANATE("Великое ханство");
    private final String str;

    Khanate(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return this.str;
    }
}
