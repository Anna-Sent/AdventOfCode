package advent2017;

public class AoC2017Day10Part2 {
    public static void main(String[] args) {
        String result;

        result = test("");
        System.out.println(result);
        assert "a2582a3a0e66e6e86e3812dcb672a272".equals(result) : "unexpected result is " + result;

        result = test("AoC 2017");
        System.out.println(result);
        assert "33efeb34ea91902bb2f59c9920caa6cd".equals(result) : "unexpected result is " + result;

        result = test("1,2,3");
        System.out.println(result);
        assert "3efbe78a8d82f29979031a4aa0b16a9d".equals(result) : "unexpected result is " + result;

        result = test("1,2,4");
        System.out.println(result);
        assert "63960835bcdc130f0b66d7ff4f6a5a8e".equals(result) : "unexpected result is " + result;

        result = test("18,1,0,161,255,137,254,252,14,95,165,33,181,168,2,188");
        assert "23234babdc6afa036749cfa9b597de1b".equals(result) : "unexpected result is " + result;
        System.out.println(result);
    }

    public static String test(String input) {
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
