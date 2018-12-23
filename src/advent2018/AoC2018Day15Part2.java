package advent2018;

import utils.Point;

import java.util.*;

public class AoC2018Day15Part2 {
    public static void main(String[] args) {
        int result;

        result = test("#######\n" +
                "#.G...#\n" +
                "#...EG#\n" +
                "#.#.#G#\n" +
                "#..G#E#\n" +
                "#.....#\n" +
                "#######");
        assert result == 4988 : "unexpected result is " + result;
        System.out.println(result);

        result = test("#######\n" +
                "#E..EG#\n" +
                "#.#G.E#\n" +
                "#E.##E#\n" +
                "#G..#.#\n" +
                "#..E#.#\n" +
                "#######");
        assert result == 31284 : "unexpected result is " + result;
        System.out.println(result);

        result = test("#######\n" +
                "#E.G#.#\n" +
                "#.#G..#\n" +
                "#G.#.G#\n" +
                "#G..#.#\n" +
                "#...E.#\n" +
                "#######");
        assert result == 3478 : "unexpected result is " + result;
        System.out.println(result);

        result = test("#######\n" +
                "#.E...#\n" +
                "#.#..G#\n" +
                "#.###.#\n" +
                "#E#G#G#\n" +
                "#...#G#\n" +
                "#######");
        assert result == 6474 : "unexpected result is " + result;
        System.out.println(result);

        result = test("#########\n" +
                "#G......#\n" +
                "#.E.#...#\n" +
                "#..##..G#\n" +
                "#...##..#\n" +
                "#...#...#\n" +
                "#.G...G.#\n" +
                "#.....G.#\n" +
                "#########");
        assert result == 1140 : "unexpected result is " + result;
        System.out.println(result);

        result = test("################################\n" +
                "###############G.G.#############\n" +
                "###############...G#############\n" +
                "##############.....#############\n" +
                "#############.G....#############\n" +
                "############.......#############\n" +
                "###########...##################\n" +
                "###########G.###################\n" +
                "#########....###################\n" +
                "##########..####################\n" +
                "##########G.###########...######\n" +
                "###########.G.G.......#....#####\n" +
                "###########...#####...#....#####\n" +
                "###########..#######..G.....##.#\n" +
                "###########.#########..........#\n" +
                "######..###.#########.G.#.....##\n" +
                "#####....#..#########....#######\n" +
                "#####.......#########..#.##..###\n" +
                "###..##.....#########..#.......#\n" +
                "###..........#######...........#\n" +
                "##..GG........#####G.......E...#\n" +
                "#...#....G...........G.......E.#\n" +
                "###.#...............E.EE.......#\n" +
                "###..............G#E......E...##\n" +
                "##.....G............#.....E..###\n" +
                "#.G........G..............E..###\n" +
                "#.#.....######.......E.......###\n" +
                "##...G...#####....#..#.#..######\n" +
                "#####..#...###....######..######\n" +
                "#####.......##..########..######\n" +
                "######....#.###########...######\n" +
                "################################");
        assert result == 88537 : "unexpected result is " + result;
        System.out.println(result);

        result = test("################################\n" +
                "#####################...########\n" +
                "###################....G########\n" +
                "###################....#########\n" +
                "#######.##########......########\n" +
                "#######G#########........#######\n" +
                "#######G#######.G.........######\n" +
                "#######.######..G.........######\n" +
                "#######.......##.G...G.G..######\n" +
                "########..##..#....G......G#####\n" +
                "############...#.....G.....#####\n" +
                "#...#######..........G.#...#####\n" +
                "#...#######...#####G......######\n" +
                "##...######..#######G.....#.##.#\n" +
                "###.G.#####.#########G.........#\n" +
                "###G..#####.#########.......#.E#\n" +
                "###..######.#########..........#\n" +
                "###.......#.#########.....E..E.#\n" +
                "#####G...#..#########.......#..#\n" +
                "####.G.#.#...#######.....G.....#\n" +
                "########......#####...........##\n" +
                "###########..................###\n" +
                "##########.................#####\n" +
                "##########.................#####\n" +
                "############..E.........E.....##\n" +
                "############.........E........##\n" +
                "###############.#............E##\n" +
                "##################...E..E..##.##\n" +
                "####################.#E..####.##\n" +
                "################.....######...##\n" +
                "#################.#..###########\n" +
                "################################");
        assert result == 95764 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static void dump(Map<Point, Cell> cells, int maxX, int maxY) {
        for (int y = 0; y < maxY; ++y) {
            StringBuilder line = new StringBuilder();
            StringBuilder units = new StringBuilder();
            for (int x = 0; x < maxX; ++x) {
                Point current = new Point(x, y);
                if (cells.containsKey(current)) {
                    Cell cell = cells.get(current);
                    line.append(cells.get(current).mnemonic);
                    if (cell instanceof Unit) {
                        units.append(String.format("%c(%d) ", cell.mnemonic, ((Unit) cell).points));
                    }
                }
            }
            line.append(" ").append(units);
            System.out.println(line.toString());
        }
    }

    public static int test(String s) {
        for (int i = 4; i < 100; ++i) {
            Result result = solve(s, i);
            if (result.elvesWin) {
                return result.outcome;
            }
        }
        return -1;
    }

    public static Result solve(String s, int attackPower) {
        Map<Point, Cell> cells = new HashMap<>();
        Map<Point, Unit> units = new HashMap<>();
        int elvesCount = 0;
        String[] tokens = s.split("\n");
        for (int y = 0; y < tokens.length; ++y) {
            String token = tokens[y];
            char[] chars = token.toCharArray();
            for (int x = 0; x < chars.length; ++x) {
                Point point = new Point(x, y);
                Cell cell;
                char ch = chars[x];
                switch (ch) {
                    case '#':
                        cell = new Wall(point);
                        break;
                    case '.':
                        cell = new Cavern(point);
                        break;
                    case 'G':
                        Goblin goblin = new Goblin(point);
                        units.put(point, goblin);
                        cell = goblin;
                        break;
                    case 'E':
                        ++elvesCount;
                        Elf elf = new Elf(point, attackPower);
                        units.put(point, elf);
                        cell = elf;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid input '" + ch + "'");
                }
                cells.put(point, cell);
            }
        }

        int maxX = tokens[0].length(), maxY = tokens.length;
        int round = 0;
        boolean isFinished = false;
        while (!isFinished && round < 2900000) {
            // System.out.println(round);
            // dump(cells, maxX, maxY);
            List<Unit> sortedUnits = sortUnits(units.values());
            for (Unit unit : sortedUnits) {
                if (!unit.isAlive()) {
                    continue;
                }
                List<Unit> possibleTargets = new ArrayList<>();
                for (Unit other : sortedUnits) {
                    if (other != unit && other.isAlive()) {
                        if (isGoblin(unit) && isElf(other)
                                || isElf(unit) && isGoblin(other)) {
                            possibleTargets.add(other);
                        }
                    }
                }
                if (possibleTargets.isEmpty()) {
                    isFinished = true;
                } else {
                    Set<Point> pointsInRange = new HashSet<>();
                    for (Unit target : possibleTargets) {
                        if (isAdjacent(target.point, unit.point)) {
                            pointsInRange.add(unit.point);
                        } else {
                            pointsInRange.addAll(nextPoints(target.point, cells));
                        }
                    }
                    if (pointsInRange.isEmpty()) {
                        // ends turn
                        continue;
                    } else if (pointsInRange.contains(unit.point)) {
                        // attack
                        List<Unit> nearestTargets = nearestTargets(unit, possibleTargets);
                        if (nearestTargets.isEmpty()) {
                            // ends turn
                            continue;
                        } else {
                            Collections.sort(nearestTargets, (u1, u2) -> {
                                int result = Integer.compare(u1.points, u2.points);
                                if (result == 0) {
                                    return compare(u1.point, u2.point);
                                }
                                return result;
                            });
                            Unit target = nearestTargets.get(0);
                            target.points -= unit.attackPower;
                        }
                    } else {
                        // move
                        Point point = bfs(unit.point, pointsInRange, cells);
                        if (point == null) {
                            // System.out.println("deadlock");
                            continue;
                        }
                        // remove old
                        cells.put(unit.point, new Cavern(unit.point));
                        units.remove(unit.point);
                        // put new
                        cells.put(point, unit);
                        units.put(point, unit);
                        // update
                        unit.point = point;
                        if (pointsInRange.contains(unit.point)) {
                            // attack
                            List<Unit> nearestTargets = nearestTargets(unit, possibleTargets);
                            if (nearestTargets.isEmpty()) {
                                // ends turn
                                continue;
                            } else {
                                Collections.sort(nearestTargets, (u1, u2) -> {
                                    int result = Integer.compare(u1.points, u2.points);
                                    if (result == 0) {
                                        return compare(u1.point, u2.point);
                                    }
                                    return result;
                                });
                                Unit target = nearestTargets.get(0);
                                target.points -= unit.attackPower;
                            }
                        }
                    }
                }
            }
            ++round;
        }
        // System.out.println(round);
        // dump(cells, maxX, maxY);
        --round;
        int totalPoints = 0;
        int aliveElvesCount = 0;
        for (Unit unit : units.values()) {
            if (unit.isAlive()) {
                totalPoints += unit.points;
                if (isElf(unit)) {
                    ++aliveElvesCount;
                }
            }
        }
        // System.out.println(round);
        Result result = new Result();
        result.outcome = totalPoints * round;
        result.elvesWin = aliveElvesCount == elvesCount;
        return result;
    }

    private static int compare(Point p1, Point p2) {
        if (p1.y == p2.y) {
            return Integer.compare(p1.x, p2.x);
        }
        return Integer.compare(p1.y, p2.y);
    }

    private static Point bfs(Point startPoint, Set<Point> endPoints, Map<Point, Cell> cells) {
        Map<Point, Point> closed = new HashMap<>();
        Map<Point, Point> opened = new HashMap<>();
        Map<Point, Integer> lenghts = new HashMap<>();

        int count = 0;
        opened.put(startPoint, null);
        lenghts.put(startPoint, 0);

        while (opened.size() > 0) {
            List<Point> sortedOpened = sortPoints(opened.keySet());
            for (Point point : sortedOpened) {
                Set<Point> next = nextPoints(point, cells);
                for (Point nextPoint : next) {
                    if (!opened.containsKey(nextPoint) && !closed.containsKey(nextPoint)) {
                        opened.put(nextPoint, point);
                        lenghts.put(nextPoint, lenghts.get(point) + 1);
                    }
                }
                closed.put(point, opened.get(point));
                opened.remove(point);
            }
        }

        List<Point> sortedEndPoints = sortPoints(endPoints);
        Point minPoint = null;
        int minLenght = Integer.MAX_VALUE;
        for (Point endPoint : sortedEndPoints) {
            if (lenghts.containsKey(endPoint) && lenghts.get(endPoint) < minLenght) {
                minLenght = lenghts.get(endPoint);
                minPoint = endPoint;
            }
        }
        if (minPoint == null) {
            return null;
        }
        Point prevPoint = null;
        while (minPoint != startPoint) {
            prevPoint = minPoint;
            minPoint = closed.get(minPoint);
        }

        return prevPoint;
    }

    private static List<Point> sortPoints(Collection<Point> points) {
        List<Point> sortedPoints = new ArrayList<>(points);
        Collections.sort(sortedPoints, (p1, p2) -> compare(p1, p2));
        return sortedPoints;
    }

    private static List<Unit> sortUnits(Collection<Unit> units) {
        List<Unit> sortedUnits = new ArrayList<>(units);
        Collections.sort(sortedUnits, (u1, u2) -> compare(u1.point, u2.point));
        return sortedUnits;
    }

    private static List<Unit> nearestTargets(Unit unit, List<Unit> possibleTargets) {
        List<Unit> nearestTargets = new ArrayList<>();
        for (Unit target : possibleTargets) {
            if (isAdjacent(unit.point, target.point)) {
                nearestTargets.add(target);
            }
        }
        return nearestTargets;
    }

    private static boolean isAdjacent(Point p1, Point p2) {
        int x1 = p1.x, y1 = p1.y;
        int x2 = p2.x, y2 = p2.y;
        if (x1 - 1 == x2 && y1 == y2) {
            return true;
        }
        if (x1 + 1 == x2 && y1 == y2) {
            return true;
        }
        if (x1 == x2 && y1 - 1 == y2) {
            return true;
        }
        if (x1 == x2 && y1 + 1 == y2) {
            return true;
        }
        return false;
    }

    private static Set<Point> nextPoints(Point point, Map<Point, Cell> cells) {
        int x = point.x, y = point.y;
        Cell cell;
        Set<Point> next = new HashSet<>();

        point = new Point(x - 1, y);
        cell = cells.get(point);
        if (isOpen(cell)) {
            next.add(point);
        }

        point = new Point(x + 1, y);
        cell = cells.get(point);
        if (isOpen(cell)) {
            next.add(point);
        }

        point = new Point(x, y - 1);
        cell = cells.get(point);
        if (isOpen(cell)) {
            next.add(point);
        }

        point = new Point(x, y + 1);
        cell = cells.get(point);
        if (isOpen(cell)) {
            next.add(point);
        }

        return next;
    }

    private static boolean isOpen(Cell cell) {
        if (isCavern(cell)) {
            return true;
        }
        if (cell instanceof Unit) {
            Unit unit = (Unit) cell;
            return !unit.isAlive();
        }
        return false;
    }

    private static boolean isCavern(Cell cell) {
        return cell instanceof Cavern;
    }

    private static boolean isWall(Cell cell) {
        return cell instanceof Wall;
    }

    private static boolean isGoblin(Cell cell) {
        return cell instanceof Goblin;
    }

    private static boolean isElf(Cell cell) {
        return cell instanceof Elf;
    }

    private static class Result {
        int outcome;
        boolean elvesWin;
    }

    private static abstract class Cell {
        Point point;
        char mnemonic;

        Cell(Point point, char mnemonic) {
            this.point = point;
            this.mnemonic = mnemonic;
        }
    }

    private static class Cavern extends Cell {
        Cavern(Point point) {
            super(point, '.');
        }
    }

    private static class Wall extends Cell {
        Wall(Point point) {
            super(point, '#');
        }
    }

    private static abstract class Unit extends Cell {
        int points = 200;
        int attackPower;

        Unit(Point point, char mnemonic, int attackPower) {
            super(point, mnemonic);
            this.attackPower = attackPower;
        }

        boolean isAlive() {
            return points > 0;
        }
    }

    private static class Goblin extends Unit {
        Goblin(Point point) {
            super(point, 'G', 3);
        }
    }

    private static class Elf extends Unit {
        Elf(Point point, int attackPower) {
            super(point, 'E', attackPower);
        }
    }
}
