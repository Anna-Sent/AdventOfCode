package advent2016;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2016Day25Java8 {
    private static final String INPUT = "cpy a d\n" +
            "cpy 4 c\n" +
            "cpy 643 b\n" +
            "inc d\n" +
            "dec b\n" +
            "jnz b -2\n" +
            "dec c\n" +
            "jnz c -5\n" +
            "cpy d a\n" +
            "jnz 0 0\n" +
            "cpy a b\n" +
            "cpy 0 a\n" +
            "cpy 2 c\n" +
            "jnz b 2\n" +
            "jnz 1 6\n" +
            "dec b\n" +
            "dec c\n" +
            "jnz c -4\n" +
            "inc a\n" +
            "jnz 1 -7\n" +
            "cpy 2 b\n" +
            "jnz c 2\n" +
            "jnz 1 4\n" +
            "dec b\n" +
            "dec c\n" +
            "jnz 1 -4\n" +
            "jnz 0 0\n" +
            "out b\n" +
            "jnz a -19\n" +
            "jnz 1 -21";

    public static void main(String[] args) {
        // asnwer is 158
        for (int a = 1; ; ++a) {
            registers.put("a", a);
            registers.put("b", 0);
            registers.put("c", 0);
            registers.put("d", 0);
            System.out.println("a=" + a);
            test(INPUT);
            System.out.println();
        }
    }

    private static Map<String, Integer> registers = new HashMap<>();

    private static final Pattern cpy_reg = Pattern.compile("cpy (a|b|c|d) (a|b|c|d)");
    private static final Pattern cpy_val = Pattern.compile("cpy (-?\\d+) (a|b|c|d)");
    private static final Pattern inc = Pattern.compile("inc (a|b|c|d)");
    private static final Pattern dec = Pattern.compile("dec (a|b|c|d)");
    private static final Pattern jnz_reg_reg = Pattern.compile("jnz (a|b|c|d) (a|b|c|d)");
    private static final Pattern jnz_val_reg = Pattern.compile("jnz (-?\\d+) (a|b|c|d)");
    private static final Pattern jnz_reg_val = Pattern.compile("jnz (a|b|c|d) (-?\\d+)");
    private static final Pattern jnz_val_val = Pattern.compile("jnz (\\d+) (-?\\d+)");
    private static final Pattern out_reg = Pattern.compile("out (a|b|c|d)");

    private static final String[] sequence = new String[]{"cpy 643 b",
            "inc d",
            "dec b",
            "jnz b -2",
            "dec c",
            "jnz c -5"};

    private static boolean isTheSequence(String[] instructions, int i) {
        boolean found = true;
        for (int j = 0; found && j < sequence.length; ++j) {
            found = sequence[j].equals(instructions[i + j]);
        }
        return found;
    }

    public static void test(String s) {
        String[] instructions = s.split("\n");

        int last = 1;

        for (int i = 0; i < instructions.length; ) {
            if (i + sequence.length < instructions.length) {
                if (isTheSequence(instructions, i)) {
                    int c = registers.get("c");
                    int d = registers.get("d");
                    registers.put("d", d + c * 643);
                    registers.put("b", 0);
                    registers.put("c", 0);
                    i += sequence.length;
                }
            }

            String instruction = instructions[i];
            Matcher m;
            m = cpy_reg.matcher(instruction);
            if (m.matches()) {
                String reg1 = m.group(1);
                String reg2 = m.group(2);
                registers.put(reg2, registers.get(reg1));
                ++i;
                continue;
            }
            m = cpy_val.matcher(instruction);
            if (m.matches()) {
                int val = Integer.parseInt(m.group(1));
                String reg = m.group(2);
                registers.put(reg, val);
                ++i;
                continue;
            }
            m = inc.matcher(instruction);
            if (m.matches()) {
                String reg = m.group(1);
                registers.put(reg, registers.get(reg) + 1);
                ++i;
                continue;
            }
            m = dec.matcher(instruction);
            if (m.matches()) {
                String reg = m.group(1);
                registers.put(reg, registers.get(reg) - 1);
                ++i;
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
                continue;
            }
            m = out_reg.matcher(instruction);
            if (m.matches()) {
                String reg = m.group(1);
                int val = registers.get(reg);
                System.out.print(val);
                boolean isValid = last == 1 ? val == 0 : val == 1;
                if (!isValid) return;
                last = val;
                ++i;
                continue;
            }
            throw new RuntimeException("invalid instruction: " + instruction);
        }
    }
}
