package advent.advent2018;

import utils.Point;

import java.util.HashMap;
import java.util.Map;

public class AoC2018Day22Part1 {
    private static final Point mouthPoint = new Point();
    private static final Map<Point, Info> points = new HashMap<>();
    private static Point targetPoint;
    private static int depth;

    public static void main(String[] args) {
        int result;

        result = test(new Point(10, 10), 510);
        assert result == 114 : "unexpected result is " + result;
        System.out.println(result);

        result = test(new Point(15, 740), 3558);
        assert result == 11810 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(Point targetPoint, int depth) {
        AoC2018Day22Part1.targetPoint = targetPoint;
        AoC2018Day22Part1.depth = depth;
        points.clear();
        return riskLevelOfArea(targetPoint);
    }

    private static int geologicIndex(Point point) {
        if (point.equals(mouthPoint) || point.equals(targetPoint)) {
            return 0;
        }
        int x = point.x, y = point.y;
        if (y == 0) {
            return x * 16807;
        }
        if (x == 0) {
            return y * 48271;
        }
        return points.get(new Point(x - 1, y)).erosionLevel * points.get(new Point(x, y - 1)).erosionLevel;
    }

    private static int errosionLevel(Point point) {
        return (points.get(point).geologicIndex + depth) % 20183;
    }

    private static Type type(Point point) {
        switch (points.get(point).erosionLevel % 3) {
            case 0:
                return Type.rocky;
            case 1:
                return Type.wet;
            case 2:
                return Type.narrow;
        }
        throw new RuntimeException("Unreachable");
    }

    private static int riskLevelOfArea(Point point) {
        for (int y = 0; y <= point.y; ++y) {
            for (int x = 0; x <= point.x; ++x) {
                Point currentPoint = new Point(x, y);
                Info info = new Info();
                points.put(currentPoint, info);
                info.geologicIndex = geologicIndex(currentPoint);
                info.erosionLevel = errosionLevel(currentPoint);
                info.type = type(currentPoint);
                info.riskLevel = riskLevel(currentPoint);
            }
        }
        int totalRiskLevel = 0;
        for (int y = 0; y <= point.y; ++y) {
            for (int x = 0; x <= point.x; ++x) {
                Point currentPoint = new Point(x, y);
                totalRiskLevel += points.get(currentPoint).riskLevel;
            }
        }
        return totalRiskLevel;
    }

    private static int riskLevel(Point point) {
        switch (points.get(point).type) {
            case rocky:
                return 0;
            case wet:
                return 1;
            case narrow:
                return 2;
        }
        throw new RuntimeException("Unreachable");
    }

    private enum Type {
        rocky, wet, narrow
    }

    private static class Info {
        int geologicIndex;
        int erosionLevel;
        Type type;
        int riskLevel;
    }
}
