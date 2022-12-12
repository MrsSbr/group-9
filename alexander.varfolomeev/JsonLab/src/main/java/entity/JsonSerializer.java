package entity;

import java.io.Serializable;

public abstract class JsonSerializer {

    static public <T extends Serializable> String serialize(T object) {

        return "";
    }

    static public Object deserialize(String jsonDocument)
    {
        return new Object();
    }

}
