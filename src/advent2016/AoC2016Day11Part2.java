package advent2016;

import java.util.*;

public class AoC2016Day11Part2 {
    private static boolean PRINT_SOLUTION = false;

    public static void main(String[] args) {
        int result;

        // The first floor contains a hydrogen-compatible microchip and a
        // lithium-compatible microchip.
        // The second floor contains a hydrogen generator.
        // The third floor contains a lithium generator.
        // The fourth floor contains nothing relevant.

        result = test(new String[][]{{"..", "HM", "..", "LM"},
                {"HG", "..", "..", ".."}, {"..", "..", "LG", ".."},
                {"..", "..", "..", ".."}});
        assert result == 11;
        System.out.println("min sol is " + result);

        // The first floor contains a thulium generator, a thulium-compatible
        // microchip, a plutonium generator, and a strontium generator.
        // The second floor contains a plutonium-compatible microchip and a
        // strontium-compatible microchip.
        // The third floor contains a promethium generator, a
        // promethium-compatible microchip, a ruthenium generator, and a
        // ruthenium-compatible microchip.
        // The fourth floor contains nothing relevant.

        result = test(new String[][]{
                {"TG", "TM", "PG", "..", "SG", "..", "..", "..", "..", ".."},
                {"..", "..", "..", "PM", "..", "SM", "..", "..", "..", ".."},
                {"..", "..", "..", "..", "..", "..", "XG", "XM", "RG", "RM"},
                {"..", "..", "..", "..", "..", "..", "..", "..", "..", ".."}});
        assert result == 31;
        System.out.println("min sol is " + result);

        result = test(new String[][]{
                {"TG", "TM", "PG", "..", "SG", "..", "..", "..", "..", "..",
                        "EG", "EM", "DG", "DM"},
                {"..", "..", "..", "PM", "..", "SM", "..", "..", "..", "..",
                        "..", "..", "..", ".."},
                {"..", "..", "..", "..", "..", "..", "XG", "XM", "RG", "RM",
                        "..", "..", "..", ".."},
                {"..", "..", "..", "..", "..", "..", "..", "..", "..", "..",
                        "..", "..", "..", ".."}});
        assert result == 55;
        System.out.println("min sol is " + result);
    }

    static class State {
        int floor;
        String[][] table;
        State previousState;

        public State(int floor, String[][] table) {
            this.floor = floor;
            this.table = new String[table.length][];
            for (int i = 0; i < table.length; ++i) {
                this.table[i] = new String[table[i].length];
                for (int j = 0; j < table[i].length; ++j) {
                    this.table[i][j] = table[i][j];
                }
            }
        }

        String getKey() {
            StringBuilder key = new StringBuilder();
            key.append(floor).append('[');
            for (int i = 0; i < table.length; ++i) {
                for (int j = 0; j < table[i].length; ++j) {
                    key.append(table[i][j]).append(',');
                }
                key.append(',');
            }
            key.append(']');
            return key.toString();
        }

        void print() {
            System.out.println(floor
                    + "===========================================");
            for (int i = table.length - 1; i >= 0; --i) {
                for (int j = 0; j < table[i].length; ++j) {
                    System.out.print("\t" + table[i][j]);
                }
                System.out.println();
            }
        }

        boolean isValid() {
            for (int i = 0; i < table.length; ++i) {
                List<String> generators = new ArrayList<>();
                List<String> micros = new ArrayList<>();
                for (int j = 0; j < table[i].length; ++j) {
                    if (table[i][j].charAt(1) == 'G') {
                        generators.add(table[i][j]);
                    } else if (table[i][j].charAt(1) == 'M') {
                        micros.add(table[i][j]);
                    }
                }

                if (generators.size() == 0 || micros.size() == 0) {
                    continue;
                }

                if (micros.size() > generators.size()) {
                    return false;
                }

                if (micros.size() == generators.size()) {
                    Collections.sort(generators);
                    Collections.sort(micros);
                    int j = 0;
                    while (j < generators.size() && j < micros.size()) {
                        if (generators.get(j).charAt(0) != micros.get(j)
                                .charAt(0)) {
                            return false;
                        }

                        ++j;
                    }
                }

                // micros size less than generators size
                for (String micro : micros) {
                    if (!generators.contains(micro.charAt(0) + "G")) {
                        return false;
                    }
                }
            }

            return true;
        }

