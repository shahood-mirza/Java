//this is a practice program designed to teach programmers about integers and user input
//this program checks the inputted number and outputs a message of whether it is even or odd

import java.util.*;

public class IfStatements 
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner (System.in);
		int intNum;
		
		while(true)
		{
			System.out.printf("Enter a whole number: ");
			intNum = s.nextInt();

			if (intNum % 2 == 0)
				System.out.printf(intNum + " is Even\n");
			else
				System.out.printf(intNum + " is Odd\n");
		}
	}
}
