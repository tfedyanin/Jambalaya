package fj.mergesort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by Timofey on 27.07.2016.
 */
public class MergeSortForkJoin {
    public static void main(String[] args) {
        int length = 5000000;
        Double[] doublesForLittle = new Double[length];
        for (int i = 0; i < length; i++) {
            doublesForLittle[i] = Math.random() * length;
        }

        Double[] doublesForBig = doublesForLittle.clone();
        Double[] doublesForStandart = doublesForLittle.clone();

//        System.out.println(Arrays.toString(doublesForLittle));
        ForkJoinPool littlePool = new ForkJoinPool(1);
        int parallelism = Runtime.getRuntime().availableProcessors();
        System.out.println("parallelism: " + parallelism);
        ForkJoinPool bigPool = new ForkJoinPool(parallelism);

        long time;
        MergeSortTask<Double> taskForLittle = new MergeSortTask<>(doublesForLittle);
        MergeSortTask<Double> taskForBig = new MergeSortTask<>(doublesForBig);

        time = System.currentTimeMillis();
        littlePool.invoke(taskForLittle);
        System.err.println((System.currentTimeMillis() - time));

//        System.out.println(Arrays.toString(doublesForLittle));


        time = System.currentTimeMillis();
        bigPool.invoke(taskForBig);
        System.err.println((System.currentTimeMillis() - time));

//        System.out.println(Arrays.toString(doublesForBig));

        time = System.currentTimeMillis();
        Arrays.sort(doublesForStandart);
        System.err.println((System.currentTimeMillis() - time));
    }
}
