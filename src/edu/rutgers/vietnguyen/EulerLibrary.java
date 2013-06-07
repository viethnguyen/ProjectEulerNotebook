package edu.rutgers.vietnguyen;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class EulerLibrary {
	public static int findPrimeAt(int index)
	{
		Set<Integer> lstPrime = new TreeSet<Integer>();
		lstPrime.add(2);
		int count = 1;
		int numberToCheck = 3;
		boolean isPrime ;
		while(count < index)
		{
			isPrime = true;
			Iterator<Integer> ite = lstPrime.iterator();
			while(ite.hasNext())
			{
				int factor = ite.next();
				if(numberToCheck % factor == 0)
				{
					isPrime = false;
					break;
				}
			}
			if(isPrime)
			{
				count ++;
				lstPrime.add(numberToCheck);
			}
			numberToCheck += 2;
		}
		return (numberToCheck - 2);
	}
	
	/*
	 * Eratosthenes sieve 
	 * Using a BitSet to store list of primes under upperBound
	 */
	public static BitSet lstPrime(int upperBound)
	{
		BitSet b = new BitSet(upperBound + 1);
		int i;
		for(i = 2; i <= upperBound ; i++)
			b.set(i);
		i = 2;
		while(i*i <= upperBound)
		{
			if(b.get(i))
			{
				int k = 2 * i;
				while(k<=upperBound)
				{
					b.clear(k);
					k+=i;
				}
			}
			i++;
		}
		return b;
	}
	
	/**
	 * Find prime factors of a number, together with their frequencies
	 * @param num
	 * @return a map with a key is a prime, a value is its frequency
	 */
	public static Map<Integer,Integer> primeFactors(int num)
	{
		Map<Integer,Integer> listPrime = new HashMap<Integer,Integer>();
		int count = 0;
		int factor; 
		if(num % 2 == 0)
		{
			count = 1;
			num = num / 2;
			while(num % 2 == 0)
			{
				count ++;
				num = num / 2;
			}
			listPrime.put(2, count);
		}
		factor = 3;
		while(factor <= num)
		{
			if( num % factor == 0)
			{
				count = 1;
				num = num / factor;
				while(num % factor == 0)
				{
					count ++;
					num = num / factor;
				}
				listPrime.put(factor,count);
			}
			factor += 2;
		}
		return listPrime;
	}
	
	/**
	 * Return number of divisors of a number
	 * @param num
	 * @return number of divisors
	 */
	
	public static int numDivisors(int num)
	{
		int res = 1;
		Map<Integer, Integer> lstPrime = primeFactors(num);
		for(Map.Entry<Integer, Integer> entry : lstPrime.entrySet())
		{
			int freq = entry.getValue();
			res *= (freq + 1);
		}
		return res;
	}
}
