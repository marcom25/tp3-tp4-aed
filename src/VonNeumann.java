import java.math.BigInteger;

public class VonNeumann {
    private BigInteger seed;
    private int count;
    private String subString;
    private String multipliedText;

    public VonNeumann(BigInteger firstSeed) {
        this.seed = firstSeed;
    }

    public BigInteger next() {
        seed = seed.multiply(seed);
        multipliedText = String.valueOf(seed);
        count = multipliedText.length();

        if (count == 20) {
            subString = multipliedText.substring(5, 15);
        } else {
            subString = multipliedText.substring(4, 14);
        }

        this.seed = BigInteger.valueOf(Long.parseLong(subString));
        return seed;
    }

    public BigInteger getSeed() {
        return this.seed;
    }

    public void setSeed(BigInteger seed) {
        this.seed = seed;
    }
}
