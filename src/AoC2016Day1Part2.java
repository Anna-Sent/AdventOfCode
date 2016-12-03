import java.util.HashSet;

public class AoC2016Day1Part2 {
	public static void main(String[] args) {
		int result;

		result = test("R8, R4, R4, R8");
		assert (result == 4);
		System.out.println(result);

		result = test("R2, R3, L2, L2, L3");
		assert (result == 3);
		System.out.println(result);

		result = test("L1, L3, L5, L3, R1, L4, L5, R1, R3, L5, R1, L3, L2, L3, R2, R2, L3, L3, R1, L2, R1, L3, L2, R4, R2, L5, R4, L5, R4, L2, R3, L2, R4, R1, L5, L4, R1, L2, R3, R1, R2, L4, R1, L2, R3, L2, L3, R5, L192, R4, L5, R4, L1, R4, L4, R2, L5, R45, L2, L5, R4, R5, L3, R5, R77, R2, R5, L5, R1, R4, L4, L4, R2, L4, L1, R191, R1, L1, L2, L2, L4, L3, R1, L3, R1, R5, R3, L1, L4, L2, L3, L1, L1, R5, L4, R1, L3, R1, L2, R1, R4, R5, L4, L2, R4, R5, L1, L2, R3, L4, R2, R2, R3, L2, L3, L5, R3, R1, L4, L3, R4, R2, R2, R2, R1, L4, R4, R1, R2, R1, L2, L2, R4, L1, L2, R3, L3, L5, L4, R4, L3, L1, L5, L3, L5, R5, L5, L4, L2, R1, L2, L4, L2, L4, L1, R4, R4, R5, R1, L4, R2, L4, L2, L4, R2, L4, L1, L2, R1, R4, R3, R2, R2, R5, L1, L2");
		System.out.println(result);
	}

	public static int test(String s) {
		HashSet<String> set = new HashSet<String>();
		String[] parts = s.split(", ");
		int x = 0, y = 0, deltaX = 0, deltaY = 0;
		set.add("0,0");
		for (int i = 0; i < parts.length; ++i) {
			int delta = Integer.parseInt(parts[i].substring(1));
			if (parts[i].startsWith("R")) {
				// move right
				if (deltaX > 0) {
					deltaX = 0;
					deltaY = -delta;
				} else if (deltaX < 0) {
					deltaX = 0;
					deltaY = delta;
				} else if (deltaY > 0) {
					deltaX = delta;
					deltaY = 0;
				} else if (deltaY < 0) {
					deltaX = -delta;
					deltaY = 0;
				} else {
					deltaX = delta;
					deltaY = 0;
				}
			} else {
				// move left
				if (deltaX > 0) {
					deltaX = 0;
					deltaY = delta;
				} else if (deltaX < 0) {
					deltaX = 0;
					deltaY = -delta;
				} else if (deltaY > 0) {
					deltaX = -delta;
					deltaY = 0;
				} else if (deltaY < 0) {
					deltaX = delta;
					deltaY = 0;
				} else {
					deltaX = -delta;
					deltaY = 0;
				}
			}
			boolean found = false;
			if (deltaX != 0) {
				for (int j = 0; j < Math.abs(deltaX); ++j) {
					x = deltaX > 0 ? x + 1 : x - 1;
					String coord = x + "," + y;
					if (set.contains(coord)) {
						found = true;
						break;
					}
					set.add(coord);
				}
			} else {
				for (int j = 0; j < Math.abs(deltaY); ++j) {
					y = deltaY > 0 ? y + 1 : y - 1;
					String coord = x + "," + y;
					if (set.contains(coord)) {
						found = true;
						break;
					}
					set.add(coord);
				}
			}
			if (found) {
				break;
			}
		}
		return Math.abs(x) + Math.abs(y);
	}
}