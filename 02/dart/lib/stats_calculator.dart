import 'dart:io';

List<String> getTeamsUnderAgeAverage() {
  var csvFile = 'input.csv';
  var somme = 0.0;
  var counter = 0;
  var teams = <String>[];

  var myFile = new File(csvFile);

  var lines = myFile.readAsLinesSync();

  lines.removeAt(0);

  for (var line in lines) {
    var truc = line.split(',');

    var age = double.parse(truc[2]);

    somme += age;
    counter++;
  }

  // Lire l'autre fichier
  var moyenne = somme / counter;

  var myFile2 = new File(csvFile);

  lines = myFile2.readAsLinesSync();

  lines.removeAt(0);

  for (var line in lines) {
    var truc = line.split(',');

    var age = double.parse(truc[2]);

    if (age >= moyenne) {
      /* do nothing */
    } else {
      teams.add(truc[1]);
    }
  }

  return teams;
}

List<String> getTeamsOverPointsAverage() {
  var csvFile = 'input.csv';
  var somme = 0.0;
  var counter = 0;
  var teams = <String>[];

  var myFile = new File(csvFile);

  var lines = myFile.readAsLinesSync();

  lines.removeAt(0);

  for (var line in lines) {
    var truc = line.split(',');

    var points = int.parse(truc[7]);

    somme += points;
    counter++;
  }

  // Lire l'autre fichier
  var moyenne = somme / counter;

  var myFile2 = new File(csvFile);

  lines = myFile2.readAsLinesSync();

  lines.removeAt(0);

  for (var line in lines) {
    var truc = line.split(',');

    var points = int.parse(truc[7]);

    if (points > moyenne) {
      teams.add(truc[1]);
    }
  }

  return teams;
}
