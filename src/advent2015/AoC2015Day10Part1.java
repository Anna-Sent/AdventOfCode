package advent2015;
public class AoC2015Day10Part1 {
	public static void main(String[] args) {
		int result;

		result = test("1");
		System.out.println(result);

		result = test("1113122113");
		System.out.println(result);
	}

	public static int test(String s) {
		System.out.println(s);
		for (int i = 0; i < 40; ++i) {
			String result = "";
			for (int j = 0; j < s.length();) {
				char countedSym = s.charAt(j);
				int count = 0;
				do {
					++j;
					++count;
				} while (j < s.length() && countedSym == s.charAt(j));
				result += String.valueOf(count) + String.valueOf(countedSym);
			}
			s = result;
			// System.out.println(s);
		}
		int len = s.length();
		return len;
	}
}