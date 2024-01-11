package advent2016;

public class AoC2016Day15Part2 {
    public static void main(String[] args) {
        int result;

        // Disc #1 has 5 positions; at time=0, it is at position 4.
        // Disc #2 has 2 positions; at time=0, it is at position 1.
        result = test(new Disk[]{new Disk(4, 5), new Disk(1, 2)});
        assert result == 5;
        System.out.println(result);

        // Disc #1 has 5 positions; at time=0, it is at position 2.
        // Disc #2 has 13 positions; at time=0, it is at position 7.
        // Disc #3 has 17 positions; at time=0, it is at position 10.
        // Disc #4 has 3 positions; at time=0, it is at position 2.
        // Disc #5 has 19 positions; at time=0, it is at position 9.
        // Disc #6 has 7 positions; at time=0, it is at position 0.
        result = test(new Disk[]{new Disk(2, 5), new Disk(7, 13),
                new Disk(10, 17), new Disk(2, 3), new Disk(9, 19),
                new Disk(0, 7), new Disk(0, 11)});
        assert result == 2353212;
        System.out.println(result);
    }

    static class Disk {
        int start;
        int count;
        int current;

        Disk(int start, int count) {
            this.start = start;
            this.count = count;
        }

        @Override
        public String toString() {
            return current + " (" + count + ")";
        }
    }

    public static int test(Disk[] disks) {
        for (int t = 0; t <= 1000000000; ++t) {
            boolean all = true;
            for (int i = 0; all && i < disks.length; ++i) {
                Disk disk = disks[i];
                disk.current = (disk.start + t + i + 1) % disk.count;
                all = disk.current == 0;
            }
            if (all) {
                return t;
            }
        }
        return -1;
    }
}