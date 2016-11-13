package ru.ittim.bytecode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Timofey on 12.11.2016.
 */
public class FieldsHolder {
    private Map<String, Object> fieldNameValueMap;

    public FieldsHolder() {
        fieldNameValueMap = new HashMap<>();
    }

    public Map<String, Object> fillReflection(Object o, Map<String, Method> getters) throws NoSuchFieldException, IllegalAccessException {
        getters.forEach((k, v) -> {
            try {
                fieldNameValueMap.put(k, v.invoke(o));
            } catch ( IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        return fieldNameValueMap;
    }

    public Map<String, Object> fillCGLIB(Target target, Map<String, OneGetter> getters) {
        getters.forEach((k, v) -> {
            Object value = v.get();
            fieldNameValueMap.put(k, value);
        });
        return fieldNameValueMap;
    }
}
