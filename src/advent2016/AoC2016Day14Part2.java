package advent2016;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AoC2016Day14Part2 {
	public static void main(String[] args) {
		int result;

		result = test("abc", 64);
		assert (result == 22551);
		System.out.println(result);

		result = test("ihaygndm", 64);
		assert (result == 19968);
		System.out.println(result);
	}

	public static int test(String s, int index) {
		int count = 0;
		for (int i = 0; i < 2000000; ++i) {
			try {
				String hash1 = getHash(s, i);
				char letter = containsThreeLetters(hash1);
				if (letter != '\0') {
					for (int j = i + 1; j <= i + 1000; ++j) {
						String hash2 = getHash(s, j);
						if (containsFiveLetters(hash2, letter)) {
							++count;
							if (count == index) {
								return i;
							} else {
								System.out.println(count + " key " + i + " "
										+ j);
								break;
							}
						}
					}
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}

		return -1;
	}

	static Map<Integer, String> map = new HashMap<Integer, String>();

	private static String getHash(String s, int number)
			throws NoSuchAlgorithmException {
		Integer key = Integer.valueOf(number);
		if (map.containsKey(key)) {
			return map.get(key);
		} else {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			String hash = s + number;
			for (int i = 0; i <= 2016; ++i) {
				digest.update(hash.getBytes());
				byte[] bytes = digest.digest();
				hash = String.format(Locale.US, "%032x", new BigInteger(1,
						bytes));
			}
			map.put(key, hash);
			return hash;
		}
	}

	private static char containsThreeLetters(String s) {
		for (int i = 0; i <= s.length() - 3; ++i) {
			char letter = s.charAt(i);
			boolean found = true;
			for (int j = 0; found && j < 3; ++j) {
				found = s.charAt(i + j) == letter;
			}
			if (found) {
				return letter;
			}
		}
		return '\0';
	}

	private static boolean containsFiveLetters(String s, char letter) {
		for (int i = 0; i <= s.length() - 5; ++i) {
			boolean found = true;
			for (int j = 0; found && j < 5; ++j) {
				found = s.charAt(i + j) == letter;
			}
			if (found) {
				return true;
			}
		}
		return false;
	}
}