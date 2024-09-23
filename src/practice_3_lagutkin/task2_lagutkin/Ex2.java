package practice_3_lagutkin.task2_lagutkin;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ex2 {
    private static Random random = new Random();

    public static void main(String[] args) {
        Observable<Integer> stream1 = Observable.range(0, 1000)
                .map(i -> random.nextInt(100))
                .subscribeOn(Schedulers.computation());
        Observable<Integer> stream2 = Observable.range(0, 1000)
                .map(i -> random.nextInt(100))
                .subscribeOn(Schedulers.computation());

        Observable.zip(stream1,
                stream2,
                (num1, num2) -> "Stream1: " + num1 + ", Stream2: " + num2)
                .subscribe(result -> System.out.println(result),
                        Throwable::printStackTrace,
                        () -> System.out.println("Оба потока завершены"));

        // Ждем некоторое время, чтобы оба потока завершили работу
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
