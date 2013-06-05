package edu.rutgers.vietnguyen;

public class p009 extends EulerSolution{
	public final int probId = 9;
	public int probAns;
	
	@Override
	public void run() {
		int a, b, c, maxb;
		for(a = 1; a <=333; a++ )
		{
			maxb = (1000 - a ) / 2;
			for(b = a+1; b <= maxb; b++)
			{
				c = 1000 - a - b;
				if(a * a + b * b == c * c)
				{
					reportResult(a,b,c);
					return;
				}	
			}
		}
		
	}

	private void reportResult(int a, int b, int c)
	{
		System.out.println("Found: a: "+ a + ", b: " + b + ", c: " +c);
		System.out.println("Product: " + a*b*c);
		probAns = a*b*c;
		AnswerUtilities.writeAnswer(probId, String.valueOf(probAns));
	}
}
