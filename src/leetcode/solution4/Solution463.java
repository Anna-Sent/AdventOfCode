package leetcode.solution4;

class Solution463 {
    class Solution {
        public int islandPerimeter(int[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[i].length; ++j) {
                    if (grid[i][j] == 1) {
                        if (cell(grid, i + 1, j) == 0) {
                            ++count;
                        }
                        if (cell(grid, i - 1, j) == 0) {
                            ++count;
                        }
                        if (cell(grid, i, j + 1) == 0) {
                            ++count;
                        }
                        if (cell(grid, i, j - 1) == 0) {
                            ++count;
                        }
                    }
                }
            }
            return count;
        }

        private int cell(int[][] grid, int x, int y) {
            if (x < 0 || x >= grid.length) {
                return 0;
            }
            if (y < 0 || y >= grid[x].length) {
                return 0;
            }
            return grid[x][y];
        }
    }
}
