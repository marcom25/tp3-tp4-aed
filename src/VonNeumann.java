import java.math.BigInteger;

public class VonNeumann {
    private BigInteger seed;
    private int seedDigits;
    private BigInteger newSeed;
    private String newSeedString;
    private int newSeedDigits;
    private String newSeedMiddle;

    public VonNeumann(BigInteger firstSeed) {
        this.seed = firstSeed;
    }

    public BigInteger next() throws IllegalArgumentException {
        // cantidad de digitos de la semilla
        seedDigits = this.seed.toString().length();

        if (seedDigits > 10) {
            throw new IllegalArgumentException("semilla mayor a 10 dígitos");
        }

        newSeed = this.seed.multiply(this.seed);
        newSeedString = newSeed.toString();
        // cantidad de digitos del cuadrado de la semilla
        newSeedDigits = newSeedString.length();

        // si la nueva semilla tiene un digito menos
        // que el doble de digitos de la semilla usada,
        // le insertamos un 0 al inicio para que la cantidad
        // de digitos sea par;
        // asi podemos dejar la misma cantidad de digitos
        // de un lado y del otro del numero "cortado" al medio
        if (newSeedDigits == (seedDigits * 2) - 1) {
            newSeedString = "0" + newSeedString;
            newSeedDigits = newSeedString.length();
        }

        newSeedMiddle = newSeedString.substring(newSeedDigits / 4, newSeedDigits - (newSeedDigits / 4));
        this.seed = new BigInteger(newSeedMiddle);

        return this.seed;
    }

    public BigInteger getSeed() {
        return this.seed;
    }

    public void setSeed(BigInteger seed) {
        this.seed = seed;
    }
}
