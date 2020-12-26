package leetcode;

import utils.FileUtils;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;

class Solution477 {
    public static void main(String[] args) {
        try {
            int[][] inputs;
            String path = Paths.get(".").toAbsolutePath().normalize() + File.separator +
                    "src" + File.separator +
                    "leetcode" + File.separator +
                    "Solution477_input.txt";
            System.out.println(path);
            String s = FileUtils.readToString(path);
            String[] lines = s.split("\r\n");
            inputs = new int[lines.length][];
            for (int j = 0; j < lines.length; ++j) {
                String[] strings = lines[j].split(",");
                int[] nums = new int[strings.length];
                for (int i = 0; i < strings.length; ++i) {
                    nums[i] = Integer.parseInt(strings[i]);
                }
                inputs[j] = nums;
            }

            Solution[] solutions = new Solution[]{new Solution1(), new Solution2(), new Solution3()};
            int[][] results = new int[solutions.length][];
            for (int i = 0; i < solutions.length; ++i) {
                results[i] = test(solutions[i], inputs);
                for (int j = 0; j < results[i].length; ++j) {
                    System.out.println("solution " + i + " case " + j + " " + results[i][j]);
                }
            }
            for (int j = 0; j < results.length - 1; ++j) {
                int[] result1 = results[j];
                int[] result2 = results[j + 1];
                assert Arrays.equals(result1, result2) : "results " + j + " differs from results " + (j + 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int[] test(Solution solution, int[][] inputs) throws Exception {
        int[] results = new int[inputs.length];
        for (int j = 0; j < inputs.length; ++j) {
            int[] nums = inputs[j];
            results[j] = solution.totalHammingDistance(nums);
        }
        return results;
    }

    private interface Solution {
        int totalHammingDistance(int[] nums);
    }

    static class Solution1 implements Solution {
        @Override
        public int totalHammingDistance(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; ++i) {
                for (int j = i + 1; j < nums.length; ++j) {
                    sum += hammingDistance(nums[i], nums[j]);
                }
            }
            return sum;
        }

        private int hammingDistance(int x, int y) {
            int count = 0;
            while (x != 0 || y != 0) {
                count += (x & 1) ^ (y & 1);
                x >>>= 1;
                y >>>= 1;
            }
            return count;
        }
    }

    static class Solution2 implements Solution {
        @Override
        public int totalHammingDistance(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; ++i) {
                for (int j = i + 1; j < nums.length; ++j) {
                    sum += Integer.bitCount(nums[i] ^ nums[j]);
                }
            }
            return sum;
        }
    }

    static class Solution3 implements Solution {
        @Override
        public int totalHammingDistance(int[] nums) {
            int sum = 0, n = nums.length;
            for (int i = 0; i < 32; ++i) {
                int count = 0;
                for (int j = 0; j < n; ++j) {
                    if ((nums[j] & (1 << i)) == 0) {
                        ++count;
                    }
                }
                sum += count * (n - count);
            }
            return sum;
        }
    }
}
