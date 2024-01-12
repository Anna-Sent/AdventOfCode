package advent.advent2017;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2017Day23Part1 {
    private static final String REGISTER = "([a-z])";
    private static final String REGISTER_OR_NUMBER = "([a-z]|-?\\d+)";
    private static final Pattern set = Pattern.compile(String.format("set %s %s", REGISTER, REGISTER_OR_NUMBER));
    private static final Pattern sub = Pattern.compile(String.format("sub %s %s", REGISTER, REGISTER_OR_NUMBER));
    private static final Pattern mul = Pattern.compile(String.format("mul %s %s", REGISTER, REGISTER_OR_NUMBER));
    private static final Pattern jnz = Pattern.compile(String.format("jnz %s %s", REGISTER_OR_NUMBER, REGISTER_OR_NUMBER));

    private static final Map<String, Long> registers = new HashMap<>();

    public static void main(String[] args) {
        int result;

        result = test("set b 81\n" +
                "set c b\n" +
                "jnz a 2\n" +
                "jnz 1 5\n" +
                "mul b 100\n" +
                "sub b -100000\n" +
                "set c b\n" +
                "sub c -17000\n" +
                "set f 1\n" +
                "set d 2\n" +
                "set e 2\n" +
                "set g d\n" +
                "mul g e\n" +
                "sub g b\n" +
                "jnz g 2\n" +
                "set f 0\n" +
                "sub e -1\n" +
                "set g e\n" +
                "sub g b\n" +
                "jnz g -8\n" +
                "sub d -1\n" +
                "set g d\n" +
                "sub g b\n" +
                "jnz g -13\n" +
                "jnz f 2\n" +
                "sub h -1\n" +
                "set g b\n" +
                "sub g c\n" +
                "jnz g 2\n" +
                "jnz 1 3\n" +
                "sub b -17\n" +
                "jnz 1 -23");
        assert result == 6241 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(String s) {
        String[] instructions = s.split("\n");

        int count = 0;
        registers.clear();
        for (int i = 0; i < instructions.length; ) {
            String instruction = instructions[i];
            Matcher m;

            m = set.matcher(instruction);
            if (m.matches()) {
                putRegisterValue(m.group(1), getRegisterOrNumberValue(m.group(2)));
                ++i;
                continue;
            }

            m = sub.matcher(instruction);
            if (m.matches()) {
                long v1 = getRegisterValue(m.group(1));
                long v2 = getRegisterOrNumberValue(m.group(2));
                putRegisterValue(m.group(1), v1 - v2);
                ++i;
                continue;
            }

            m = mul.matcher(instruction);
            if (m.matches()) {
                long v1 = getRegisterValue(m.group(1));
                long v2 = getRegisterOrNumberValue(m.group(2));
                putRegisterValue(m.group(1), v1 * v2);
                ++i;
                ++count;
                continue;
            }

            m = jnz.matcher(instruction);
            if (m.matches()) {
                long v1 = getRegisterOrNumberValue(m.group(1));
                long v2 = getRegisterOrNumberValue(m.group(2));
                if (v1 != 0) {
                    i += v2;
                } else {
                    ++i;
                }
                continue;
            }

            throw new RuntimeException("unknown instruction " + instruction);
        }

        return count;
    }

    private static long getRegisterOrNumberValue(String s) {
        try {
            return Long.parseLong(s);
        } catch (Exception e) {
            if (!registers.containsKey(s)) {
                registers.put(s, 0L);
            }
            return registers.get(s);
        }
    }

    private static long getRegisterValue(String s) {
        try {
            long n = Long.parseLong(s);
            throw new RuntimeException("Expected register, not number " + n);
        } catch (Exception e) {
        }
        if (!registers.containsKey(s)) {
            registers.put(s, 0L);
        }
        return registers.get(s);
    }

    private static void putRegisterValue(String s, long value) {
        try {
            long n = Long.parseLong(s);
            throw new RuntimeException("Expected register, not number " + n);
        } catch (Exception e) {
        }
        registers.put(s, value);
    }
}
