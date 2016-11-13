package ru.ittim.bytecode;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;


/**
 * Created by Timofey on 12.11.2016.
 */
public class TestTwoApproaches {
    private Blackhole blackhole;
    private Target target;
    private List<String> fields;
    private Map<String, Method> gettersReflection;
    private int BENCH_SIZE = 100_000_000;
    private Map<String, OneGetter> gettersBytecode;

    @Before
    public void init() throws IOException {
        target = new Target(1, 2, 3);
        blackhole = new Blackhole(target);
        gettersReflection = ReflectionAnalyser.getGetters(target);
        gettersBytecode = BytecodeAnalyzer.getGetters(target);
    }

    @Test
    public void reflectionTest() throws NoSuchFieldException, IllegalAccessException {
        long l = System.currentTimeMillis();
        for (int i = 0; i < BENCH_SIZE; i++) {
            FieldsHolder holder = new FieldsHolder();
            Map<String, Object> map = holder.fillReflection(target, gettersReflection);
            blackhole.add(map);
        }
        System.out.println((System.currentTimeMillis() - l) + " ms, " + blackhole.getCount());
    }

    @Test
    public void bytecodeTest() throws IOException, NoSuchMethodException {
        long l = System.currentTimeMillis();
        for (int i = 0; i < BENCH_SIZE; i++) {
            FieldsHolder holder = new FieldsHolder();
            Map<String, Object> map = holder.fillCGLIB(target, gettersBytecode);
            blackhole.add(map);
        }
        System.out.println((System.currentTimeMillis() - l) + " ms, " + blackhole.getCount());
    }
}
