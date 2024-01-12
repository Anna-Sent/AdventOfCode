package advent.advent2018;

import utils.Point;

import java.util.*;

public class AoC2018Day22Part2 {
    private static final Point mouthPoint = new Point();
    private static final Map<Point, Info> points = new HashMap<>();
    private static final Comparator<State> stateComparator = (s1, s2) -> Integer.compare(s1.minutes, s2.minutes);
    private static Point targetPoint;
    private static int depth;

    public static void main(String[] args) {
        int result;

        result = test(new Point(10, 10), 510);
        assert result == 45 : "unexpected result is " + result;
        System.out.println(result);

        result = test(new Point(15, 740), 3558);
        assert result == 1015 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(Point targetPoint, int depth) {
        AoC2018Day22Part2.targetPoint = targetPoint;
        AoC2018Day22Part2.depth = depth;
        points.clear();
        riskLevelOfArea(new Point(targetPoint.x + 1000, targetPoint.y + 1000));
        return bfs(new State(mouthPoint, Instrument.torch, 0));
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
        if (point.equals(mouthPoint) || point.equals(targetPoint)) {
            return Type.rocky;
        }
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

    private static List<State> sort(Set<State> set) {
        List<State> sorted = new ArrayList<>(set);
        Collections.sort(sorted, stateComparator);
        return sorted;
    }

    private static int bfs(State initial) {
        Set<State> closed = new HashSet<>();
        Queue<State> opened = new PriorityQueue<>(stateComparator);

        opened.add(initial);

        int i = 0;
        while (opened.size() > 0) {
            State currentState = opened.poll();

            if (closed.contains(currentState)) {
                continue;
            }

            if (currentState.isEnd()) {
                return currentState.minutes;
            }

            Set<State> next = currentState.generateNext();
            for (State nextState : next) {
                opened.add(nextState);
            }

            closed.add(currentState);

            if (i % 1000 == 0) {
                System.out.println("i " + (i / 1000) + " " + currentState.minutes);
            }
            ++i;
        }

        return -1;
    }

    private enum Type {
        rocky, wet, narrow
    }

    private enum Instrument {
        gear, torch, neither
    }

    private static class State {
        private static final int[] dxs = new int[]{1, -1, 0, 0};
        private static final int[] dys = new int[]{0, 0, 1, -1};
        private static final Map<Type, Set<Instrument>> validInstruments = new HashMap<Type, Set<Instrument>>() {{
            put(Type.rocky, EnumSet.of(Instrument.gear, Instrument.torch));
            put(Type.wet, EnumSet.of(Instrument.gear, Instrument.neither));
            put(Type.narrow, EnumSet.of(Instrument.neither, Instrument.torch));
        }};
        Point point;
        Instrument instrument;
        int minutes;

        public State(Point point, Instrument instrument, int minutes) {
            this.point = point;
            this.instrument = instrument;
            this.minutes = minutes;
        }

        public Set<State> generateNext() {
            Set<State> next = new HashSet<>();

            for (int i = 0; i < 4; ++i) {
                int dx = dxs[i], dy = dys[i];
                Point nextPoint = new Point(point.x + dx, point.y + dy);
                if (nextPoint.x < 0 || nextPoint.y < 0) {
                    continue;
                }
                Type nextType = points.get(nextPoint).type;
                Type currentType = points.get(point).type;
                for (Instrument nextInstrument : Instrument.values()) {
                    if (!validInstruments.get(nextType).contains(nextInstrument)
                            || !validInstruments.get(currentType).contains(nextInstrument)) {
                        continue;
                    }
                    int nextMinutes = minutes + (nextInstrument != instrument ? 8 : 1);
                    next.add(new State(nextPoint, nextInstrument, nextMinutes));
                }
            }

            return next;
        }

        public boolean isEnd() {
            return point.equals(targetPoint) && instrument == Instrument.torch;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return point.equals(state.point) && instrument == state.instrument;
        }

        @Override
        public int hashCode() {
            int result = 31;
            result = 31 * result + point.hashCode();
            result = 31 * result + instrument.hashCode();
            return result;
        }
    }

    private static class Info {
        int geologicIndex;
        int erosionLevel;
        Type type;
        int riskLevel;
    }
}
