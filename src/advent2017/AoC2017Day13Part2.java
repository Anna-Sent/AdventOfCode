package advent2017;


public class AoC2017Day13Part2 {
    public static void main(String[] args) {
        int result;

        result = test("0: 3\n" +
                "1: 2\n" +
                "4: 4\n" +
                "6: 4", 6);
        System.out.println(result);
        assert result == 10 : "unexpected result is " + result;

        result = test("0: 3\n" +
                "1: 2\n" +
                "2: 4\n" +
                "4: 6\n" +
                "6: 4\n" +
                "8: 6\n" +
                "10: 5\n" +
                "12: 6\n" +
                "14: 8\n" +
                "16: 8\n" +
                "18: 8\n" +
                "20: 6\n" +
                "22: 12\n" +
                "24: 8\n" +
                "26: 8\n" +
                "28: 10\n" +
                "30: 9\n" +
                "32: 12\n" +
                "34: 8\n" +
                "36: 12\n" +
                "38: 12\n" +
                "40: 12\n" +
                "42: 14\n" +
                "44: 14\n" +
                "46: 12\n" +
                "48: 12\n" +
                "50: 12\n" +
                "52: 12\n" +
                "54: 14\n" +
                "56: 12\n" +
                "58: 14\n" +
                "60: 14\n" +
                "62: 14\n" +
                "64: 14\n" +
                "70: 10\n" +
                "72: 14\n" +
                "74: 14\n" +
                "76: 14\n" +
                "78: 14\n" +
                "82: 14\n" +
                "86: 17\n" +
                "88: 18\n" +
                "96: 26", 96);
        assert result == 3907994 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(String s, int max) {
        int[] layers = new int[max + 1];
        String[] parts = s.split("\n");
        for (String part : parts) {
            String[] tokens = part.split(": ");
            int key = Integer.parseInt(tokens[0]);
            int length = Integer.parseInt(tokens[1]);
            layers[key] = length;
        }

        for (int delay = 0; ; ++delay) {
            System.out.println("count for delay " + delay);
            boolean caught = startWithDelay(layers, delay, max);
            if (!caught) {
                return delay;
            }
        }
    }

    private static boolean startWithDelay(int[] layers, int delay, int max) {
        for (int i = delay; i <= delay + max; ++i) {
            int length = layers[i - delay];
            if (length > 1 && i % ((length - 1) * 2) == 0) {
                return true;
            }
        }
        return false;
    }
}
