package advent2015;

public class AoC2015Day10Part2 {
    public static void main(String[] args) {
        int result;

        result = test("1113122113");
        System.out.println(result);
    }

    public static int test(String s) {
        System.out.println(s);
        for (int i = 0; i < 50; ++i) {
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < s.length(); ) {
                char countedSym = s.charAt(j);
                int count = 0;
                do {
                    ++j;
                    ++count;
                } while (j < s.length() && countedSym == s.charAt(j));
                result.append(count).append(countedSym);
            }
            s = result.toString();
            System.out.println(i + " " + s.length());
        }
        int len = s.length();
        return len;
    }
}