package ru.ittim.bytecode;

/**
 * Created by Timofey on 12.11.2016.
 */
public class Blackhole {
    private int count;
    private Object o;

    public Blackhole(Object o) {
        this.o = o;
    }

    public void add(Object o) {
        this.o = o;
        count++;
    }

    public Object get() {
        return o;
    }

    public int getCount() {
        return count;
    }
}
