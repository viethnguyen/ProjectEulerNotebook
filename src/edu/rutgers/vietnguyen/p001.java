package edu.rutgers.vietnguyen;

public final class p001 extends EulerSolution{

	public final int probId = 1;
	public int probAns;
	
	@Override
	public void run() {
		int sum = 0;
		for(int i = 1; i < 1000; i ++ )
		{
			if((i % 3 == 0 ) || (i % 5 == 0))
			{
				sum += i;
			}
		}
		probAns = sum;
		AnswerUtilities.writeAnswer(probId, String.valueOf(probAns));
	}
	
}
