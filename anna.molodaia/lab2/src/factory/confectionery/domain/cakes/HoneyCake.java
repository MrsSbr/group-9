package factory.confectionery.domain.cakes;

public class HoneyCake extends Cake{
    public HoneyCake() {
        super("Медовик", "Заварной крем", "Бисквитное");
    }

    @Override
    public String toString() {
        return "Медовый " + super.toString();
    }
}
