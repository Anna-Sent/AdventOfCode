package advent2015;

import java.util.ArrayList;
import java.util.List;

public class AoC2015Day15Part1 {
    public static void main(String[] args) {
        int result;

        result = test("Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8"
                + "\r\n"
                + "Cinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3");
        assert result == 62842880;
        System.out.println(result);

        result = test("Sprinkles: capacity 2, durability 0, flavor -2, texture 0, calories 3"
                + "\r\n"
                + "Butterscotch: capacity 0, durability 5, flavor -3, texture 0, calories 3"
                + "\r\n"
                + "Chocolate: capacity 0, durability 0, flavor 5, texture -1, calories 8"
                + "\r\n"
                + "Candy: capacity 0, durability -1, flavor 0, texture 5, calories 8");
        assert result == 21367368;
        System.out.println(result);
    }

    public static int test(String s) {
        List<Component> components = new ArrayList<>();
        String[] parts = s.split("\r\n");
        for (String part : parts) {
            String[] tokens = part.split(": ");
            Component component = new Component();
            component.name = tokens[0];
            tokens = tokens[1].split(", ");
            component.capacity = Integer.parseInt(tokens[0].split(" ")[1]);
            component.durability = Integer.parseInt(tokens[1].split(" ")[1]);
            component.flavor = Integer.parseInt(tokens[2].split(" ")[1]);
            component.texture = Integer.parseInt(tokens[3].split(" ")[1]);
            component.calories = Integer.parseInt(tokens[4].split(" ")[1]);
            components.add(component);
        }

        int max = bf(0, components, 0, 0);
        return max;
    }

    private static int bf(int currentScore, List<Component> components,
                          int index, int max) {
        if (index < components.size() - 1) {
            for (int v = 100 - currentScore; v >= 0; --v) {
                components.get(index).teaspoons = v;
                max = bf(currentScore + v, components, index + 1, max);
            }

            return max;
        } else {
            components.get(components.size() - 1).teaspoons = 100 - currentScore;
            // System.out.println(components);
            int capacity = 0;
            int durability = 0;
            int flavor = 0;
            int texture = 0;
            for (Component component : components) {
                capacity += component.teaspoons * component.capacity;
                durability += component.teaspoons * component.durability;
                flavor += component.teaspoons * component.flavor;
                texture += component.teaspoons * component.texture;
            }
            int total = capacity > 0 && durability > 0 && flavor > 0
                    && texture > 0 ? capacity * durability * flavor * texture
                    : 0;
            return max = total > max ? total : max;
        }
    }

    static class Component {
        String name;
        int capacity;
        int durability;
        int flavor;
        int texture;
        int calories;

        int teaspoons;

        @Override
        public String toString() {
            return String.valueOf(teaspoons);
        }
    }
}