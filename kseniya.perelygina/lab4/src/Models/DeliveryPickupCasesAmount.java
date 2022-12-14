package Models;

public class DeliveryPickupCasesAmount {

    private int deliveries;
    private int pickups;

    public DeliveryPickupCasesAmount() {
        deliveries = 0;
        pickups = 0;
    }

    public int getDeliveries() {
        return deliveries;
    }

    public int getPickups() {
        return pickups;
    }

    public void deliveryCase() {
        deliveries++;
    }

    public void pickupCase() {
        pickups++;
    }

    public ReceivingType whatsMore() {

        if (deliveries > pickups) {

            return ReceivingType.DELIVERY;

        } else if (pickups > deliveries) {

            return ReceivingType.PICKUP;

        } else {

            return ReceivingType.NONE;

        }
    }
}
