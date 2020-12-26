package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class FileUtils {
    public static String readToString(String packageName, String fileName) throws IOException {
        String path = Paths.get(".").toAbsolutePath().normalize() + File.separator +
                "src" + File.separator +
                packageName + File.separator +
                fileName;
        System.out.println(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            for (String line = reader.readLine(); line != null; sb.append(line).append("\r\n"), line = reader.readLine())
                ;
            return sb.toString();
        }
    }
}
