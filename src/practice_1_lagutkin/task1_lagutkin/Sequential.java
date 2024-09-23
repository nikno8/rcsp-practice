package practice_1_lagutkin.task1_lagutkin;

public class Sequential {

    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

}
