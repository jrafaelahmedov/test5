import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteToFileExampleNIO {

    public static void main(String[] args) {
        copyFileUsingPath();
    }

    public static void writeUsingPath(String data,boolean append) throws IOException {
        Path path = Paths.get("question.txt");
        if(append)
            Files.write(path,data.getBytes(), StandardOpenOption.APPEND);
        else
            Files.write(path, data.getBytes());
    }

    public static void writeUsingBufferedWriter() throws IOException {
        Path path = Paths.get("text.txt");
        BufferedWriter writer = Files.newBufferedWriter(path);
            writer.write("To be, or not to be. That is the question.");
            writer.close();
    }

    public static void copyFileUsingPath(){
        Path oldFile = Paths.get("", "Sarkhan Rasullu.jpg");
        Path newFile = Paths.get("", "Sarkhan Rasullu2.jpg");
        try (OutputStream os = new FileOutputStream(newFile.toFile())) {
            Files.copy(oldFile, os);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
