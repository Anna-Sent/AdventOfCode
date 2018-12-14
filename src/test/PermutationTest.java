package test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PermutationTest {
    public static void main(String[] args) {
        permutate(new int[]{}, 0);
        permutate(new int[]{1}, 0);
        permutate(new int[]{1, 2}, 0);
        for (int i = 3; i <= 6; ++i) {
            int[] array = Stream.iterate(1, x -> x + 1).limit(i).mapToInt(Integer::intValue).toArray();
            permutate(array, 0);
        }
    }

    public static void permutate(int[] list, int pointer) {
        if (pointer == list.length) {
            System.out.println(String.join(",", Arrays.stream(list).mapToObj(x -> String.valueOf(x)).collect(Collectors.toList())));
            return;
        }
        for (int i = pointer; i < list.length; i++) {
            int[] permutation = list.clone();
            permutation[pointer] = list[i];
            permutation[i] = list[pointer];
            permutate(permutation, pointer + 1);
        }
    }
}
