package edu.rutgers.vietnguyen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public final class p013 extends EulerSolution {
	public final int probId = 13;
	public int probAns;
	private final String inputFilename = "src/edu/rutgers/vietnguyen/p013_number.txt";
	
	@Override
	public void run() {
		BufferedReader br = null;
		int[] tmpSum = new int[50]; //store sum of each digit column
		int additionalAmount = 0; //memorized from each column to the column to the left.	
		for(int i = 0; i < 50; i ++)
		{
			tmpSum[i] = 0;
		}
		try
		{
			br = new BufferedReader( new FileReader(inputFilename));
			String line;
			while((line = br.readLine())!=null)
			{
				for(int i = 0; i < line.length(); i ++)
				{
					tmpSum[i] += (line.charAt(i) - '0');
				}
				
			}
			
			for(int i = 49; i >0; i --)
			{
				tmpSum[i] += additionalAmount;
				additionalAmount = tmpSum[i] / 10;
				tmpSum[i] = tmpSum[i] % 10;
			}
			
			//column 0 is special
			tmpSum[0] += additionalAmount;
			
			String ans = "";
			ans = ans.concat(String.valueOf(tmpSum[0]));
			int index = 1;
			while(ans.length() < 10)
			{
				ans = ans.concat(String.valueOf(tmpSum[index++]));
			}
			System.out.println("First 10 digits: " + ans);
			AnswerUtilities.writeAnswer(probId, ans);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	
}
