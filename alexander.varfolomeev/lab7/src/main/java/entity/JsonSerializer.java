package entity;

import java.io.Serializable;

public abstract class JsonSerializer {

    static public <T extends Serializable> String Serialize(T object) {
        return "";
    }

}
