package practice_1_lagutkin.task1_lagutkin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoin {

    public static int findMaxNumberFork(int[] array) {
        // Проверяем, что массив не пуст и не равен null
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив пуст или равен null");
        }
        // Создаем пул потоков task1.ForkJoin
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // Создаем корневую задачу MaxFinderTask для всего массива
        MaxFinderTask task = new MaxFinderTask(array, 0, array.length);
        // Выполняем корневую задачу и получаем результат
        return forkJoinPool.invoke(task);
    }

    static class MaxFinderTask extends RecursiveTask<Integer> {
        private int[] array;
        private int start;
        private int end;

        // Конструктор MaxFinderTask для создания задачи для подмассива
        MaxFinderTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        // Метод compute(), выполняющий вычисления для задачи
        @Override
        protected Integer compute() {
            // Если в подмассиве меньше или равно 500 элементов, находим максимум последовательно
            if (end - start <= 500) {
                try {
                    return findMaxInRange(array, start, end);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            // Находим середину подмассива
            int middle = start + (end - start) / 2;

            // Создаем две подзадачи для левой и правой половин подмассива
            MaxFinderTask leftTask = new MaxFinderTask(array, start, middle);
            MaxFinderTask rightTask = new MaxFinderTask(array, middle, end);

            // Запускаем подзадачу для левой половины параллельно
            leftTask.fork();

            // Вычисляем максимальные значения в правой половине подмассива
            int rightResult = rightTask.compute();

            // Получаем результат из левой половины подмассива
            int leftResult = leftTask.join();

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Возвращаем максимальное значение из левой и правой половин
            return Math.max(leftResult, rightResult);
        }
    }

    // Метод для поиска максимального значения в указанном диапазоне массива
    public static int findMaxInRange(int[] array, int start, int end) throws InterruptedException {
        int localMax = array[start];
        for (int i = start + 1; i < end; i++) {
            Thread.sleep(1); // Симуляция работы
            if (array[i] > localMax) {
                localMax = array[i];
            }
        }
        return localMax;
    }


}