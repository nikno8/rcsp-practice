package practice_3_lagutkin.task2_lagutkin;

import io.reactivex.Observable;

import java.util.Random;

public class Ex1 {
    public static void main(String[] args) {
        Random random = new Random();

        // Генерируем случайное количество чисел от 0 до 1000
        int randomCount = random.nextInt(1001); // от 0 до 1000

        Observable<Integer> randomNumbersStream = Observable.range(0, randomCount)
                .flatMap(i -> Observable.just(random.nextInt(100))); // Генерация случайных чисел

        // Преобразуем поток в поток, содержащий количество чисел
        randomNumbersStream
                .count()
                .subscribe(count -> System.out.println("Количество чисел: " + count));
    }
}
