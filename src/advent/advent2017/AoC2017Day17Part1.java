package advent.advent2017;

import java.util.ArrayList;
import java.util.List;

public class AoC2017Day17Part1 {
    public static void main(String[] args) {
        int result;

        result = test(3);
        System.out.println(result);
        assert result == 638 : "unexpected result is " + result;

        result = test(367);
        assert result == 1487 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(int steps) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int index = 0;
        while (count <= 2017) {
            index += steps;
            index = count == 0 ? 0 : index % count;
            index += count == 0 ? 0 : 1;
            list.add(index, count);
            ++count;
            for (int i = 0; i <= 10 && i < list.size(); ++i) {
                System.out.print(String.format("%5d", list.get(i)));
            }
            System.out.println();
        }
        int i = list.indexOf(2017);
        return list.get(i + 1);
    }
}
