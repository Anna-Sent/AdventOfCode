package advent.advent2017;

public class AoC2017Day14Part1 {
    public static void main(String[] args) {
        int result;

        result = test("flqrgnkx");
        System.out.println(result);
        assert result == 8108 : "unexpected result is " + result;

        result = test("jxqlasbh");
        assert result == 8140 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(String s) {
        int count = 0;
        for (int i = 0; i < 128; ++i) {
            String hash = s + "-" + i;
            String knotHash = knotHash(hash);
            for (int j = 0; j < knotHash.length(); ++j) {
                char c = knotHash.charAt(j);
                int v = Character.digit(c, 16);
                count += Integer.bitCount(v);
            }
        }
        return count;
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
