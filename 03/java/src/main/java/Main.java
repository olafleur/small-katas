import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            Path path = Paths.get(Main.class.getClassLoader().getResource("payments.dat").toURI());
            String s1 = Files.readAllLines(path).get(0);
            String s2 = Files.readAllLines(path).get(1);

            boolean isReadingName = true, isReadingAmount = false;

            List<String> vips = new ArrayList<>();
            vips.add("rick");
            vips.add("matthew");

            Map<String, Integer> initialMap =  new HashMap<>();
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
                        initialMap.put(currentName, Integer.parseInt(currentAmount));
                        dueMap.put(currentName, Integer.parseInt(currentAmount));
                        currentName = "";
                        currentAmount = "";
                    } else {
                        currentAmount = currentAmount + c;
                    }
                }
            }

            for (char c : s2.toCharArray()) {
                if (isReadingName == true) {
                    if (c == ':') {
                        // Amount is read
                        isReadingName = false;
                        isReadingAmount = true;
                    } else {
                        currentName = currentName + c;
                    }
                } else if (isReadingAmount == true) {
                    if (c == '|') {
                        // Name read
                        isReadingName = true;
                        isReadingAmount = false;
                        dueMap.put(currentName, dueMap.get(currentName) - Integer.parseInt(currentAmount));
                        currentName = "";
                        currentAmount = "";
                    } else {
                        currentAmount = currentAmount + c;
                    }
                }
            }

            Iterator<String> i = dueMap.keySet().iterator();
            while(i.hasNext()) {
                String name = i.next();
                Integer due = dueMap.get(name);
                // VIPs be VIPs :)
                if (due == 0 || (vips.stream().filter((x) -> x.equals(name)).findFirst().isPresent() && due * 100 / initialMap.get(name) <= 10)) {
                    i.remove();
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
