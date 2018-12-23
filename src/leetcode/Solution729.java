package leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution729 {
    static class MyCalendar {
        private final List<Pair> pairs = new ArrayList<>();

        public MyCalendar() {
        }

        public boolean book(int start, int end) {
            if (end < start) {
                return false;
            }
            if (pairs.size() == 0) {
                pairs.add(new Pair(start, end));
                return true;
            }
            Pair pair;
            pair = pairs.get(0);
            if (end == pair.min) {
                pair.min = start;
                return true;
            }
            if (end < pair.min) {
                pairs.add(0, new Pair(start, end));
                return true;
            }
            pair = pairs.get(pairs.size() - 1);
            if (pair.max == start) {
                pair.max = end;
                return true;
            }
            if (pair.max < start) {
                pairs.add(new Pair(start, end));
                return true;
            }
            for (int i = 0; i < pairs.size() - 1; ++i) {
                Pair curr = pairs.get(i);
                Pair next = pairs.get(i + 1);
                if (curr.max <= start && end <= next.min) {
                    pairs.add(i + 1, new Pair(start, end));
                    return true;
                }
            }
            return false;
        }

        private static class Pair {
            private int min, max;

            private Pair(int min, int max) {
                this.min = min;
                this.max = max;
            }
        }
    }
}
