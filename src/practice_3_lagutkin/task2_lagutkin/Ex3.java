package practice_3_lagutkin.task2_lagutkin;

import io.reactivex.Observable;

import java.util.Random;

public class Ex3 {
    public static void main(String[] args) {
        Random random = new Random();
        int streamSize = random.nextInt(0, 1001);

        Observable<Integer> source = Observable.range(0, streamSize)
                .flatMap(i -> Observable.just(random.nextInt(1001)));
        Observable<Integer> result = source.lastElement().toObservable();

        result.subscribe(
                item -> System.out.println("Последний элемент: " + item)
        );

    }
}
