package entity;

import java.util.stream.Stream;

public enum PlaceBattle {
    VORONEZH_RIVER("Река Воронеж"),
    RYAZAN("город Рязань"),
    BELGOROD("город Белгород"),
    TVER("горорд Тверь");
    private final String str;

    public static Stream<PlaceBattle> stream() {
        return Stream.of(PlaceBattle.values());
    }

    PlaceBattle(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return this.str;
    }
}
