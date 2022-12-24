package enums;

public enum SizeGift {
    SMALL("маленький"),
    MEDIUM("средний"),
    BIG("большой"),
    NOT_DEFINE("not define");
    private final String sizeName;

    SizeGift(String sizeName) {

        this.sizeName = sizeName;

    }

    public String getName() {
        return this.sizeName;
    }

    public static SizeGift getSize(String size) {
        for (SizeGift s : SizeGift.values()) {
            if (s.getName().equals(size))
                return s;
        }
        return NOT_DEFINE;
    }
}
