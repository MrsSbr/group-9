package enums;

public enum BreedType {
    MAINE_COON("Maine-Coon"),
    ABYSSINIAN("Abyssinian"),
    PERSIAN("Persian"),
    SIAMESE("Siamese");

    private final String value;

    BreedType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
