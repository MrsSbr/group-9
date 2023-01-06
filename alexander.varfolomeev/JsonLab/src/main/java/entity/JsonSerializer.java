package entity;

import org.apache.commons.text.StringEscapeUtils;

import java.io.Serializable;
import java.util.*;

public abstract class JsonSerializer {

    static public String serialize(Object object) throws IllegalAccessException {
        var list = object.getClass().getDeclaredFields();
        StringBuilder result = new StringBuilder("{");
        for (var field : list) {
            field.setAccessible(true);
            result.append('"').append(field.getName()).append("\":").append(serializeValue(field.get(object))).append(",");
        }
       // result.deleteCharAt(result.length() - 1);
        result.deleteCharAt(result.length() - 1);
        return result.append("}").toString();
    }

    static public String serializeValue(Object object) throws IllegalAccessException {
        StringBuilder result = new StringBuilder();
        if (object == null) {
            result.append("null");
        } else if (object instanceof String str) {
            result.append('"').append(StringEscapeUtils.escapeJson(str)).append('"');
        } else if (object.getClass().isEnum()) {
            result.append(String.format("\"%s\"", object));
        } else if (object.getClass().isPrimitive() || isPrimitiveType(object.getClass())) {
            result.append(object);
        } else if (object.getClass().isArray()) {
            result.append(serializeArray(object));
        } else {
            result.append(serialize(object));
        }

        return result.toString();
    }

    static private String serializeArray(Object object) throws IllegalAccessException {
        StringBuilder result = new StringBuilder();
        if (object instanceof Object[] array) {
            result.append("[");
            for (Object o : array) {
                result.append(serializeValue(o)).append(",");
            }
            result.deleteCharAt(result.length() - 1);
            //result.deleteCharAt(result.length() - 1);
            result.append("]");
        } else {
            result.append(serializeArrayOfPrimitives(object));
        }

        return result.toString();
    }

    static private String serializeArrayOfPrimitives(Object arr) throws IllegalAccessException {
        StringBuilder result = new StringBuilder();

        if (arr instanceof int[] convertArr) {
            result.append(Arrays.toString(convertArr));
        } else if (arr instanceof double[] convertArr) {
            result.append(Arrays.toString(convertArr));
        } else if (arr instanceof float[] convertArr) {
            result.append(Arrays.toString(convertArr));
        } else if (arr instanceof char[] convertArr) {
            result.append(Arrays.toString(convertArr));
        } else if (arr instanceof byte[] convertArr) {
            result.append(Arrays.toString(convertArr));
        } else if (arr instanceof short[] convertArr) {
            result.append(Arrays.toString(convertArr));
        } else if (arr instanceof long[] convertArr) {
            result.append(Arrays.toString(convertArr));
        } else if (arr instanceof boolean[] convertArr) {
            result.append(Arrays.toString(convertArr));
        }

        return result.toString();
    }

    static public Object deserialize(String jsonDocument) {
        return new Object();
    }


    //region
    private static final Set<Class<?>> WRAPPER_TYPES = getPrimitiveTypes();

    public static boolean isPrimitiveType(Class<?> clazz) {
        return WRAPPER_TYPES.contains(clazz);
    }

    private static Set<Class<?>> getPrimitiveTypes() {
        Set<Class<?>> ret = new HashSet<Class<?>>();
        ret.add(Boolean.class);
        ret.add(Character.class);
        ret.add(Byte.class);
        ret.add(Short.class);
        ret.add(Integer.class);
        ret.add(Long.class);
        ret.add(Float.class);
        ret.add(Double.class);
        ret.add(Void.class);
        return ret;
    }
    //endregion

}
