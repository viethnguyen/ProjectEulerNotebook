package edu.rutgers.vietnguyen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayDeque;
import java.util.Queue;

public final class p008 extends EulerSolution {
	public final int probId = 8;
	public int probAns;
	private String inputFileName = "src/edu/rutgers/vietnguyen/p008_number.txt";
	
	@Override
	public void run() {
		

		
		try
		{
			
			Queue<Integer> curr5digits = new ArrayDeque<Integer>();
			
			BufferedReader br = new BufferedReader(new FileReader(inputFileName));
			int currProduct = 1;
			int maxProduct = 1;
			
			//initiate the queue with the first 5 digits
			for(int i = 0; i<5; i++)
			{
				int digit = (char)br.read() - '0';
				curr5digits.add(digit);
				currProduct *= digit;
				maxProduct = currProduct;
			}
			
			maxProduct = currProduct;
			int ch;
			
			while((ch = br.read())!= -1)
			{
				int newDigit = (char) ch - '0';
				curr5digits.add(newDigit);
				curr5digits.remove();
				currProduct = 1;
				for(int i : curr5digits)
				{
					currProduct *= i;
				}
				if(maxProduct < currProduct)
				{
					maxProduct = currProduct;
				}
			}
			
			
			System.out.println("result: " + maxProduct);
			
			br.close();
			probAns = maxProduct;
			AnswerUtilities.writeAnswer(probId, String.valueOf(probAns));
			
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}

		
	}

}
