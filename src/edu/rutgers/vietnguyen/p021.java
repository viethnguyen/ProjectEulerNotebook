package edu.rutgers.vietnguyen;

import java.util.BitSet;

public final class p021 extends EulerSolution{
	public final int probId = 21;
	public int probAns;
	
	@Override
	public void run() {
		BitSet b = new BitSet(10000);
		for(int i = 1; i< 10000; i++)
		{
			b.set(i);
		}
		for(int i = 1; i < 10000; i++)
		{
			if(b.get(i))
			{
				int sumDiv = EulerLibrary.sumDivisors(i);
				if (sumDiv == i)
					b.clear(i);
				if(sumDiv >= 10000)
					b.clear(i);
				if(i != EulerLibrary.sumDivisors(sumDiv))
					b.clear(i);
			}
		}
		int sum = 0;
		for(int i = 1; i < 10000; i++)
		{
			if(b.get(i))
			{
				sum+=i;
			}
		}
		probAns = sum;
		
		System.out.println("Result: " + probAns);
		AnswerUtilities.writeAnswer(probId, String.valueOf(probAns));
	}
	

}
