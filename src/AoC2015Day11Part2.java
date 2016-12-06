public class AoC2015Day11Part2 {
	public static void main(String[] args) {
		String result;

		result = test("abcdefgh");
		assert (result.equals("abcdffaa"));
		System.out.println(result);

		result = test("ghijklmn");
		assert (result.equals("ghjaabcc"));
		System.out.println(result);

		result = test("hepxxyzz");
		System.out.println(result);
	}

	public static String test(String s) {
		System.out.println(s);
		char[] result = s.toCharArray();
		boolean found = false;
		for (int j = 0; j < 1000000000; ++j) {
			int add = 1;
			for (int i = s.length() - 1; i >= 0; --i) {
				char newChar = (char) (result[i] + add);
				if (newChar > 'z') {
					newChar = 'a';
					add = 1;
					result[i] = newChar;
				} else {
					result[i] = newChar;
					break;
				}
			}
			// System.out.println(j + " " + String.valueOf(result));
			// check result. if acceptable, break
			boolean acceptable = true;
			boolean foundInc = false;
			int index1 = -1, index2 = -1;
			for (int i = 0; acceptable && i < result.length; ++i) {
				acceptable = result[i] != 'i' && result[i] != 'l'
						&& result[i] != 'o';
				if (!foundInc) {
					if (i + 3 <= result.length) {
						foundInc = result[i] + 1 == result[i + 1]
								&& result[i + 1] + 1 == result[i + 2];
					}
				}
				if (index1 == -1 || index2 == -1) {
					if (i + 2 <= result.length) {
						if (result[i] == result[i + 1]) {
							if (index1 == -1) {
								index1 = i;
							} else {
								index2 = i;
							}
						}
					}
				}
			}
			if (acceptable && foundInc && index2 - index1 >= 2
					&& result[index1] != result[index2]) {
				found = true;
				break;
			}
		}
		return found ? String.valueOf(result) : "-1";
	}
}