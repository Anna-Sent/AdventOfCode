package advent2015;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class AoC2015Day4Part1 {
    public static void main(String[] args) {
        int result;

        result = test("abcdef");
        assert result == 609043;
        System.out.println(result);

        result = test("pqrstuv");
        assert result == 1048970;
        System.out.println(result);

        result = test("iwrupvqb");
        System.out.println(result);
    }

    public static int test(String s) {
        for (int i = 1; i < 2000000; ++i) {
            String ss = s + i;
            try {
                MessageDigest digest = MessageDigest.getInstance("MD5");
                digest.update(ss.getBytes());
                byte[] bytes = digest.digest();
                String hash = String.format(Locale.US, "%032x", new BigInteger(
                        1, bytes));
                if (hash.startsWith("00000")) {
                    return i;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        return -1;
    }
}