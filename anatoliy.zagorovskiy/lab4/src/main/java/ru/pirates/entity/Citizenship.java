package ru.pirates.entity;

public enum Citizenship {
    PERU("Перу"),
    SPAIN("Испания"),
    GREAT_BRITAIN("Великобритания"),
    AMERICA("Америка"),
    RUSSIA("Россия");

    private final String str;

    Citizenship(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return this.str;
    }
}
