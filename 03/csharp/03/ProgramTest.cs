using System;
using NUnit.Framework;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using FluentAssertions;

namespace Application
{
	[TestFixture]
	public class ProgramTest
	{
		private class PrintInterceptor : StringWriter {
			public List<String> getLines()
			{
				var sb = GetStringBuilder ();
				var result = sb.ToString ();

				var splitted = result.Split ('\n');

				return splitted.ToList ();
			}
		}	

		[Test]
		public void BasicTest ()
		{
			// given
			var printInterceptor = new PrintInterceptor();
			Console.SetOut(printInterceptor);

			// when
			MainClass.Main(null);

			// then
			var outputLines = printInterceptor.getLines();

			outputLines.ElementAt (0).Should ().Be ("rick : 50");
			outputLines.ElementAt (1).Should ().Be ("josh : 5");
		}
	}
}

