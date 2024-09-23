package practice_1_lagutkin.task1_lagutkin;

import java.util.concurrent.ExecutionException;
//
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Последовательное выполнение
        int[] numbersArray = ArrayGenerator.generateArray(10000);

//        long startTime = System.currentTimeMillis();
//        int max = Sequential.findMax(numbersArray);
//        long endTime = System.currentTimeMillis();
//
//        System.out.println("Max element: " + max);
//        System.out.println("Sequential execution time: " + (endTime - startTime) + " ms");

        // Многопоточное выполнение

//        long startTime = System.currentTimeMillis();
//        int max = Multithreaded.findMax(numbersArray, 3);
//        long endTime = System.currentTimeMillis();
//
//        System.out.println("Max element: " + max);
//        System.out.println("Multithreaded execution time: " + (endTime - startTime) + " ms");

        //ForkJoin

        long startTime = System.currentTimeMillis();
        int max = ForkJoin.findMaxNumberFork(numbersArray);
        long endTime = System.currentTimeMillis();

        System.out.println("Max element: " + max);
        System.out.println("ForkJoin execution time: " + (endTime - startTime) + " ms");

    }
}