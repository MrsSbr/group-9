package Enum;

public enum GenderType {
    MALE("Мale"),
    FEMALE("Female");

    private final String value;

    GenderType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
