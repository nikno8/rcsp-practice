package practice_3_lagutkin.task4_lagutkin;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;


import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class FileGenerator {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private static Random random = new Random();
    // Генерирует файлы асинхронно с задержкой
    public Observable<File> generateFile() {
        return Observable
                .fromCallable(() -> {
                    try {
                        FileType fileType = FileType.values()[random.nextInt(FileType.values().length)];
                        int fileSize = (int) (Math.random() * 91) + 10;
                        Thread.sleep((long) (Math.random() * 901) + 100); //Имитация генерации файла
                        return new File(fileType, fileSize);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .repeat() // Повторяем бесконечно
                .subscribeOn(Schedulers.io()) // Выполняется в фоновом потоке
                .observeOn(Schedulers.io()); // Результаты наблюдаются в фоновом потоке
    }
}
