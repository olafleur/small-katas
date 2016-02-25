using System;
using NUnit.Framework;
using FluentAssertions;

namespace csharp
{
	[TestFixture]
	public class HumanoidTests
	{
		[Test]
		public void test()
		{
			true.Should ().BeTrue ();
		}
	}
}
