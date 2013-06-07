package edu.rutgers.vietnguyen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class p011 extends EulerSolution {
	public final int probId = 11;
	public int probAns;
	private final String inputFilename = "src/edu/rutgers/vietnguyen/p011_number.txt";
	private int[][] intArr = new int[50][50];
	
	@Override
	public void run() {
		BufferedReader br = null;
		int maxRow = 0;
		int maxCol = 0;
		try
		{
			br = new BufferedReader(new FileReader(inputFilename));
			int row = 0;
			int col = 0;

			String line;
			while((line = br.readLine())!= null)
			{
				String[] tokens = line.split("\\s+");
				for( int i = 0; i < tokens.length; i++)
				{
					try
					{
						int tmpInt = Integer.parseInt(tokens[i]);
						intArr[row][col++] = tmpInt;
					}
					catch(NumberFormatException ex)
					{
						
					}
				}
				if(maxCol < col ) maxCol = col;
				col = 0;
				row ++;
			}
			maxRow = row;
			br.close();
			
			System.out.println(findMax(intArr, maxRow, maxCol));
			
			probAns = findMax(intArr, maxRow, maxCol);
			AnswerUtilities.writeAnswer(probId, String.valueOf(probAns));
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	private int findMax (int[][] intArr, int maxRow, int maxCol)
	{
		int max = 0;
		for(int i = 0; i < maxRow - 4; i++)
		{
			for(int j = 0; j < maxCol - 4; j++)
			{
				//left to right;
				if(max < intArr[i][j] * intArr[i][j+1] * intArr[i][j+2] * intArr[i][j+3] )
					max = intArr[i][j] * intArr[i][j+1] * intArr[i][j+2] * intArr[i][j+3] ;
				
				//diagonally - top left to down right
				if(max < intArr[i][j] * intArr[i+1][j+1] * intArr[i+2][j+2] * intArr[i+3][j+3] )
					max = intArr[i][j] * intArr[i+1][j+1] * intArr[i+2][j+2] * intArr[i+3][j+3];
				
				//up to down
				if(max < intArr[i][j] * intArr[i+1][j] * intArr[i+2][j] * intArr[i+3][j] )
					max = intArr[i][j] * intArr[i+1][j] * intArr[i+2][j] * intArr[i+3][j]  ;
				
				//diagonally - top right to down left
				if(j >= 4)
				{
					if(max < intArr[i][j] * intArr[i+1][j-1] * intArr[i+2][j-2] * intArr[i+3][j-3] )
						max = intArr[i][j] * intArr[i+1][j-1] * intArr[i+2][j-2] * intArr[i+3][j-3];
				}
				
			}
		}
		return max;
	}
	
	

}
