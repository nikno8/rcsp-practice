package task1_lagutkin;

import java.util.Random;

public class ArrayGenerator {
    private static Random random = new Random();
    public static int[] generateArray(int size){
        int[] array = new int[size];
        for (int i = 0; i < size; i++){
            array[i] = random.nextInt(10000);
        }

        return array;
    }
}
