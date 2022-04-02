package examples.books.java_programm_design_by_edward_sciore.version8_object_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException {
        String file = "C:\\Users\\DVatlin\\IdeaProjects\\JavaDesignPatternsGOF\\src\\main\\resources\\fname.txt"; // abcdefghigklmnop
        InputStream inputStream = new FileInputStream(file);

        // читаем последовательно из потока
        System.out.println((char) inputStream.read()); // a
        System.out.println((char) inputStream.read()); // b
        for (byte by: inputStream.readAllBytes()) // cdefghigklmnop
            System.out.print((char) by);
    }
}
