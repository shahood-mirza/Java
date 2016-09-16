//this is a practice program designed to teach programmers about basic exception handling in java
//the program shows how certain exceptions can be handled gracefully

import java.util.*;

public class  ExceptionHandling
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner (System.in);

		int a, b;
		double res;
		
		try
		{
			System.out.printf("enter an integer: ");
			a = in.nextInt();

			System.out.printf("enter an integer: ");
			b = in.nextInt();

			res = (double) a / b;

			System.out.println("the result is: " + res);
		}
		catch (Exception e)
		{
			System.out.println("You either either entered a value that cannot be converted into number, or your second number is zero");
			System.out.println(e.toString());
		}
	}
}
