import java.math.BigInteger;

public class RandomGenerator {

    public static BigInteger vonNewman(BigInteger seed) {

        return null;
    }

    public static BigInteger congruential(BigInteger seed) {
        BigInteger a = new BigInteger("1103515245");
        BigInteger c = new BigInteger("12345");
        BigInteger m = new BigInteger("" + (int) Math.pow(2, 32));
        
        return seed = (seed.multiply(a).add(c)).mod(m);

        
    }
    
}
