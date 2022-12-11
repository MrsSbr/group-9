package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FlowerOrder {

    private final String type;
    private final List<String> composition;
    private final double cost;
    private final ReceivingType receive;



    public FlowerOrder(String type, String composition, double cost, char receive) {

        this.type = type;
        this.cost = cost;

        this.receive = ( receive == 'd' ? ReceivingType.DELIVERY : ReceivingType.PICKUP);

        this.composition = new ArrayList<>(List.of(composition.split(",")));

    }

    public String getType() {

        return type;

    }

    public List<String> getComposition() {

        return composition;

    }

    public int getCompositionSize() {

        return composition.size();

    }

    public double getCost() {

        return cost;

    }

    public ReceivingType getReceive() {

        return receive;

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FlowerOrder that = (FlowerOrder) o;
        return Double.compare(that.cost, cost) == 0 &&
                Objects.equals(type, that.type) &&
                Objects.equals(composition, that.composition) &&
                receive == that.receive;

    }

    @Override
    public int hashCode() {

        return Objects.hash(type, composition, cost, receive);

    }
}
