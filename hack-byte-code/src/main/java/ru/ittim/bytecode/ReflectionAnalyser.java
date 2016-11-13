package ru.ittim.bytecode;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Timofey on 12.11.2016.
 */
public class ReflectionAnalyser {
    public static Map<String, Method> getGetters(Object bean) {
        Method[] methods = bean.getClass().getMethods();
        HashMap<String, Method> res = new HashMap<>();
        for (Method method : methods) {
            String name = method.getName();
            if (name.startsWith("get") && !name.equals("getClass")) {
                String fieldName = Character.toLowerCase(name.charAt(3)) + name.substring(4);
                res.put(fieldName, method);
            }
        }
        return res;
    }
}
