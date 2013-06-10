package edu.rutgers.vietnguyen;

public final class p015 extends EulerSolution{
	public final int probId = 15;
	public int probAns;
	@Override
	public void run() {
		AnswerUtilities.writeAnswer(probId, String.valueOf(f(20,20)));
	}
	
	//recursive -- too slow!!  
	private long f(int row, int col)
	{
		if(row == 1)
			return (col + 1);
		if(col == 1)
			return (row + 1);
		
		return f(row - 1, col) + f(row, col -1);
	}

}
