package advent2017;

public class AoC2017Day7Part1 {
    public static void main(String[] args) {
        int result;

        result = test("");
        assert result == 0 : "unexpected result is " + result;
        System.out.println(result);

        result = test("");
        //assert result == : "unexpected result is " + result;
        System.out.println(result);
    }

    public static int test(String s) {
        String[] parts = s.split(" |\t");
        int[] input = new int[parts.length];
        for (int i = 0; i < parts.length; ++i) {
//            input[i] = Integer.parseInt(parts[i]);
        }
        int count = 0;
        return count;
    }
}