        boolean isEnd() {
            for (int i = 0; i < table.length; ++i) {
                for (int j = 0; j < table[i].length; ++j) {
                    if (i < 3 && !table[i][j].equals("..")) {
                        return false;
                    }
                }
            }

            return true;
        }

        static int heuristicHashCode(String[][] table) {
            final int prime = 31;
            int hashCode = 1;
            for (int i = 0; i < table.length; ++i) {
                Map<Character, Integer> map = new HashMap<>();
                for (int j = 0; j < table[i].length; ++j) {
                    char first = table[i][j].charAt(0);
                    if (first != '.') {
                        char second = table[i][j].charAt(1);
                        Character key = Character.valueOf(first);
                        int value = map.containsKey(key) ? map.get(key)
                                .intValue() : 0;
                        if (second == 'G') {
                            ++value;
                        } else if (second == 'M') {
                            --value;
                        }
                        map.put(key, Integer.valueOf(value));
                    }
                }
                int couplesCount = 0;
                int generatorsCount = 0;
                int microsCount = 0;
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    int value = entry.getValue().intValue();
                    if (value == 0) {
                        ++couplesCount;
                    } else if (value > 0) {
                        ++generatorsCount;
                    } else {
                        ++microsCount;
                    }
                }
                hashCode = prime * hashCode + couplesCount;
                hashCode = prime * hashCode + generatorsCount;
                hashCode = prime * hashCode + microsCount;
            }
            return hashCode;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + floor;
            result = prime * result + heuristicHashCode(table);
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            State other = (State) obj;
            if (floor != other.floor)
                return false;
            if (heuristicHashCode(table) != heuristicHashCode(other.table))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return getKey();
        }

        Set<State> generateNext() {
            Set<State> opened = new HashSet<>();
            int fromFloor = floor;
            for (int toFloor = fromFloor - 1; toFloor <= fromFloor + 1; ++toFloor) {
                if (toFloor >= 0 && toFloor != fromFloor && toFloor < 4) {
                    for (int x = 0; x < table[fromFloor].length; ++x) {
                        for (int y = x; y < table[fromFloor].length; ++y) {
                            State newState;

                            if (x == y) {
                                if (table[fromFloor][x].charAt(0) == '.') {
                                    continue;
                                }
                                newState = new State(toFloor, table);
                                newState.table[toFloor][x] = newState.table[fromFloor][x];
                                newState.table[fromFloor][x] = "..";
                            } else {
                                if (table[fromFloor][x].charAt(0) == '.'
                                        || table[fromFloor][y].charAt(0) == '.'
                                        || (table[fromFloor][x].charAt(1) == 'M'
                                        && table[fromFloor][y]
                                        .charAt(1) == 'G' || table[fromFloor][x]
                                        .charAt(1) == 'G'
                                        && table[fromFloor][y]
                                        .charAt(1) == 'M')
                                        && table[fromFloor][x].charAt(0) != table[fromFloor][y]
                                        .charAt(0)) {
                                    continue;
                                }
                                newState = new State(toFloor, table);
                                newState.table[toFloor][x] = newState.table[fromFloor][x];
                                newState.table[fromFloor][x] = "..";
                                newState.table[toFloor][y] = newState.table[fromFloor][y];
                                newState.table[fromFloor][y] = "..";
                            }

                            if (newState.isValid()) {
                                newState.previousState = this;
                                opened.add(newState);
                            }
                        }
                    }
                }
            }
            return opened;
        }
    }

    public static int test(String[][] table) {
        State initial = new State(0, table);
        initial.print();
        if (!initial.isValid()) {
            throw new RuntimeException("invalid state");
        }

        Set<State> closed = new HashSet<>();
        Set<State> opened = new HashSet<>();

        int count = 0;
        opened.add(initial);

        while (opened.size() > 0) {
            Set<State> achievable = new HashSet<>();
            for (State currentState : opened) {
                if (currentState.isEnd()) {
                    if (PRINT_SOLUTION) {
                        State item = currentState;
                        do {
                            item.print();
                            item = item.previousState;
                        } while (item != null);
                    }

                    return count;
                }

                Set<State> set = currentState.generateNext();
                for (State nextState : set) {
                    if (!closed.contains(nextState)) {
                        achievable.add(nextState);
                    }
                }

                closed.add(currentState);
            }

            ++count;
            opened = achievable;
        }

        return -1;
    }
}