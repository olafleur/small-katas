import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            Path path = Paths.get(Main.class.getClassLoader().getResource("payments.dat").toURI());
            String s1 = Files.readAllLines(path).get(0);
            String s2 = Files.readAllLines(path).get(1);

            boolean isReadingName = true, isReadingAmount = false;

            Map<String, Integer> dueMap = new HashMap<>();
            String currentName = "";
            String currentAmount = "";
            for (char c : s1.toCharArray()) {
                if (isReadingName == true) {
                    if (c == ':') {
                        // Name is read
                        isReadingName = false;
                        isReadingAmount = true;
                    } else {
                        currentName = currentName + c;
                    }
                } else if (isReadingAmount == true) {
                    if (c == '|') {
                        // Amount read
                        isReadingName = true;
                        isReadingAmount = false;
                        dueMap.put(currentName, Integer.parseInt(currentAmount));
                        currentName = "";
                        currentAmount = "";
                    } else {
                        currentAmount = currentAmount + c;
                    }
                }
            }

            for (String s : dueMap.keySet()) {
                System.out.println(s + " : " + dueMap.get(s));
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
