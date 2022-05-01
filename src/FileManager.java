import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class FileManager {
    private String fileName;
    
    public String getFileName(){
        return this.fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public ArrayList<BigInteger> read() {
        ArrayList<BigInteger> numbers = new ArrayList<BigInteger>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                numbers.add(new BigInteger(line.split(",")[0]));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }

    public void write(ArrayList<BigInteger> numbers) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".csv"));

            for (int i = 0; i < numbers.size(); ++i) {
                writer.write(numbers.get(i) + "\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  public void sortedFile() {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    try {
        //  READ
        String filePath = "./"+ fileName + ".csv";
        File file = new File(filePath);

        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt((line.split(",")[0])));
            }
            reader.close();
    
            numbers = (ArrayList<Integer>) MergeSort.sort(numbers);

            //  WRITE
            String newFileName = fileName + "-ordenado.csv";
            BufferedWriter writer = new BufferedWriter(new FileWriter(newFileName));

            for (int i = 0; i < numbers.size(); ++i) {
                writer.write(numbers.get(i) + "\n");
            }
            System.out.println("El archivo '" + newFileName + "' fue creado.");
            writer.close();
        }else {
            System.out.println("El archivo '" + fileName + ".csv' no existe.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}