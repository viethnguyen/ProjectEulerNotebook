package edu.rutgers.vietnguyen;

public class p002 extends EulerSolution{

	public final int probId = 2;
	public int probAns;
	
	@Override
	public void run() {
		int sum = 0;
		int term1 = 1;
		int term2 = 1;
		int currTerm = term1 + term2;
		while(currTerm <= 4000000)
		{
			if(currTerm %2 == 0)
			{
				sum += currTerm;
			}
			term1 = term2;
			term2 = currTerm;
			currTerm = term1 + term2; 
		}
		probAns = sum;
		AnswerUtilities.writeAnswer(probId, probAns);
	}
	
	
	
}
