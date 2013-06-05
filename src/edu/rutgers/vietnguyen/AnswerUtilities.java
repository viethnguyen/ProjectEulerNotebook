package edu.rutgers.vietnguyen;

import java.io.*;
import java.util.regex.*;

public class AnswerUtilities {
	private final static String answerFileName = "Answer.txt";
	private final static String tmpFileName = "_Answer.txt";
	
	public static void writeAnswer(int probId, String answer)
	{	
		try
		{	
			File file;
			BufferedReader in;

			PrintWriter out;
			
			if(isAnswerExisted(probId)) 
			{
				System.out.print ("Answer to problem " + probId + " existed! Do you want to override? (y/n):  ");
				BufferedReader in_br = new BufferedReader(new InputStreamReader(System.in));
				String ans = in_br.readLine();
				if(ans.equals("n"))
				{
					System.out.println("Your answer has been aborted!");
					return;
				}
			}
			
			//Check if answer file is exist. If not, create it, and write the first answer
			file = new File(answerFileName);
			if(!file.exists())
			{
				file.createNewFile();
				out = new PrintWriter(new BufferedWriter(new FileWriter(answerFileName)));
				printAnswer(out, probId, answer);
				out.close();
				System.out.println("Answer to problem " + probId + " has been written!");
				return;
			}	
			
			//Read the answer file, copy the content to a temp file. 
			//Insert new answer in correct order. 
			in = new BufferedReader(new FileReader(answerFileName));
			out = new PrintWriter(new BufferedWriter( new FileWriter( tmpFileName, true)));
			Pattern p = Pattern.compile("Problem [^:]*:");
			String line;
			int prevProbId = 0;
			int currProbId = 0;
			boolean isInserted = false;
			
			while((line = in.readLine())!= null)
			{
				Matcher m = p.matcher(line);
				if(m.find()) 
				{
					Pattern p2 = Pattern.compile("[0-9]+");
					Matcher m2 = p2.matcher(m.group());
					if(m2.find())
					{
						String probIdStr = m2.group();
						prevProbId = currProbId;
						currProbId = Integer.parseInt(probIdStr);
					}
					
					if(currProbId == probId)
					{
						//overwrite the answer
						printAnswer(out, probId, answer);
						isInserted = true;
					}
					else if((prevProbId < probId) && (currProbId > probId))
					{
						//insert
						printAnswer(out, probId, answer);
						out.println(line);
						isInserted = true;
					}
					else 
					{
						//otherwise copy as source
						out.println(line);
					}
				}
			}
			if(!isInserted)
			{
				printAnswer(out, probId, answer);
			}
			in.close();
			out.close();
			
			//delete the old answer file
			file = new File(answerFileName);
			file.delete();
			
			//move back content from tmpFile to answerFile.
			in = new BufferedReader(new FileReader(tmpFileName));
			out = new PrintWriter(new BufferedWriter( new FileWriter( answerFileName, true)));
			while((line = in.readLine()) != null)
			{
				out.println(line);
			}
			
			in.close();
			out.close();
			
			//delete the temp file
			file = new File(tmpFileName);
			file.delete();
			
			System.out.println("Answer to problem " + probId + " has been written!");
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	private static void printAnswer(PrintWriter out, int probId, String answer )
	{
		out.println("Problem " + probId + ": " + answer);
	}
	
	public static boolean isAnswerExisted(int probId)
	{
		File file = new File(answerFileName);
		if (file.exists() == false)
			return false;
		
		try
		{
			Pattern p = Pattern.compile("Problem [^:]*:");
			BufferedReader in = new BufferedReader(new FileReader(answerFileName));
			String line;
			while((line = in.readLine())!= null)
			{
				Matcher m = p.matcher(line);
				if(m.find()) 
				{
					Pattern p2 = Pattern.compile(Integer.toString(probId));
					Matcher m2 = p2.matcher(m.group());
					if(m2.find())
					{
						in.close();
						return true;
					}
				}
			}
			in.close();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		
		return false;
	}
}
