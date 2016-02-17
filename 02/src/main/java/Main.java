import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String csvFile = System.getProperty("user.dir") + "/src/main/resources/input.csv";
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {
                String[] truc = line.split(",");

                System.out.println(truc[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
