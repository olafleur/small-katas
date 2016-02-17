import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StatsCalculator {
    static List<String> getTeamsUnderAgeAverage() {
        String csvFile = System.getProperty("user.dir") + "/src/main/resources/input.csv";
        String line;
        Double somme = 0.0;
        int counter = 0;
        List<String> teams = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));

            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] truc = line.split(",");

                double age = Double.valueOf(truc[2]);

                somme += age;
                counter++;

            }

            // Lire l'autre fichier
            double moyenne = somme / counter;

            BufferedReader br2 = new BufferedReader(new FileReader(csvFile));

            br2.readLine();

            while ((line = br2.readLine()) != null) {
                String[] truc = line.split(",");

                double age = Double.valueOf(truc[2]);

                if(age >= moyenne) {
                   /* do nothing */
                } else {
                    teams.add(truc[1]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return teams;
    }

    List<String> getTeamsOverPointsAverage() {
        return null;
    }
}
