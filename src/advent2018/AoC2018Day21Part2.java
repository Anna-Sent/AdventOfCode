package advent2018;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2018Day21Part2 {
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
        assert result == 4520776 : "unexpected result is " + result;
        System.out.println(result);
    }

    public static int test(String s, int ip) {
        List<ConcreteCommand> commands = readCommands(s);
        int[] registers = new int[6];
        Set<Integer> results = new HashSet<>();
        int time = 0;
        int prevResult = 0;
        for (; registers[ip] < commands.size(); ) {
            ConcreteCommand command = commands.get(registers[ip]);
            command.command.apply(registers, command.a, command.b, command.c);
            if ("eqrr".equals(command.opname)) {
                int result = registers[3];
                if (results.contains(result)) {
                    return prevResult;
                }
                results.add(result);
                ++time;
                prevResult = result;
            }
            ++registers[ip];
        }
        return -1;
    }

    private static List<ConcreteCommand> readCommands(String s) {
        Pattern opPattern = Pattern.compile("(.+) (\\d+) (\\d+) (\\d+)");
        String[] tokens = s.split("\n");
        List<ConcreteCommand> commands = new ArrayList<>();
        for (String token : tokens) {
            Matcher matcher = opPattern.matcher(token);
            if (!matcher.matches()) {
                System.out.println("not matches op " + token);
            }
            String opname = matcher.group(1);
            int aValue = Integer.parseInt(matcher.group(2));
            int bValue = Integer.parseInt(matcher.group(3));
            int cValue = Integer.parseInt(matcher.group(4));
            ConcreteCommand concreteCommand = new ConcreteCommand(opname, aValue, bValue, cValue);
            commands.add(concreteCommand);
            switch (opname) {
                case "addr":
                    concreteCommand.command = (int[] registers, int a, int b, int c) ->
                            registers[c] = registers[a] + registers[b];
                    break;
                case "addi":
                    concreteCommand.command = (int[] registers, int a, int b, int c) ->
                            registers[c] = registers[a] + b;
                    break;
                case "mulr":
                    concreteCommand.command = (int[] registers, int a, int b, int c) ->
                            registers[c] = registers[a] * registers[b];
                    break;
                case "muli":
                    concreteCommand.command = (int[] registers, int a, int b, int c) ->
                            registers[c] = registers[a] * b;
                    break;
                case "banr":
                    concreteCommand.command = (int[] registers, int a, int b, int c) ->
                            registers[c] = registers[a] & registers[b];
                    break;
                case "bani":
                    concreteCommand.command = (int[] registers, int a, int b, int c) ->
                            registers[c] = registers[a] & b;
                    break;
                case "borr":
                    concreteCommand.command = (int[] registers, int a, int b, int c) ->
                            registers[c] = registers[a] | registers[b];
                    break;
                case "bori":
                    concreteCommand.command = (int[] registers, int a, int b, int c) ->
                            registers[c] = registers[a] | b;
                    break;
                case "setr":
                    concreteCommand.command = (int[] registers, int a, int b, int c) ->
                            registers[c] = registers[a];
                    break;
                case "seti":
                    concreteCommand.command = (int[] registers, int a, int b, int c) ->
                            registers[c] = a;
                    break;
                case "gtir":
                    concreteCommand.command = (int[] registers, int a, int b, int c) ->
                            registers[c] = a > registers[b] ? 1 : 0;
                    break;
                case "gtri":
                    concreteCommand.command = (int[] registers, int a, int b, int c) ->
                            registers[c] = registers[a] > b ? 1 : 0;
                    break;
                case "gtrr":
                    concreteCommand.command = (int[] registers, int a, int b, int c) ->
                            registers[c] = registers[a] > registers[b] ? 1 : 0;
                    break;
                case "eqir":
                    concreteCommand.command = (int[] registers, int a, int b, int c) ->
                            registers[c] = a == registers[b] ? 1 : 0;
                    break;
                case "eqri":
                    concreteCommand.command = (int[] registers, int a, int b, int c) ->
                            registers[c] = registers[a] == b ? 1 : 0;
                    break;
                case "eqrr":
                    concreteCommand.command = (int[] registers, int a, int b, int c) ->
                            registers[c] = registers[a] == registers[b] ? 1 : 0;
                    break;
            }
        }
        return commands;
    }

    @FunctionalInterface
    private static interface Command {
        void apply(int[] registers, int a, int b, int c);
    }

    private static class ConcreteCommand {
        String opname;
        int a, b, c;
        Command command;

        ConcreteCommand(String opname, int a, int b, int c) {
            this.opname = opname;
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
