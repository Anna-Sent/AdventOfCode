package advent2016;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2016Day10Part1 {
    public static void main(String[] args) {
        int result;

        result = test(2, 5, "value 5 goes to bot 2" + "\r\n"
                + "bot 2 gives low to bot 1 and high to bot 0" + "\r\n"
                + "value 3 goes to bot 1" + "\r\n"
                + "bot 1 gives low to output 1 and high to bot 0" + "\r\n"
                + "bot 0 gives low to output 2 and high to output 0" + "\r\n"
                + "value 2 goes to bot 2");
        assert result == 2;
        System.out.println(result);

        result = test(
                17,
                61,
                "bot 59 gives low to bot 176 and high to bot 120\r\nbot 92 gives low to bot 42 and high to bot 187\r\nvalue 31 goes to bot 114\r\nbot 182 gives low to bot 49 and high to bot 176\r\nbot 17 gives low to bot 181 and high to bot 162\r\nbot 36 gives low to bot 118 and high to bot 121\r\nbot 118 gives low to bot 164 and high to bot 55\r\nbot 172 gives low to bot 79 and high to bot 123\r\nbot 51 gives low to bot 60 and high to bot 31\r\nbot 48 gives low to bot 107 and high to bot 58\r\nbot 142 gives low to output 6 and high to bot 35\r\nbot 133 gives low to output 4 and high to bot 47\r\nbot 134 gives low to bot 122 and high to bot 66\r\nbot 106 gives low to bot 155 and high to bot 99\r\nbot 77 gives low to bot 93 and high to bot 84\r\nbot 9 gives low to bot 173 and high to bot 197\r\nbot 64 gives low to bot 123 and high to bot 48\r\nbot 177 gives low to bot 21 and high to bot 132\r\nbot 94 gives low to bot 6 and high to bot 25\r\nbot 126 gives low to bot 193 and high to bot 56\r\nbot 74 gives low to bot 187 and high to bot 125\r\nbot 80 gives low to bot 41 and high to bot 191\r\nbot 62 gives low to bot 157 and high to bot 138\r\nbot 66 gives low to bot 1 and high to bot 209\r\nbot 90 gives low to bot 104 and high to bot 34\r\nbot 68 gives low to bot 23 and high to bot 87\r\nbot 121 gives low to bot 55 and high to bot 126\r\nbot 122 gives low to bot 137 and high to bot 1\r\nbot 209 gives low to bot 168 and high to bot 26\r\nbot 141 gives low to bot 170 and high to bot 6\r\nbot 149 gives low to bot 62 and high to bot 13\r\nbot 120 gives low to bot 179 and high to bot 71\r\nbot 160 gives low to bot 194 and high to bot 151\r\nbot 86 gives low to bot 96 and high to bot 106\r\nvalue 13 goes to bot 9\r\nbot 180 gives low to bot 189 and high to bot 27\r\nvalue 67 goes to bot 88\r\nbot 169 gives low to bot 99 and high to bot 159\r\nbot 56 gives low to bot 98 and high to bot 147\r\nbot 197 gives low to bot 174 and high to bot 81\r\nbot 57 gives low to bot 113 and high to bot 179\r\nbot 39 gives low to bot 115 and high to bot 3\r\nbot 79 gives low to bot 22 and high to bot 40\r\nbot 161 gives low to output 14 and high to bot 185\r\nbot 21 gives low to bot 114 and high to bot 119\r\nbot 136 gives low to bot 28 and high to bot 158\r\nbot 105 gives low to bot 89 and high to bot 19\r\nbot 168 gives low to bot 126 and high to bot 26\r\nbot 193 gives low to bot 64 and high to bot 98\r\nbot 186 gives low to bot 86 and high to bot 178\r\nvalue 11 goes to bot 165\r\nbot 33 gives low to bot 116 and high to bot 150\r\nbot 32 gives low to bot 154 and high to bot 206\r\nbot 166 gives low to bot 33 and high to bot 139\r\nvalue 7 goes to bot 63\r\nbot 203 gives low to bot 172 and high to bot 64\r\nbot 200 gives low to bot 94 and high to bot 25\r\nvalue 43 goes to bot 76\r\nbot 145 gives low to bot 103 and high to bot 128\r\nbot 119 gives low to bot 186 and high to bot 97\r\nbot 12 gives low to bot 31 and high to bot 4\r\nbot 23 gives low to bot 198 and high to bot 171\r\nbot 34 gives low to bot 10 and high to bot 20\r\nbot 198 gives low to bot 43 and high to bot 17\r\nbot 50 gives low to output 1 and high to bot 127\r\nbot 155 gives low to bot 191 and high to bot 32\r\nbot 206 gives low to bot 12 and high to bot 43\r\nbot 96 gives low to bot 80 and high to bot 155\r\nbot 93 gives low to bot 44 and high to bot 70\r\nbot 24 gives low to bot 85 and high to bot 83\r\nbot 30 gives low to bot 159 and high to bot 68\r\nbot 55 gives low to bot 203 and high to bot 193\r\nbot 199 gives low to bot 68 and high to bot 135\r\nbot 170 gives low to bot 97 and high to bot 5\r\nbot 65 gives low to bot 152 and high to bot 194\r\nbot 43 gives low to bot 4 and high to bot 181\r\nbot 113 gives low to output 9 and high to bot 161\r\nbot 81 gives low to bot 141 and high to bot 94\r\nvalue 29 goes to bot 7\r\nbot 46 gives low to bot 175 and high to bot 195\r\nvalue 47 goes to bot 21\r\nvalue 23 goes to bot 42\r\nbot 13 gives low to bot 138 and high to bot 61\r\nbot 135 gives low to bot 87 and high to bot 111\r\nbot 194 gives low to bot 190 and high to bot 82\r\nvalue 73 goes to bot 109\r\nbot 154 gives low to bot 51 and high to bot 12\r\nbot 1 gives low to bot 18 and high to bot 209\r\nbot 98 gives low to bot 48 and high to bot 45\r\nbot 147 gives low to bot 45 and high to bot 95\r\nbot 47 gives low to output 19 and high to bot 152\r\nbot 26 gives low to bot 56 and high to bot 147\r\nbot 179 gives low to bot 161 and high to bot 71\r\nbot 148 gives low to bot 204 and high to bot 137\r\nbot 5 gives low to bot 67 and high to bot 85\r\nbot 174 gives low to bot 132 and high to bot 141\r\nbot 8 gives low to bot 13 and high to bot 75\r\nbot 82 gives low to bot 146 and high to bot 22\r\nbot 123 gives low to bot 40 and high to bot 107\r\nbot 99 gives low to bot 32 and high to bot 201\r\nbot 41 gives low to bot 196 and high to bot 192\r\nbot 139 gives low to bot 150 and high to bot 153\r\nbot 11 gives low to output 16 and high to bot 113\r\nbot 72 gives low to bot 65 and high to bot 160\r\nbot 195 gives low to bot 133 and high to bot 183\r\nbot 54 gives low to output 12 and high to output 10\r\nbot 158 gives low to bot 102 and high to bot 110\r\nbot 112 gives low to bot 19 and high to bot 118\r\nbot 31 gives low to bot 208 and high to bot 143\r\nbot 167 gives low to bot 7 and high to bot 96\r\nbot 63 gives low to bot 92 and high to bot 74\r\nbot 116 gives low to bot 20 and high to bot 131\r\nbot 184 gives low to bot 39 and high to bot 3\r\nbot 162 gives low to bot 205 and high to bot 39\r\nbot 108 gives low to output 11 and high to bot 175\r\nvalue 53 goes to bot 207\r\nbot 111 gives low to bot 202 and high to bot 184\r\nbot 25 gives low to bot 24 and high to bot 83\r\nvalue 71 goes to bot 77\r\nbot 69 gives low to bot 142 and high to bot 0\r\nbot 146 gives low to output 13 and high to bot 53\r\nbot 7 gives low to bot 76 and high to bot 80\r\nbot 131 gives low to bot 73 and high to bot 204\r\nbot 102 gives low to bot 195 and high to bot 117\r\nbot 76 gives low to bot 165 and high to bot 41\r\nbot 153 gives low to bot 148 and high to bot 122\r\nbot 208 gives low to bot 90 and high to bot 163\r\nbot 70 gives low to bot 144 and high to bot 78\r\nbot 125 gives low to bot 8 and high to bot 156\r\nbot 83 gives low to bot 199 and high to bot 135\r\nbot 75 gives low to bot 61 and high to bot 104\r\nbot 67 gives low to bot 169 and high to bot 30\r\nbot 14 gives low to bot 81 and high to bot 200\r\nbot 159 gives low to bot 201 and high to bot 23\r\nvalue 3 goes to bot 93\r\nbot 110 gives low to bot 117 and high to bot 89\r\nbot 128 gives low to bot 129 and high to bot 182\r\nbot 87 gives low to bot 171 and high to bot 111\r\nbot 45 gives low to bot 58 and high to bot 95\r\nbot 4 gives low to bot 143 and high to bot 166\r\nbot 60 gives low to bot 156 and high to bot 208\r\nbot 27 gives low to bot 108 and high to bot 46\r\nbot 42 gives low to bot 207 and high to bot 149\r\nbot 117 gives low to bot 183 and high to bot 72\r\nbot 115 gives low to bot 153 and high to bot 134\r\nbot 140 gives low to bot 125 and high to bot 60\r\nbot 173 gives low to bot 177 and high to bot 174\r\nbot 138 gives low to bot 180 and high to bot 52\r\nbot 100 gives low to bot 38 and high to bot 59\r\nvalue 41 goes to bot 173\r\nvalue 59 goes to bot 177\r\nbot 165 gives low to bot 63 and high to bot 196\r\nbot 84 gives low to bot 70 and high to bot 78\r\nbot 2 gives low to bot 160 and high to bot 91\r\nvalue 61 goes to bot 29\r\nbot 114 gives low to bot 109 and high to bot 186\r\nbot 205 gives low to bot 139 and high to bot 115\r\nbot 175 gives low to output 17 and high to bot 133\r\nbot 176 gives low to bot 57 and high to bot 120\r\nbot 107 gives low to bot 124 and high to bot 15\r\nbot 52 gives low to bot 27 and high to bot 28\r\nbot 103 gives low to bot 50 and high to bot 129\r\nbot 150 gives low to bot 131 and high to bot 148\r\nbot 16 gives low to output 20 and high to bot 189\r\nbot 190 gives low to output 18 and high to bot 146\r\nbot 157 gives low to bot 16 and high to bot 180\r\nbot 10 gives low to bot 158 and high to bot 130\r\nbot 202 gives low to bot 162 and high to bot 184\r\nbot 88 gives low to bot 77 and high to bot 84\r\nbot 188 gives low to bot 128 and high to bot 38\r\nbot 58 gives low to bot 15 and high to bot 101\r\nbot 171 gives low to bot 17 and high to bot 202\r\nbot 97 gives low to bot 178 and high to bot 67\r\nbot 163 gives low to bot 34 and high to bot 116\r\nbot 124 gives low to bot 0 and high to bot 145\r\nbot 71 gives low to bot 185 and high to bot 54\r\nbot 78 gives low to bot 14 and high to bot 200\r\nbot 101 gives low to bot 188 and high to bot 100\r\nbot 189 gives low to output 7 and high to bot 108\r\nbot 95 gives low to bot 101 and high to bot 100\r\nbot 0 gives low to bot 35 and high to bot 103\r\nbot 207 gives low to bot 37 and high to bot 62\r\nbot 49 gives low to bot 11 and high to bot 57\r\nbot 85 gives low to bot 30 and high to bot 199\r\nbot 89 gives low to bot 72 and high to bot 2\r\nbot 3 gives low to bot 134 and high to bot 66\r\nbot 181 gives low to bot 166 and high to bot 205\r\nbot 91 gives low to bot 151 and high to bot 172\r\nvalue 17 goes to bot 167\r\nbot 20 gives low to bot 130 and high to bot 73\r\nbot 196 gives low to bot 74 and high to bot 140\r\nbot 18 gives low to bot 121 and high to bot 168\r\nbot 185 gives low to output 15 and high to bot 54\r\nbot 178 gives low to bot 106 and high to bot 169\r\nbot 129 gives low to bot 127 and high to bot 49\r\nbot 19 gives low to bot 2 and high to bot 164\r\nbot 15 gives low to bot 145 and high to bot 188\r\nbot 144 gives low to bot 197 and high to bot 14\r\nbot 201 gives low to bot 206 and high to bot 198\r\nbot 164 gives low to bot 91 and high to bot 203\r\nbot 73 gives low to bot 105 and high to bot 112\r\nbot 191 gives low to bot 192 and high to bot 154\r\nbot 109 gives low to bot 167 and high to bot 86\r\nbot 151 gives low to bot 82 and high to bot 79\r\nbot 53 gives low to output 2 and high to bot 142\r\nbot 37 gives low to bot 29 and high to bot 157\r\nvalue 2 goes to bot 44\r\nbot 204 gives low to bot 112 and high to bot 36\r\nbot 40 gives low to bot 69 and high to bot 124\r\nbot 22 gives low to bot 53 and high to bot 69\r\nbot 104 gives low to bot 136 and high to bot 10\r\nvalue 19 goes to bot 88\r\nbot 127 gives low to output 5 and high to bot 11\r\nbot 183 gives low to bot 47 and high to bot 65\r\nbot 192 gives low to bot 140 and high to bot 51\r\nbot 38 gives low to bot 182 and high to bot 59\r\nbot 61 gives low to bot 52 and high to bot 136\r\nbot 156 gives low to bot 75 and high to bot 90\r\nvalue 37 goes to bot 37\r\nbot 28 gives low to bot 46 and high to bot 102\r\nbot 187 gives low to bot 149 and high to bot 8\r\nbot 132 gives low to bot 119 and high to bot 170\r\nbot 44 gives low to bot 9 and high to bot 144\r\nbot 29 gives low to output 0 and high to bot 16\r\nbot 6 gives low to bot 5 and high to bot 24\r\nbot 137 gives low to bot 36 and high to bot 18\r\nbot 130 gives low to bot 110 and high to bot 105\r\nvalue 5 goes to bot 92\r\nbot 35 gives low to output 3 and high to bot 50\r\nbot 152 gives low to output 8 and high to bot 190\r\nbot 143 gives low to bot 163 and high to bot 33");
        assert result == 47;
        System.out.println(result);
    }

    private static int test(int low0, int high0, String s) {
        Map<Integer, Bot> bots = new HashMap<>();
        Map<Integer, Output> outputs = new HashMap<>();
        Pattern p1 = Pattern.compile("value (\\d+) goes to bot (\\d+)");
        Pattern p2 = Pattern
                .compile("bot (\\d+) gives low to (bot|output) (\\d+) and high to (output|bot) (\\d+)");
        Set<String> executed = new HashSet<>();
        String[] commands = s.split("\r\n");
        while (executed.size() != commands.length) {
            int exec1 = executed.size();
            for (String command : commands) {
                if (executed.contains(command)) {
                    continue;
                }
                Matcher m1 = p1.matcher(command);
                Matcher m2 = p2.matcher(command);
                if (m1.matches()) {
                    System.out.println(command);
                    executed.add(command);
                    int value = Integer.parseInt(m1.group(1));
                    int botNumber = Integer.parseInt(m1.group(2));
                    Bot bot = getBot(bots, Integer.valueOf(botNumber));
                    bot.pushValue(value);
                    if (bot.values[0] == low0 && bot.values[1] == high0) {
                        return botNumber;
                    }
                } else if (m2.matches()) {
                    int botNumber = Integer.parseInt(m2.group(1));
                    Bot fromBot = getBot(bots, Integer.valueOf(botNumber));

                    if (!fromBot.hasTwoMicrochips()) {
                        continue;
                    }

                    System.out.println(command);
                    executed.add(command);

                    int low = fromBot.popLow();
                    int high = fromBot.popHigh();

                    String lowTo = m2.group(2);
                    int lowNum = Integer.parseInt(m2.group(3));
                    String highTo = m2.group(4);
                    int highNum = Integer.parseInt(m2.group(5));
                    if (lowTo.equals("bot")) {
                        Bot toBot = getBot(bots, Integer.valueOf(lowNum));
                        toBot.pushValue(low);
                        if (toBot.values[0] == low0 && toBot.values[1] == high0) {
                            return lowNum;
                        }
                    } else if (lowTo.equals("output")) {
                        Output toOutput = getOutput(outputs,
                                Integer.valueOf(lowNum));
                        toOutput.value = low;
                    }
                    if (highTo.equals("bot")) {
                        Bot toBot = getBot(bots, Integer.valueOf(highNum));
                        toBot.pushValue(high);
                        if (toBot.values[0] == low0 && toBot.values[1] == high0) {
                            return highNum;
                        }
                    } else if (highTo.equals("output")) {
                        Output toOutput = getOutput(outputs,
                                Integer.valueOf(highNum));
                        toOutput.value = high;
                    }
                } else {
                    throw new RuntimeException("invalid input");
                }
                int exec2 = executed.size();
                if (exec1 == exec2) {
                    break;
                }
            }
        }
        return 0;
    }

    private static Bot getBot(Map<Integer, Bot> bots, Integer key) {
        Bot bot = bots.get(key);
        if (bot == null) {
            bot = new Bot();
            bots.put(key, bot);
        }
        return bot;
    }

    private static Output getOutput(Map<Integer, Output> outputs, Integer key) {
        Output output = outputs.get(key);
        if (output == null) {
            output = new Output();
            outputs.put(key, output);
        }
        return output;
    }

    static class Bot {
        int[] values = new int[2];

        void pushValue(int value) {
            if (values[0] == 0) {
                values[0] = value;
            } else {
                throw new RuntimeException("invalid input");
            }
            Arrays.sort(values);
        }

        int popLow() {
            int low = values[0];
            values[0] = 0;
            Arrays.sort(values);
            return low;
        }

        int popHigh() {
            int high = values[1];
            values[1] = 0;
            Arrays.sort(values);
            return high;
        }

        boolean hasTwoMicrochips() {
            return values[0] != 0 && values[1] != 0;
        }
    }

    static class Output {
        int value;
    }
}