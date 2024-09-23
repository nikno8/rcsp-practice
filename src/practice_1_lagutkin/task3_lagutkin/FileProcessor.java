package practice_1_lagutkin.task3_lagutkin;

import java.util.concurrent.BlockingQueue;

public class FileProcessor implements Runnable {
    private final BlockingQueue<File> queue;
    private final FileType supportedType;

    public FileProcessor(BlockingQueue<File> queue, FileType supportedType) {
        this.queue = queue;
        this.supportedType = supportedType;
    }

    @Override
    public void run() {
        try {
            while (true) {
                File file = queue.take();
                if (file.getType() == supportedType) {
                    long processingTime = file.getSize() * 7; // Время обработки
                    Thread.sleep(processingTime);
                    System.out.println("Обработан файл типа " +
                                    file.getType() +
                                    " с размером " + file.getSize() + ". Время обработки: " + processingTime + " мс.");
                }
                else {
                    queue.put(file);
                    Thread.sleep(100);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
