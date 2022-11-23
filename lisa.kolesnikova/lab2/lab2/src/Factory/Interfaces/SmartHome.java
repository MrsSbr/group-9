package Factory.Interfaces;

import Models.SmartObject.SmartObject;
import Enum.*;


public interface SmartHome {
    SmartObject createSmartObject(Rooms pos);
}
