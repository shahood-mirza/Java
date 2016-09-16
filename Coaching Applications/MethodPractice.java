import java.util.*;

public class  MethodPractice
{
/*
program that asks the user to enter a two values, then finds and calculates the total
as well as the average of the accepted values.
NOTE: use one function to calculate total, another function to calculate the average
NOTE: all values must be diplayed from the main()
*/

	public static void main(String[] args) 
	{
		Scanner in = new Scanner (System.in);

		double num1, num2, total, average;

		printString("Enter the first number: ");
		num1 = in.nextDouble();
		
		printString("Enter the second number: ");
		num2 = in.nextDouble();

		total = calcTotal(num1, num2);
		printNum("The total is: ", total);

		average = calcAverage(total);
		printNum("The average is: ", average);
	}
	public static void printString(String s)
	{
		System.out.printf(s);
	}

	public static void printNum(String s, double n)
	{
		System.out.println(s + n);
	}

	public static double calcTotal(double n1, double n2)
	{
		return n1 + n2;
	}

	public static double calcAverage(double t)
	{
		return t/2;
	}

}