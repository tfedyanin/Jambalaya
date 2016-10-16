package jambalaya.jni;

import java.util.ArrayList;

/**
 * Created by Timofey on 16.10.2016.
 */
public class Main {
    static {
        System.loadLibrary("libtestlib");
    }

    public static native long calcNative(int a, int b);
    public static native int calcNative(byte[] data);

    public static long calc(int a, int b){
        return b - a;
    };
    public static int calc(byte[] data){
        byte[] newData = new byte[data.length];
        System.arraycopy(data, 0, newData, 0, data.length);
        int res = 0;
        for (int i = 0; i < data.length; i++) {
            res++;
        }
        return res;
    };

    public static void main(String[] args) {
        final long count = 1_000_000_000L;

        long timeB = System.nanoTime();;
        long timeA = 0;
        for (long i = 0; i < count; i++) {
            calc(10, 9);
        }
        timeA = System.nanoTime();
        double nsPerPureSimple = ((double) (timeA - timeB)) / count;
        System.out.println("Simple pure = " +nsPerPureSimple + " ns per call");

        timeB = System.nanoTime();;
        for (long i = 0; i < count; i++) {
            calcNative(10, 9);
        }
        timeA = System.nanoTime();
        double nsPerNativeSimple = ((double) (timeA - timeB)) / count;
        System.out.println("Simple native = " +nsPerNativeSimple + " ns per call");

        final int countMini = 100_000;
        byte[] bytes = new byte[countMini];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (Math.random() * Byte.MAX_VALUE);
        }

        timeB = System.nanoTime();
        for (int i = 0; i < countMini; i++) {
            int calc = calc(bytes);
        }
        timeA = System.nanoTime();
        double nsPerPureComplex = ((double) (timeA - timeB)) / countMini;
        System.out.println("Complex pure = " +(int)nsPerPureComplex + " ns per call");

        timeB = System.nanoTime();
        for (int i = 0; i < countMini; i++) {
            int calc = calcNative(bytes);
        }
        timeA = System.nanoTime();
        double nsPerNativeComplex = ((double) (timeA - timeB)) / countMini;
        System.out.println("Complex native = " +(int)nsPerNativeComplex + " ns per call");
    }


}
