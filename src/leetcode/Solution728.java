class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; ++i) {
            int num = i;
            boolean matches = true;
            while (num != 0) {
                int r = num % 10;
                if (r == 0 || i % r != 0) {
                    matches = false;
                    break;
                }
                num /= 10;
            }
            if (matches) {
                result.add(i);
            }
        }
        return result;
    }
}
