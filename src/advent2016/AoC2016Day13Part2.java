package advent2016;

import java.util.HashSet;
import java.util.Set;

public class AoC2016Day13Part2 {
	public static void main(String[] args) {
		int result;

		final int THREADS_COUNT = 4;
		Thread[] threads = new Thread[THREADS_COUNT];
		int prev = -1;
		for (int i = 0; i < THREADS_COUNT; ++i) {
			final int index = i;
			final int from = prev + 1;
			final int to = i == THREADS_COUNT - 1 ? Integer.MAX_VALUE
					: Integer.MAX_VALUE / THREADS_COUNT + prev;
			prev = to;
			System.out.println("started thread " + i + " from " + from + " to "
					+ to);
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = from; j <= to && j >= 0; ++j) {
						assert countOfOne(j) == Integer.bitCount(j) : "j = "
								+ j;
					}
					System.out.println("finished thread " + index);
				}
			});
			threads[i].start();
		}
		try {
			for (int i = 0; i < THREADS_COUNT; ++i) {
				threads[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("passed");

		result = test(1352, 1, 1);
		assert (result == 135);
		System.out.println(result);
	}

	static class Point {
		int x, y;
		Point previousPoint;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, Point previousPoint) {
			this.x = x;
			this.y = y;
			this.previousPoint = previousPoint;
		}

		Set<Point> generateNext(int favoriteNumber) {
			Set<Point> result = new HashSet<Point>();
			if (!isWall(favoriteNumber, x + 1, y)) {
				result.add(new Point(x + 1, y, this));
			}
			if (!isWall(favoriteNumber, x, y + 1)) {
				result.add(new Point(x, y + 1, this));
			}
			if (y - 1 >= 0 && !isWall(favoriteNumber, x, y - 1)) {
				result.add(new Point(x, y - 1, this));
			}
			if (x - 1 >= 0 && !isWall(favoriteNumber, x - 1, y)) {
				result.add(new Point(x - 1, y, this));
			}
			return result;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}

	private static int test(int favoriteNumber, int startX, int startY) {
		if (isWall(favoriteNumber, startX, startY)) {
			throw new RuntimeException("invalid state");
		}

		Set<Point> closed = new HashSet<>();
		Set<Point> opened = new HashSet<>();

		int count = 0;
		opened.add(new Point(startX, startY));

		while (opened.size() > 0) {
			Set<Point> achievable = new HashSet<>();
			for (Point currentPoint : opened) {
				Set<Point> set = currentPoint.generateNext(favoriteNumber);
				for (Point nextPoint : set) {
					if (!closed.contains(nextPoint)) {
						achievable.add(nextPoint);
					}
				}

				closed.add(currentPoint);
			}

			++count;
			opened = achievable;

			if (count == 51) {
				return closed.size();
			}
		}

		return -1;
	}

	private static boolean isWall(int favoriteNumber, int x, int y) {
		int number = x * x + 3 * x + 2 * x * y + y + y * y + favoriteNumber;
		int countOfOne = countOfOne(number);
		return countOfOne % 2 == 0 ? false : true;
	}

	private static int countOfOne(int number) {
		int countOfOne = 0;
		while (number > 0) {
			if ((number & 1) == 1) {
				++countOfOne;
			}
			number = number >>> 1;
		}
		return countOfOne;
	}
}