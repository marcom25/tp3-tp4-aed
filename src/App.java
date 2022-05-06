import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    // generar números entre 0 y LIMIT - 1
    private static final BigInteger LIMIT = new BigInteger("10001");

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();

        try (Scanner input = new Scanner(System.in)) {
            String fileName;
            int data;
            int option;
            BigInteger seed;

            while (true) {
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("Bienvenido al programa.");
                System.out.println("Ingrese [1] para generar números con el método de Von Newman (cuadrado medio).");
                System.out.println("Ingrese [2] para generar números con el método Congruencial (Unix).");
                System.out.println("Ingrese [3] para ordenar un archivo.");
                System.out.println("Ingrese cualquier otra tecla para salir.");
                System.out.print("> ");
                option = input.nextInt();

                if (option == 1 || option == 2) {
                    System.out.print("Ingrese el nombre del archivo donde se guardarán los números: ");
                    input.nextLine();
                    fileName = input.nextLine();
                    fileManager.setFileName(fileName);

                    System.out.print("Ingrese la cantidad de números a generar: ");
                    data = input.nextInt();

                    System.out.print("Ingrese la semilla (máximo 10 dígitos): ");
                    seed = input.nextBigInteger();

                    int seedLength = seed.toString().length();
                    while (seedLength > 10) {
                        System.out.print("Por favor, ingrese la semilla (máximo 10 dígitos): ");
                        seed = input.nextBigInteger();

                        seedLength = seed.toString().length();
                    }

                    List<BigInteger> list = new ArrayList<BigInteger>(data);
                    if (option == 1) {
                        VonNeumann vonNeumannGenerator = new VonNeumann(seed);
                        for (int i = 0; i < data; ++i) {
                            list.add(vonNeumannGenerator.next().mod(LIMIT));
                        }
                    } else {
                        UnixGLC unixGLCGenerator = new UnixGLC(seed);
                        for (int i = 0; i < data; ++i) {
                            list.add(unixGLCGenerator.next().mod(LIMIT));
                        }
                    }
                    fileManager.write(list);

                } else if (option == 3) {
                    System.out.print("Ingrese el nombre del archivo para ordenar: ");
                    input.nextLine();
                    fileName = input.nextLine();
                    fileManager.setFileName(fileName);
                    fileManager.sortFile();

                } else {
                    return;
                }
            }
        } catch (InputMismatchException e) {
            return;
        }
    }
}
