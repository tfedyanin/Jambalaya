package ru.ittim.bytecode;

/**
 * Created by Timofey on 12.11.2016.
 */
public class Target {
    private Integer a;
    private Integer b;
    private Integer c;

    public Target(Integer a, Integer b, Integer c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }
}
