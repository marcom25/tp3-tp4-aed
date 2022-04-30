import java.math.BigInteger;

public class RandomGenerator {

    public void vonNewman(BigInteger seed, int data) {
        int count = 0;
        String subString;
        String multipliedText;

        for (int i = 0; i < data; i++) {
            seed = seed.multiply(seed);

            multipliedText = String.valueOf(seed);
            count = multipliedText.length();

            if (count == 20) {
                subString = multipliedText.substring(5,15);    
            } else {	
                subString = multipliedText.substring(4,14);
            }
            
            seed = BigInteger.valueOf(Long.parseLong(subString));

            System.out.println("Seed multiplied "+ (i+1) + ": " + multipliedText);
            System.out.println("Seed "+ (i+1) + ": " + seed);
            System.out.println();
        }
    }



    public void congruential(BigInteger seed, int data) {
        BigInteger a = new BigInteger("1103515245");
        BigInteger c = new BigInteger("12345");
        BigInteger m = new BigInteger("" + (int) Math.pow(2, 32));
        
        for (int i = 0; i < data; i++) {
            seed = (seed.multiply(a).add(c)).mod(m);
            System.out.println("Seed: " + seed);
            System.out.println();
        }
        
    }
    
}
