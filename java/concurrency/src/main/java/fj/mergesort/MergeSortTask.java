package fj.mergesort;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/**
 * Created by Timofey on 27.07.2016.
 */
public class MergeSortTask<T extends Comparable<? super T>> extends RecursiveAction {
    static final int THRESHOLD = 10;

    final T[] array;
    final int lo, hi;

    public MergeSortTask(T[] array, int lo, int hi) {
        this.array = array;
        this.lo = lo;
        this.hi = hi;
    }

    public MergeSortTask(T[] array) {
        this(array, 0, array.length);
    }

    protected void compute() {
        if (hi - lo < THRESHOLD) {
            sortSequentially(lo, hi);
        } else {
            int mid = (lo + hi) >>> 1;
            invokeAll(new MergeSortTask<T>(array, lo, mid),
                      new MergeSortTask<T>(array, mid, hi));
            merge(lo, mid, hi);
        }

    }

    private void merge(int lo, int mid, int hi) {
        T[] buf = Arrays.copyOfRange(array, lo, mid);
        for (int i = 0, j = lo, k = mid; i < buf.length; j++) {
            array[j] = (k == hi || buf[i].compareTo(array[k]) < 0 ?
                    buf[i++] : array[k++]);
        }
    }

    private void sortSequentially(int lo, int hi) {
        Arrays.sort(array, lo, hi);
    }
}
