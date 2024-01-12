package advent.advent2015;

import java.util.Arrays;

public class AoC2015Day17Part1 {
    public static void main(String[] args) {
        test(5, new int[]{5, 5}, 2);

        test(10, new int[]{5, 5}, 1);

        test(25, new int[]{20, 15, 10, 5, 5}, 4);

        test(150, new int[]{150}, 1);

        test(150, new int[]{15}, 0);

        test(9, new int[]{3, 3, 3}, 1);

        test(150, new int[]{43, 3, 4, 10, 21, 44, 4, 6, 47, 41, 34, 17, 17,
                44, 36, 31, 46, 9, 27, 38}, 1638);
    }

    private static void test(int total, int[] containers, int expected) {
        int actual1 = solve1(total, containers);
        System.out.println(actual1);
        assert actual1 == expected || expected == -1;
        int actual2 = solve2(total, containers);
        System.out.println(actual2);
        assert actual2 == expected || expected == -1;
        assert actual1 == actual2;
    }

    static int solve1(int total, int[] containers) {
        int len = containers.length;
        int count = 1 << len;
        int variants = 0;
        for (int i = 0; i < count; ++i) {
            int sum = 0;
            for (int j = len - 1; j >= 0; --j) {
                int number = (i >> j) & 1;
                if (number == 1) {
                    sum += containers[j];
                }
                // System.out.print(number);
            }
            // System.out.println();
            if (sum == total) {
                ++variants;
            }
        }
        return variants;
    }

    static int solve2(int total, int[] containers) {
        int len = total + 1;
        int[] array = new int[len];
        int[] arrayAdd = new int[len];
        for (int i = 0; i < containers.length; ++i) {
            int container = containers[i];
            Arrays.fill(arrayAdd, 0);
            for (int j = 1; j < len - container; ++j) {
                if (array[j] > 0) {
                    arrayAdd[j + container] = array[j];
                }
            }
            ++arrayAdd[container];
            for (int j = 1; j < len; ++j) {
                array[j] += arrayAdd[j];
            }
        }
        return array[total];
    }
}