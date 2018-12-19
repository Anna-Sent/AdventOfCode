package advent2018;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2018Day19Part2 {
    public static void main(String[] args) {
        int result;

        result = test("addi 2 16 2\n" +//0
                        "seti 1 1 1\n" +//1
                        "seti 1 4 3\n" +//2
                        "mulr 1 3 5\n" +//3+
                        "eqrr 5 4 5\n" +//4+
                        "addr 5 2 2\n" +//5+
                        // "addi 2 1 2\n" +//6+
                        // "addr 1 0 0\n" +//7
                        "addi 3 1 3\n" +//8+
                        "gtrr 3 4 5\n" +//9+
                        "addr 2 5 2\n" +//10+
                        "seti 2 4 2\n" +//11+
                        "addi 1 1 1\n" +//12
                        "gtrr 1 4 5\n" +//13
                        "addr 5 2 2\n" +//14
                        "seti 1 0 2\n" +//15
                        "mulr 2 2 2\n" +//16
                        "addi 4 2 4\n" +//17
                        "mulr 4 4 4\n" +//18
                        "mulr 2 4 4\n" +//19
                        "muli 4 11 4\n" +//20
                        "addi 5 1 5\n" +//21
                        "mulr 5 2 5\n" +//22
                        "addi 5 17 5\n" +//23
                        "addr 4 5 4\n" +//24
                        "addr 2 0 2\n" +//25
                        "seti 0 9 2\n" +//26
                        "setr 2 3 5\n" +//27
                        "mulr 5 2 5\n" +//28
                        "addr 2 5 5\n" +//29
                        "mulr 2 5 5\n" +//30
                        "muli 5 14 5\n" +//31
                        "mulr 5 2 5\n" +//32
                        "addr 4 5 4\n" +//33
                        "seti 0 9 0\n" +//34
                        "seti 0 6 2",//35
                2);
        // assert result ==  : "unexpected result is " + result;
        System.out.println(result);
    }

    public static int test(String s, int ip) {
        Pattern opPattern = Pattern.compile("(.+) (\\d+) (\\d+) (\\d+)");
        int[] registers = new int[6];
        registers[0] = 1;
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
                    break;
            }
            ++registers[ip];
            System.out.println(Arrays.toString(registers));
        }

        return registers[0];
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
