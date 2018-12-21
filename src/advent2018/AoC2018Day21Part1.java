package advent2018;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2018Day21Part1 {
    public static void main(String[] args) {
        int result;

        result = test("seti 123 0 3\n" +
                "bani 3 456 3\n" +
                "eqri 3 72 3\n" +
                "addr 3 2 2\n" +
                "seti 0 0 2\n" +
                "seti 0 6 3\n" +
                "bori 3 65536 4\n" +
                "seti 2176960 8 3\n" +
                "bani 4 255 1\n" +
                "addr 3 1 3\n" +
                "bani 3 16777215 3\n" +
                "muli 3 65899 3\n" +
                "bani 3 16777215 3\n" +
                "gtir 256 4 1\n" +
                "addr 1 2 2\n" +
                "addi 2 1 2\n" +
                "seti 27 7 2\n" +
                "seti 0 9 1\n" +
                "addi 1 1 5\n" +
                "muli 5 256 5\n" +
                "gtrr 5 4 5\n" +
                "addr 5 2 2\n" +
                "addi 2 1 2\n" +
                "seti 25 7 2\n" +
                "addi 1 1 1\n" +
                "seti 17 2 2\n" +
                "setr 1 7 4\n" +
                "seti 7 9 2\n" +
                "eqrr 3 0 1\n" +
                "addr 1 2 2\n" +
                "seti 5 9 2", 2);
        assert result == 11474091 : "unexpected result is " + result;
        System.out.println(result);
    }

    public static int test(String s, int ip) {
        Pattern opPattern = Pattern.compile("(.+) (\\d+) (\\d+) (\\d+)");
        int[] registers = new int[6];
        String[] tokens = s.split("\n");
        for (; registers[ip] < tokens.length; ) {
            String token = tokens[registers[ip]];
            Matcher matcher = opPattern.matcher(token);
            if (!matcher.matches()) {
                System.out.println("not matches op " + token);
            }
            String opname = matcher.group(1);
            int a = Integer.parseInt(matcher.group(2));
            int b = Integer.parseInt(matcher.group(3));
            int c = Integer.parseInt(matcher.group(4));
            switch (opname) {
                case "addr":
                    registers = addr(registers, a, b, c);
                    break;
                case "addi":
                    registers = addi(registers, a, b, c);
                    break;
                case "mulr":
                    registers = mulr(registers, a, b, c);
                    break;
                case "muli":
                    registers = muli(registers, a, b, c);
                    break;
                case "banr":
                    registers = banr(registers, a, b, c);
                    break;
                case "bani":
                    registers = bani(registers, a, b, c);
                    break;
                case "borr":
                    registers = borr(registers, a, b, c);
                    break;
                case "bori":
                    registers = bori(registers, a, b, c);
                    break;
                case "setr":
                    registers = setr(registers, a, b, c);
                    break;
                case "seti":
                    registers = seti(registers, a, b, c);
                    break;
                case "gtir":
                    registers = gtir(registers, a, b, c);
                    break;
                case "gtri":
                    registers = gtri(registers, a, b, c);
                    break;
                case "gtrr":
                    registers = gtrr(registers, a, b, c);
                    break;
                case "eqir":
                    registers = eqir(registers, a, b, c);
                    break;
                case "eqri":
                    registers = eqri(registers, a, b, c);
                    break;
                case "eqrr":
                    registers = eqrr(registers, a, b, c);
                    System.out.println(Arrays.toString(registers));
                    return registers[3];
            }
            ++registers[ip];
        }
        return -1;
    }

    private static int[] addr(int[] registers, int a, int b, int c) {
        int[] result = Arrays.copyOf(registers, registers.length);
        registers = result;
        registers[c] = registers[a] + registers[b];
        return registers;
    }

    private static int[] addi(int[] registers, int a, int b, int c) {
        int[] result = Arrays.copyOf(registers, registers.length);
        registers = result;
        registers[c] = registers[a] + b;
        return registers;
    }

    private static int[] mulr(int[] registers, int a, int b, int c) {
        int[] result = Arrays.copyOf(registers, registers.length);
        registers = result;
        registers[c] = registers[a] * registers[b];
        return registers;
    }

    private static int[] muli(int[] registers, int a, int b, int c) {
        int[] result = Arrays.copyOf(registers, registers.length);
        registers = result;
        registers[c] = registers[a] * b;
        return registers;
    }

    private static int[] banr(int[] registers, int a, int b, int c) {
        int[] result = Arrays.copyOf(registers, registers.length);
        registers = result;
        registers[c] = registers[a] & registers[b];
        return registers;
    }

    private static int[] bani(int[] registers, int a, int b, int c) {
        int[] result = Arrays.copyOf(registers, registers.length);
        registers = result;
        registers[c] = registers[a] & b;
        return registers;
    }

    private static int[] borr(int[] registers, int a, int b, int c) {
        int[] result = Arrays.copyOf(registers, registers.length);
        registers = result;
        registers[c] = registers[a] | registers[b];
        return registers;
    }

    private static int[] bori(int[] registers, int a, int b, int c) {
        int[] result = Arrays.copyOf(registers, registers.length);
        registers = result;
        registers[c] = registers[a] | b;
        return registers;
    }

    private static int[] setr(int[] registers, int a, int b, int c) {
        int[] result = Arrays.copyOf(registers, registers.length);
        registers = result;
        registers[c] = registers[a];
        return registers;
    }

    private static int[] seti(int[] registers, int a, int b, int c) {
        int[] result = Arrays.copyOf(registers, registers.length);
        registers = result;
        registers[c] = a;
        return registers;
    }

    private static int[] gtir(int[] registers, int a, int b, int c) {
        int[] result = Arrays.copyOf(registers, registers.length);
        registers = result;
        registers[c] = a > registers[b] ? 1 : 0;
        return registers;
    }

    private static int[] gtri(int[] registers, int a, int b, int c) {
        int[] result = Arrays.copyOf(registers, registers.length);
        registers = result;
        registers[c] = registers[a] > b ? 1 : 0;
        return registers;
    }

    private static int[] gtrr(int[] registers, int a, int b, int c) {
        int[] result = Arrays.copyOf(registers, registers.length);
        registers = result;
        registers[c] = registers[a] > registers[b] ? 1 : 0;
        return registers;
    }

    private static int[] eqir(int[] registers, int a, int b, int c) {
        int[] result = Arrays.copyOf(registers, registers.length);
        registers = result;
        registers[c] = a == registers[b] ? 1 : 0;
        return registers;
    }

    private static int[] eqri(int[] registers, int a, int b, int c) {
        int[] result = Arrays.copyOf(registers, registers.length);
        registers = result;
        registers[c] = registers[a] == b ? 1 : 0;
        return registers;
    }

    private static int[] eqrr(int[] registers, int a, int b, int c) {
        int[] result = Arrays.copyOf(registers, registers.length);
        registers = result;
        registers[c] = registers[a] == registers[b] ? 1 : 0;
        return registers;
    }
}
