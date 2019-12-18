package advent2019;

import utils.Point;

import java.util.*;

public class AoC2019Day18Part2_v2 {

    public static void main(String[] args) {
        int result;

        result = test("#######\n" +
                "#a.#Cd#\n" +
                "##...##\n" +
                "##.@.##\n" +
                "##...##\n" +
                "#cB#Ab#\n" +
                "#######");
        assert result == 8 : "unexpected result is " + result;
        System.out.println(result);

        result = test("###############\n" +
                "#d.ABC.#.....a#\n" +
                "######...######\n" +
                "######.@.######\n" +
                "######...######\n" +
                "#b.....#.....c#\n" +
                "###############");
        assert result == 24 : "unexpected result is " + result;
        System.out.println(result);

        result = test("#############\n" +
                "#g#f.D#..h#l#\n" +
                "#F###e#E###.#\n" +
                "#dCba...BcIJ#\n" +
                "#####.@.#####\n" +
                "#nK.L...G...#\n" +
                "#M###N#H###.#\n" +
                "#o#m..#i#jk.#\n" +
                "#############");
        assert result == 72 : "unexpected result is " + result;
        System.out.println(result);

        result = test("#################################################################################\n" +
                "#.....#...............#.....#.A.#.......#.....#e..............#.....#...........#\n" +
                "#.###.#########.#####.###.#.###.#.###.#.###.#.###.###########.#.#.###.#####.#####\n" +
                "#.#.#.....#...#.#...#.#...#.....#.#.#.#.#...#..m#...#.......#.#.#.#...#.#...#...#\n" +
                "#.#.#####.#.#.#.#.###.#.#########.#.#.###.#####.###.#.#######.###.#.###.#N###.#.#\n" +
                "#.#.#...#...#...#...#.#.....T.......#...#.#...#.....#.#.....#.#...#.....#.#...#.#\n" +
                "#.#.#.#.###########.#.#.###############.#.#.#.#######.#.###.#.#.#.#####.#.#.###.#\n" +
                "#.#...#.......#.....#.#.......#.....#...#.#.#...#.........#j....#.#...#.#.#.#...#\n" +
                "#.###########.#.#.#.#.#########.###.#.#.#.#.###.#.#########.#####.###.#.#.#.#.#.#\n" +
                "#.#.....#...#.#.#.#.#...........#...#.#.#.#...#.#.#...#...#.#...#...#.#.#...#.#.#\n" +
                "#.#P###.#D#.#.#.#.###############.###.#.#.###.#.#.###.#.#.###.#.###.#.#.#####.###\n" +
                "#...#...#.#.#u..#.......#...#.....#...#.#.#...#.......#.#.....#...#...#.....#...#\n" +
                "#####.###.#.#######.###.#.###.#######.#.#.#########.###.#########.#########.###.#\n" +
                "#...#.#...#g......#...#.#...#.#.....#.#.#.#...#...#.#...#.......#.#.........#...#\n" +
                "#.#.#.#.#########.###.#.###.#.###.#.#.#.#.#.#.#.#.###.#######.#.#.#.#########O#.#\n" +
                "#.#...#..d#.....#...#.#.....#.....#...#.#...#...#.....#.....#.#.#...#.....#...#.#\n" +
                "#.#######.#.###F###.#.#################.#.###############.#.#.#.#######.#.#.###.#\n" +
                "#.....#...#..h#...#.#.............#.....#.#.......#.......#...#.....#...#.#.#...#\n" +
                "#.###.#H#####.#.###G#.#######.#####.#####.###.#.#.#.###.###########.#.###.#.#####\n" +
                "#.#.#.#.......#.#...#.....#...#...#.#...#...#.#.#.#...#.#...#.....#...#.#.#.....#\n" +
                "#.#.#.#########.#.#########.###.#.#.###.###.#.#.#.#####.#.#.#####.#####.#.#####.#\n" +
                "#...#.....#.....#b..#...#...#...#...#...#...#.#.#.....#...#.#y..#.......#.....#.#\n" +
                "###.#####.#.#######.###B#.#.#.#######.#.#.#####.#####.#.###.###.#####.#.#.#####.#\n" +
                "#...#...I.#f......#.....#.#.#.#...#...#.#...#...#...#.#.#.....#.....#.#...#.....#\n" +
                "#####.###########.#######.###.#.###.#.#####.#.###.###.###.#########.#######.#####\n" +
                "#o....#k........#.#.#.......#.#.#...#...#.#.#.#.....#.#...#.......#.......K.#...#\n" +
                "#.#####.###.#####.#.#.#####.#.#.#.#####.#.#.#.###.#.#.#.###.###.###############.#\n" +
                "#.#.......#...#.C.#.....#...#.#...#...#.#...#...#.#.#.#...#...#.....#...........#\n" +
                "#.#.#########.#.#########.###.###.#.###.#.#####.#.#.#.###.###.#####.#.#.#######.#\n" +
                "#...#l........#...#.....#...#...#...#...#.......#.#...#...#...#...#...#.X.#...#.#\n" +
                "#.###.#.#########.#V###.###.###.#####.###########.#####.###.###.#########.#.#.#.#\n" +
                "#...#.#.#.....#...#.#.#.#...#.#.....#...#.......#...#...#...#...........#.#.#.#.#\n" +
                "#####.#.#.###.#.###.#.#.#.#.#.#####.###.#.#####.###.#.#.#.###.#######.###.#.#.#W#\n" +
                "#.....#.#.#r#.#.#...#.#.#.#.#.#...#...#.#.#...#...#.#.#.#...#.......#...#.#.#.#.#\n" +
                "#.#######.#.#.#.###.#.#.#.#.#.#.#.###.#.#.###.###.#.#.#.###.###########.#.#.#.#.#\n" +
                "#.........#.#.#.#s..#...#.#.Q.#.#.#...#.#...#...#...#.#.............#...#.#.#...#\n" +
                "#.#########.#.#.#.###.###.#.###.#.#.###.###.#.#.#####.#######.#####.#.###.#.#####\n" +
                "#...#...#...#.#...#...#...#.#...#...#...#.#.#.#.....#...#...#.#...#...#...#...#.#\n" +
                "###.#Y#.###.#.#####.###.#####.#########.#.#.###.###.#####.#.###.#.#####.#####.#.#\n" +
                "#.....#.....#.......#...........................#.........#....q#.......#.......#\n" +
                "#######################################.@.#######################################\n" +
                "#...#.#.................#..z..............#.......#.............#...............#\n" +
                "#.#.#.#.#.#############.#.#.###########.#.#.#.#####.#####.#####.#.###.#########.#\n" +
                "#.#...#.#.#...#.#.....#.#.#.#.....#...#.#...#.#...Z.....#.#.....#.#.#.#.......#.#\n" +
                "#.#####.#.#.#.#.#.#.#.#.###.#.#####.#.#.#.###.#.#########.#######.#.#.#####.###.#\n" +
                "#.#...#.#...#.#...#.#x#.#...#.#.....#.#.#...#.....#.....#.#...#.....#.#...#.....#\n" +
                "#.#.#.#.#####.#####.###.#.###.#.#####.#.###.#######.###.#.#.#.#.#####.#.#.#####.#\n" +
                "#w..#...#...#.....#.#.....#...#.#.....#.#.#...#.....#.#...#.#...#..v#.#.#.....#.#\n" +
                "#.#######.#.#####.#.#.#####.###.#.#####.#.###.#.#####.#.###.#####.#.#.#.#####.###\n" +
                "#.#.......#.#.#...#.#.#...#.#...#.#...#.#...#.#.#.......#...#...#.#.#.#.#...#...#\n" +
                "#.###.#.###.#.#.###.#.#.#.#.#.###.#.#.#.#.###.#.###.#####.###.#.#.#.#.#.###.###.#\n" +
                "#...#.#...#...#.#.#...#.#.#...#.#.#.#...#...#.#...#.#...#.#...#.R.#.#.........#.#\n" +
                "###.#####.###.#.#.#.###.#.###.#.#.#.#####.#.#.###.#.#.#.#.#.#######.#.#########.#\n" +
                "#.#...#...#.#.#.#.....#.#...#...#.......#.#.#...#.#...#.#.#.#...#...#.#.........#\n" +
                "#.###.#.###.#.#.#######.###.#.#########.#.#.###.#.#######.#.#.###.###.#.#######.#\n" +
                "#...#...#...#.#.........#...#.#...#.....#.#...#.#.........#.#.#...#...#.#.......#\n" +
                "#.#######.#.#.###########.#####.#.#####.###.###.###########.#.#.#######.#########\n" +
                "#.........#.#.#.........#.......#.#...#.#...#...#...........#.#.#.....#.........#\n" +
                "#.###.#######.#.###.#####.#####.#.#.#.###.#.#.###.###########.#.#.###S#########.#\n" +
                "#...#.......#...#...#...#.#...#.#...#...#.#.#...#.....L.#.....#...#...#...#...#.#\n" +
                "#.#########.#####.###.#.###.#.###.#####.#.#####.#######.#.#########.###.#.#.#.#.#\n" +
                "#.#.......#.#...#.#.#.#.#...#...#...#...#...........#...#...#.#....c#...#...#.#.#\n" +
                "###.#####.#.#.#.#.#.###.#.#####.#####.###.###########.#####.#.#.#####.#######.#.#\n" +
                "#...#.......#.#...#...#...#...#...#...#.#...#.........#.....#...#.......#.......#\n" +
                "#.###.#######.#####.#######.#.###.#.###.###.#.###########.#.#########.#.#######.#\n" +
                "#.#.#.#...#...#.............#...#...#...#...#.............#.........#.#.#.....#.#\n" +
                "#.#.#.#.#.#.###########.#####.#.#####.###.#########################.###.#.###.#.#\n" +
                "#.#...#.#.#.....#.....#...#...#.#.#.....#.....#...#.......#.......#...#...#...#.#\n" +
                "#.#####.#.#####.#.###.#####.###.#.#.###.#####.#.###.###.###.#####.###.#####.#####\n" +
                "#.......#...#.#...#.#.#.....#.#.#...#...#...#.#.#.....#.........#...#.....#.....#\n" +
                "#.#######.#.#.#####E#.#.#####.#.#.###.#.#.#.#.#.#.#############.#.#.#####.###.#.#\n" +
                "#...#.....#...#...#...#.#.....#.#...#.#.#.#...#.....#..a#.....#.#.#...#.#...#.#.#\n" +
                "#####.#######.#.###.###.#.###.#.#.###.#.#.###########.#.#.###.###.###.#.###.###.#\n" +
                "#...#.#.#...#.#.#...#...#.#...#.#.#...#.#.....#.....#.#.#.#.#...#...#...#.#...#.#\n" +
                "#.#.#.#.#.#.#.#.#.###.#.#.#.#.#.###.###.#####.#.###.#.#.#.#.###.###.###.#.###.#.#\n" +
                "#.#.#.#.#.#.....#.#...#.#.#.#.#.....#.#.#.....#.#...#.#...#...#...#.#.#.#...#..i#\n" +
                "#.#.#.#.#.#######.#####.###.#########.#.#.#####U#.###.#######.###.#.#.#.#.#.#####\n" +
                "#.#n..#.......#...#...#...#.#...#.......#.......#t#...#.........#.#.#.#...#.#...#\n" +
                "#.#############.###.#.###.#.#.#.#.###############.#.###.#.#######.#.#.#####.#.#.#\n" +
                "#...............J...#.....#...#.........#...........#...#.........M.#..p......#.#\n" +
                "#################################################################################");
        // assert result ==  : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(String s) {
        Map<Point, Character> map = new HashMap<>();
        Set<Character> allKeys = new HashSet<>();
        Point initialPoint = null;

        String[] tokens = s.split("\n");
        int h = tokens.length;
        int w = tokens[0].length();
        for (int i = 0; i < tokens.length; ++i) {
            char[] token = tokens[i].toCharArray();
            for (int j = 0; j < token.length; ++j) {
                char ch = token[j];
                Point point = new Point(j, i);
                map.put(point, ch);
                if ('a' <= ch && ch <= 'z') {
                    allKeys.add(ch);
                } else if (ch == '@') {
                    assert initialPoint == null : "invalid input";
                    initialPoint = point;
                }
            }
        }
        assert initialPoint != null : "invalid input";

        List<Point> initialPoints = new ArrayList<>();

        map.put(initialPoint, '#');
        Point next;

        next = new Point(initialPoint);
        --next.x;
        map.put(next, '#');

        next = new Point(initialPoint);
        ++next.x;
        map.put(next, '#');

        next = new Point(initialPoint);
        ++next.y;
        map.put(next, '#');

        next = new Point(initialPoint);
        --next.y;
        map.put(next, '#');

        next = new Point(initialPoint);
        --next.x;
        --next.y;
        map.put(next, '@');
        initialPoints.add(next);

        next = new Point(initialPoint);
        ++next.x;
        ++next.y;
        map.put(next, '@');
        initialPoints.add(next);

        next = new Point(initialPoint);
        ++next.x;
        --next.y;
        map.put(next, '@');
        initialPoints.add(next);

        next = new Point(initialPoint);
        --next.x;
        ++next.y;
        map.put(next, '@');
        initialPoints.add(next);

        List<Set<Character>> allKeysList = new ArrayList<>();
        Set<Character> set;

        set = new HashSet<>();
        for (int i = 0; i < initialPoint.y; ++i) {
            for (int j = 0; j < initialPoint.x; ++j) {
                char ch = map.get(new Point(j, i));
                if ('a' <= ch && ch <= 'z') {
                    set.add(ch);
                }
            }
        }
        allKeysList.add(set);

        set = new HashSet<>();
        for (int i = initialPoint.y; i < h; ++i) {
            for (int j = initialPoint.x; j < w; ++j) {
                char ch = map.get(new Point(j, i));
                if ('a' <= ch && ch <= 'z') {
                    set.add(ch);
                }
            }
        }
        allKeysList.add(set);

        set = new HashSet<>();
        for (int i = 0; i < initialPoint.y; ++i) {
            for (int j = initialPoint.x; j < w; ++j) {
                char ch = map.get(new Point(j, i));
                if ('a' <= ch && ch <= 'z') {
                    set.add(ch);
                }
            }
        }
        allKeysList.add(set);

        set = new HashSet<>();
        for (int i = initialPoint.y; i < h; ++i) {
            for (int j = 0; j < initialPoint.x; ++j) {
                char ch = map.get(new Point(j, i));
                if ('a' <= ch && ch <= 'z') {
                    set.add(ch);
                }
            }
        }
        allKeysList.add(set);

        return bfs(map, allKeys, new State(initialPoints, Collections.emptySet()), allKeysList);
    }

