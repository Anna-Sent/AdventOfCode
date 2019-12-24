package advent2019;

import java.util.*;

public class AoC2019Day24Part2 {

    public static void main(String[] args) {
        int result;

        result = test(10, "....#\n" +
                "#..#.\n" +
                "#..##\n" +
                "..#..\n" +
                "#....");
        assert result == 99 : "unexpected result is " + result;
        System.out.println(result);

        result = test(200, ".##.#\n" +
                "###..\n" +
                "#...#\n" +
                "##.#.\n" +
                ".###.");
        assert result == 1953 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(int minutes, String s) {
        Map<Coord, Character> state = new HashMap<>();
        int i = 0;
        for (String token : s.split("\n")) {
            int j = 0;
            for (char ch : token.toCharArray()) {
                if (i == 2 && j == 2) {
                    continue;
                }
                state.put(new Coord(i, j, 0), ch);
                ++j;
            }
            ++i;
        }

        int minLevel = -1, maxLevel = 1;
        for (int min = 0; min < minutes; ++min) {
            Map<Coord, Character> newState = new HashMap<>();
            for (int level = minLevel; level <= maxLevel; ++level) {
                for (i = 0; i < 5; ++i) {
                    for (int j = 0; j < 5; ++j) {
                        if (i == 2 && j == 2) {
                            continue;
                        }
                        List<Character> adjacents = adjacents(state, i, j, level);
                        int bugsCount = bugsCount(adjacents);
                        Coord key = new Coord(i, j, level);
                        Character ch = state.get(key);
                        if (ch != null && ch == '#') {
                            if (bugsCount == 1) {
                                newState.put(key, '#');
                            } else {
                                newState.put(key, '.');
                            }
                        } else {
                            if (bugsCount == 1 || bugsCount == 2) {
                                newState.put(key, '#');
                            } else {
                                newState.put(key, ch);
                            }
                        }
                    }
                }
            }
            state = newState;
            --minLevel;
            ++maxLevel;
        }

        int count = 0;
        for (Map.Entry<Coord, Character> entry : state.entrySet()) {
            Character value = entry.getValue();
            if (value != null && value == '#') {
                ++count;
            }
        }
        return count;
    }

    private static int bugsCount(List<Character> chars) {
        int count = 0;
        for (Character ch : chars) {
            if (ch != null && ch == '#') {
                ++count;
            }
        }
        return count;
    }

    private static List<Character> adjacents(Map<Coord, Character> state, int i, int j, int level) {
        List<Character> result = new ArrayList<>();

        if (i < 4) {
            if (i == 1 && j == 2) {
                for (int k = 0; k < 5; ++k) {
                    result.add(state.get(new Coord(0, k, level - 1)));
                }
            } else {
                result.add(state.get(new Coord(i + 1, j, level)));
            }
        } else {
            result.add(state.get(new Coord(3, 2, level + 1)));
        }
        if (i > 0) {
            if (i == 3 && j == 2) {
                for (int k = 0; k < 5; ++k) {
                    result.add(state.get(new Coord(4, k, level - 1)));
                }
            } else {
                result.add(state.get(new Coord(i - 1, j, level)));
            }
        } else {
            result.add(state.get(new Coord(1, 2, level + 1)));
        }
        if (j < 4) {
            if (j == 1 && i == 2) {
                for (int k = 0; k < 5; ++k) {
                    result.add(state.get(new Coord(k, 0, level - 1)));
                }
            } else {
                result.add(state.get(new Coord(i, j + 1, level)));
            }
        } else {
            result.add(state.get(new Coord(2, 3, level + 1)));
        }
        if (j > 0) {
            if (j == 3 && i == 2) {
                for (int k = 0; k < 5; ++k) {
                    result.add(state.get(new Coord(k, 4, level - 1)));
                }
            } else {
                result.add(state.get(new Coord(i, j - 1, level)));
            }
        } else {
            result.add(state.get(new Coord(2, 1, level + 1)));
        }

        assert result.size() == 8 || result.size() == 4 : "invalid adjacents " + result.size();

        return result;
    }

    private static class Coord {

        int i, j;
        int level;

        public Coord(int i, int j, int level) {
            this.i = i;
            this.j = j;
            this.level = level;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coord coord = (Coord) o;
            return i == coord.i &&
                    j == coord.j &&
                    level == coord.level;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j, level);
        }
    }
}
