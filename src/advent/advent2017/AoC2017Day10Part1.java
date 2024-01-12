package advent.advent2017;

public class AoC2017Day10Part1 {
    public static void main(String[] args) {
        int result;

        result = test("3,4,1,5", 5);
        System.out.println(result);
        assert result == 12 : "unexpected result is " + result;

        result = test("18,1,0,161,255,137,254,252,14,95,165,33,181,168,2,188", 256);
        assert result == 46600 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(final String lengthsStr, final int length) {
        int[] elements = new int[length];
        for (int i = 0; i < length; ++i) {
            elements[i] = i;
        }
        String[] parts = lengthsStr.split(",");
        int[] lengths = new int[parts.length];
        for (int i = 0; i < lengths.length; ++i) {
            lengths[i] = Integer.parseInt(parts[i]);
        }

        int skipSize = 0, current = 0;
        for (int i = 0; i < lengths.length; ++i, ++skipSize) {
            int reverseLength = lengths[i];
            int position = current % length;
            reverse(elements, position, reverseLength);
            print(elements, position);
            current += reverseLength + skipSize;
        }

        return elements[0] * elements[1];
    }

    private static void print(int[] elements, int position) {
        System.out.println("position is " + position);
        for (int i = 0; i < elements.length; ++i) {
            System.out.print(String.format("%5d", elements[i]));
        }
        System.out.println();
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
