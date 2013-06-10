package edu.rutgers.vietnguyen;

import java.util.BitSet;

public final class p014 extends EulerSolution{
	public final int probId = 14;
	public int probAns;
	
	@Override
	public void run() {
		probAns = longestCollatzStartNum(1000000);
		System.out.println("Starting number, under one million, that produces the longest Collatz chain: " + longestCollatzStartNum(1000000));
		AnswerUtilities.writeAnswer(probId, String.valueOf(probAns));
	}

	/**
	 * Return the starting number, which is under upperBound, produces the longest Collatz chain
	 * Algorithm: Use BitSet to mark potential answer. Iterate from 2 to upperBound, do Collatz operations, clear bit corresponding to the number 
	 * in the sequence (as this number cannot be the starting of the longest Collatz chain). 
	 * @param upperBound
	 * @return starting number which produces the longest Collatz chain
	 */
	private int longestCollatzStartNum(int upperBound)
	{
		BitSet b = new BitSet(upperBound+1);
		int result = 1;
		int count;
		int countLongest = 0;
		int i ;
		for(i = 2; i <= upperBound; i ++ )
			b.set(i);
		i = 2; 
		while(i <= upperBound)
		{
			if(b.get(i))
			{
				long j = i;
				count = 1;
				while(j != 1)
				{
					if(j % 2 == 0)
						j = j / 2;
					else
						j = 3*j+1;
					
					count ++ ;
					
					if(j < upperBound)
						b.clear((int)j);
				}
				if(countLongest < count)
				{
					countLongest = count;
					result = i;
				}
			}
			i++;
		}
		return result;
	}
}
