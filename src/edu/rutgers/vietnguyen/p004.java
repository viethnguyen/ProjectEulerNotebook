package edu.rutgers.vietnguyen;

public final class p004 extends EulerSolution {
	public final int probId = 4;
	public int probAns;
	
	
	@Override
	public void run() {
		int factor1 = 1;
		int factor2 = 1;
		for(int i = 100; i < 1000; i++)
		{
			for(int j = i; j < 1000; j++)
			{
				if(isPalindrome(Integer.toString(i*j)) && probAns < i*j)
				{
					probAns = i * j;
					factor1 = i;
					factor2 = j;
				}
			}
		}
		System.out.println(probAns);
		System.out.println(factor1);
		System.out.println(factor2);
		
		AnswerUtilities.writeAnswer(probId, String.valueOf(probAns));
	}
	
	/**
	 * check if an integer number is a palindromic number
	 * @param number a String represents an integer number
	 * @return true if the number is read the same both ways, false otherwise
	 */
	private boolean isPalindrome(String number)
	{
		StringBuilder sb = new StringBuilder(number);
		if (number.equals(sb.reverse().toString()))
			return true;
		else return false;
	}
	

}
