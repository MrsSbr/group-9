package interfaces;

import enums.PortTypes;
import models.CargoFactory;
import models.MilitaryFactory;
import models.Port;

public interface PortFactory {
    static PortFactory createPortFactoryType(PortTypes type) throws Exception {
        return switch (type) {
            case CARGO-> new CargoFactory();
            case MILITARY -> new MilitaryFactory();
            default -> throw new ClassNotFoundException("Класс переданного типа не существует.");
        };
    }
    Port createPort();
}
