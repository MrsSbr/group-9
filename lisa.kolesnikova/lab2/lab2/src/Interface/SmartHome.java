package Interface;

import Model.SmartHome.SmartHomeHeater;
import Model.SmartHome.SmartHomeLightning;
import Model.SmartObject.SmartObject;
import Enum.*;


public interface SmartHome {
    SmartObject createSmartObject(Rooms pos);

    static SmartHome createSmartObjectType(Type type) throws Exception {
        return switch (type) {
            case LIGHT-> new SmartHomeLightning();
            case HEAT -> new SmartHomeHeater();
            // ...
            default -> throw new ClassNotFoundException("Класс переданного типа не существует.");
        };
    }
}
