package entity;

public enum PlaceBattle {
    VORONEZH_RIVER("Река Воронеж"),
    RYAZAN("город Рязань"),
    BELGOROD("город Белгород"),
    TVER("горорд Тверь");
    private final String str;

    PlaceBattle(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return this.str;
    }
}
