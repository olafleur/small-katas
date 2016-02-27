using System;
using System.IO;
using System.Collections.Generic;
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

		public static void Main (string[] args)
		{
			var path = "payments.dat";
			var s1 = ReadFrom (path).ToList () [0];
			var s2 = ReadFrom (path).ToList () [1];

			var isReadingName = true;
			var isReadingAmount = false;

			var vips = new List<String> ();
			vips.Add ("rick");
			vips.Add ("matthew");

			var initialMap = new Dictionary<String, int> ();
			var dueMap = new Dictionary<String, int> ();
			var currentName = "";
			var currentAmount = "";
			foreach (var c in s1.ToCharArray()) {
				if (isReadingName == true) {
					if (c == ':') {
						isReadingName = false;
						isReadingAmount = true;
					} else {
						currentName = currentName + c;
					}
				} else if (isReadingAmount == true) {
					if (c == '|') {
						// Amount is read
						isReadingName = true;
						isReadingAmount = false;
						initialMap [currentName] = int.Parse (currentAmount);
						dueMap [currentName] = int.Parse (currentAmount);
						currentName = "";
						currentAmount = "";
					} else {
						currentAmount = currentAmount + c;
					}
				}
			}
  			
			foreach (var c in s2.ToCharArray()) {
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
						dueMap [currentName] = dueMap [currentName] - int.Parse (currentAmount);
						currentName = "";
						currentAmount = "";
					} else {
						currentAmount = currentAmount + c;
					}
				}
			}

			var toRemove = new List<String> ();
			foreach (var key in dueMap.Keys) {
				var name = key;
				var due = dueMap [name];

				// VIPs be VIPs :)
				if (due == 0 || (vips.Where (x => x == name).Any () && due * 100 / initialMap [name] <= 10)) {
					toRemove.Add (name);
				}
			}

			toRemove.ForEach (x => dueMap.Remove (x));

			foreach (var s in dueMap.Keys) {
				Console.WriteLine(String.Format("{0} : {1}", s, dueMap[s]));
			}
		}
	}
}
