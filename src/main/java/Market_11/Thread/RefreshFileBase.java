package Market_11.Thread;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class RefreshFileBase implements Runnable {

    private HashMap list;

    public RefreshFileBase(HashMap map) {
        this.list = map;
    }

    @Override
    public void run() {
        try {
            FileWriter file = new FileWriter("marketBase.txt", false);

            try (BufferedWriter write = new BufferedWriter(file)) {
                write.write(Arrays.toString(
                        Stream.of(list).
                                toArray()).toString()
                        .replace(", ", "")
                        .replace("[", "")
                        .replace("{", "")
                        .replace("}", "")
                        .replace("]", "")
                        .replaceAll("[0-9]{9}\\=", ""));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                file.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
