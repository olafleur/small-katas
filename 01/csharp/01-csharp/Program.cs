using System;

namespace csharp
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			Humanoid humanoid1 = new Humanoid();
			humanoid1.HumanoidType = "Lady with high heels";
			humanoid1.Walk();

			Humanoid humanoid2 = new Humanoid();
			humanoid2.HumanoidType = "Ninja";
			humanoid2.Walk();

			Humanoid humanoid3 = new Humanoid();
			humanoid3.HumanoidType = "Pirate";
			humanoid3.Walk();

			Humanoid humanoid4 = new Humanoid();
			humanoid4.HumanoidType = "Robot";
			humanoid4.Walk();

			Humanoid humanoid5 = new Humanoid();
			humanoid5.HumanoidType = "Regular human";
			humanoid5.Walk();
		}
	}
}
