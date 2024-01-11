package advent2016;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class AoC2016Day5Part2 {
    public static void main(String[] args) {
        String result;

        result = test("abc");
        assert result.equals("05ace8e3");
        System.out.println(result);

        result = test("ugkcyxxp");
        assert result.equals("f2c730e5");
        System.out.println(result);
    }

    public static String test(final String s) {
        final char[] password = new char[8];

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            for (int i = 0; i < 1000000000; ++i) {
                String ss = s + i;
                digest.update(ss.getBytes());
                byte[] bytes = digest.digest();
                String hash = String.format(Locale.US, "%032x", new BigInteger(
                        1, bytes));
                if (hash.startsWith("00000")) {
                    int index = hash.charAt(5) - '0';
                    if (index >= 0 && index < 8 && password[index] == 0) {
                        password[index] = hash.charAt(6);
                        System.out.println("found character " + index + ": "
                                + password[index]);
                        boolean completed = true;
                        for (int j = 0; completed && j < 8; ++j) {
                            completed = completed && password[j] != 0;
                        }
                        if (completed) {
                            break;
                        }
                    }
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return String.valueOf(password);
    }
}