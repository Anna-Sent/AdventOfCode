package advent2015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AoC2015Day24Part2Java8 {
    public static void main(String[] args) {
        long result;

        result = solve(new int[]{1, 2, 3, 4, 5, 7, 8, 9, 10, 11});
        System.out.println(result);
        assert result == 44;

        result = solve(new int[]{1, 2, 3, 5, 7, 13, 17, 19, 23, 29, 31, 37, 41, 43, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113});
        System.out.println(result);
        assert result == 74850409L;
    }

    private static long solve(int[] packages) {
        int sum = Arrays.stream(packages).sum();
        if (sum % 4 != 0) {
            throw new RuntimeException("invalid input");
        }
        sum = sum / 4;
        int n = packages.length;
        System.out.println("sum/4=" + sum + "; n=" + n);

        Group minGroup = bf(sum, new Group(), packages, n - 1, null);
        System.out.println(minGroup);

        return minGroup.product;
    }

    private static Group bf(int sum, Group group, int[] packages, int n, Group minGroup) {
        for (int i = n; i >= 0; --i) {
            Group groupCopy = new Group(group);
            groupCopy.addValue(packages[i]);
            if (groupCopy.sum == sum) {
                if (minGroup == null) {
                    minGroup = groupCopy;
                } else {
                    if (minGroup.count > groupCopy.count) {
                        minGroup = groupCopy;
                    } else if (minGroup.count == groupCopy.count) {
                        if (minGroup.product > groupCopy.product) {
                            minGroup = groupCopy;
                        }
                    }
                }
            } else {
                minGroup = bf(sum, groupCopy, packages, i - 1, minGroup);
            }
        }
        return minGroup;
    }

    private static class Group {
        List<Integer> values = new ArrayList<>();
        int sum;
        long product = 1;
        int count;

        public Group() {
        }

        public Group(Group other) {
            other.values.stream().forEach(x -> values.add(x));
            this.sum = other.sum;
            this.product = other.product;
            this.count = other.count;
        }

        void addValue(int value) {
            values.add(value);
            sum += value;
            product *= value;
            ++count;
        }

        @Override
        public String toString() {
            return '[' + values.stream().map(x -> x.toString()).collect(Collectors.joining(", ")) + ']'
                    + "sum=" + sum + ";product=" + product + ";count=" + count;
        }
    }
}
