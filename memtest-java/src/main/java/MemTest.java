/**
 * Created by Timofey on 08.11.2016.
 */
public class MemTest {
    public static int read;

    public static void main(String[] args) {
        long size;
        int iter;
        if (args.length > 0) {
            size = Integer.parseInt(args[0]) * 1024 * 1024 / 4;
        } else {
            size = 256 * 1024 * 1024;
        }
        if (args.length > 1) {
            iter = Integer.parseInt(args[1]);
        } else {
            iter = 1;
        }
        int[] a = new int[(int) size];
        int[] b = new int[(int) size];
        long l = System.currentTimeMillis();
        for (int j = 0; j < iter; j++) {
            System.arraycopy(a, 0, b, 0, a.length);
        }
        l = System.currentTimeMillis() - l;
        System.out.println("Copy " + size * 4 * iter / l / 1024 + "MB/s");
        l = System.currentTimeMillis();
        for (int j = 0; j < iter; j++) {
            for (int i = 0; i < a.length; i++) {
                read = a[i];
            }
        }
        l = System.currentTimeMillis() - l;
        System.out.println("Pseudoread " + size * 4 * iter / l / 1024 + "MB/s");

    }
}
