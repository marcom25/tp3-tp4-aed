import java.math.BigInteger;

public class RandomGenerator {
    FileManager fileManager = new FileManager();

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

            
        }
    }



    public void congruential(BigInteger seed, int data) {
        BigInteger a = new BigInteger("1103515245");
        BigInteger c = new BigInteger("12345");
        BigInteger m = new BigInteger("" + (int) Math.pow(2, 32));
        
        for (int i = 0; i < data; i++) {
            seed = (seed.multiply(a).add(c)).mod(m);
           
        }
        
    }
    
    
}
