import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager("test.csv");
        Scanner input = new Scanner(System.in);
        int data;
        int option;
        BigInteger seed;

        System.out.println("Bienvenido a el programa, por favor especifique que generador quiere usar");
        System.out.println("Seleccione [1] para el metodo de Von Newman (cuadrado medio)");
        System.out.println("Seleccione [2] para el metodo Congruencial (Unix)");
        System.out.print("> ");
        option = input.nextInt();

        System.out.print("Ingrese la cantidad de numeros a generar: ");
        data = input.nextInt();

        System.out.print("Ingrese la semilla: ");
        seed = input.nextBigInteger();

        try {
            ArrayList<BigInteger> arrayList = new ArrayList<BigInteger>(data);
            switch (option) {
                case 1:
                    VonNeumann vonNeumannGenerator = new VonNeumann(seed);
                    for (int i = 0; i < data; ++i) {
                        arrayList.add(vonNeumannGenerator.next());
                    }
                    break;
                case 2:
                    UnixGLC unixGLCGenerator = new UnixGLC(seed);
                    for (int i = 0; i < data; ++i) {
                        arrayList.add(unixGLCGenerator.next());
                    }
                    break;
            }
            fileManager.write(arrayList);
        } catch (InputMismatchException e) {
            System.out.println(e);
        }

        input.close();
    }
}
