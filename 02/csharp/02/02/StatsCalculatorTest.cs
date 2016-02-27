using System;
using FluentAssertions;
using NUnit.Framework;

namespace Application
{
	[TestFixture]
	public class StatsCalculatorTest
	{
		[Test]
		public void BasicTest ()
		{
			true.Should ().BeFalse ();
		}
	}
}

