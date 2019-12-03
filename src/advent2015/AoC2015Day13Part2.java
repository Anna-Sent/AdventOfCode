package advent2015;

import java.util.*;

public class AoC2015Day13Part2 {
    private static final Map<String, Integer> connections = new HashMap<>();
    private static final Set<String> nodes = new HashSet<>();

    public static void main(String[] args) {
        int result;

        result = test("Alice would gain 2 happiness units by sitting next to Bob.\r\nAlice would gain 26 happiness units by sitting next to Carol.\r\nAlice would lose 82 happiness units by sitting next to David.\r\nAlice would lose 75 happiness units by sitting next to Eric.\r\nAlice would gain 42 happiness units by sitting next to Frank.\r\nAlice would gain 38 happiness units by sitting next to George.\r\nAlice would gain 39 happiness units by sitting next to Mallory.\r\nBob would gain 40 happiness units by sitting next to Alice.\r\nBob would lose 61 happiness units by sitting next to Carol.\r\nBob would lose 15 happiness units by sitting next to David.\r\nBob would gain 63 happiness units by sitting next to Eric.\r\nBob would gain 41 happiness units by sitting next to Frank.\r\nBob would gain 30 happiness units by sitting next to George.\r\nBob would gain 87 happiness units by sitting next to Mallory.\r\nCarol would lose 35 happiness units by sitting next to Alice.\r\nCarol would lose 99 happiness units by sitting next to Bob.\r\nCarol would lose 51 happiness units by sitting next to David.\r\nCarol would gain 95 happiness units by sitting next to Eric.\r\nCarol would gain 90 happiness units by sitting next to Frank.\r\nCarol would lose 16 happiness units by sitting next to George.\r\nCarol would gain 94 happiness units by sitting next to Mallory.\r\nDavid would gain 36 happiness units by sitting next to Alice.\r\nDavid would lose 18 happiness units by sitting next to Bob.\r\nDavid would lose 65 happiness units by sitting next to Carol.\r\nDavid would lose 18 happiness units by sitting next to Eric.\r\nDavid would lose 22 happiness units by sitting next to Frank.\r\nDavid would gain 2 happiness units by sitting next to George.\r\nDavid would gain 42 happiness units by sitting next to Mallory.\r\nEric would lose 65 happiness units by sitting next to Alice.\r\nEric would gain 24 happiness units by sitting next to Bob.\r\nEric would gain 100 happiness units by sitting next to Carol.\r\nEric would gain 51 happiness units by sitting next to David.\r\nEric would gain 21 happiness units by sitting next to Frank.\r\nEric would gain 55 happiness units by sitting next to George.\r\nEric would lose 44 happiness units by sitting next to Mallory.\r\nFrank would lose 48 happiness units by sitting next to Alice.\r\nFrank would gain 91 happiness units by sitting next to Bob.\r\nFrank would gain 8 happiness units by sitting next to Carol.\r\nFrank would lose 66 happiness units by sitting next to David.\r\nFrank would gain 97 happiness units by sitting next to Eric.\r\nFrank would lose 9 happiness units by sitting next to George.\r\nFrank would lose 92 happiness units by sitting next to Mallory.\r\nGeorge would lose 44 happiness units by sitting next to Alice.\r\nGeorge would lose 25 happiness units by sitting next to Bob.\r\nGeorge would gain 17 happiness units by sitting next to Carol.\r\nGeorge would gain 92 happiness units by sitting next to David.\r\nGeorge would lose 92 happiness units by sitting next to Eric.\r\nGeorge would gain 18 happiness units by sitting next to Frank.\r\nGeorge would gain 97 happiness units by sitting next to Mallory.\r\nMallory would gain 92 happiness units by sitting next to Alice.\r\nMallory would lose 96 happiness units by sitting next to Bob.\r\nMallory would lose 51 happiness units by sitting next to Carol.\r\nMallory would lose 81 happiness units by sitting next to David.\r\nMallory would gain 31 happiness units by sitting next to Eric.\r\nMallory would lose 73 happiness units by sitting next to Frank.\r\nMallory would lose 89 happiness units by sitting next to George.");
        assert result == 725;
        System.out.println(result);
    }

    private static int test(String s) {
        connections.clear();
        nodes.clear();

        String[] strings = s.split("\r\n");
        for (String string : strings) {
            String[] parts = string
                    .split(" happiness units by sitting next to ");

            int sign = 1;
            String[] cities;
            cities = parts[0].split(" would gain ");
            if (cities.length != 2) {
                sign = -1;
                cities = parts[0].split(" would lose ");
            }

            parts[1] = parts[1].substring(0, parts[1].length() - 1);

            int distance = sign * Integer.parseInt(cities[1]);
            String key1 = cities[0] + "," + parts[1];
            String key2 = parts[1] + "," + cities[0];
            if (connections.containsKey(key1)) {
                distance += connections.get(key1).intValue();
            } else if (connections.containsKey(key2)) {
                distance += connections.get(key2).intValue();
            }
            connections.put(key1, Integer.valueOf(distance));
            connections.put(key2, Integer.valueOf(distance));

            nodes.add(cities[0]);
            nodes.add(parts[1]);
        }

        for (String node : nodes) {
            connections.put("Me," + node, 0);
            connections.put(node + ",Me", 0);
        }
        nodes.add("Me");

        List<List<String>> routes = new ArrayList<>();

        buildRoute(new ArrayList<>(), routes);

        int maxDistance = 0;
        for (List<String> route : routes) {
            if (route.size() == nodes.size()) {
                int distance = 0;
                for (int i = 0; i < route.size(); ++i) {
                    if (i == route.size() - 1) {
                        System.out.print(route.get(i) + " = " + distance);
                        String key = route.get(i) + "," + route.get(0);
                        distance += connections.get(key).intValue();
                    } else {
                        String key = route.get(i) + "," + route.get(i + 1);
                        distance += connections.get(key).intValue();
                        System.out.print(route.get(i) + " -> ");
                    }
                }
                maxDistance = distance > maxDistance ? distance : maxDistance;
                System.out.println();
            }
        }

        return maxDistance;
    }

    private static void buildRoute(List<String> route, List<List<String>> routes) {
        for (String node : nodes) {
            if (!route.contains(node)
                    && (route.size() == 0 || connections.containsKey(route
                    .get(route.size() - 1) + "," + node))) {
                List<String> newRoute = new ArrayList<>(route);
                newRoute.add(node);
                routes.add(newRoute);
                buildRoute(newRoute, routes);
            }
        }
    }
}