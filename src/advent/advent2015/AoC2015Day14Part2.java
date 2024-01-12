package advent.advent2015;

import java.util.ArrayList;
import java.util.List;

public class AoC2015Day14Part2 {
    public static void main(String[] args) {
        int result;

        result = test(
                1000,
                "Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.\r\nDancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.");
        assert result == 689;
        System.out.println(result);

        result = test(
                2503,
                "Rudolph can fly 22 km/s for 8 seconds, but then must rest for 165 seconds.\r\nCupid can fly 8 km/s for 17 seconds, but then must rest for 114 seconds.\r\nPrancer can fly 18 km/s for 6 seconds, but then must rest for 103 seconds.\r\nDonner can fly 25 km/s for 6 seconds, but then must rest for 145 seconds.\r\nDasher can fly 11 km/s for 12 seconds, but then must rest for 125 seconds.\r\nComet can fly 21 km/s for 6 seconds, but then must rest for 121 seconds.\r\nBlitzen can fly 18 km/s for 3 seconds, but then must rest for 50 seconds.\r\nVixen can fly 20 km/s for 4 seconds, but then must rest for 75 seconds.\r\nDancer can fly 7 km/s for 20 seconds, but then must rest for 119 seconds.");
        System.out.println(result);
    }

    private static int test(int seconds, String s) {
        List<Reindeer> reindeers = new ArrayList<>();
        String[] strings = s.split("\r\n");
        for (String string : strings) {
            reindeers.add(new Reindeer(string));
        }

        for (int t = 1; t <= seconds; ++t) {
            int leadingDistance = 0;
            for (Reindeer reindeer : reindeers) {
                int km1 = t / (reindeer.flying + reindeer.resting)
                        * reindeer.flying * reindeer.speed;
                int seconds1 = t % (reindeer.flying + reindeer.resting);
                int km2 = seconds1 > reindeer.flying ? reindeer.flying
                        * reindeer.speed : seconds1 * reindeer.speed;
                reindeer.currentDistance = km1 + km2;
                leadingDistance = reindeer.currentDistance > leadingDistance ? reindeer.currentDistance
                        : leadingDistance;
            }
            for (Reindeer reindeer : reindeers) {
                if (reindeer.currentDistance == leadingDistance) {
                    ++reindeer.points;
                }
            }
        }

        int maxPoints = 0;

        for (Reindeer reindeer : reindeers) {
            System.out.println(reindeer.name + " " + reindeer.points
                    + " points; " + reindeer.currentDistance + " km");
            maxPoints = reindeer.points > maxPoints ? reindeer.points
                    : maxPoints;
        }

        return maxPoints;
    }

    static class Reindeer {
        String name;
        int speed;
        int flying, resting;
        int points;
        int currentDistance;

        Reindeer(String s) {
            String[] parts = s.split(" can fly ");
            name = parts[0];
            parts = parts[1].split(" km/s for ");
            speed = Integer.parseInt(parts[0]);
            parts = parts[1].split(" seconds, but then must rest for ");
            flying = Integer.parseInt(parts[0]);
            parts = parts[1].split(" seconds.");
            resting = Integer.parseInt(parts[0]);
        }
    }
}