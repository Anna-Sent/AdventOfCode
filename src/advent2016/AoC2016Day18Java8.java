public class AoC2016Day18Java8 {
    public static void main(String[] args) {
        long result;

        result = test(3, "..^^.");
        assert (result == 6);
        System.out.println(result);

        result = test(10, ".^^.^.^^^^");
        assert (result == 38);
        System.out.println(result);

        result = test(40, "......^.^^.....^^^^^^^^^...^.^..^^.^^^..^.^..^.^^^.^^^^..^^.^.^.....^^^^^..^..^^^..^^.^.^..^^..^^^..");
        assert (result == 1963);
        System.out.println(result);

        result = test(400000, "......^.^^.....^^^^^^^^^...^.^..^^.^^^..^.^..^.^^^.^^^^..^^.^.^.....^^^^^..^..^^^..^^.^.^..^^..^^^..");
        assert (result == 20009568);
        System.out.println(result);
    }

    private static long test(int rows, String s) {
        int cols = s.length();
        long count = s.chars().filter(ch -> ch == '.').count();

        char[] prev = s.toCharArray();
        for (int row = 1; row < rows; ++row) {
            char[] next = new char[cols];
            for (int col = 0; col < cols; ++col) {
                if (isTrap(col - 1, prev) ^ isTrap(col + 1, prev)) {
                    next[col] = '^';
                } else {
                    next[col] = '.';
                    ++count;
                }
            }
            prev = next;
        }

        return count;
    }

    private static boolean isTrap(int pos, char[] chars) {
        return pos >= 0 && pos < chars.length && chars[pos] == '^';
    }
}