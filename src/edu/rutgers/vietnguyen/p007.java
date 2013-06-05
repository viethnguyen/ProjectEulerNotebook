package edu.rutgers.vietnguyen;

public final class p007 extends EulerSolution {

	public final int probId = 7;
	public int probAns;
	
	@Override
	public void run() {
		probAns = EulerLibrary.findPrimeAt(10001);
		System.out.println("answer: " + probAns);
		AnswerUtilities.writeAnswer(probId, String.valueOf(probAns));
	}
	
}
