package test.concurrency;

import java.util.ArrayList;
import java.util.List;

public class RaceConditionSample {

    private static Integer sum = 0;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10000; ++i) {
            Thread thread = new Thread(RaceConditionSample::doWork);
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.printf("sum = %d", sum);
    }

    private static void doWork() {
        sum += 1;
    }
}
