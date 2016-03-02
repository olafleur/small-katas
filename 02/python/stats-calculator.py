# coding=utf-8
import os
import csv

class StatsCalculator:
    def __init__(self):
        pass

    @staticmethod
    def get_teams_under_age_average():
        csv_file = os.getcwd() + "/input.csv"
        counter = 0
        somme = 0
        teams = []

        with open('input.csv', 'rb') as csvfile:
            spamreader = csv.reader(csvfile, delimiter=',', quotechar='|')
            for truc in spamreader:
                if counter > 0:
                    age = float(truc[2])

                    somme += age
                counter = counter+1

        # Lire l'autre fichier
        moyenne = somme / counter
        counter = 0

        with open('input.csv', 'rb') as csvfile:
            spamreader = csv.reader(csvfile, delimiter=',', quotechar='|')
            for truc in spamreader:
                if counter > 0:
                    age = float(truc[2])

                    if age >= moyenne:
                        pass
                    else:
                        teams.append(truc[1])
                counter = counter+1

        return teams


    @staticmethod
    def get_teams_over_points_average():
        csv_file = os.getcwd() + "/input.csv"
        counter = 0
        somme = 0
        teams = []

        with open('input.csv', 'rb') as csvfile:
            spamreader = csv.reader(csvfile, delimiter=',', quotechar='|')
            for truc in spamreader:
                if counter > 0:
                    points = int(truc[7])

                    somme += points
                counter = counter+1

        # Lire l'autre fichier
        moyenne = float(somme) / counter
        counter = 0

        with open('input.csv', 'rb') as csvfile:
            spamreader = csv.reader(csvfile, delimiter=',', quotechar='|')
            for truc in spamreader:
                if counter > 0:
                    points = int(truc[7])

                    if points > moyenne:
                        teams.append(truc[1])
                counter = counter+1

        return teams


print("Les équipes dont l'âge moyen est en dessous de la moyenne sont :")
for team in StatsCalculator.get_teams_under_age_average():
    print team
print ""
print("Les équipes dont le nombre de points moyen est au-dessus de la moyenne sont :")
for team in StatsCalculator.get_teams_over_points_average():
    print team