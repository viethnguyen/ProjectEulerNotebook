package edu.rutgers.vietnguyen;

public final class p012 extends EulerSolution{
	public final int probId = 12;
	public int probAns;
	
	@Override
	public void run() {
		int triangleNum = 0;
		int i = 0;
		while(true)
		{
			i ++ ;
			triangleNum += i;
			if(EulerLibrary.numDivisors(triangleNum) > 500)
			{
				System.out.println("Result: " + triangleNum);
				probAns = triangleNum;
				break;
			}
				
		}
		
		AnswerUtilities.writeAnswer(probId, String.valueOf(triangleNum));
	}
	
}
