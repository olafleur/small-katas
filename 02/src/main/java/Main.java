public class Main {

    public static void main(String[] args) {
        System.out.println("Les équipes dont l'âge moyen est en dessous de la moyenne sont :");
        StatsCalculator.getTeamsUnderAgeAverage().forEach(System.out::println);
        System.out.println("");
        System.out.println("Les équipes dont le nombre de points moyen est au-dessus de la moyenne sont :");
        StatsCalculator.getTeamsOverPointsAverage().forEach(System.out::println);
    }
}
