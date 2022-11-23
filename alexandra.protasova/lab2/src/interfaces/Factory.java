package interfaces;
import enums.AplianceType;
import сlass.BlenderFactory;
import сlass.Fridge;
import сlass.FridgeFactory;
import сlass.KitchenApliance;

public interface Factory {

    KitchenApliance createApliance();

    static Factory createAplianceType(AplianceType type) throws Exception {
        return switch (type) {
            case BLENDER-> new BlenderFactory();
            case FRIDGE -> new FridgeFactory();
            default -> throw new ClassNotFoundException("Класс переданного типа не существует.");
        };
    }

}
