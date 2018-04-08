class Solution {
    public int reverse(int x) {
        long reversed = Long.parseLong(new StringBuilder(String.valueOf(Math.abs((long) x))).reverse().toString());
        reversed = x < 0 ? -reversed : reversed;
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reversed;
    }
}
