package leetcode.solution2;

class Solution278 {
    private static int badVersion;

    public static void main(String[] args) {
        for (int i = -2; i <= 6; ++i) {
            for (int j = -2; j <= 6; ++j) {
                test(i, j);
            }
        }
    }

    private static void test(int badVersion, int n) {
        Solution278.badVersion = badVersion;
        int actual = new Solution().firstBadVersion(n);
        int expected = n >= 1 ? (badVersion >= 1 ? (badVersion <= n ? badVersion : -1) : 1) : -1;
        assert expected == actual : "failed with bad version=" + badVersion + ", n=" + n
                + ": expected is " + expected + ", actual is " + actual;
    }

    static class VersionControl {
        public boolean isBadVersion(int n) {
            return n >= badVersion;
        }
    }

    static class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            if (n <= 0) {
                return -1;
            }
            int low = 1;
            int high = n, lastBadVersion = -1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                boolean isBadVersion = isBadVersion(mid);
                if (isBadVersion) {
                    lastBadVersion = mid;
                }
                if (isBadVersion) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return lastBadVersion;
        }
    }
}
