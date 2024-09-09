package task3_lagutkin;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<File> queue = new ArrayBlockingQueue<>(5);


        Thread generatorThread = new Thread(new FileGenerator(queue));
        generatorThread.start();


        Thread xmlProcessor = new Thread(new FileProcessor(queue, FileType.XML));
        Thread jsonProcessor = new Thread(new FileProcessor(queue, FileType.JSON));
        Thread xlsProcessor = new Thread(new FileProcessor(queue, FileType.XLS));

        xmlProcessor.start();
        jsonProcessor.start();
        xlsProcessor.start();


    }
}
