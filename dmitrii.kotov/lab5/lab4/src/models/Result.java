package models;

public enum Result {
    WIN("Победа"),
    LOSE_WITH_MERCY("Поражение с помилованием"),
    LOSE_WITHOUT_MERCY("Поражение без помилования");

    private final String str;

    Result(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return this.str;
    }
}
