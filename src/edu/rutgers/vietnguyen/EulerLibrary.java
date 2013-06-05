package edu.rutgers.vietnguyen;

import java.util.BitSet;
import java.util.Iterator;
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
}
