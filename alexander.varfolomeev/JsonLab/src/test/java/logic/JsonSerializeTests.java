package logic;

import entity.Cat;
import entity.JsonSerializer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonSerializeTests {
    @Test
    public void SerializeSimpleObject() throws IllegalAccessException {
        Cat cat = new Cat();
        String result = "{\"age\": 12}";
        result = result.replace(" ", "");
        result = result.replace("\n", "");

        assertEquals(result, JsonSerializer.serialize(cat).replace(" ", "").replace("\n", ""));
    }
}
