package advent2018;

public class AoC2018Day9Part2 {
    public static void main(String[] args) {
        long result;

        result = test(458, 72019 * 100);
        assert result == 3243916887L : "unexpected result is " + result;
        System.out.println(result);
    }

    public static long test(int playersCount, int marblesCount) {
        return test(playersCount, marblesCount, false);
    }

    public static long test(int playersCount, int marblesCount, boolean print) {
        long[] scores = new long[playersCount];
        Marble rootMarble = new Marble(0);
        rootMarble.prev = rootMarble;
        rootMarble.next = rootMarble;
        int count = 0;
        int currentPlayer = 0;
        Marble currentMarble = rootMarble;
        while (count < marblesCount) {
            int newMarbleNumber = ++count;
            Marble newMarble;
            if (newMarbleNumber % 23 == 0) {
                Marble prevMarble = currentMarble;
                for (int i = 0; i < 7; ++i) {
                    prevMarble = prevMarble.prev;
                }
                scores[currentPlayer] += count;
                scores[currentPlayer] += prevMarble.number;
                newMarble = prevMarble.next;
                prevMarble.prev.next = newMarble;
                newMarble.prev = prevMarble.prev.next;
            } else {
                Marble firstMarble = currentMarble.next;
                Marble secondMarble = firstMarble.next;
                newMarble = new Marble(newMarbleNumber);
                newMarble.prev = firstMarble;
                newMarble.next = secondMarble;
                firstMarble.next = newMarble;
                secondMarble.prev = newMarble;
            }

            currentPlayer = (currentPlayer + 1) % playersCount;
            currentMarble = newMarble;

            if (print) {
                System.out.print("[" + currentPlayer + "]");
                for (Marble marble = rootMarble; ; ) {
                    boolean isCurrent = marble == currentMarble;
                    System.out.print("\t" + (isCurrent ? "(" : "") + marble + (isCurrent ? ")" : ""));
                    marble = marble.next;
                    if (marble == rootMarble) {
                        break;
                    }
                }
                System.out.println();
            }
        }

        long max = 0;
        for (int i = 0; i < scores.length; ++i) {
            max = Math.max(max, scores[i]);
        }
        return max;
    }

    private static class Marble {
        int number;
        Marble next;
        Marble prev;

        Marble(int number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return String.valueOf(number);
        }
    }
}
