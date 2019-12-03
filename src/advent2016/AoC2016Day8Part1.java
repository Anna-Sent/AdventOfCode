package advent2016;

public class AoC2016Day8Part1 {
    public static void main(String[] args) {
        int result;

        result = test(
                7,
                3,
                "rect 3x2\r\nrotate column x=1 by 1\r\nrotate row y=0 by 4\r\nrotate column x=1 by 1");
        assert result == 6;
        System.out.println(result);

        result = test(
                50,
                6,
                "rect 1x1\r\nrotate row y=0 by 5\r\nrect 1x1\r\nrotate row y=0 by 5\r\nrect 1x1\r\nrotate row y=0 by 5\r\nrect 1x1\r\nrotate row y=0 by 5\r\nrect 1x1\r\nrotate row y=0 by 2\r\nrect 1x1\r\nrotate row y=0 by 2\r\nrect 1x1\r\nrotate row y=0 by 3\r\nrect 1x1\r\nrotate row y=0 by 3\r\nrect 2x1\r\nrotate row y=0 by 2\r\nrect 1x1\r\nrotate row y=0 by 3\r\nrect 2x1\r\nrotate row y=0 by 2\r\nrect 1x1\r\nrotate row y=0 by 3\r\nrect 2x1\r\nrotate row y=0 by 5\r\nrect 4x1\r\nrotate row y=0 by 5\r\nrotate column x=0 by 1\r\nrect 4x1\r\nrotate row y=0 by 10\r\nrotate column x=5 by 2\r\nrotate column x=0 by 1\r\nrect 9x1\r\nrotate row y=2 by 5\r\nrotate row y=0 by 5\r\nrotate column x=0 by 1\r\nrect 4x1\r\nrotate row y=2 by 5\r\nrotate row y=0 by 5\r\nrotate column x=0 by 1\r\nrect 4x1\r\nrotate column x=40 by 1\r\nrotate column x=27 by 1\r\nrotate column x=22 by 1\r\nrotate column x=17 by 1\r\nrotate column x=12 by 1\r\nrotate column x=7 by 1\r\nrotate column x=2 by 1\r\nrotate row y=2 by 5\r\nrotate row y=1 by 3\r\nrotate row y=0 by 5\r\nrect 1x3\r\nrotate row y=2 by 10\r\nrotate row y=1 by 7\r\nrotate row y=0 by 2\r\nrotate column x=3 by 2\r\nrotate column x=2 by 1\r\nrotate column x=0 by 1\r\nrect 4x1\r\nrotate row y=2 by 5\r\nrotate row y=1 by 3\r\nrotate row y=0 by 3\r\nrect 1x3\r\nrotate column x=45 by 1\r\nrotate row y=2 by 7\r\nrotate row y=1 by 10\r\nrotate row y=0 by 2\r\nrotate column x=3 by 1\r\nrotate column x=2 by 2\r\nrotate column x=0 by 1\r\nrect 4x1\r\nrotate row y=2 by 13\r\nrotate row y=0 by 5\r\nrotate column x=3 by 1\r\nrotate column x=0 by 1\r\nrect 4x1\r\nrotate row y=3 by 10\r\nrotate row y=2 by 10\r\nrotate row y=0 by 5\r\nrotate column x=3 by 1\r\nrotate column x=2 by 1\r\nrotate column x=0 by 1\r\nrect 4x1\r\nrotate row y=3 by 8\r\nrotate row y=0 by 5\r\nrotate column x=3 by 1\r\nrotate column x=2 by 1\r\nrotate column x=0 by 1\r\nrect 4x1\r\nrotate row y=3 by 17\r\nrotate row y=2 by 20\r\nrotate row y=0 by 15\r\nrotate column x=13 by 1\r\nrotate column x=12 by 3\r\nrotate column x=10 by 1\r\nrotate column x=8 by 1\r\nrotate column x=7 by 2\r\nrotate column x=6 by 1\r\nrotate column x=5 by 1\r\nrotate column x=3 by 1\r\nrotate column x=2 by 2\r\nrotate column x=0 by 1\r\nrect 14x1\r\nrotate row y=1 by 47\r\nrotate column x=9 by 1\r\nrotate column x=4 by 1\r\nrotate row y=3 by 3\r\nrotate row y=2 by 10\r\nrotate row y=1 by 8\r\nrotate row y=0 by 5\r\nrotate column x=2 by 2\r\nrotate column x=0 by 2\r\nrect 3x2\r\nrotate row y=3 by 12\r\nrotate row y=2 by 10\r\nrotate row y=0 by 10\r\nrotate column x=8 by 1\r\nrotate column x=7 by 3\r\nrotate column x=5 by 1\r\nrotate column x=3 by 1\r\nrotate column x=2 by 1\r\nrotate column x=1 by 1\r\nrotate column x=0 by 1\r\nrect 9x1\r\nrotate row y=0 by 20\r\nrotate column x=46 by 1\r\nrotate row y=4 by 17\r\nrotate row y=3 by 10\r\nrotate row y=2 by 10\r\nrotate row y=1 by 5\r\nrotate column x=8 by 1\r\nrotate column x=7 by 1\r\nrotate column x=6 by 1\r\nrotate column x=5 by 1\r\nrotate column x=3 by 1\r\nrotate column x=2 by 2\r\nrotate column x=1 by 1\r\nrotate column x=0 by 1\r\nrect 9x1\r\nrotate column x=32 by 4\r\nrotate row y=4 by 33\r\nrotate row y=3 by 5\r\nrotate row y=2 by 15\r\nrotate row y=0 by 15\r\nrotate column x=13 by 1\r\nrotate column x=12 by 3\r\nrotate column x=10 by 1\r\nrotate column x=8 by 1\r\nrotate column x=7 by 2\r\nrotate column x=6 by 1\r\nrotate column x=5 by 1\r\nrotate column x=3 by 1\r\nrotate column x=2 by 1\r\nrotate column x=1 by 1\r\nrotate column x=0 by 1\r\nrect 14x1\r\nrotate column x=39 by 3\r\nrotate column x=35 by 4\r\nrotate column x=20 by 4\r\nrotate column x=19 by 3\r\nrotate column x=10 by 4\r\nrotate column x=9 by 3\r\nrotate column x=8 by 3\r\nrotate column x=5 by 4\r\nrotate column x=4 by 3\r\nrotate row y=5 by 5\r\nrotate row y=4 by 5\r\nrotate row y=3 by 33\r\nrotate row y=1 by 30\r\nrotate column x=48 by 1\r\nrotate column x=47 by 5\r\nrotate column x=46 by 5\r\nrotate column x=45 by 1\r\nrotate column x=43 by 1\r\nrotate column x=38 by 3\r\nrotate column x=37 by 3\r\nrotate column x=36 by 5\r\nrotate column x=35 by 1\r\nrotate column x=33 by 1\r\nrotate column x=32 by 5\r\nrotate column x=31 by 5\r\nrotate column x=30 by 1\r\nrotate column x=23 by 4\r\nrotate column x=22 by 3\r\nrotate column x=21 by 3\r\nrotate column x=20 by 1\r\nrotate column x=12 by 2\r\nrotate column x=11 by 2\r\nrotate column x=3 by 5\r\nrotate column x=2 by 5\r\nrotate column x=1 by 3\r\nrotate column x=0 by 4");
        assert result == 119;
        System.out.println(result);
    }

