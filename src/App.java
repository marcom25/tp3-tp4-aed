
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        Scanner input = new Scanner(System.in);
        String fileName;
        int data;
        int option;
        BigInteger seed;

        while (true) {
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println("Bienvenido al programa");
            System.out.println("Seleccione [1] para generar numeros con el metodo de Von Newman (cuadrado medio)");
            System.out.println("Seleccione [2] para generar numeros con el metodo Congruencial (Unix)");
            System.out.println("Seleccione [3] para ordenar un archivo");
            System.out.println("Seleccione [4] para salir");
            System.out.print("> ");
            option = input.nextInt();
            
            if (option == 1 || option == 2) {

                System.out.print("Ingrese el nombre del archivo donde se guardarán los números: ");
                input.nextLine();
                fileName = input.nextLine();
                fileManager.setFileName(fileName);

                System.out.print("Ingrese la cantidad de numeros a generar: ");
                data = input.nextInt();

                System.out.print("Ingrese la semilla (maximo 10 digitos): ");
                seed = input.nextBigInteger();

                int lengthSeed = String.valueOf(seed).length();

                while (lengthSeed > 10) {
                    System.out.print("Error. Ingrese la semilla (maximo 10 digitos): ");
                    seed = input.nextBigInteger();

                    lengthSeed = String.valueOf(seed).length();
                }

                try {
                    ArrayList<BigInteger> arrayList = new ArrayList<BigInteger>(data);
                    
                    if (option == 1) {  
                        VonNeumann vonNeumannGenerator = new VonNeumann(seed);
                        for (int i = 0; i < data; ++i) {
                            arrayList.add(vonNeumannGenerator.next());
                        }
                    }else if (option == 2) {
                        UnixGLC unixGLCGenerator = new UnixGLC(seed);
                        for (int i = 0; i < data; ++i) {
                            arrayList.add(unixGLCGenerator.next());
                        }
                    }
   
                    fileManager.write(arrayList);
                }
                 catch (InputMismatchException e) {
                    System.out.println(e);
                }
               
            }else if (option == 3) {
                System.out.println("Ingrese el nombre del archivo para ordenar: ");
                System.out.print("> ");
                input.nextLine();
                fileName = input.nextLine();
                if (Objects.equals(fileName, fileManager.getFileName())) {
                    fileManager.setFileName(fileName);
                    fileManager.sortedFile();
                    System.out.println("El archivo '" + fileName + "-ordenado.csv' fue creado.");
                }else{
                    System.out.println("No existe el archivo csv.");
                }
            }else {
                return;
            }
        }
    }
}
