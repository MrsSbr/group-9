package enums;

public enum ColorGift {
    YELLOW("желтый"),
    RED("красный"),
    GREEN("зеленый"),
    BLUE("синий"),
    GRAY("серый"),
    BLACK("черный"),
    PINK("розовый"),
    NOT_DEFINE("not define");

    final String color;

    ColorGift(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public static ColorGift getColor(String color) {
        for (ColorGift c : ColorGift.values()) {
            if (c.getColor().equals(color))
                return c;
        }
        return NOT_DEFINE;
    }
}
