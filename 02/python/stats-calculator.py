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






print(StatsCalculator.get_teams_under_age_average())