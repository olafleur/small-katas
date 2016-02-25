using System;

namespace csharp
{
	public class Humanoid
	{
		public String HumanoidType {
			get;
			set;
		}

		public void Walk() {
			if (HumanoidType.Equals("Lady with high heels")) {
				Console.WriteLine("TOC! TOC! TOC!");
			} else {
				if (HumanoidType.Equals("Ninja")) {
					Console.WriteLine("...");
				} else {
					if (HumanoidType.Equals("Pirate")) {
						Console.WriteLine("Tap, toc, tap, toc.");
					} else {
						if(HumanoidType.Equals("Robot")) {
							Console.WriteLine("Bzz, bang, bzzz, bang");
						} else {
							if(HumanoidType.Equals("Regular human")) {
								Console.WriteLine("Tap, tap, tap, tap");
							}
						}
					}
				}
			}
		}
	}
}
