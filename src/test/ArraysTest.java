package test;

import java.util.Arrays;
import java.util.List;

public class ArraysTest {

    public static void main(String[] args) {
        System.out.println(Arrays.asList(1, 2, 3));
        System.out.println(toList1(1, 2, 3));
        System.out.println(toList2(1, 2, 3));
    }

    private static List<Integer> toList1(Integer... args) {
        return Arrays.asList(args);
    }

    @SafeVarargs
    private static <T> List<T> toList2(T... args) {
        return Arrays.asList(args);
    }
}