    private static int bfs(Map<Point, Character> map, Set<Character> allKeys, State initialState,
                           List<Set<Character>> allKeysList) {
        Set<State> closed = new HashSet<>();
        Set<State> opened = new HashSet<>();

        int count = 0;
        opened.add(initialState);
        while (opened.size() > 0) {
            Set<State> achievable = new HashSet<>();
            for (State current : opened) {
                if (allKeysCollected(current, allKeys)) {
                    System.out.println("closed: " + closed.size());
                    return count;
                }
                Set<State> set = generateNext(current, map, allKeysList);
                for (State next : set) {
                    if (!closed.contains(next)) {
                        achievable.add(next);
                    }
                }

                closed.add(current);
            }

            ++count;
            opened = achievable;
        }
        return -1;
    }

    private static Set<State> generateNext(State current, Map<Point, Character> map,
                                           List<Set<Character>> allKeysList) {
        Set<State> set = new HashSet<>();

        for (int i = 0; i < current.currentPoints.size(); ++i) {
            Point currentPoint = current.currentPoints.get(i);

            Set<Character> allKeysIth = allKeysList.get(i);
            if (current.collected.containsAll(allKeysIth)) {
                continue;
            }

            List<Point> currentPoints;
            Point nextPoint;

            nextPoint = new Point(currentPoint);
            ++nextPoint.x;
            currentPoints = new ArrayList<>(current.currentPoints);
            currentPoints.set(i, nextPoint);
            putState(map, set, nextPoint, currentPoints, current.collected);

            nextPoint = new Point(currentPoint);
            --nextPoint.x;
            currentPoints = new ArrayList<>(current.currentPoints);
            currentPoints.set(i, nextPoint);
            putState(map, set, nextPoint, currentPoints, current.collected);

            nextPoint = new Point(currentPoint);
            ++nextPoint.y;
            currentPoints = new ArrayList<>(current.currentPoints);
            currentPoints.set(i, nextPoint);
            putState(map, set, nextPoint, currentPoints, current.collected);

            nextPoint = new Point(currentPoint);
            --nextPoint.y;
            currentPoints = new ArrayList<>(current.currentPoints);
            currentPoints.set(i, nextPoint);
            putState(map, set, nextPoint, currentPoints, current.collected);
        }

        return set;
    }

