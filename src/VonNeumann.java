import java.math.BigInteger;

public class VonNeumann {
    private BigInteger seed;
    private BigInteger divider = new BigInteger("10001");
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

        if (count % 2 == 0) {
            subString = multipliedText.substring(count/4 , count - count/4);
        } else {
            subString = multipliedText.substring(count/4 , count - count/4);
        }

        this.seed = BigInteger.valueOf(Long.parseLong(subString));
        System.out.println(seed);
        return seed.mod(divider);
    }

    public BigInteger getSeed() {
        return this.seed;
    }

    public void setSeed(BigInteger seed) {
        this.seed = seed;
    }
}
