package advent.advent2017;

import java.util.HashSet;
import java.util.Set;

public class AoC2017Day6Part1 {
    public static void main(String[] args) {
        int result;

        result = test("0 2 7 0");
        assert result == 5 : "unexpected result is " + result;
        System.out.println(result);

        result = test("14\t0\t15\t12\t11\t11\t3\t5\t1\t6\t8\t4\t9\t1\t8\t4");
        assert result == 11137 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(String s) {
        String[] parts = s.split(" |\t");
        int[] banks = new int[parts.length];
        for (int i = 0; i < parts.length; ++i) {
            banks[i] = Integer.parseInt(parts[i]);
        }
        Set<String> configurations = new HashSet<>();
        configurations.add(printConfiguration(banks));
        int count = 0;
        for (; ; ) {
            int maxIndex = findBankWithMaxBlocks(banks);
            redistribute(banks, maxIndex);
            String configuration = printConfiguration(banks);
            ++count;
            System.out.println(count + ": " + configuration);
            if (configurations.contains(configuration)) {
                return count;
            }
            configurations.add(configuration);
        }
    }

    private static void redistribute(int[] banks, int maxIndex) {
        int maxBlocks = banks[maxIndex];
        banks[maxIndex] = 0;
        int i = maxIndex + 1;
        if (i == banks.length) {
            i = 0;
        }
        while (maxBlocks > 0) {
            banks[i] += 1;
            --maxBlocks;
            ++i;
            if (i == banks.length) {
                i = 0;
            }
        }
    }

    private static int findBankWithMaxBlocks(int[] banks) {
        int max = 0;
        int maxIndex = -1;
        for (int i = 0; i < banks.length; ++i) {
            if (banks[i] > max) {
                max = banks[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static String printConfiguration(int[] banks) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < banks.length; ++i) {
            sb.append(banks[i]).append(' ');
        }
        return sb.toString();
    }
}
