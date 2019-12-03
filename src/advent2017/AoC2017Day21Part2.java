package advent2017;

public class AoC2017Day21Part2 {
    public static void main(String[] args) {
        int result;

        result = test(18, "../.. => #.#/.#./...\n" +
                "#./.. => .../..#/..#\n" +
                "##/.. => .#./##./###\n" +
                ".#/#. => ..#/#../##.\n" +
                "##/#. => ##./..#/#.#\n" +
                "##/## => ###/###/.##\n" +
                ".../.../... => ...#/#.##/.##./#..#\n" +
                "#../.../... => .###/#.##/##.#/##.#\n" +
                ".#./.../... => #.../.###/..#./#.##\n" +
                "##./.../... => .#.#/.###/##../#.##\n" +
                "#.#/.../... => .##./..../##.#/#...\n" +
                "###/.../... => ..##/.#.#/###./#..#\n" +
                ".#./#../... => .#.#/##.#/.#.#/.##.\n" +
                "##./#../... => ###./.###/#.../...#\n" +
                "..#/#../... => #.##/##../.#../.##.\n" +
                "#.#/#../... => ..##/..../..##/...#\n" +
                ".##/#../... => ####/#..#/.#../....\n" +
                "###/#../... => ##../..#./##../....\n" +
                ".../.#./... => .###/...#/#.../#...\n" +
                "#../.#./... => .#../.#.#/..##/#.#.\n" +
                ".#./.#./... => ##.#/####/.#.#/##..\n" +
                "##./.#./... => ..../.###/#.#./..##\n" +
                "#.#/.#./... => ..#./..#./..../....\n" +
                "###/.#./... => ###./..../..#./....\n" +
                ".#./##./... => ..../.##./##.#/....\n" +
                "##./##./... => ..#./.#../..##/#...\n" +
                "..#/##./... => #.##/.##./..#./.##.\n" +
                "#.#/##./... => .###/#.../##.#/..#.\n" +
                ".##/##./... => ###./##../..#./..##\n" +
                "###/##./... => ..#./.##./.###/#..#\n" +
                ".../#.#/... => ###./#.../####/#.#.\n" +
                "#../#.#/... => .##./.#../#.##/.#..\n" +
                ".#./#.#/... => .#../##../..##/.#.#\n" +
                "##./#.#/... => ###./#.#./##.#/##..\n" +
                "#.#/#.#/... => #.../.##./#.##/#.#.\n" +
                "###/#.#/... => ###./..##/#.##/###.\n" +
                ".../###/... => ##../...#/#.#./#.#.\n" +
                "#../###/... => .#../...#/##.#/####\n" +
                ".#./###/... => #.#./..##/#.#./.##.\n" +
                "##./###/... => ..##/..##/.###/#...\n" +
                "#.#/###/... => ####/##../..../#..#\n" +
                "###/###/... => ...#/#.##/#.##/#.#.\n" +
                "..#/.../#.. => .#.#/..##/#.##/#..#\n" +
                "#.#/.../#.. => ...#/..#./##../#..#\n" +
                ".##/.../#.. => ####/##../..../##..\n" +
                "###/.../#.. => ..#./..#./##.#/#..#\n" +
                ".##/#../#.. => .#../####/.###/#..#\n" +
                "###/#../#.. => ####/.#.#/...#/..##\n" +
                "..#/.#./#.. => #.#./.##./####/....\n" +
                "#.#/.#./#.. => ##../###./.#../##..\n" +
                ".##/.#./#.. => ###./.#../...#/....\n" +
                "###/.#./#.. => .#../.###/##../##.#\n" +
                ".##/##./#.. => .#../#..#/.###/#...\n" +
                "###/##./#.. => ..../.##./##../...#\n" +
                "#../..#/#.. => ##.#/...#/.###/##.#\n" +
                ".#./..#/#.. => ##../##../..../#.#.\n" +
                "##./..#/#.. => ..##/.#../#.#./.#.#\n" +
                "#.#/..#/#.. => ..../..##/...#/...#\n" +
                ".##/..#/#.. => #.../..##/...#/####\n" +
                "###/..#/#.. => #.../..#./##.#/.#.#\n" +
                "#../#.#/#.. => ..##/#.../#..#/..#.\n" +
                ".#./#.#/#.. => #..#/#.../.##./#.##\n" +
                "##./#.#/#.. => ##.#/.##./##.#/...#\n" +
                "..#/#.#/#.. => ####/.#.#/.##./#.#.\n" +
                "#.#/#.#/#.. => #..#/.##./.##./.###\n" +
                ".##/#.#/#.. => ...#/...#/..../.##.\n" +
                "###/#.#/#.. => .#../###./..../.###\n" +
                "#../.##/#.. => ##.#/##../#.#./...#\n" +
                ".#./.##/#.. => ###./.#.#/#.##/####\n" +
                "##./.##/#.. => #.##/..#./.#../#..#\n" +
                "#.#/.##/#.. => #.#./..##/..##/.#.#\n" +
                ".##/.##/#.. => .#../.###/.###/#.##\n" +
                "###/.##/#.. => #.../##../#.#./.#..\n" +
                "#../###/#.. => #.#./###./.##./..#.\n" +
                ".#./###/#.. => #.../#.../.##./.#..\n" +
                "##./###/#.. => ..#./.###/..##/#...\n" +
                "..#/###/#.. => #.##/.#../###./.###\n" +
                "#.#/###/#.. => .#.#/#..#/###./##..\n" +
                ".##/###/#.. => #.#./#.##/..##/.#..\n" +
                "###/###/#.. => ##../#.../..#./#..#\n" +
                ".#./#.#/.#. => #..#/####/#.#./#..#\n" +
                "##./#.#/.#. => ..##/.#../##.#/#..#\n" +
                "#.#/#.#/.#. => ####/#.#./#..#/#.#.\n" +
                "###/#.#/.#. => #.../##.#/..../#...\n" +
                ".#./###/.#. => ..##/.##./####/.###\n" +
                "##./###/.#. => .##./..#./#.##/#..#\n" +
                "#.#/###/.#. => ##.#/##../####/...#\n" +
                "###/###/.#. => ..##/####/...#/.#..\n" +
                "#.#/..#/##. => #.##/.#.#/#.#./#.##\n" +
                "###/..#/##. => ...#/##.#/#..#/..#.\n" +
                ".##/#.#/##. => .#.#/..#./..../###.\n" +
                "###/#.#/##. => ###./####/##.#/#.##\n" +
                "#.#/.##/##. => ##.#/#.##/.##./##..\n" +
                "###/.##/##. => .#.#/#.#./###./####\n" +
                ".##/###/##. => .#../####/.#../....\n" +
                "###/###/##. => .#../..../##.#/.##.\n" +
                "#.#/.../#.# => #.../#.../..##/..##\n" +
                "###/.../#.# => ...#/..#./##.#/####\n" +
                "###/#../#.# => .###/..##/.#../....\n" +
                "#.#/.#./#.# => ###./####/.#../#..#\n" +
                "###/.#./#.# => #.../#.##/..../###.\n" +
                "###/##./#.# => .###/####/#..#/.###\n" +
                "#.#/#.#/#.# => .#.#/...#/.#.#/#.##\n" +
                "###/#.#/#.# => ..../..#./..#./####\n" +
                "#.#/###/#.# => ..##/...#/.#.#/.##.\n" +
                "###/###/#.# => .###/.##./..##/####\n" +
                "###/#.#/### => #.#./.#../.#.#/#.#.\n" +
                "###/###/### => #..#/##../#.#./####");
        assert result == 2449665 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(int iterations, String s) {
        char[][] table = new char[][]{
                new char[]{'.', '#', '.'},
                new char[]{'.', '.', '#'},
                new char[]{'#', '#', '#'}
        };

        String[] parts = s.split("\n");
        Rule[] rules = new Rule[parts.length];
        for (int i = 0; i < parts.length; ++i) {
            String part = parts[i];
            String[] tokens = part.split(" => ");
            Rule rule = new Rule();
            rule.from = tokens[0];
            rule.to = tokens[1];
            rules[i] = rule;
        }

        for (int i = 0; i < iterations; ++i) {
            int size = table.length % 2 == 0 ? 2 : 3;
            int count = table.length / size;
            char[][] subtable = new char[size][];
            for (int j = 0; j < size; subtable[j] = new char[size], ++j) ;

            int newsize = count * (size + 1);
            char[][] newtable = new char[newsize][];
            for (int j = 0; j < newsize; newtable[j] = new char[newsize], ++j) ;

            for (int j = 0; j < count; ++j) {
                for (int k = 0; k < count; ++k) {

                    for (int j1 = j * size; j1 < j * size + size; ++j1) {
                        for (int k1 = k * size; k1 < k * size + size; ++k1) {
                            subtable[j1 - j * size][k1 - k * size] = table[j1][k1];
                        }
                    }

                    char[][] result = null;
                    for (Rule rule : rules) {
                        if (rule.matches(subtable)) {
                            result = rule.process();
                            break;
                        }
                    }

                    if (result == null) {
                        throw new RuntimeException("no matches found");
                    }

                    for (int j1 = j * (size + 1); j1 < j * (size + 1) + (size + 1); ++j1) {
                        for (int k1 = k * (size + 1); k1 < k * (size + 1) + (size + 1); ++k1) {
                            newtable[j1][k1] = result[j1 - j * (size + 1)][k1 - k * (size + 1)];
                        }
                    }

                }
            }
            table = newtable;
        }

        int count = 0;
        for (int i = 0; i < table.length; ++i) {
            for (int j = 0; j < table[i].length; ++j) {
                count += (table[i][j] == '#' ? 1 : 0);
            }
        }
        return count;
    }

    private static class Rule {
        String from, to;

        boolean matches(char[][] table) {
            // get 8 matrixes and compare with from, get first match
            table = copy(table);
            if (toString(table).equals(from)) {
                return true;
            }
            if (toString(rotate(table)).equals(from)) {
                return true;
            }
            if (toString(rotate(table)).equals(from)) {
                return true;
            }
            if (toString(rotate(table)).equals(from)) {
                return true;
            }
            if (toString(transpose(table)).equals(from)) {
                return true;
            }
            if (toString(rotate(table)).equals(from)) {
                return true;
            }
            if (toString(rotate(table)).equals(from)) {
                return true;
            }
            if (toString(rotate(table)).equals(from)) {
                return true;
            }
            return false;
        }

        char[][] copy(char[][] m) {
            char[][] newm = new char[m.length][];
            for (int i = 0; i < m.length; ++i) {
                newm[i] = new char[m[i].length];
                for (int j = 0; j < m[i].length; ++j) {
                    newm[i][j] = m[i][j];
                }
            }
            return newm;
        }

        char[][] swapRows(char[][] m) {
            for (int i = 0, k = m.length - 1; i < k; ++i, --k) {
                char[] x = m[i];
                m[i] = m[k];
                m[k] = x;
            }
            return m;
        }

        char[][] rotate(char[][] m) {
            transpose(m);
            swapRows(m);
            return m;
        }

        char[][] transpose(char[][] m) {
            for (int i = 0; i < m.length; i++) {
                for (int j = i; j < m[0].length; j++) {
                    char x = m[i][j];
                    m[i][j] = m[j][i];
                    m[j][i] = x;
                }
            }
            return m;
        }

        String toString(char[][] table) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < table.length; ++i) {
                for (int j = 0; j < table[i].length; ++j) {
                    result.append(table[i][j]);
                }
                result.append(i == table.length - 1 ? "" : "/");
            }
            return result.toString();
        }

        char[][] process() {
            // make to matrix
            String[] rows = to.split("/");
            char[][] table = new char[rows.length][];
            for (int i = 0; i < rows.length; ++i) {
                table[i] = new char[rows[i].length()];
                for (int j = 0; j < rows[i].length(); ++j) {
                    table[i][j] = rows[i].charAt(j);
                }
            }
            return table;
        }
    }
}
