package advent2017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AoC2017Day24Part2 {
    private static Map<Integer, List<Integer>> edges = new HashMap<>();
    private static int maxLength = 0;
    private static int maxStrenght = 0;

    public static void main(String[] args) {
        int result;

        result = test("0/2\n" +
                "2/2\n" +
                "2/3\n" +
                "3/4\n" +
                "3/5\n" +
                "0/1\n" +
                "10/1\n" +
                "9/10", true);
        System.out.println(result);
        assert result == 19 : "unexpected result is " + result;

        result = test("48/5\n" +
                "25/10\n" +
                "35/49\n" +
                "34/41\n" +
                "35/35\n" +
                "47/35\n" +
                "34/46\n" +
                "47/23\n" +
                "28/8\n" +
                "27/21\n" +
                "40/11\n" +
                "22/50\n" +
                "48/42\n" +
                "38/17\n" +
                "50/33\n" +
                "13/13\n" +
                "22/33\n" +
                "17/29\n" +
                "50/0\n" +
                "20/47\n" +
                "28/0\n" +
                "42/4\n" +
                "46/22\n" +
                "19/35\n" +
                "17/22\n" +
                "33/37\n" +
                "47/7\n" +
                "35/20\n" +
                "8/36\n" +
                "24/34\n" +
                "6/7\n" +
                "7/43\n" +
                "45/37\n" +
                "21/31\n" +
                "37/26\n" +
                "16/5\n" +
                "11/14\n" +
                "7/23\n" +
                "2/23\n" +
                "3/25\n" +
                "20/20\n" +
                "18/20\n" +
                "19/34\n" +
                "25/46\n" +
                "41/24\n" +
                "0/33\n" +
                "3/7\n" +
                "49/38\n" +
                "47/22\n" +
                "44/15\n" +
                "24/21\n" +
                "10/35\n" +
                "6/21\n" +
                "14/50", false);
        assert result == 1642 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(String s, boolean print) {
        edges.clear();
        maxLength = 0;
        maxStrenght = 0;
        String[] parts = s.split("\n");
        for (String part : parts) {
            String[] tokens = part.split("/");
            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);
            if (edges.containsKey(from)) {
                List<Integer> toList = edges.get(from);
                toList.add(to);
            } else {
                List<Integer> toList = new ArrayList<>();
                toList.add(to);
                edges.put(from, toList);
            }
            if (edges.containsKey(to)) {
                List<Integer> toList = edges.get(to);
                toList.add(from);
            } else {
                List<Integer> toList = new ArrayList<>();
                toList.add(from);
                edges.put(to, toList);
            }
        }
        int[] bridge0 = new int[0];
        findPaths(0, bridge0);
        return maxStrenght;
    }

    private static int weight(int[] bridge) {
        int sum = 0;
        for (int i = 0; i < bridge.length; ++i) {
            sum += bridge[i];
        }
        return sum;
    }

    private static void findPaths(int from, int[] bridge) {
        List<Integer> toList = edges.get(from);
        for (Integer to : toList) {
            if (!contains(bridge, from, to)) {
                int[] newBridge = new int[bridge.length + 2];
                System.arraycopy(bridge, 0, newBridge, 0, bridge.length);
                newBridge[bridge.length] = from;
                newBridge[bridge.length + 1] = to;
                int weight = weight(newBridge);
                int length = newBridge.length;
                if (length > maxLength) {
                    maxLength = length;
                    maxStrenght = weight;
                } else if (length == maxLength) {
                    maxStrenght = Math.max(maxStrenght, weight);
                }
                System.out.println("max length " + maxLength + "; max strength " + maxStrenght);
                findPaths(to, newBridge);
            }
        }
    }

    private static boolean contains(int[] bridge, int from, int to) {
        assert bridge.length % 2 == 0 : "invalid bridge";
        for (int i = 0; i < bridge.length; i += 2) {
            if (bridge[i] == from && bridge[i + 1] == to
                    || bridge[i] == to && bridge[i + 1] == from) {
                return true;
            }
        }
        return false;
    }
}
