package test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class ConcurrentHashMapTest {

    private static final int THREAD_COUNT = 100;

    public static void main(String[] args) throws InterruptedException {
        Map<Integer, Integer> map;

        // hash map no sync
        map = new HashMap<>();
        fillMap(map);
        testHashMap(map, ConcurrentHashMapTest::processMap);
        assert nonZeroValuesCount(map) != 0 : "increase threads count";

        // hash map with sync
        map = new HashMap<>();
        fillMap(map);
        testHashMap(map, ConcurrentHashMapTest::processMapWithSync);
        assert nonZeroValuesCount(map) == 0 : "something went wrong";

        // concurrent map no sync
        map = new ConcurrentHashMap<>();
        fillMap(map);
        testHashMap(map, ConcurrentHashMapTest::processMap);
        assert nonZeroValuesCount(map) != 0 : "increase threads count";

        // concurrent map with compute
        map = new ConcurrentHashMap<>();
        fillMap(map);
        testHashMap(map, ConcurrentHashMapTest::processMapWithCompute);
        assert nonZeroValuesCount(map) == 0 : "something went wrong";
    }

    private static void fillMap(Map<Integer, Integer> map) {
        IntStream.range(1, 51).forEach(value -> map.put(value, THREAD_COUNT));
    }

    private static void testHashMap(Map<Integer, Integer> map,
                                    Consumer<Map<Integer, Integer>> consumer)
            throws InterruptedException {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < threads.length; ++i) {
            threads[i] = new Thread(() -> {
                consumer.accept(map);
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

    private static void processMap(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            map.put(entry.getKey(), entry.getValue() - 1);
        }
    }

    private static void processMapWithSync(Map<Integer, Integer> map) {
        synchronized (map) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                map.put(entry.getKey(), entry.getValue() - 1);
            }
        }
    }

    private static void processMapWithCompute(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            map.compute(entry.getKey(), (key, value) -> value - 1);
        }
    }

    private static long nonZeroValuesCount(Map<Integer, Integer> map) {
        return map.values().stream().filter(value -> value != 0).count();
    }
}
