package test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestJava8 {
    private static String[] DIRS = new String[]{
            "C:\\Users\\User\\workspace\\",
            "C:\\Users\\User\\Desktop\\my_android_workspace\\",
            "C:\\Users\\User\\Desktop\\tv_android_workspace\\"};

    private static Set<String> EXCEPT_DIRS = new HashSet<>();

    static {
        EXCEPT_DIRS.add("android-i18n-plurals");
        EXCEPT_DIRS.add("ComLibSher");
        EXCEPT_DIRS.add("google-play-services_lib");
        EXCEPT_DIRS.add("OSMDroid");
        EXCEPT_DIRS.add("Payment");
        EXCEPT_DIRS.add("SherLib");
        EXCEPT_DIRS.add("tv_ios");
        EXCEPT_DIRS.add("RE");
        EXCEPT_DIRS.add("bin");
        EXCEPT_DIRS.add("gen");
        EXCEPT_DIRS.add("build");
        EXCEPT_DIRS.add("generated");
    }

    public static void main(String[] args) {

        Collection<String> lines = new HashSet<>();
        List<String> files = new ArrayList<>();

        for (String dir : DIRS) {
            findInDir(Paths.get(dir), lines, files);
        }

        lines = new ArrayList<>(lines);
        Collections.sort((List) lines);

        try {
            Files.write(Paths.get("C:\\Users\\User\\workspace\\lines.txt"), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(files);

        try {
            Files.write(Paths.get("C:\\Users\\User\\workspace\\files.txt"), files);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findInDir(Path dir, Collection<String> lines, Collection<String> files) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    if (!EXCEPT_DIRS.contains(entry.getFileName().toString())) {
                        findInDir(entry, lines, files);
                    }
                } else {
                    if (entry.toString().endsWith(".java")) {
                        files.add(entry.toString());
                        findInFile(entry, lines);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findInFile(Path file, Collection<String> lines) {
        try (Stream<String> stream = Files.lines(file)) {

            lines.addAll(stream
                    .filter(line -> line.startsWith("import"))
                    .collect(Collectors.toList()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}