package advent2017;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2017Day18Part1 {
    public static void main(String[] args) {
        long result;

        result = test("set a 1\n" +
                "add a 2\n" +
                "mul a a\n" +
                "mod a 5\n" +
                "snd a\n" +
                "set a 0\n" +
                "rcv a\n" +
                "jgz a -1\n" +
                "set a 1\n" +
                "jgz a -2");
        System.out.println(result);
        assert result == 4 : "unexpected result is " + result;

        result = test("set i 31\n" +
                "set a 1\n" +
                "mul p 17\n" +
                "jgz p p\n" +
                "mul a 2\n" +
                "add i -1\n" +
                "jgz i -2\n" +
                "add a -1\n" +
                "set i 127\n" +
                "set p 622\n" +
                "mul p 8505\n" +
                "mod p a\n" +
                "mul p 129749\n" +
                "add p 12345\n" +
                "mod p a\n" +
                "set b p\n" +
                "mod b 10000\n" +
                "snd b\n" +
                "add i -1\n" +
                "jgz i -9\n" +
                "jgz a 3\n" +
                "rcv b\n" +
                "jgz b -1\n" +
                "set f 0\n" +
                "set i 126\n" +
                "rcv a\n" +
                "rcv b\n" +
                "set p a\n" +
                "mul p -1\n" +
                "add p b\n" +
                "jgz p 4\n" +
                "snd a\n" +
                "set a b\n" +
                "jgz 1 3\n" +
                "snd b\n" +
                "set f 1\n" +
                "add i -1\n" +
                "jgz i -11\n" +
                "snd a\n" +
                "jgz f -16\n" +
                "jgz a -19");
        assert result == 9423 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static final String REGISTER = "([a-z])";
    private static final String REGISTER_OR_NUMBER = "([a-z]|-?\\d+)";
    private static final Pattern snd = Pattern.compile(String.format("snd %s", REGISTER_OR_NUMBER));
    private static final Pattern set = Pattern.compile(String.format("set %s %s", REGISTER, REGISTER_OR_NUMBER));
    private static final Pattern add = Pattern.compile(String.format("add %s %s", REGISTER, REGISTER_OR_NUMBER));
    private static final Pattern mul = Pattern.compile(String.format("mul %s %s", REGISTER, REGISTER_OR_NUMBER));
    private static final Pattern mod = Pattern.compile(String.format("mod %s %s", REGISTER, REGISTER_OR_NUMBER));
    private static final Pattern rcv = Pattern.compile(String.format("rcv %s", REGISTER_OR_NUMBER));
    private static final Pattern jgz = Pattern.compile(String.format("jgz %s %s", REGISTER_OR_NUMBER, REGISTER_OR_NUMBER));

    private static Map<String, Long> registers = new HashMap<>();

    public static long test(String s) {
        String[] instructions = s.split("\n");

        Long lastPlayedSound = null;
        registers.clear();

        for (int i = 0; i < instructions.length; ) {
            String instruction = instructions[i];
            Matcher m;

            m = snd.matcher(instruction);
            if (m.matches()) {
                lastPlayedSound = getRegisterOrNumberValue(m.group(1));
                ++i;
                continue;
            }

            m = set.matcher(instruction);
            if (m.matches()) {
                putRegisterValue(m.group(1), getRegisterOrNumberValue(m.group(2)));
                ++i;
                continue;
            }

            m = add.matcher(instruction);
            if (m.matches()) {
                long v1 = getRegisterValue(m.group(1));
                long v2 = getRegisterOrNumberValue(m.group(2));
                putRegisterValue(m.group(1), v1 + v2);
                ++i;
                continue;
            }

            m = mul.matcher(instruction);
            if (m.matches()) {
                long v1 = getRegisterValue(m.group(1));
                long v2 = getRegisterOrNumberValue(m.group(2));
                putRegisterValue(m.group(1), v1 * v2);
                ++i;
                continue;
            }

            m = mod.matcher(instruction);
            if (m.matches()) {
                long v1 = getRegisterValue(m.group(1));
                long v2 = getRegisterOrNumberValue(m.group(2));
                putRegisterValue(m.group(1), v1 % v2);
                ++i;
                continue;
            }

            m = rcv.matcher(instruction);
            if (m.matches()) {
                long v = getRegisterOrNumberValue(m.group(1));
                if (v != 0) {
                    if (lastPlayedSound == null) {
                        throw new RuntimeException("last played sound is null");
                    }
                    return lastPlayedSound;
                }
                ++i;
                continue;
            }

            m = jgz.matcher(instruction);
            if (m.matches()) {
                long v1 = getRegisterOrNumberValue(m.group(1));
                long v2 = getRegisterOrNumberValue(m.group(2));
                if (v1 > 0) {
                    i += v2;
                } else {
                    ++i;
                }
                continue;
            }

            throw new RuntimeException("unknown instruction " + instruction);
        }

        throw new RuntimeException("no result");
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
