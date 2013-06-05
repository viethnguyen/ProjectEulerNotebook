package edu.rutgers.vietnguyen;

public final class p006 extends EulerSolution{
	public final int probId = 6;
	public int probAns;
	
	@Override
	public void run() {
		probAns = difference(100);
		System.out.println("result: " + probAns);
		AnswerUtilities.writeAnswer(probId, String.valueOf(probAns));
	}
	
	/*
	 * Calculate the difference between (1^2 + 2^2 + ... + n^2) and (1+2+3+...+n)^2
	 */
	private int difference(int n)
	{
		int result = n * (n+1) / 2;
		result = result * result;
		for(int i = 1; i <=n; i++)
		{
			result = result - i*i;
		}
		return result;
	}

}
