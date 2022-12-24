package enums;

public enum TypeGift {
    DOLL("кукла"),
    CAR("машина"),
    WEAPON("пистолет"),
    SOFT_TOY("мягкая игрушка"),
    CONSTRUCTOR("конструктор"),
    NOT_DEFINE("not define");
    private final String name;

    TypeGift(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static TypeGift getType(String name) {
        for (TypeGift t : TypeGift.values()) {
            if (t.getName().equals(name))
                return t;
        }
        return NOT_DEFINE;
    }
}
