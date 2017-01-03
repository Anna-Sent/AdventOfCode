package advent2015;

public class AoC2015Day25Java8 {
    public static void main(String[] args) {
        int result;

        long[] chain = new long[]{20151125, 31916031, 18749137, 16080970};
        for (int i = 0; i < chain.length; ++i) {
            result = generate(i + 1);
            System.out.println((i + 1) + " " + result);
            assert result == chain[i];
        }

        long[][] grid = new long[][]{
                new long[]{20151125, 18749137, 17289845, 30943339, 10071777, 33511524},
                new long[]{31916031, 21629792, 16929656, 7726640, 15514188, 4041754},
                new long[]{16080970, 8057251, 1601130, 7981243, 11661866, 16474243},
                new long[]{24592653, 32451966, 21345942, 9380097, 10600672, 31527494},
                new long[]{77061, 17552253, 28094349, 6899651, 9250759, 31663883},
                new long[]{33071741, 6796745, 25397450, 24659492, 1534922, 27995004}};

        for (int i = 1; i <= grid.length; ++i) {
            for (int j = 1; j <= grid[i - 1].length; ++j) {
                result = solve(i, j);
                System.out.println(i + "," + j + " " + result);
                assert result == grid[i - 1][j - 1];
            }
        }

        result = solve(2981, 3075);
        System.out.println(result);
        assert result == 9132360;
    }

    private static int solve(int row, int column) {
        int index = getIndex(row, column);
        return generate(index);
    }

    private static int getIndex(int row, int column) {
        int initial = initialForRow(row);
        return column == 1 ? initial : getIndex(row, column - 1) + row + column - 1;
    }

    private static int initialForRow(int row) {
        return row == 1 ? 1 : initialForRow(row - 1) + row - 1;
    }

    private static int generate(int index) {
        int number = 20151125;
        for (int i = 1; i < index; ++i) {
            number = (int) (((long) number * 252533) % 33554393);
        }
        return number;
    }
}
