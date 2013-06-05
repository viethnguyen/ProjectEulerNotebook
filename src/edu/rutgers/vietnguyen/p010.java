package edu.rutgers.vietnguyen;

import java.util.*;

public final class p010 extends EulerSolution{

	public final int probId = 10;
	public long probAns;
	
	@Override
	public void run() {
		BitSet b = EulerLibrary.lstPrime(2000000);
		long sum = 0;
		for(int i = 2; i <= 2000000; i ++)
		{
			if(b.get(i))
			{
				sum+=i;
			}
		}
		System.out.println("Sum: " + String.valueOf(sum));
		probAns = sum;
		
		AnswerUtilities.writeAnswer(probId, String.valueOf(probAns));
	}
	
}
