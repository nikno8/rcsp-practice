package practice_1_lagutkin.task1_lagutkin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Multithreaded {


    public static int findMax(int[] array, int numThreads) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        int numbersForOneThread = array.length / numThreads;

        Future<Integer>[] futures = new Future[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int start = i * numbersForOneThread;
            int end = (i == numThreads - 1) ? array.length : start + numbersForOneThread;
            futures[i] = executor.submit(() -> {

                int localMax = array[start];


                for (int j = start + 1; j < end; j++) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (array[j] > localMax) {
                        localMax = array[j];
                    }
                }
                return localMax;
            });
        }

        int max = futures[0].get();
        for (int i = 1; i < numThreads; i++) {
            int localMax = futures[i].get();
            if (localMax > max) {
                max = localMax;
            }
        }

        executor.shutdown();
        return max;
    }


}
