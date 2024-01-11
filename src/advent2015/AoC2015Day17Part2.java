package advent2015;

import java.util.Arrays;

public class AoC2015Day17Part2 {
    public static void main(String[] args) {
        test(5, new int[]{5, 5}, 2);

        test(10, new int[]{5, 5}, 1);

        test(25, new int[]{20, 15, 10, 5, 5}, 3);

        test(150, new int[]{150}, 1);

        test(150, new int[]{15}, 0);

        test(9, new int[]{3, 3, 3}, 1);

        test(150, new int[]{43, 3, 4, 10, 21, 44, 4, 6, 47, 41, 34, 17, 17,
                44, 36, 31, 46, 9, 27, 38}, 17);
    }

    public static void test(int total, int[] containers, int expected) {
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
        int minContainersCount = Integer.MAX_VALUE;
        for (int i = 0; i < count; ++i) {
            int sum = 0;
            int containersCount = 0;
            for (int j = len - 1; j >= 0; --j) {
                int number = (i >> j) & 1;
                if (number == 1) {
                    sum += containers[j];
                    ++containersCount;
                }
                // System.out.print(number);
            }
            // System.out.println();
            if (sum == total) {
                if (containersCount == minContainersCount) {
                    ++variants;
                } else if (containersCount < minContainersCount) {
                    variants = 1;
                    minContainersCount = containersCount;
                }
            }
        }
        return variants;
    }

    static int solve2(int total, int[] containers) {
        int len = total + 1;
        int[] array = new int[len];
        int[] arrayAdd = new int[len];
        int[] minContainers = new int[len];
        int[] minContainersAdd = new int[len];
        for (int i = 0; i < containers.length; ++i) {
            int container = containers[i];
            Arrays.fill(arrayAdd, 0);
            Arrays.fill(minContainersAdd, 0);
            for (int j = 1; j < len - container; ++j) {
                if (array[j] > 0) {
                    arrayAdd[j + container] = array[j];
                    minContainersAdd[j + container] = minContainers[j] + 1;
                }
            }
            ++arrayAdd[container];
            ++minContainersAdd[container];
            for (int j = 1; j < len; ++j) {
                if (minContainers[j] > minContainersAdd[j]
                        && minContainersAdd[j] != 0 || minContainers[j] == 0) {
                    array[j] = arrayAdd[j];
                    minContainers[j] = minContainersAdd[j];
                } else if (minContainers[j] == minContainersAdd[j]) {
                    array[j] += arrayAdd[j];
                }
            }
        }
        return array[total];
    }
}