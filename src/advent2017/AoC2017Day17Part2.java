package advent2017;

public class AoC2017Day17Part2 {
    public static void main(String[] args) {
        int result;

        result = test(367);
        assert result == 25674054 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(int steps) {
        int count = 0;
        int index = 0;
        int result = 0;
        while (count <= 50000000) {
            index += steps;
            index = count == 0 ? 0 : index % count;
            index += count == 0 ? 0 : 1;
            if (index == 1) {
                result = count;
            }
            ++count;
        }
        return result;
    }
}
