package edu.rutgers.vietnguyen;

import java.util.*;

public final class p003  extends EulerSolution{

	public final int probId = 3;
	public int probAns;
	
	private List<Integer> lstPrimes = new LinkedList<Integer>();
	
	@Override
	public void run() {
		probAns = largestPrimeFactor(Long.parseLong("600851475143"));
		System.out.println(probAns);
		AnswerUtilities.writeAnswer(probId, probAns);
	}

	private int largestPrimeFactor(long number)
	{
		int res = 1;
		long upperBound = Math.round(Math.sqrt(number));
		updatePrimeList(upperBound);
		ListIterator<Integer> ite = lstPrimes.listIterator();
		while(ite.hasNext())
		{
			int primeToCheck = ite.next().intValue();
			if( ( number % primeToCheck == 0 ) && ( res < primeToCheck) )
			{
				res = primeToCheck;
			}
		}
		return res;
	}
	
	private void updatePrimeList(long upperBound)
	{
		lstPrimes.clear();
		boolean isPrime;
		
		for(int numberToCheck = 2; numberToCheck < upperBound; numberToCheck++)
		{
			isPrime = true;
			ListIterator<Integer> ite = lstPrimes.listIterator();
			while(ite.hasNext())
			{
				if(numberToCheck % ite.next().intValue() == 0)
				{
					isPrime = false;
					break;
				}
			}
			if(isPrime)
			{
				lstPrimes.add(numberToCheck);
			}
		}
	}
}
