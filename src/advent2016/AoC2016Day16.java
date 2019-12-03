package advent2016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AoC2016Day16 {
    public static void main(String[] args) {
        String result;

        // test
        result = test(20, new int[]{1, 0, 0, 0, 0});
        assert result.equals("01100");
        System.out.println(result);

        // part 1
        result = test(272, new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0,
                1, 0, 0, 0});
        assert result.equals("11100111011101111");
        System.out.println(result);

        // part 2
        result = test0(35651584, new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1,
                0, 0, 1, 0, 0, 0});
        assert result.equals("10001110010000110");
        System.out.println(result);
    }

    private static String test(int LEN, int[] initial) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < initial.length; ++i)
            list.add(initial[i]);
        while (list.size() < LEN) {
            List<Integer> b = new ArrayList<>(list);
            Collections.reverse(b);
            for (int i = 0; i < b.size(); ++i)
                b.set(i, b.get(i) == 0 ? 1 : 0);
            list.add(0);
            list.addAll(b);
        }
        while (list.size() > LEN || list.size() % 2 != 0) {
            list.remove(list.size() - 1);
        }
        List<Integer> checksum = new ArrayList<>();
        while (checksum.size() % 2 == 0) {
            checksum.clear();
            for (int i = 0; i < list.size() - 1; i += 2)
                checksum.add(list.get(i) == list.get(i + 1) ? 1 : 0);
            list = new ArrayList<>(checksum);
        }
        String s = "";
        for (int i = 0; i < checksum.size(); ++i)
            s += checksum.get(i);
        return s;
    }

    private static String test0(int LEN, int[] initial) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < initial.length; ++i)
            list.add(initial[i]);
        while (list.size() < LEN) {
            int len = list.size();
            list.add(0);
            for (int i = len - 1; i >= 0; --i)
                list.add(list.get(i) == 0 ? 1 : 0);
        }
        while (list.size() > LEN || list.size() % 2 != 0) {
            list.remove(list.size() - 1);
        }
        List<Integer> checksum = new ArrayList<>();
        while (checksum.size() % 2 == 0) {
            checksum.clear();
            for (int i = 0; i < list.size() - 1; i += 2)
                checksum.add(list.get(i) == list.get(i + 1) ? 1 : 0);
            list = new ArrayList<>(checksum);
        }
        String s = "";
        for (int i = 0; i < checksum.size(); ++i)
            s += checksum.get(i);
        return s;
    }
}