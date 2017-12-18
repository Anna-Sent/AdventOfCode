package advent2017;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2017Day18Part2VM {
    private static final String REGISTER = "([a-z])";
    private static final String REGISTER_OR_NUMBER = "([a-z]|-?\\d+)";
    private static final Pattern snd = Pattern.compile(String.format("snd %s", REGISTER_OR_NUMBER));
    private static final Pattern set = Pattern.compile(String.format("set %s %s", REGISTER, REGISTER_OR_NUMBER));
    private static final Pattern add = Pattern.compile(String.format("add %s %s", REGISTER, REGISTER_OR_NUMBER));
    private static final Pattern mul = Pattern.compile(String.format("mul %s %s", REGISTER, REGISTER_OR_NUMBER));
    private static final Pattern mod = Pattern.compile(String.format("mod %s %s", REGISTER, REGISTER_OR_NUMBER));
    private static final Pattern rcv = Pattern.compile(String.format("rcv %s", REGISTER_OR_NUMBER));
    private static final Pattern jgz = Pattern.compile(String.format("jgz %s %s", REGISTER_OR_NUMBER, REGISTER_OR_NUMBER));

    private Map<String, Long> registers = new HashMap<>();

    private int i, sndCounter;
    private String[] instructions;
    private Queue<Long> rcvQueue = new LinkedBlockingQueue<>(), sndQueue;

    public AoC2017Day18Part2VM(long number, String[] instructions) {
        registers.put("p", number);
        this.instructions = instructions;
        if (instructions == null) {
            throw new RuntimeException("instructions is null");
        }
    }

    public int getSndCounter() {
        return sndCounter;
    }

    public Queue<Long> getRcvQueue() {
        return rcvQueue;
    }

    public void setSndQueue(Queue<Long> sndQueue) {
        this.sndQueue = sndQueue;
    }

    public boolean isFinished() {
        return i >= instructions.length;
    }

    public void run() {
        if (sndQueue == null) {
            throw new RuntimeException("snd queue is null");
        }
        for (; i < instructions.length; ) {
            String instruction = instructions[i];
            Matcher m;

            m = snd.matcher(instruction);
            if (m.matches()) {
                sndQueue.add(getRegisterOrNumberValue(m.group(1)));
                ++sndCounter;
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
                Long value = rcvQueue.poll();
                if (value == null) {
                    return;
                } else {
                    putRegisterValue(m.group(1), value);
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

    private long getRegisterOrNumberValue(String s) {
        try {
            return Long.parseLong(s);
        } catch (Exception e) {
            if (!registers.containsKey(s)) {
                registers.put(s, 0L);
            }
            return registers.get(s);
        }
    }

    private long getRegisterValue(String s) {
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

    private void putRegisterValue(String s, long value) {
        try {
            long n = Long.parseLong(s);
            throw new RuntimeException("Expected register, not number " + n);
        } catch (Exception e) {
        }
        registers.put(s, value);
    }
}
