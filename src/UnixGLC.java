import java.math.BigInteger;

public class UnixGLC {
    private final BigInteger a = new BigInteger("1103515245");
    private final BigInteger c = new BigInteger("12345");
    private final BigInteger m = new BigInteger("" + (int) Math.pow(2, 32));
    private BigInteger seed;

    public UnixGLC(BigInteger firstSeed) {
        this.seed = firstSeed;
    }

    public BigInteger next() {
        this.seed = (seed.multiply(a).add(c)).mod(m);
        return seed;
    }

    public BigInteger getSeed() {
        return this.seed;
    }

    public void setSeed(BigInteger seed) {
        this.seed = seed;
    }
}
