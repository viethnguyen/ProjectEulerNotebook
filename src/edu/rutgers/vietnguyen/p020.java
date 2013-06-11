package edu.rutgers.vietnguyen;

import java.math.BigInteger;

public final class p020 extends EulerSolution{
	public final int probId = 20;
	public int probAns;
	
	@Override
	public void run() {
		BigInteger b = BigInteger.valueOf(1);
		for(int i = 2; i <= 100; i ++ )
		{
			b = b.multiply(BigInteger.valueOf(i));
		}
		String strRes = b.toString();
		int sum = 0;
		for(int i = 0 ; i < strRes.length(); i ++)
		{
			sum += strRes.charAt(i) - '0';
		}
		probAns = sum;
		System.out.println("Result: " + probAns);
		AnswerUtilities.writeAnswer(probId, String.valueOf(probAns));
	}
	

}