    private static void putState(Map<Point, Character> map,
                                 Set<State> set,
                                 Point nextPoint,
                                 List<Point> currentPoints,
                                 Set<Character> collected) {
        if (!map.containsKey(nextPoint)) {
            return;
        }
        char charAtPoint = map.get(nextPoint);
        if (charAtPoint == '#') {
            return;
        }
        if (charAtPoint == '.' || charAtPoint == '@'
                || 'A' <= charAtPoint && charAtPoint <= 'Z' && collected.contains((char) (charAtPoint - 'A' + 'a'))) {
            set.add(new State(currentPoints, collected));
        } else if ('a' <= charAtPoint && charAtPoint <= 'z') {
            Set<Character> newCollected = new HashSet<>(collected);
            newCollected.add(charAtPoint);
            set.add(new State(currentPoints, newCollected));
        }
    }

    private static boolean allKeysCollected(State current, Set<Character> allKeys) {
        return current.collected.equals(allKeys);
    }

    private static class State {

        List<Point> currentPoints;
        Set<Character> collected;

        State(List<Point> currentPoints, Set<Character> collected) {
            this.currentPoints = currentPoints;
            this.collected = collected;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return Objects.equals(currentPoints, state.currentPoints) &&
                    Objects.equals(collected, state.collected);
        }

        @Override
        public int hashCode() {
            return Objects.hash(currentPoints, collected);
        }

        @Override
        public String toString() {
            return "State{" +
                    "currentPoints=" + currentPoints +
                    ", collected=" + collected +
                    '}';
        }
    }
}
