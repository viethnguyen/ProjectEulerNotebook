package edu.rutgers.vietnguyen;

import java.util.HashMap;
import java.util.Map;

public final class p005 extends EulerSolution{
	
	public final int probId = 5;
	public int probAns;
	
	@Override
	public void run() {
		Map<Integer, Integer> totalPrimeFactors = new HashMap<Integer, Integer>();
		Map<Integer, Integer> tmpPrimeFactors;
		
		for(int i = 1; i <= 20; i++)
		{
			System.out.println("--Number: " + i);
			tmpPrimeFactors = primeFactors(i);
			for (Map.Entry<Integer, Integer> entry : tmpPrimeFactors.entrySet())
			{
				int key = entry.getKey();
				int value = entry.getValue();
				System.out.println("factor: " + key + ", freq: " + value);
				
				if(totalPrimeFactors.get(key) == null || totalPrimeFactors.get(key) < value)
				{
					totalPrimeFactors.put(key, value);
				}
			}
		}
		
		int result = 1;
		for(Map.Entry<Integer, Integer> entry: totalPrimeFactors.entrySet())
		{
			int key = entry.getKey();
			int value = entry.getValue();
			result = result * (int)Math.pow(key, value);
		}
		System.out.println("Smallest multiple : " + result);
		
		probAns = result;
		AnswerUtilities.writeAnswer(probId, String.valueOf(probAns));
	}

	/*
	 * return a map of prime factors together with their frequencies
	 * Algorithm: iterate from 2, 3, ... For each factor, check if number can be divided by it. If so, divide by this factor 
	 * until impossible.
	 * Also add the factor together with the frequency.
	 */
	private Map<Integer,Integer> primeFactors(int number)
	{
		Map<Integer,Integer> primeFactors = new HashMap<Integer, Integer>();
		int factor;
		int maxFactor;
		int count;
		
		if(number % 2 == 0)
		{
			count = 1;
			number = number / 2;
			while(number %2 == 0)
			{
				count ++;
				number = number / 2;
			}
			primeFactors.put(2, count);
		}
		factor = 3; 
		maxFactor = (int)Math.round(Math.sqrt(number));
		while(number > 1 && factor <= maxFactor)
		{
			if(number % factor == 0)
			{
				count = 1;
				number = number / factor;
				while(number % factor == 0)
				{
					count ++ ;
					number = number / factor;
				}
				primeFactors.put(factor,count);
				maxFactor = (int)Math.round(Math.sqrt(number));
			}
			factor = factor + 2;
		}
		
		//special case: number is a prime! 
		if(number != 1)
		{
			primeFactors.put(number, 1);
		}
		
		return primeFactors;
	}
}
