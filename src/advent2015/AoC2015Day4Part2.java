package advent2015;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class AoC2015Day4Part2 {
    public static void main(String[] args) {
        int result;

        result = test("iwrupvqb");
        System.out.println(result);
    }

    public static int test(String s) {
        for (int i = 9000000; i < 100000000; ++i) {
            String ss = s + i;
            try {
                MessageDigest digest = MessageDigest.getInstance("MD5");
                digest.update(ss.getBytes());
                byte[] bytes = digest.digest();
                String hash = String.format(Locale.US, "%032x", new BigInteger(
                        1, bytes));
                if (hash.startsWith("000000")) {
                    return i;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        return -1;
    }
}