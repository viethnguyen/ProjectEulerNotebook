package edu.rutgers.vietnguyen;

public class TestEulerLibrary {
	public static void testPrimeFactors()
	{
		assert(EulerLibrary.primeFactors(10).containsKey(2));
		assert(EulerLibrary.primeFactors(10).containsKey(5));
		
	}
	
	public static void testNumDivisors()
	{
		assert(EulerLibrary.numDivisors(1) == 1);
		assert(EulerLibrary.numDivisors(3) == 2);
		assert(EulerLibrary.numDivisors(6) == 4);
		assert(EulerLibrary.numDivisors(10) == 4);
		assert(EulerLibrary.numDivisors(15) == 4);
		assert(EulerLibrary.numDivisors(21) == 4);
		
	}
}