    private static int test(int W, int H, String s) {
        char[][] table = new char[W][H];
        for (int x = 0; x < W; ++x) {
            for (int y = 0; y < H; ++y) {
                table[x][y] = '.';
            }
        }

        String[] commands = s.split("\r\n");
        for (String command : commands) {
            System.out.println(command);
            if (command.startsWith("rect ")) {
                String token = command.substring("rect ".length());
                String[] tokens = token.split("x");
                int w = Integer.parseInt(tokens[0]);
                int h = Integer.parseInt(tokens[1]);
                for (int x = 0; x < w; ++x) {
                    for (int y = 0; y < h; ++y) {
                        table[x][y] = '#';
                    }
                }
            } else if (command.startsWith("rotate row y=")) {
                String token = command.substring("rotate row y=".length());
                String[] tokens = token.split(" by ");
                int y = Integer.parseInt(tokens[0]);
                int shift = Integer.parseInt(tokens[1]);
                char[] tmp = new char[W];
                for (int x = 0; x < W; ++x) {
                    tmp[x] = table[x][y];
                }
                for (int x = 0; x < W; ++x) {
                    int newX = (x + shift) % W;
                    char c = tmp[x];
                    table[newX][y] = c;
                }
            } else if (command.startsWith("rotate column x=")) {
                String token = command.substring("rotate column x=".length());
                String[] tokens = token.split(" by ");
                int x = Integer.parseInt(tokens[0]);
                int shift = Integer.parseInt(tokens[1]);
                char[] tmp = new char[H];
                for (int y = 0; y < H; ++y) {
                    tmp[y] = table[x][y];
                }
                for (int y = 0; y < H; ++y) {
                    int newY = (y + shift) % H;
                    char c = tmp[y];
                    table[x][newY] = c;
                }
            }
            for (int y = 0; y < H; ++y) {
                for (int x = 0; x < W; ++x) {
                    System.out.print(table[x][y] + " ");
                }
                System.out.println();
            }
        }

        int count = 0;

        for (int x = 0; x < W; ++x) {
            for (int y = 0; y < H; ++y) {
                if (table[x][y] == '#') {
                    ++count;
                }
            }
        }

        return count;
    }
}