package advent2019;

import utils.Point;

import java.util.*;

public class AoC2019Day17Part2 {

    public static void main(String[] args) {
        long result;

        result = test("1,330,331,332,109,3508,1102,1,1182,16,1101,0,1473,24,101,0,0,570,1006,570,36,1002,571,1,0,1001,570,-1,570,1001,24,1,24,1105,1,18,1008,571,0,571,1001,16,1,16,1008,16,1473,570,1006,570,14,21102,58,1,0,1105,1,786,1006,332,62,99,21102,1,333,1,21101,0,73,0,1106,0,579,1102,0,1,572,1101,0,0,573,3,574,101,1,573,573,1007,574,65,570,1005,570,151,107,67,574,570,1005,570,151,1001,574,-64,574,1002,574,-1,574,1001,572,1,572,1007,572,11,570,1006,570,165,101,1182,572,127,1002,574,1,0,3,574,101,1,573,573,1008,574,10,570,1005,570,189,1008,574,44,570,1006,570,158,1105,1,81,21102,340,1,1,1106,0,177,21101,477,0,1,1105,1,177,21102,514,1,1,21102,1,176,0,1106,0,579,99,21101,184,0,0,1106,0,579,4,574,104,10,99,1007,573,22,570,1006,570,165,101,0,572,1182,21102,375,1,1,21101,211,0,0,1105,1,579,21101,1182,11,1,21102,222,1,0,1105,1,979,21102,388,1,1,21102,233,1,0,1105,1,579,21101,1182,22,1,21101,0,244,0,1106,0,979,21102,401,1,1,21101,255,0,0,1106,0,579,21101,1182,33,1,21101,266,0,0,1106,0,979,21101,0,414,1,21102,1,277,0,1106,0,579,3,575,1008,575,89,570,1008,575,121,575,1,575,570,575,3,574,1008,574,10,570,1006,570,291,104,10,21101,0,1182,1,21101,0,313,0,1106,0,622,1005,575,327,1102,1,1,575,21102,1,327,0,1106,0,786,4,438,99,0,1,1,6,77,97,105,110,58,10,33,10,69,120,112,101,99,116,101,100,32,102,117,110,99,116,105,111,110,32,110,97,109,101,32,98,117,116,32,103,111,116,58,32,0,12,70,117,110,99,116,105,111,110,32,65,58,10,12,70,117,110,99,116,105,111,110,32,66,58,10,12,70,117,110,99,116,105,111,110,32,67,58,10,23,67,111,110,116,105,110,117,111,117,115,32,118,105,100,101,111,32,102,101,101,100,63,10,0,37,10,69,120,112,101,99,116,101,100,32,82,44,32,76,44,32,111,114,32,100,105,115,116,97,110,99,101,32,98,117,116,32,103,111,116,58,32,36,10,69,120,112,101,99,116,101,100,32,99,111,109,109,97,32,111,114,32,110,101,119,108,105,110,101,32,98,117,116,32,103,111,116,58,32,43,10,68,101,102,105,110,105,116,105,111,110,115,32,109,97,121,32,98,101,32,97,116,32,109,111,115,116,32,50,48,32,99,104,97,114,97,99,116,101,114,115,33,10,94,62,118,60,0,1,0,-1,-1,0,1,0,0,0,0,0,0,1,42,14,0,109,4,1201,-3,0,586,21001,0,0,-1,22101,1,-3,-3,21102,0,1,-2,2208,-2,-1,570,1005,570,617,2201,-3,-2,609,4,0,21201,-2,1,-2,1106,0,597,109,-4,2105,1,0,109,5,1202,-4,1,630,20101,0,0,-2,22101,1,-4,-4,21101,0,0,-3,2208,-3,-2,570,1005,570,781,2201,-4,-3,652,21001,0,0,-1,1208,-1,-4,570,1005,570,709,1208,-1,-5,570,1005,570,734,1207,-1,0,570,1005,570,759,1206,-1,774,1001,578,562,684,1,0,576,576,1001,578,566,692,1,0,577,577,21102,702,1,0,1105,1,786,21201,-1,-1,-1,1105,1,676,1001,578,1,578,1008,578,4,570,1006,570,724,1001,578,-4,578,21102,1,731,0,1105,1,786,1105,1,774,1001,578,-1,578,1008,578,-1,570,1006,570,749,1001,578,4,578,21101,0,756,0,1106,0,786,1106,0,774,21202,-1,-11,1,22101,1182,1,1,21102,774,1,0,1106,0,622,21201,-3,1,-3,1106,0,640,109,-5,2106,0,0,109,7,1005,575,802,21002,576,1,-6,21001,577,0,-5,1106,0,814,21101,0,0,-1,21101,0,0,-5,21101,0,0,-6,20208,-6,576,-2,208,-5,577,570,22002,570,-2,-2,21202,-5,55,-3,22201,-6,-3,-3,22101,1473,-3,-3,2102,1,-3,843,1005,0,863,21202,-2,42,-4,22101,46,-4,-4,1206,-2,924,21102,1,1,-1,1105,1,924,1205,-2,873,21101,35,0,-4,1105,1,924,1201,-3,0,878,1008,0,1,570,1006,570,916,1001,374,1,374,1201,-3,0,895,1102,1,2,0,2101,0,-3,902,1001,438,0,438,2202,-6,-5,570,1,570,374,570,1,570,438,438,1001,578,558,922,20102,1,0,-4,1006,575,959,204,-4,22101,1,-6,-6,1208,-6,55,570,1006,570,814,104,10,22101,1,-5,-5,1208,-5,37,570,1006,570,810,104,10,1206,-1,974,99,1206,-1,974,1102,1,1,575,21101,973,0,0,1106,0,786,99,109,-7,2105,1,0,109,6,21101,0,0,-4,21102,0,1,-3,203,-2,22101,1,-3,-3,21208,-2,82,-1,1205,-1,1030,21208,-2,76,-1,1205,-1,1037,21207,-2,48,-1,1205,-1,1124,22107,57,-2,-1,1205,-1,1124,21201,-2,-48,-2,1106,0,1041,21102,1,-4,-2,1105,1,1041,21102,1,-5,-2,21201,-4,1,-4,21207,-4,11,-1,1206,-1,1138,2201,-5,-4,1059,1201,-2,0,0,203,-2,22101,1,-3,-3,21207,-2,48,-1,1205,-1,1107,22107,57,-2,-1,1205,-1,1107,21201,-2,-48,-2,2201,-5,-4,1090,20102,10,0,-1,22201,-2,-1,-2,2201,-5,-4,1103,2101,0,-2,0,1106,0,1060,21208,-2,10,-1,1205,-1,1162,21208,-2,44,-1,1206,-1,1131,1106,0,989,21101,439,0,1,1105,1,1150,21101,477,0,1,1106,0,1150,21102,514,1,1,21102,1149,1,0,1106,0,579,99,21102,1157,1,0,1105,1,579,204,-2,104,10,99,21207,-3,22,-1,1206,-1,1138,1201,-5,0,1176,2102,1,-4,0,109,-6,2106,0,0,40,9,46,1,7,1,46,1,7,1,46,1,7,1,46,1,7,1,46,1,7,1,42,13,42,1,3,1,50,1,3,1,50,1,3,1,50,1,3,9,42,1,11,1,36,9,9,1,36,1,5,1,1,1,9,1,18,13,5,1,5,7,5,1,18,1,17,1,7,1,9,1,8,7,3,1,13,11,1,1,9,1,8,1,5,1,3,1,13,1,3,1,5,1,1,1,9,1,6,7,1,1,3,1,13,1,3,1,5,1,1,1,9,1,6,1,1,1,3,1,1,1,3,1,13,1,3,1,5,1,1,1,9,1,6,1,1,1,3,1,1,1,3,1,13,1,3,1,5,1,1,1,9,1,6,1,1,1,3,1,1,1,3,1,13,1,3,1,5,1,1,1,9,1,6,1,1,11,13,1,3,7,1,1,9,8,5,1,1,1,17,1,11,1,15,2,5,1,1,1,5,13,11,9,7,2,5,1,1,1,5,1,31,1,7,10,5,1,31,1,7,1,6,1,7,1,31,1,7,1,6,1,7,1,25,11,3,1,6,1,7,1,25,1,5,1,3,1,3,1,6,9,25,1,1,13,40,1,1,1,3,1,3,1,44,1,1,1,3,1,3,1,44,1,1,1,3,1,3,1,44,7,3,1,46,1,7,1,46,9,4");
        assert result == 1075882 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static long test(String input) {
        List<Long> values = new ArrayList<>();
        String[] tokens = input.split(",");
        for (String token : tokens) {
            values.add(Long.parseLong(token));
        }

        values.set(0, 2L);
        ProgramState program = new ProgramState("test", new ArrayList<>(values), Collections.emptyList());

        run(program);
        List<Long> outputs = program.outputs;

        String map = "";
        for (Long output : outputs) {
            switch (output.intValue()) {
                case 35:
                    map += '#';
                    break;
                case 46:
                    map += '.';
                    break;
                case 10:
                    map += '\n';
                    break;
                case 94:
                    map += '^';
                    break;
            }
        }

        System.out.println(map);

        String[] lines = map.split("\n");

        findIntersections(lines);

        State initialState = new State(findStartingPoint(lines), State.Direction.UP);
        List<State> path = bfs(lines, initialState);
        List<String> route = getPath(path);
        List<List<String>> routines = getRoutines(route);

        for (List<String> routine : routines) {
            for (int i = 0; i < routine.size(); ++i) {
                String item = routine.get(i);
                for (int j = 0; j < item.length(); ++j) {
                    addInput(program, item.charAt(j));
                }
                if (i != routine.size() - 1) {
                    addInput(program, 44);
                }
            }
            addInput(program, 10L);
            System.out.println();
        }

        System.out.println();
        addInput(program, 'n');
        addInput(program, 10L);

        run(program);

        return program.outputs.get(program.outputs.size() - 1);
    }

    private static void addInput(ProgramState program, long input) {
        program.inputs.add(input);
        System.out.print(input + " ");
    }

    private static List<List<String>> getRoutines(List<String> route) {
        for (int a1 = 0; a1 < route.size(); ++a1) {
            for (int a2 = a1 + 1; a2 < route.size(); ++a2) {
                for (int b1 = 0; b1 < route.size(); ++b1) {
                    for (int b2 = b1 + 1; b2 < route.size(); ++b2) {
                        for (int c1 = 0; c1 < route.size(); ++c1) {
                            for (int c2 = c1 + 1; c2 < route.size(); ++c2) {
                                if (a2 - a1 < 11 && b2 - b1 < 11 && c2 - c1 < 11) {
                                    String main = toString(route);
                                    List<String> aRoute = route.subList(a1, a2);
                                    String a = toString(aRoute);
                                    List<String> bRoute = route.subList(b1, b2);
                                    String b = toString(bRoute);
                                    List<String> cRoute = route.subList(c1, c2);
                                    String c = toString(cRoute);
                                    main = main.replace(a, "");
                                    main = main.replace(b, "");
                                    main = main.replace(c, "");
                                    if (main.isEmpty()) {
                                        List<List<String>> result = new ArrayList<>();
                                        route = replace(route, aRoute, "A");
                                        route = replace(route, bRoute, "B");
                                        route = replace(route, cRoute, "C");
                                        result.add(route);
                                        result.add(aRoute);
                                        result.add(bRoute);
                                        result.add(cRoute);
                                        System.out.println(toString(route));
                                        System.out.println(a);
                                        System.out.println(b);
                                        System.out.println(c);
                                        return result;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        assert false : "subroutines not found";
        return null;
    }

    private static List<String> replace(List<String> route, List<String> subRoute, String name) {
        int index;
        while ((index = indexOf(route, subRoute)) != -1) {
            route = replace(route, index, subRoute.size(), name);
        }
        return route;
    }

    private static int indexOf(List<String> route, List<String> subRoute) {
        for (int i = 0; i < route.size(); ++i) {
            boolean found = true;
            for (int j = 0; j < subRoute.size(); ++j) {
                if (!route.get(i + j).equals(subRoute.get(j))) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }

    private static List<String> replace(List<String> route, int start, int length, String name) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < start; ++i) {
            result.add(route.get(i));
        }
        result.add(name);
        for (int i = start + length; i < route.size(); ++i) {
            result.add(route.get(i));
        }
        return result;
    }

    private static List<String> getPath(List<State> path) {
        List<String> commands = new ArrayList<>();
        int d = 0;
        for (int i = 1; i < path.size(); ++i) {
            State prev = path.get(i - 1);
            State next = path.get(i);
            switch (prev.direction) {
                case UP:
                    switch (next.direction) {
                        case UP:
                            ++d;
                            break;
                        case RIGHT:
                            if (d != 0)
                                commands.add(String.valueOf(d));
                            d = 0;
                            commands.add("R");
                            ++d;
                            break;
                        case DOWN:
                            assert false : "invalid path";
                            break;
                        case LEFT:
                            if (d != 0)
                                commands.add(String.valueOf(d));
                            d = 0;
                            commands.add("L");
                            ++d;
                            break;
                    }
                    break;
                case RIGHT:
                    switch (next.direction) {
                        case UP:
                            if (d != 0)
                                commands.add(String.valueOf(d));
                            d = 0;
                            commands.add("L");
                            ++d;
                            break;
                        case RIGHT:
                            ++d;
                            break;
                        case DOWN:
                            if (d != 0)
                                commands.add(String.valueOf(d));
                            d = 0;
                            commands.add("R");
                            ++d;
                            break;
                        case LEFT:
                            assert false : "invalid path";
                            break;
                    }
                    break;
                case DOWN:
                    switch (next.direction) {
                        case UP:
                            assert false : "invalid path";
                            break;
                        case RIGHT:
                            if (d != 0)
                                commands.add(String.valueOf(d));
                            d = 0;
                            commands.add("L");
                            ++d;
                            break;
                        case DOWN:
                            ++d;
                            break;
                        case LEFT:
                            if (d != 0)
                                commands.add(String.valueOf(d));
                            d = 0;
                            commands.add("R");
                            ++d;
                            break;
                    }
                    break;
                case LEFT:
                    switch (next.direction) {
                        case UP:
                            if (d != 0)
                                commands.add(String.valueOf(d));
                            d = 0;
                            commands.add("R");
                            ++d;
                            break;
                        case RIGHT:
                            assert false : "invalid path";
                            break;
                        case DOWN:
                            if (d != 0)
                                commands.add(String.valueOf(d));
                            d = 0;
                            commands.add("L");
                            ++d;
                            break;
                        case LEFT:
                            ++d;
                            break;
                    }
                    break;
            }
        }
        if (d != 0)
            commands.add(String.valueOf(d));

        System.out.println(toString(commands));

        return commands;
    }

    private static String toString(List<String> route) {
        StringBuilder sb = new StringBuilder();
        for (String item : route) {
            sb.append(item);
        }
        return sb.toString();
    }

    private static Set<Point> intersections = new HashSet<>();

    private static void findIntersections(String[] lines) {
        int w = lines[0].length();
        int h = lines.length;
        intersections.clear();
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                char curr = lines[i].charAt(j);
                char up = charAt(lines, i - 1, j);
                char down = charAt(lines, i + 1, j);
                char left = charAt(lines, i, j - 1);
                char right = charAt(lines, i, j + 1);
                boolean isIntersection = false;
                if (up == '#' && down == '#' && left == '#' && right == '#' && curr == '#') {
                    isIntersection = true;
                    intersections.add(new Point(j, i));
                }
                System.out.print(isIntersection ? 'O' : curr);
            }
            System.out.println();
        }
    }

    private static Point findStartingPoint(String[] lines) {
        int w = lines[0].length();
        int h = lines.length;
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                char curr = lines[i].charAt(j);
                if (curr == '^') {
                    return new Point(j, i);
                }
            }
        }
        assert false : "not found starting point";
        return null;
    }

    private static List<State> bfs(String[] lines, State initialState) {
        Map<State, State> states = new HashMap<>();

        Set<State> closed = new HashSet<>();
        Set<State> opened = new HashSet<>();

        opened.add(initialState);
        while (opened.size() > 0) {
            Set<State> achievable = new HashSet<>();
            for (State current : opened) {
                Set<State> set = generateNext(current, lines);

                if (set.isEmpty()) {
                    List<State> path = new ArrayList<>();
                    State prev = new State(new Point(24, 14), State.Direction.RIGHT);
                    path.add(0, prev);
                    while ((prev = states.get(prev)) != null) {
                        path.add(0, prev);
                    }
                    for (State state : path) {
                        System.out.println(state);
                    }
                    return path;
                }

                for (State next : set) {
                    if (!closed.contains(next)) {
                        achievable.add(next);
                        states.put(next, current);
                    }
                }

                closed.add(current);
            }

            if (achievable.isEmpty()) {
                System.out.println(opened);
            }

            opened = achievable;
        }

        assert false : "path not found";
        return null;
    }

    private static Set<State> generateNext(State current, String[] lines) {
        Set<State> next = new HashSet<>();

        if (!intersections.contains(current.point)) {
            for (State.Direction direction : State.Direction.values()) {
                if (direction != current.direction
                        && !isOpposite(direction, current.direction)
                        && !isOpposite(current.direction, direction)) {
                    Point nextPoint = new Point(current.point);
                    switch (direction) {
                        case UP:
                            --nextPoint.y;
                            break;
                        case RIGHT:
                            ++nextPoint.x;
                            break;
                        case DOWN:
                            ++nextPoint.y;
                            break;
                        case LEFT:
                            --nextPoint.x;
                            break;
                    }

                    char ch = charAt(lines, nextPoint.y, nextPoint.x);
                    if (ch == '#') {
                        next.add(new State(nextPoint, direction));
                    }
                }
            }
        }

        Point nextPoint = new Point(current.point);
        switch (current.direction) {
            case UP:
                --nextPoint.y;
                break;
            case RIGHT:
                ++nextPoint.x;
                break;
            case DOWN:
                ++nextPoint.y;
                break;
            case LEFT:
                --nextPoint.x;
                break;
        }

        char ch = charAt(lines, nextPoint.y, nextPoint.x);
        if (ch == '#') {
            next.add(new State(nextPoint, current.direction));
        }

        return next;
    }

    private static boolean isOpposite(State.Direction direction1, State.Direction direction2) {
        return direction1 == State.Direction.LEFT && direction2 == State.Direction.RIGHT
                || direction1 == State.Direction.UP && direction2 == State.Direction.DOWN;
    }

    private static class State {

        Point point;
        Direction direction;

        State(Point point, Direction direction) {
            this.point = point;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return Objects.equals(point, state.point) &&
                    direction == state.direction;
        }

        @Override
        public int hashCode() {
            return Objects.hash(point, direction);
        }

        @Override
        public String toString() {
            return "State{" +
                    "point=" + point +
                    ", direction=" + direction +
                    '}';
        }

        enum Direction {
            UP, RIGHT, DOWN, LEFT
        }
    }

    private static char charAt(String[] lines, int row, int col) {
        return row >= 0 && row < lines.length && col >= 0 && col < lines[row].length()
                ? lines[row].charAt(col) : 0;
    }

    private static void run(ProgramState state) {
        for (; !state.completed; ) {
            assert state.i >= 0 : "invalid i " + state.i;
            assert state.values.containsKey(state.i) : "invalid i " + state.i + ": no value";
            long cmd = state.values.get(state.i);

            int A = (int) (cmd / 10000 % 10);
            int B = (int) (cmd / 1000 % 10);
            int C = (int) (cmd / 100 % 10);

            int DE = (int) (cmd % 100);

            switch (DE) {

                case 1: {
                    long first = getParamValue(state.values, state.i + 1, C, state.relativeBase);
                    long second = getParamValue(state.values, state.i + 2, B, state.relativeBase);
                    long result = getParamValue(state.values, state.i + 3, A, state.relativeBase, true);
                    long sum = first + second;
                    state.values.put(result, sum);
                    state.i += 4;
                    break;
                }

                case 2: {
                    long first = getParamValue(state.values, state.i + 1, C, state.relativeBase);
                    long second = getParamValue(state.values, state.i + 2, B, state.relativeBase);
                    long result = getParamValue(state.values, state.i + 3, A, state.relativeBase, true);
                    long mul = first * second;
                    state.values.put(result, mul);
                    state.i += 4;
                    break;
                }

                case 3: {
                    if (state.inputCounter == state.inputs.size()) {
                        System.out.println("wait for input");
                        return;
                    }
                    long input = state.inputs.get(state.inputCounter);
                    ++state.inputCounter;
                    System.out.println(state.name + " in: " + input);
                    assert A == 0 : "a not 0";
                    assert B == 0 : "b not 0";
                    long result = getParamValue(state.values, state.i + 1, C, state.relativeBase, true);
                    state.values.put(result, input);
                    state.i += 2;
                    break;
                }

                case 4: {
                    assert A == 0 : "a not 0";
                    assert B == 0 : "b not 0";
                    long result = getParamValue(state.values, state.i + 1, C, state.relativeBase);
                    System.out.println(state.name + " out: " + result);
                    state.outputs.add(result);
                    state.i += 2;
                    break;
                }

                case 5: {
                    assert A == 0 : "a not 0";
                    long first = getParamValue(state.values, state.i + 1, C, state.relativeBase);
                    long second = getParamValue(state.values, state.i + 2, B, state.relativeBase);
                    if (first == 0) {
                        state.i += 3;
                    } else {
                        state.i = second;
                    }
                    break;
                }

                case 6: {
                    assert A == 0 : "a not 0";
                    long first = getParamValue(state.values, state.i + 1, C, state.relativeBase);
                    long second = getParamValue(state.values, state.i + 2, B, state.relativeBase);
                    if (first == 0) {
                        state.i = second;
                    } else {
                        state.i += 3;
                    }
                    break;
                }

                case 7: {
                    long first = getParamValue(state.values, state.i + 1, C, state.relativeBase);
                    long second = getParamValue(state.values, state.i + 2, B, state.relativeBase);
                    long result = getParamValue(state.values, state.i + 3, A, state.relativeBase, true);
                    if (first < second) {
                        state.values.put(result, 1L);
                    } else {
                        state.values.put(result, 0L);
                    }
                    state.i += 4;
                    break;
                }

                case 8: {
                    long first = getParamValue(state.values, state.i + 1, C, state.relativeBase);
                    long second = getParamValue(state.values, state.i + 2, B, state.relativeBase);
                    long result = getParamValue(state.values, state.i + 3, A, state.relativeBase, true);
                    if (first == second) {
                        state.values.put(result, 1L);
                    } else {
                        state.values.put(result, 0L);
                    }
                    state.i += 4;
                    break;
                }

                case 9: {
                    long first = getParamValue(state.values, state.i + 1, C, state.relativeBase);
                    state.relativeBase += first;
                    state.i += 2;
                    break;
                }

                case 99:
                    state.completed = true;
                    break;

                default:
                    assert false : "unexpected value " + state.i;
            }
        }
    }

    private static long getParamValue(Map<Long, Long> values, long position, int mode, long relativeBase) {
        return getParamValue(values, position, mode, relativeBase, false);
    }

    private static long getParamValue(Map<Long, Long> values, long position, int mode, long relativeBase, boolean result) {
        switch (mode) {
            case 0:
                // position
                return result ? values.get(position) : values.getOrDefault(values.get(position), 0L);
            case 1:
                // immediate
                return values.get(position);
            case 2:
                // relative
                return result ? values.get(position) + relativeBase : values.getOrDefault(values.get(position) + relativeBase, 0L);
            default:
                assert false : "invalid mode " + mode;
                return -1;
        }
    }

    private static class ProgramState {

        List<Long> inputs = new ArrayList<>();
        List<Long> outputs = new ArrayList<>();

        String name;
        Map<Long, Long> values = new HashMap<>();

        boolean completed;
        long i;
        int inputCounter;
        long relativeBase;

        ProgramState(String name, List<Long> values, List<Long> inputs) {
            this.name = name;
            for (int i = 0; i < values.size(); ++i) {
                this.values.put((long) i, values.get(i));
            }
            this.inputs.addAll(inputs);
        }

        ProgramState(ProgramState program) {
            this.inputs = new ArrayList<>(program.inputs);
            this.outputs = new ArrayList<>(program.outputs);
            this.name = program.name;
            this.values = new HashMap<>(program.values);
            this.completed = program.completed;
            this.i = program.i;
            this.inputCounter = program.inputCounter;
            this.relativeBase = program.relativeBase;
        }
    }
}
