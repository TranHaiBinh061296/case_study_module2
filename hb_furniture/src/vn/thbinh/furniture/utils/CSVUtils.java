package vn.thbinh.furniture.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    public static <T> void writeFile(String path, List<T> items) {
        try {
            PrintWriter printWriter = new PrintWriter(path);
            for (Object item : items) {
                printWriter.println(item.toString());
            }
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile(String path)  {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null && !line.trim().isEmpty())
                lines.add(line);
        } catch (IOException e) {
            throw new IllegalArgumentException(path + " invalid");
        }
        return lines;
    }
}
