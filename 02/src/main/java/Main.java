public class Main {

    public static void main(String[] args) {
        for (String team : StatsCalculator.getTeamsUnderAgeAverage()) {
            System.out.println(team);
        }
    }
}
