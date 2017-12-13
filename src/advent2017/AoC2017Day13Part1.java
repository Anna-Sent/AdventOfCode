package advent2017;


import java.util.HashMap;
import java.util.Map;

public class AoC2017Day13Part1 {
    public static void main(String[] args) {
        int result;

        result = test("0: 3\n" +
                "1: 2\n" +
                "4: 4\n" +
                "6: 4");
        System.out.println(result);
        assert result == 24 : "unexpected result is " + result;

        result = test("0: 3\n" +
                "1: 2\n" +
                "2: 4\n" +
                "4: 6\n" +
                "6: 4\n" +
                "8: 6\n" +
                "10: 5\n" +
                "12: 6\n" +
                "14: 8\n" +
                "16: 8\n" +
                "18: 8\n" +
                "20: 6\n" +
                "22: 12\n" +
                "24: 8\n" +
                "26: 8\n" +
                "28: 10\n" +
                "30: 9\n" +
                "32: 12\n" +
                "34: 8\n" +
                "36: 12\n" +
                "38: 12\n" +
                "40: 12\n" +
                "42: 14\n" +
                "44: 14\n" +
                "46: 12\n" +
                "48: 12\n" +
                "50: 12\n" +
                "52: 12\n" +
                "54: 14\n" +
                "56: 12\n" +
                "58: 14\n" +
                "60: 14\n" +
                "62: 14\n" +
                "64: 14\n" +
                "70: 10\n" +
                "72: 14\n" +
                "74: 14\n" +
                "76: 14\n" +
                "78: 14\n" +
                "82: 14\n" +
                "86: 17\n" +
                "88: 18\n" +
                "96: 26");
        assert result == 1612 : "unexpected result is " + result;
        System.out.println(result);
    }

    public static int test(String s) {
        Map<Integer, Layer> layers = new HashMap<>();
        String[] parts = s.split("\n");
        int count = 0;
        for (String part : parts) {
            String[] tokens = part.split(": ");
            int key = Integer.parseInt(tokens[0]);
            int length = Integer.parseInt(tokens[1]);
            Layer layer = new Layer();
            layer.length = length;
            layers.put(key, layer);
            count = Math.max(count, key);
        }
        int sum = 0;
        for (int i = 0; i <= count; ++i) {
            Layer currentLayer = layers.get(i);
            if (currentLayer != null && currentLayer.position == 0) {
                int severity = currentLayer.length * i;
                sum += severity;
            }
            move(layers, count);
        }
        return sum;
    }

    private static void move(Map<Integer, Layer> layers, int count) {
        for (int i = 0; i <= count; ++i) {
            Layer layer = layers.get(i);
            if (layer != null && layer.length > 1) {
                if (layer.backward) {
                    --layer.position;
                    if (layer.position < 0) {
                        layer.backward = false;
                        layer.position += 2;
                    }
                } else {
                    ++layer.position;
                    if (layer.position >= layer.length) {
                        layer.backward = true;
                        layer.position = layer.length - 2;
                    }
                }
            }
        }
    }

    private static class Layer {
        int length;
        int position;
        boolean backward;
    }
}
