package Models;

public enum ReceivingType {
    DELIVERY("доставка"),
    PICKUP("самовывоз"),
    NONE("-");

    private String title;
    ReceivingType(String title) {

        this.title = title;

    }

    @Override
    public String toString() {
        return title;
    }
}
