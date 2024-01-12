package advent.advent2016;

public class AoC2016Day1Part1 {
    public static void main(String[] args) {
        int result;

        result = test("R2, L3");
        assert result == 5;
        System.out.println(result);

        result = test("R2, R2, R2");
        assert result == 2;
        System.out.println(result);

        result = test("R5, L5, R5, R3");
        assert result == 12;
        System.out.println(result);

        result = test("L1, L3, L5, L3, R1, L4, L5, R1, R3, L5, R1, L3, L2, L3, R2, R2, L3, L3, R1, L2, R1, L3, L2, R4, R2, L5, R4, L5, R4, L2, R3, L2, R4, R1, L5, L4, R1, L2, R3, R1, R2, L4, R1, L2, R3, L2, L3, R5, L192, R4, L5, R4, L1, R4, L4, R2, L5, R45, L2, L5, R4, R5, L3, R5, R77, R2, R5, L5, R1, R4, L4, L4, R2, L4, L1, R191, R1, L1, L2, L2, L4, L3, R1, L3, R1, R5, R3, L1, L4, L2, L3, L1, L1, R5, L4, R1, L3, R1, L2, R1, R4, R5, L4, L2, R4, R5, L1, L2, R3, L4, R2, R2, R3, L2, L3, L5, R3, R1, L4, L3, R4, R2, R2, R2, R1, L4, R4, R1, R2, R1, L2, L2, R4, L1, L2, R3, L3, L5, L4, R4, L3, L1, L5, L3, L5, R5, L5, L4, L2, R1, L2, L4, L2, L4, L1, R4, R4, R5, R1, L4, R2, L4, L2, L4, R2, L4, L1, L2, R1, R4, R3, R2, R2, R5, L1, L2");
        assert result == 299;
        System.out.println(result);
    }

    private static int test(String s) {
        String[] parts = s.split(", ");
        int x = 0, y = 0, deltaX = 0, deltaY = 0;
        for (int i = 0; i < parts.length; ++i) {
            int delta = Integer.parseInt(parts[i].substring(1));
            if (parts[i].startsWith("R")) {
                // move right
                if (deltaX > 0) {
                    deltaX = 0;
                    deltaY = -delta;
                } else if (deltaX < 0) {
                    deltaX = 0;
                    deltaY = delta;
                } else if (deltaY > 0) {
                    deltaX = delta;
                    deltaY = 0;
                } else if (deltaY < 0) {
                    deltaX = -delta;
                    deltaY = 0;
                } else {
                    deltaX = delta;
                    deltaY = 0;
                }
            } else {
                // move left
                if (deltaX > 0) {
                    deltaX = 0;
                    deltaY = delta;
                } else if (deltaX < 0) {
                    deltaX = 0;
                    deltaY = -delta;
                } else if (deltaY > 0) {
                    deltaX = -delta;
                    deltaY = 0;
                } else if (deltaY < 0) {
                    deltaX = delta;
                    deltaY = 0;
                } else {
                    deltaX = -delta;
                    deltaY = 0;
                }
            }
            x += deltaX;
            y += deltaY;
        }
        return Math.abs(x) + Math.abs(y);
    }
}