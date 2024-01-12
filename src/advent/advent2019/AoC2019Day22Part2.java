package advent.advent2019;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2019Day22Part2 {

    public static void main(String[] args) {
        BigInteger result;

        String input = "deal with increment 5\n" +
                "cut 9569\n" +
                "deal with increment 22\n" +
                "cut -9977\n" +
                "deal with increment 64\n" +
                "cut -4758\n" +
                "deal with increment 12\n" +
                "cut 8507\n" +
                "deal with increment 7\n" +
                "cut -4724\n" +
                "deal with increment 3\n" +
                "cut 7577\n" +
                "deal with increment 20\n" +
                "cut -1543\n" +
                "deal into new stack\n" +
                "deal with increment 62\n" +
                "deal into new stack\n" +
                "deal with increment 62\n" +
                "cut 4879\n" +
                "deal into new stack\n" +
                "deal with increment 34\n" +
                "cut 3555\n" +
                "deal with increment 8\n" +
                "cut -6954\n" +
                "deal with increment 32\n" +
                "cut -4299\n" +
                "deal into new stack\n" +
                "deal with increment 70\n" +
                "cut -5387\n" +
                "deal with increment 32\n" +
                "deal into new stack\n" +
                "cut -5074\n" +
                "deal into new stack\n" +
                "deal with increment 14\n" +
                "cut -1405\n" +
                "deal with increment 40\n" +
                "cut 4665\n" +
                "deal with increment 42\n" +
                "deal into new stack\n" +
                "deal with increment 20\n" +
                "cut 5945\n" +
                "deal with increment 73\n" +
                "cut 9777\n" +
                "deal with increment 32\n" +
                "cut 4783\n" +
                "deal into new stack\n" +
                "deal with increment 63\n" +
                "cut -3388\n" +
                "deal with increment 18\n" +
                "cut 6364\n" +
                "deal with increment 34\n" +
                "cut -7962\n" +
                "deal into new stack\n" +
                "cut -5937\n" +
                "deal with increment 70\n" +
                "cut -3600\n" +
                "deal with increment 46\n" +
                "deal into new stack\n" +
                "cut -3460\n" +
                "deal with increment 61\n" +
                "cut 8430\n" +
                "deal with increment 33\n" +
                "cut -9068\n" +
                "deal into new stack\n" +
                "deal with increment 75\n" +
                "cut 3019\n" +
                "deal with increment 5\n" +
                "cut -2963\n" +
                "deal with increment 59\n" +
                "cut -2973\n" +
                "deal with increment 64\n" +
                "cut 3203\n" +
                "deal with increment 13\n" +
                "cut -9915\n" +
                "deal with increment 60\n" +
                "cut 5823\n" +
                "deal with increment 26\n" +
                "cut 2255\n" +
                "deal with increment 35\n" +
                "cut -8491\n" +
                "deal with increment 75\n" +
                "cut -8065\n" +
                "deal with increment 38\n" +
                "cut 8417\n" +
                "deal with increment 75\n" +
                "cut 7005\n" +
                "deal into new stack\n" +
                "deal with increment 67\n" +
                "deal into new stack\n" +
                "cut -896\n" +
                "deal into new stack\n" +
                "cut -7243\n" +
                "deal into new stack\n" +
                "deal with increment 29\n" +
                "cut -4407\n" +
                "deal with increment 63\n" +
                "cut -8660\n" +
                "deal into new stack\n" +
                "cut 7411\n" +
                "deal into new stack";

        result = test(BigInteger.valueOf(10007), BigInteger.valueOf(1), BigInteger.valueOf(8326), input);
        assert result.equals(BigInteger.valueOf(2019)) : "unexpected result is " + result;
        System.out.println(result);

        result = test(BigInteger.valueOf(119315717514047L), BigInteger.valueOf(101741582076661L), BigInteger.valueOf(2020), input);
        assert result.equals(BigInteger.valueOf(43781998578719L)) : "unexpected result is " + result;
        System.out.println(result);
    }

    private static final Pattern cutPattern = Pattern.compile("cut (-?\\d+)");
    private static final Pattern stackPattern = Pattern.compile("deal into new stack");
    private static final Pattern incrementPattern = Pattern.compile("deal with increment (-?\\d+)");

    private static BigInteger test(BigInteger length, BigInteger n, BigInteger x, String s) {
        BigInteger y = f(length, x, s);
        BigInteger z = f(length, y, s);
        BigInteger A = y.subtract(z).multiply(x.subtract(y).modInverse(length));
        BigInteger B = y.subtract(A.multiply(x));
        BigInteger An = A.modPow(n, length);
        return An.subtract(BigInteger.ONE).multiply(B).multiply(A.subtract(BigInteger.ONE).modInverse(length))
                .add(x.multiply(An)).mod(length);
    }

    private static BigInteger f(BigInteger length, BigInteger index, String s) {
        String[] tokens = s.split("\n");
        for (int i = tokens.length - 1; i >= 0; --i) {
            String token = tokens[i];
            Matcher matcher;
            matcher = cutPattern.matcher(token);
            if (matcher.matches()) {
                int p = Integer.parseInt(matcher.group(1));
                index = index.add(BigInteger.valueOf(p)).add(length).mod(length);
                continue;
            }
            matcher = stackPattern.matcher(token);
            if (matcher.matches()) {
                index = length.subtract(index).subtract(BigInteger.ONE);
                continue;
            }
            matcher = incrementPattern.matcher(token);
            if (matcher.matches()) {
                int p = Integer.parseInt(matcher.group(1));
                assert p > 0 : "invalid input";
                index = BigInteger.valueOf(p).modInverse(length).multiply(index).mod(length);
                continue;
            }
            assert false : "invalid input " + token;
        }
        return index;
    }
}
