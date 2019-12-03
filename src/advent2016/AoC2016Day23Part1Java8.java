package advent2016;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2016Day23Part1Java8 {
    private static final String INPUT = "cpy a b\n" +
            "dec b\n" +
            "cpy a d\n" +
            "cpy 0 a\n" +
            "cpy b c\n" +
            "inc a\n" +
            "dec c\n" +
            "jnz c -2\n" +
            "dec d\n" +
            "jnz d -5\n" +
            "dec b\n" +
            "cpy b c\n" +
            "cpy c d\n" +
            "dec d\n" +
            "inc c\n" +
            "jnz d -2\n" +
            "tgl c\n" +
            "cpy -16 c\n" +
            "jnz 1 c\n" +
            "cpy 98 c\n" +
            "jnz 91 d\n" +
            "inc a\n" +
            "inc d\n" +
            "jnz d -2\n" +
            "inc c\n" +
            "jnz c -5";
    private static final Pattern cpy_reg = Pattern.compile("cpy (a|b|c|d) (a|b|c|d)");
    private static final Pattern cpy_val = Pattern.compile("cpy (-?\\d+) (a|b|c|d)");
    private static final Pattern inc = Pattern.compile("inc (a|b|c|d)");
    private static final Pattern dec = Pattern.compile("dec (a|b|c|d)");
    private static final Pattern jnz_reg_reg = Pattern.compile("jnz (a|b|c|d) (a|b|c|d)");
    private static final Pattern jnz_val_reg = Pattern.compile("jnz (-?\\d+) (a|b|c|d)");
    private static final Pattern jnz_reg_val = Pattern.compile("jnz (a|b|c|d) (-?\\d+)");
    private static final Pattern jnz_val_val = Pattern.compile("jnz (\\d+) (-?\\d+)");
    private static final Pattern tgl_reg = Pattern.compile("tgl (a|b|c|d)");
    private static Map<String, Integer> registers = new HashMap<>();

    public static void main(String[] args) {
        int result;

        registers.put("a", 0);
        registers.put("b", 0);
        registers.put("c", 0);
        registers.put("d", 0);
        result = test("cpy 2 a\n" +
                "tgl a\n" +
                "tgl a\n" +
                "tgl a\n" +
                "cpy 1 a\n" +
                "dec a\n" +
                "dec a");
        System.out.println(result);
        assert result == 3;

        registers.put("a", 7);
        registers.put("b", 0);
        registers.put("c", 0);
        registers.put("d", 0);
        result = test(INPUT);
        System.out.println(result);
        assert result == 13958;
    }

    private static int test(String s) {
        String[] instructions = s.split("\n");

        for (int i = 0; i < instructions.length; ) {
            String instruction = instructions[i];
            Matcher m;
            m = cpy_reg.matcher(instruction);
            if (m.matches()) {
                String reg1 = m.group(1);
                String reg2 = m.group(2);
                registers.put(reg2, registers.get(reg1));
                ++i;
                print(instruction);
                continue;
            }
            m = cpy_val.matcher(instruction);
            if (m.matches()) {
                int val = Integer.parseInt(m.group(1));
                String reg = m.group(2);
                registers.put(reg, val);
                ++i;
                print(instruction);
                continue;
            }
            m = inc.matcher(instruction);
            if (m.matches()) {
                String reg = m.group(1);
                registers.put(reg, registers.get(reg) + 1);
                ++i;
                print(instruction);
                continue;
            }
            m = dec.matcher(instruction);
            if (m.matches()) {
                String reg = m.group(1);
                registers.put(reg, registers.get(reg) - 1);
                ++i;
                print(instruction);
                continue;
            }
            m = jnz_reg_reg.matcher(instruction);
            if (m.matches()) {
                String reg1 = m.group(1);
                int val1 = registers.get(reg1);
                String reg2 = m.group(2);
                int val2 = registers.get(reg2);

                if (val1 != 0) {
                    i += val2;
                } else {
                    ++i;
                }
                print(instruction);
                continue;
            }
            m = jnz_val_reg.matcher(instruction);
            if (m.matches()) {
                int val1 = Integer.parseInt(m.group(1));
                String reg2 = m.group(2);
                int val2 = registers.get(reg2);

                if (val1 != 0) {
                    i += val2;
                } else {
                    ++i;
                }
                print(instruction);
                continue;
            }
            m = jnz_reg_val.matcher(instruction);
            if (m.matches()) {
                String reg1 = m.group(1);
                int val1 = registers.get(reg1);
                int val2 = Integer.parseInt(m.group(2));

                if (val1 != 0) {
                    i += val2;
                } else {
                    ++i;
                }
                print(instruction);
                continue;
            }
            m = jnz_val_val.matcher(instruction);
            if (m.matches()) {
                int val1 = Integer.parseInt(m.group(1));
                int val2 = Integer.parseInt(m.group(2));

                if (val1 != 0) {
                    i += val2;
                } else {
                    ++i;
                }
                print(instruction);
                continue;
            }
            m = tgl_reg.matcher(instruction);
            if (m.matches()) {
                String reg = m.group(1);
                int val = registers.get(reg);

                int next = i + val;
                if (next >= 0 && next < instructions.length) {
                    tgl(instructions, next);
                } else {
                    System.err.println("out of scope: do nothing");
                }

                ++i;
                print(instruction);
                continue;
            }
            System.err.println("instruction skipped: " + instruction);
            ++i;
        }

        return registers.get("a");
    }

    private static void print(String instruction) {
        System.out.println(instruction);
        System.out.println(registers);
    }

    private static void tgl(String[] instructions, int i) {
        String instruction = instructions[i];
        Matcher m;

        m = cpy_reg.matcher(instruction);
        if (m.matches()) {
            String arg1 = m.group(1);
            String arg2 = m.group(2);
            instructions[i] = "jnz " + arg1 + " " + arg2;
            return;
        }
        m = cpy_val.matcher(instruction);
        if (m.matches()) {
            String arg1 = m.group(1);
            String arg2 = m.group(2);
            instructions[i] = "jnz " + arg1 + " " + arg2;
            return;
        }
        m = inc.matcher(instruction);
        if (m.matches()) {
            String arg = m.group(1);
            instructions[i] = "dec " + arg;
            return;
        }
        m = dec.matcher(instruction);
        if (m.matches()) {
            String arg = m.group(1);
            instructions[i] = "inc " + arg;
            return;
        }
        m = jnz_reg_reg.matcher(instruction);
        if (m.matches()) {
            String arg1 = m.group(1);
            String arg2 = m.group(2);
            instructions[i] = "cpy " + arg1 + " " + arg2;
            return;
        }
        m = jnz_val_reg.matcher(instruction);
        if (m.matches()) {
            String arg1 = m.group(1);
            String arg2 = m.group(2);
            instructions[i] = "cpy " + arg1 + " " + arg2;
            return;
        }
        m = jnz_reg_val.matcher(instruction);
        if (m.matches()) {
            String arg1 = m.group(1);
            String arg2 = m.group(2);
            instructions[i] = "cpy " + arg1 + " " + arg2;
            return;
        }
        m = jnz_val_val.matcher(instruction);
        if (m.matches()) {
            String arg1 = m.group(1);
            String arg2 = m.group(2);
            instructions[i] = "cpy " + arg1 + " " + arg2;
            return;
        }
        m = tgl_reg.matcher(instruction);
        if (m.matches()) {
            String arg = m.group(1);
            instructions[i] = "inc " + arg;
            return;
        }
        throw new RuntimeException("tgl can't modify instruction");
    }
}
