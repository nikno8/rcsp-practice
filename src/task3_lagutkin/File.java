package task3_lagutkin;

public class File {
    private final FileType type;
    private final int size;

    public File(FileType type, int size) {
        this.type = type;
        this.size = size;
    }

    public FileType getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "File{" +
                "type=" + type +
                ", size=" + size +
                '}';
    }
}