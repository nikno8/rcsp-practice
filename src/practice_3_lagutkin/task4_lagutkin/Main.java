package practice_3_lagutkin.task4_lagutkin;

public class Main {
    public static void main(String[] args) {
        int queueCapacity = 5;
        FileQueue fileQueue = new FileQueue(queueCapacity);

        for (FileType fileType : FileType.values()) {
            new FileProcessor(fileType)
                    .processFiles(fileQueue.getFileObservable())
                    .subscribe(
                            () -> {},
                            throwable -> System.err.println("Error processing file: " + throwable)
                    );
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
