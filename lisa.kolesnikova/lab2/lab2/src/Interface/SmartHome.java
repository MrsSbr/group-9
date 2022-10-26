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
    public static SmartObject smartHomeDevices(int n, Rooms room) throws Exception {
        SmartHome smartHome = switch (n) {
            case 1 -> SmartHome.createSmartObjectType(Type.LIGHT);
            case 2 -> SmartHome.createSmartObjectType(Type.HEAT);
            default -> throw new ClassNotFoundException();
        };
        return smartHome.createSmartObject(room);
    }
}
