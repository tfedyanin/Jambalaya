package ru.ittim.bytecode;


import net.sf.cglib.reflect.MethodDelegate;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Timofey on 13.11.2016.
 */
public class BytecodeAnalyzer {
    public static Map<String, OneGetter> getGetters(Object bean) throws IOException {
        Map<String, Method> getters = ReflectionAnalyser.getGetters(bean);
        HashMap<String, OneGetter> res = new HashMap<>();
        getters.forEach((k,v) ->{
            OneGetter getter = (OneGetter) MethodDelegate.create(bean, v.getName(), OneGetter.class);
            res.put(k, getter);
        });

        return res;
    }
}
