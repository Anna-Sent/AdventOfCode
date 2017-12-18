package advent2017;

public class AoC2017Day18Part2 {
    public static void main(String[] args) {
        long result;

        result = test("snd 1\n" +
                "snd 2\n" +
                "snd p\n" +
                "rcv a\n" +
                "rcv b\n" +
                "rcv c\n" +
                "rcv d");
        System.out.println(result);
        assert result == 3 : "unexpected result is " + result;

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
        assert result == 7620 : "unexpected result is " + result;
        System.out.println(result);
    }

    public static long test(String s) {
        String[] instructions = s.split("\n");
        AoC2017Day18Part2VM program0 = new AoC2017Day18Part2VM(0, instructions);
        AoC2017Day18Part2VM program1 = new AoC2017Day18Part2VM(1, instructions);
        program0.setSndQueue(program1.getRcvQueue());
        program1.setSndQueue(program0.getRcvQueue());
        boolean isFinished = false;
        while (!isFinished) {
            program0.run();
            program1.run();
            if (program0.getRcvQueue().isEmpty() && program1.getRcvQueue().isEmpty()
                    || program0.isFinished() && program1.isFinished()) {
                isFinished = true;
            }
        }
        return program1.getSndCounter();
    }
}
