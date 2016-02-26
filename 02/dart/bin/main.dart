import 'package:dart/stats_calculator.dart';

main() {
  print("Les équipes dont l'âge moyen est en dessous de la moyenne sont:");
  getTeamsUnderAgeAverage().forEach(print);
  print('');
  print(
      "Les équipes dont le nombre de points moyen est au-dessus de la moyenne sont:");
  getTeamsOverPointsAverage().forEach(print);
}
