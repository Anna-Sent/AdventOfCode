package test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RiverCrossingPuzzle {
    public static void main(String[] args) {
        State initial = new State(3, 3, 0, 0, 1, 0, null);
        int count = bfs(initial);
        System.out.println(count);
    }

    private static int bfs(State initial) {
        Set<State> closed = new HashSet<>();
        Set<State> opened = new HashSet<>();

        int count = 0;
        opened.add(initial);

        while (opened.size() > 0) {
            Set<State> achievable = new HashSet<>();
            for (State currentState : opened) {
                if (currentState.isEnd()) {
                    currentState.printSolution(count);
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

    private static class State {
        private State previousState;
        int r_left, s_left, r_right, s_right, boat_left, boat_right;

        public State(int r_left, int s_left, int r_right, int s_right, int boat_left, int boat_right, State previousState) {
            this.previousState = previousState;
            this.r_left = r_left;
            this.s_left = s_left;
            this.r_right = r_right;
            this.s_right = s_right;
            this.boat_left = boat_left;
            this.boat_right = boat_right;
        }

        public Set<State> generateNext() {
            Set<State> set = new HashSet<>();

            set.add(generateState(r_left - 1, s_left, r_right + 1, s_right, boat_left - 1, boat_right + 1));
            set.add(generateState(r_left, s_left - 1, r_right, s_right + 1, boat_left - 1, boat_right + 1));
            set.add(generateState(r_left + 1, s_left, r_right - 1, s_right, boat_left + 1, boat_right - 1));
            set.add(generateState(r_left, s_left + 1, r_right, s_right - 1, boat_left + 1, boat_right - 1));

            set.add(generateState(r_left - 2, s_left, r_right + 2, s_right, boat_left - 1, boat_right + 1));
            set.add(generateState(r_left, s_left - 2, r_right, s_right + 2, boat_left - 1, boat_right + 1));
            set.add(generateState(r_left + 2, s_left, r_right - 2, s_right, boat_left + 1, boat_right - 1));
            set.add(generateState(r_left, s_left + 2, r_right, s_right - 2, boat_left + 1, boat_right - 1));

            set.add(generateState(r_left - 1, s_left - 1, r_right + 1, s_right + 1, boat_left - 1, boat_right + 1));
            set.add(generateState(r_left + 1, s_left + 1, r_right - 1, s_right - 1, boat_left + 1, boat_right - 1));

            set = set.stream().filter(x -> x != null).collect(Collectors.toSet());

            return set;
        }

        private State generateState(int r_left, int s_left, int r_right, int s_right, int boat_left, int boat_right) {
            if (r_left >= 0 && s_left >= 0 && r_right >= 0 && s_right >= 0
                    && boat_left >= 0 && boat_right >= 0
                    && r_left + r_right == 3 && s_left + s_right == 3
                    && boat_left + boat_right == 1
                    && (r_left <= s_left || s_left == 0) && (r_right <= s_right || s_right == 0)) {
                return new State(r_left, s_left, r_right, s_right, boat_left, boat_right, this);
            }
            return null;
        }

        public boolean isEnd() {
            return r_left == 0 && s_left == 0 && r_right == 3 && s_right == 3 && boat_left == 0 && boat_right == 1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return r_left == state.r_left && s_left == state.s_left && r_right == state.r_right && s_right == state.s_right
                    && boat_left == state.boat_left && boat_right == state.boat_right;
        }

        @Override
        public int hashCode() {
            int result = 31;
            result = 31 * result + r_left;
            result = 31 * result + s_left;
            result = 31 * result + r_right;
            result = 31 * result + s_right;
            result = 31 * result + boat_left;
            result = 31 * result + boat_right;
            return result;
        }

        @Override
        public String toString() {
            return "r=" + r_left + ",s=" + s_left + (boat_left == 1 ? " x" : "") + " -- " + (boat_right == 1 ? "x " : "") + "r=" + r_right + ",s=" + s_right;
        }

        public void print() {
            System.out.println(this);
        }

        public void printSolution(int count) {
            State item = this;
            do {
                System.out.println(count);
                System.out.println(item);
                System.out.println();
                --count;
                item = item.previousState;
            } while (item != null);
        }
    }
}
