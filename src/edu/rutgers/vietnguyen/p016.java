package edu.rutgers.vietnguyen;

import java.math.BigInteger;

public final class p016 extends EulerSolution {
	public final int probId = 16;
	public int probAns;
	
	@Override
	public void run() {
		probAns = calcResult();

		System.out.println("Result: " + probAns);
		AnswerUtilities.writeAnswer(probId, String.valueOf(probAns));
	}

	//break 2^1000 into product of some of 10 terms: 
	//2^1, 2^2, 2^4, 2^8, 2^16, 2^32, 2^64, 2^128, 2^256, 2^512
	private int calcResult()
	{
		String s = Integer.toBinaryString(1000);
		BigInteger b = BigInteger.valueOf(2);
		BigInteger res = BigInteger.valueOf(1);
		int len = s.length();
		for(int i = len - 1; i >=0; i --)
		{
			if(s.charAt(i) == '1')
			{
				res = res.multiply(b);
			}
			
			b = b.pow(2);
		}
		String strRes = res.toString();
		len = strRes.length();
		int sum = 0;
		for(int i = 0; i < len; i ++)
		{
			sum += strRes.charAt(i) - '0';
		}
		return sum;
	}
}
