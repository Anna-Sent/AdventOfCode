package advent.advent2017;

public class AoC2017Day14Part2 {
    public static void main(String[] args) {
        int result;

        result = test("flqrgnkx");
        System.out.println(result);
        assert result == 1242 : "unexpected result is " + result;

        result = test("jxqlasbh");
        assert result == 1182 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(String s) {
        char[][] table = new char[128][];
        for (int i = 0; i < 128; ++i) {
            table[i] = new char[128];
            String hash = s + "-" + i;
            String knotHash = knotHash(hash);
            assert knotHash.length() == 32 : "length is " + knotHash.length();
            for (int j = 0; j < 32; ++j) {
                char c = knotHash.charAt(j);
                int v = Character.digit(c, 16);
                for (int k = 0; k < 4; ++k) {
                    table[i][j * 4 + 3 - k] = (v & (1 << k)) != 0 ? '#' : '.';
                }
            }
        }

        print(table);
        int count = 0;
        for (int i = 0; i < 128; ++i) {
            for (int j = 0; j < 128; ++j) {
                if (table[i][j] == '#') {
                    findRegion(table, i, j, count);
                    ++count;
                }
            }
        }
        print(table);
        return count;
    }

    private static void print(char[][] table) {
        System.out.println();
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                System.out.print(String.format("%5s", table[i][j]));
            }
            System.out.println();
        }
    }

    private static void findRegion(char[][] table, int x, int y, int k) {
        table[x][y] = (char) ('0' + k);
        if (x + 1 < 128) {
            if (table[x + 1][y] == '#') {
                findRegion(table, x + 1, y, k);
            }
        }
        if (x - 1 >= 0) {
            if (table[x - 1][y] == '#') {
                findRegion(table, x - 1, y, k);
            }
        }
        if (y + 1 < 128) {
            if (table[x][y + 1] == '#') {
                findRegion(table, x, y + 1, k);
            }
        }
        if (y - 1 >= 0) {
            if (table[x][y - 1] == '#') {
                findRegion(table, x, y - 1, k);
            }
        }
    }

    private static String knotHash(String input) {
        int[] sparseHash = new int[256];
        for (int i = 0; i < sparseHash.length; ++i) {
            sparseHash[i] = i;
        }

        final int[] tail = new int[]{17, 31, 73, 47, 23};

        int[] lengths = new int[input.length() + tail.length];
        for (int i = 0; i < lengths.length; ++i) {
            lengths[i] = i >= input.length() ? tail[i - input.length()] : input.charAt(i);
        }

        int skipSize = 0, current = 0;

        for (int round = 0; round < 64; ++round) {
            for (int i = 0; i < lengths.length; ++i, ++skipSize) {
                int reverseLength = lengths[i];
                int position = current % 256;
                reverse(sparseHash, position, reverseLength);
                current += reverseLength + skipSize;
            }
        }

        int[] denseHash = new int[16];
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                denseHash[i] ^= sparseHash[i * 16 + j];
            }
        }

        return toHex(denseHash);
    }

    private static String toHex(int[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; ++i) {
            sb.append(String.format("%02x", bytes[i]));
        }
        return sb.toString();
    }

    private static void reverse(int[] elements, int position, int length) {
        for (int i = 0; i < length / 2; ++i) {
            int ind1 = (position + i) % elements.length, ind2 = (position + length - 1 - i) % elements.length;
            swap(elements, ind1, ind2);
        }
    }

    private static void swap(int[] elements, int i1, int i2) {
        int tmp = elements[i1];
        elements[i1] = elements[i2];
        elements[i2] = tmp;
    }
}
