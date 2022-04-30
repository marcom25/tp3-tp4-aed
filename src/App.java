import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        RandomGenerator randomGenerator = new RandomGenerator();
        Scanner input = new Scanner(System.in);
        int data;
        int option;
        BigInteger seed;


        System.out.println("Bienvenido a el programa, por favor especifique que generador quiere usar");
        System.out.println("Seleccione [1] para el metodo de Von Newman (cuadrado medio)");
        System.out.println("Seleccione [2] para el metodo Congruencial (Unix)");
        
        option = input.nextInt();

        System.out.print("Ingrese la cantidad de numeros a generar: ");
        data = input.nextInt();

        System.out.print("Ingrese la semilla: ");
        seed = input.nextBigInteger();    
       

        try {
            switch (option) {
                case 1:
                        randomGenerator.vonNewman(seed, data);
                    break;
                case 2:
                        randomGenerator.congruential(seed, data);
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println(e);
        }
        
        input.close();
    }
}
 