package practice_1_lagutkin.task2_lagutkin;

import java.util.Scanner;
import java.util.concurrent.*;

public class FutureExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите число (или 'exit' для выхода): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                // Создаем задачу для выполнения с задержкой и возведения числа в квадрат
                Future<Integer> future = executor.submit(() -> {
                    int delay = ThreadLocalRandom.current().nextInt(1, 6);
                    TimeUnit.SECONDS.sleep(delay);
                    // Возводим число в квадрат
                    return number * number;
                });


                System.out.println("Обработка запроса...");
                int result = future.get(); // Блокирующий вызов
                System.out.println("Результат: " + result);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите допустимое число.");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

        }
        executor.shutdown();

    }
}

