using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace Application
{
	class MainClass
	{
		static IEnumerable<String> ReadFrom(string file)
		{
			string line;
			using(var reader = File.OpenText(file)) 
			{
				while ((line = reader.ReadLine ()) != null) 
				{
					yield return line;
				}
			}
		}


		static List<String> getTeamsUnderAgeAverage() {
			var csvFile = "input.csv";
			var somme = 0.0;
			var counter = 0;
			var teams = new List<String> ();

			var lines = ReadFrom (csvFile).ToList();

			lines.RemoveAt (0);

			foreach (var line in lines) {
				var truc = line.Split (',');
				var age = double.Parse (truc [2]);

				somme += age;
				counter++;
			}

			// Lire l'autre fichier
			var moyenne = somme / counter;

			lines = ReadFrom(csvFile).ToList();
			lines.RemoveAt (0);

			foreach (var line in lines) {
				var truc = line.Split (',');

				var age = double.Parse (truc [2]);

				if (age >= moyenne) {
					/* do nothing */
				} else {
					teams.Add (truc [1]);
				}
			}

			return teams;
	}


		static List<String> GetTeamsOverPointsAverage() {
			var csvFile = "input.csv";
			var somme = 0.0;
			var counter = 0;
			var teams = new List<String> ();

			var lines = ReadFrom (csvFile).ToList();

			lines.RemoveAt (0);

			foreach (var line in lines) {
				var truc = line.Split (',');
				var points = double.Parse (truc [7]);


				somme += points;
				counter++;
			}

			// Lire l'autre fichier
			var moyenne = somme / counter;

			lines = ReadFrom(csvFile).ToList();
			lines.RemoveAt (0);

			foreach (var line in lines) {
				var truc = line.Split (',');

				var points = double.Parse (truc [7]);

				if (points >= moyenne) {
					/* do nothing */
				} else {
					teams.Add (truc [1]);
				}
			}

			return teams;
		}

		static void Main(String[] args) {
			Console.WriteLine ("Hello world!");
		}
	}
}
