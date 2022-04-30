import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class FileManager {
    private final String FILENAME;

    public FileManager(String filename) {
        this.FILENAME = filename + ".csv";
    }

    public ArrayList<BigInteger> read() {
        ArrayList<BigInteger> numbers = new ArrayList<BigInteger>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
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
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME));

            for (int i = 0; i < numbers.size(); ++i) {
                writer.write(numbers.get(i) + "\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
