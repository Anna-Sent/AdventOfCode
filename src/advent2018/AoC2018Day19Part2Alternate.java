package advent2018;

public class AoC2018Day19Part2Alternate {
    public static void main(String[] args) {
        // r0 -- result
        // r1, r3 -- counters
        // r2 -- instruction pointer
        // r4 -- input number
        // r5 -- multiplication of r1 and r3
        System.out.println(calculateSumOfDividers(10551275));
    }

    private static int calculateSumOfDividers(int number) {
        int result = 0;
        int divider = 1;
        while (divider * divider < number) {
            if (number % divider == 0) {
                result += divider;
                result += number / divider;
            }
            ++divider;
        }
        return result;
    }
}
