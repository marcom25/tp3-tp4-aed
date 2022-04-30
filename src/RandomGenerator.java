import java.math.BigInteger;

public class RandomGenerator {
    private final BigInteger a = new BigInteger("1103515245");
    private final BigInteger c = new BigInteger("12345");
    private final BigInteger m = new BigInteger("" + (int) Math.pow(2, 32));

    public BigInteger vonNewman(BigInteger seed) {
        int count = 0;
        String subString;
        String multipliedText;

        seed = seed.multiply(seed);
        multipliedText = String.valueOf(seed);
        count = multipliedText.length();

        if (count == 20) {
            subString = multipliedText.substring(5, 15);
        } else {
            subString = multipliedText.substring(4, 14);
        }

        return BigInteger.valueOf(Long.parseLong(subString));
    }

    public BigInteger congruential(BigInteger seed, int data) {
        return (seed.multiply(a).add(c)).mod(m);
    }

}
