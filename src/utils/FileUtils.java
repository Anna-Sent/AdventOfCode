package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {
    public static String readToString(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            for (String line = reader.readLine(); line != null; sb.append(line).append("\r\n"), line = reader.readLine())
                ;
            return sb.toString();
        }
    }
}