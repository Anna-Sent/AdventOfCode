package advent2015;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AoC2015Day9Part2 {
	public static void main(String[] args) {
		int result;

		result = test("London to Dublin = 464\r\nLondon to Belfast = 518\r\nDublin to Belfast = 141");
		assert (result == 982);
		System.out.println(result);

		result = test("Faerun to Tristram = 65\r\nFaerun to Tambi = 129\r\nFaerun to Norrath = 144\r\nFaerun to Snowdin = 71\r\nFaerun to Straylight = 137\r\nFaerun to AlphaCentauri = 3\r\nFaerun to Arbre = 149\r\nTristram to Tambi = 63\r\nTristram to Norrath = 4\r\nTristram to Snowdin = 105\r\nTristram to Straylight = 125\r\nTristram to AlphaCentauri = 55\r\nTristram to Arbre = 14\r\nTambi to Norrath = 68\r\nTambi to Snowdin = 52\r\nTambi to Straylight = 65\r\nTambi to AlphaCentauri = 22\r\nTambi to Arbre = 143\r\nNorrath to Snowdin = 8\r\nNorrath to Straylight = 23\r\nNorrath to AlphaCentauri = 136\r\nNorrath to Arbre = 115\r\nSnowdin to Straylight = 101\r\nSnowdin to AlphaCentauri = 84\r\nSnowdin to Arbre = 96\r\nStraylight to AlphaCentauri = 107\r\nStraylight to Arbre = 14\r\nAlphaCentauri to Arbre = 46");
		System.out.println(result);
	}

	private static final Map<String, Integer> connections = new HashMap<>();
	private static final Set<String> nodes = new HashSet<>();

	public static int test(String s) {
		connections.clear();
		nodes.clear();

		String[] strings = s.split("\r\n");
		for (String string : strings) {
			String[] parts = string.split(" = ");
			String[] cities = parts[0].split(" to ");
			int distance = Integer.parseInt(parts[1]);
			connections.put(cities[0] + "," + cities[1],
					Integer.valueOf(distance));
			connections.put(cities[1] + "," + cities[0],
					Integer.valueOf(distance));
			nodes.add(cities[0]);
			nodes.add(cities[1]);
		}

		List<List<String>> routes = new ArrayList<>();

		buildRoute(new ArrayList<String>(), routes);

		int maxDistance = 0;
		for (List<String> route : routes) {
			int distance = 0;
			for (int i = 0; i < route.size(); ++i) {
				if (i == route.size() - 1) {
					System.out.print(route.get(i) + " = " + distance);
				} else {
					distance += connections.get(
							route.get(i) + "," + route.get(i + 1)).intValue();
					System.out.print(route.get(i) + " -> ");
				}
			}
			maxDistance = route.size() == nodes.size()
					&& distance > maxDistance ? distance : maxDistance;
			System.out.println();
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