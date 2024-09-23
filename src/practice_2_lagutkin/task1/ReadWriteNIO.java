package practice_2_lagutkin.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadWriteNIO {
    public static void main(String[] args) {
        String filename = "test.txt";
        List<String> strings = List.of("Some line 1",
                "Some line 2",
                "Some line 3");

        writeLinesToFile(filename, strings);
        readAndPrintFileContent(filename);
    }

    private static void writeLinesToFile(String filename, List<String> strings) {
        Path path = Paths.get(filename);
        try {
            Files.write(path, strings);
            System.out.println("Файл успешно создан: " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл " + e.getMessage());
        }
    }
    private static void readAndPrintFileContent(String filename) {
        Path filePath = Paths.get(filename);
        try {
            List<String> lines = Files.readAllLines(filePath);
            System.out.println("Содержимое файла " + filename + ":");
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Ошибка чтения из файла " + e.getMessage());
        }
    }


}
