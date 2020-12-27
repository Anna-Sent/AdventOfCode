package leetcode.solution6;

import java.util.HashSet;
import java.util.Set;

class Solution695 {
    private static void print(int[][] grid) {
        System.out.println();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    private static void test(int[][] grid, int expected) {
        print(grid);
        int actual = new Solution().maxAreaOfIsland(grid);
        print(grid);
        assert expected == actual : "expected is " + expected + ", actual is " + actual;
    }

    public static void main(String[] args) {
        test(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }, 6);
        test(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        }, 1);
        test(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        }, 0);
        test(new int[][]{
                {0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        }, 35);
    }

    static class Solution {
        private static int bfs(int[][] grid, Point start, int count) {
            Set<Point> closed = new HashSet<>();
            Set<Point> opened = new HashSet<>();

            int area = 0;
            opened.add(start);
            while (opened.size() > 0) {
                Set<Point> achievable = new HashSet<>();
                for (Point current : opened) {
                    grid[current.x][current.y] = count + 1;
                    ++area;
                    Set<Point> set = generateNext(grid, current);
                    for (Point next : set) {
                        if (!closed.contains(next)) {
                            achievable.add(next);
                        }
                    }

                    closed.add(current);
                }

                opened = achievable;
            }
            return area;
        }

        private static Set<Point> generateNext(int[][] grid, Point current) {
            Set<Point> set = new HashSet<>();
            int x = current.x, y = current.y;
            if (cell(grid, x - 1, y) == 1) {
                set.add(new Point(x - 1, y));
            }
            if (cell(grid, x + 1, y) == 1) {
                set.add(new Point(x + 1, y));
            }
            if (cell(grid, x, y + 1) == 1) {
                set.add(new Point(x, y + 1));
            }
            if (cell(grid, x, y - 1) == 1) {
                set.add(new Point(x, y - 1));
            }
            return set;
        }

        private static int cell(int[][] grid, int x, int y) {
            if (x < 0 || x >= grid.length) {
                return 0;
            }
            if (y < 0 || y >= grid[x].length) {
                return 0;
            }
            return grid[x][y];
        }

        public int maxAreaOfIsland(int[][] grid) {
            int count = 0, maxArea = 0;
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[i].length; ++j) {
                    if (grid[i][j] == 1) {
                        ++count;
                        int area = bfs(grid, new Point(i, j), count);
                        if (area > maxArea) {
                            maxArea = area;
                        }
                    }
                }
            }
            return maxArea;
        }

        private static class Point {
            int x, y;

            Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == null) return false;
                if (this == obj) return true;
                if (getClass() != obj.getClass()) return false;
                Point other = (Point) obj;
                return x == other.x && y == other.y;
            }

            @Override
            public int hashCode() {
                final int PRIME = 59;
                int result = 1;
                result = result * PRIME + x;
                result = result * PRIME + y;
                return result;
            }
        }
    }
}
