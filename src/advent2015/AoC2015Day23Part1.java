package advent2015;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2015Day23Part1 {
    static Map<String, Integer> registers = new HashMap<>();

    public static void main(String[] args) {
        int result;

        result = test("jio a, +22\r\ninc a\r\ntpl a\r\ntpl a\r\ntpl a\r\ninc a\r\ntpl a\r\ninc a\r\ntpl a\r\ninc a\r\ninc a\r\ntpl a\r\ninc a\r\ninc a\r\ntpl a\r\ninc a\r\ninc a\r\ntpl a\r\ninc a\r\ninc a\r\ntpl a\r\njmp +19\r\ntpl a\r\ntpl a\r\ntpl a\r\ntpl a\r\ninc a\r\ninc a\r\ntpl a\r\ninc a\r\ntpl a\r\ninc a\r\ninc a\r\ntpl a\r\ninc a\r\ninc a\r\ntpl a\r\ninc a\r\ntpl a\r\ntpl a\r\njio a, +8\r\ninc b\r\njie a, +4\r\ntpl a\r\ninc a\r\njmp +2\r\nhlf a\r\njmp -7");
        assert result == 255;
        System.out.println(result);
    }

    public static int test(String s) {
        String[] instructions = s.split("\r\n");

        final Pattern hlf = Pattern.compile("hlf (a|b)");
        final Pattern tpl = Pattern.compile("tpl (a|b)");
        final Pattern inc = Pattern.compile("inc (a|b)");
        final Pattern jmp = Pattern.compile("jmp ([+-]\\d+)");
        final Pattern jie = Pattern.compile("jie (a|b), ([+-]\\d+)");
        final Pattern jio = Pattern.compile("jio (a|b), ([+-]\\d+)");

        registers.put("a", 0);
        registers.put("b", 0);
        for (int i = 0; i < instructions.length; ) {
            String instruction = instructions[i];
            Matcher m;
            m = hlf.matcher(instruction);
            if (m.matches()) {
                String reg1 = m.group(1);
                int val1 = registers.get(reg1).intValue() / 2;
                registers.put(reg1, Integer.valueOf(val1));
                ++i;
                print(instruction);
                continue;
            }
            m = tpl.matcher(instruction);
            if (m.matches()) {
                String reg1 = m.group(1);
                int val1 = registers.get(reg1).intValue() * 3;
                registers.put(reg1, Integer.valueOf(val1));
                ++i;
                print(instruction);
                continue;
            }
            m = inc.matcher(instruction);
            if (m.matches()) {
                String reg1 = m.group(1);
                int val1 = registers.get(reg1).intValue() + 1;
                registers.put(reg1, Integer.valueOf(val1));
                ++i;
                print(instruction);
                continue;
            }
            m = jmp.matcher(instruction);
            if (m.matches()) {
                int val = Integer.parseInt(m.group(1));
                i += val;
                print(instruction);
                continue;
            }
            m = jie.matcher(instruction);
            if (m.matches()) {
                String reg1 = m.group(1);
                int val1 = registers.get(reg1).intValue();
                int offset = Integer.parseInt(m.group(2));
                if (val1 % 2 == 0) {
                    i += offset;
                } else {
                    ++i;
                }
                print(instruction);
                continue;
            }
            m = jio.matcher(instruction);
            if (m.matches()) {
                String reg1 = m.group(1);
                int val1 = registers.get(reg1).intValue();
                int offset = Integer.parseInt(m.group(2));
                if (val1 == 1) {
                    i += offset;
                } else {
                    ++i;
                }
                print(instruction);
                continue;
            }
            throw new RuntimeException("unknown instruction " + instruction);
        }

        return registers.get("b").intValue();
    }

    private static void print(String instruction) {
        System.out.print(instruction + " ");

        List<Map.Entry<String, Integer>> list = new LinkedList<>(
                registers.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for (Map.Entry<String, Integer> entry : list) {
            System.out.print(entry.getKey() + "=" + entry.getValue() + " ");
        }
        System.out.println();
    }
}