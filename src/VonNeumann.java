import java.math.BigInteger;

public class VonNeumann {
    private final BigInteger divider = new BigInteger("10001");
    private BigInteger seed;
    private String seedString;
    private String subString;
    private int count;

    public VonNeumann(BigInteger firstSeed) {
        this.seed = firstSeed;
    }

    public BigInteger next() {
        seed = seed.multiply(seed);
        seedString = seed.toString();
        count = seedString.length();

        if (seedString.length() >= 19) {
            if (count % 2 == 0) {
                subString = seedString.substring(5, 15);
            } else {
                subString = seedString.substring(4, 14);
            }
        } else {
            if (count % 2 == 0) {
                subString = seedString.substring(count / 4, count - count / 4);
            } else {
                subString = seedString.substring(count / 4 - 1, count - (count / 4 - 1));
            }
        }

        seed = BigInteger.valueOf(Long.parseLong(subString));
        return seed.mod(divider);
    }

    public BigInteger getSeed() {
        return this.seed;
    }

    public void setSeed(BigInteger seed) {
        this.seed = seed;
    }
}
