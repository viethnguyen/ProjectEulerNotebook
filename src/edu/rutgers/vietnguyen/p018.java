package edu.rutgers.vietnguyen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class p018 extends EulerSolution{
	public final int probId = 18;
	public int probAns;
	private final String inputFilename = "src/edu/rutgers/vietnguyen/p018_number.txt";
	private final int NLINES = 15;
	@Override
	public void run() {
		BufferedReader br = null;
		int [][] triangle = new int[NLINES][NLINES];
		int [][] maxSum = new int[NLINES][NLINES];
		int nlines = 0;
		try
		{
			br = new BufferedReader(new FileReader(inputFilename));
			String line;
			int row = 0;
			int col = 0;
			while((line = br.readLine())!=null)
			{
				String[] tokens = line.split("\\s+");
				for(int i = 0; i < tokens.length; i++)
				{				
					System.out.printf("%d ", Integer.parseInt(tokens[i]));
					triangle[row][col++] = Integer.parseInt(tokens[i]);
				}
				System.out.println();
				row++;	
				col = 0;
			}
			nlines = row;	//number of lines in this triangle
				
			//init max sum for the last lines
			for(int i = 0; i < nlines; i ++)
			{
				maxSum[nlines - 1][i] = triangle[nlines - 1][i];
			}
			
			//fill the max sum, from bottom to top
			for(row = nlines - 2; row >= 0; row --)
			{
				for(col = 0; col <= row; col++ )
				{
					maxSum[row][col] = triangle[row][col] + ((maxSum[row+1][col] > maxSum[row+1][col+1]? maxSum[row+1][col] : maxSum[row+1][col+1]));
				}	
			}
			

			probAns = maxSum[0][0];
			System.out.println("Result: " + probAns);
			AnswerUtilities.writeAnswer(probId, String.valueOf(probAns));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	

}
