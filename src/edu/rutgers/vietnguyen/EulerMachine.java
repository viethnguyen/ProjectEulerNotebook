package edu.rutgers.vietnguyen;

public class EulerMachine {

	/**
	 * This is the MAIN class, use to call the solver to each problem
	 * ALL START HERE!! 
	 */
	public static void main(String[] args) {
		//Test
		TestEulerLibrary.testPrimeFactors();
		TestEulerLibrary.testNumDivisors();
		TestEulerLibrary.testSumDivisors();
		
		//run Euler solutions
		new p020().run();
	}

}
