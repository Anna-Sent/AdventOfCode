package advent2017;

public class AoC2017Day3Part2 {
    public static void main(String[] args) {
        int result;

        result = test(347991);
        assert result == 349975 : "unexpected result is " + result;
        System.out.println(result);
    }

    public static int test(int from) {
        int side = (int) Math.ceil(Math.sqrt(from));
        side = side % 2 == 1 ? side : side + 1;
        System.out.println("side is " + side);
        int[][] table = new int[side][side];
        int startX = side / 2, startY = side / 2;
        table[startX][startY] = 1;
        for (int i = 2; i <= side * side; ++i) {
            int[] delta = coords(i);
            assert delta != null : "unexpected null";
            int x = startX + delta[1], y = startY + delta[0];
            assert table[x][y] == 0 : "cell is already filled";
            table[x][y] = sumAround(table, x, y);
            if (table[x][y] > from) {
                //print(table);
                return table[x][y];
            }
        }
        return 0;
    }

    private static int sumAround(int[][] table, int x, int y) {
        return cellValue(table, x + 1, y + 1)
                + cellValue(table, x + 1, y)
                + cellValue(table, x + 1, y - 1)
                + cellValue(table, x, y + 1)
                + cellValue(table, x, y - 1)
                + cellValue(table, x - 1, y + 1)
                + cellValue(table, x - 1, y)
                + cellValue(table, x - 1, y - 1);
    }

    private static int cellValue(int[][] table, int x, int y) {
        return x >= 0 && x < table.length && y >= 0 && y < table.length ? table[x][y] : 0;
    }

    private static void print(int[][] table) {
        for (int i = 0; i < table.length; ++i) {
            for (int j = 0; j < table[i].length; ++j) {
                System.out.print(String.format("%4d", table[i][j]));
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[] coords(int from) {
        int side = (int) Math.ceil(Math.sqrt(from));
        side = side % 2 == 1 ? side : side + 1;
        int n = side * side;
        for (int i = 0; i < 4; ++i) {
            n -= side;
            ++n;
            if (from >= n) {
                int height = side / 2;
                int width = n + side / 2 - from;
                switch (i) {
                    case 0:
                        return new int[]{-width, height};
                    case 1:
                        return new int[]{-height, -width};
                    case 2:
                        return new int[]{width, -height};
                    case 3:
                        return new int[]{height, width};
                }
            }
        }
        return null;
    }
}
