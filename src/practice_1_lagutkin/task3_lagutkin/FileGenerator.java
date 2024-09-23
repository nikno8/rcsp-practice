package practice_1_lagutkin.task3_lagutkin;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

class FileGenerator implements Runnable {
    private final BlockingQueue<File> queue;
    private final Random random = new Random();

    public FileGenerator(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                FileType type = FileType.values()[random.nextInt(FileType.values().length)];
                int size = random.nextInt(91) + 10;
                File file = new File(type, size);
                queue.put(file);
                System.out.println("Сгенерирован: " + file);
                Thread.sleep(random.nextInt(901) + 100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}