//this is a practice program designed to teach programmers about method overloading and how it can be useful

import java.util.*;

public class  MethodOverloading
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner (System.in);
		
		int intTot;
		double doubleTot;

		intTot = calculateTotal(55, 77);
		printValue(intTot);

		doubleTot = calculateTotal(55.5, 77.2);
		printValue(doubleTot);
	}

	public static int calculateTotal (int num1, int num2)
	{
		int total = num1 + num2;
		printValue(num1);
		printValue(num2);
		return total;
	}
	
	public static double calculateTotal (double num1, double num2)
	{
		double total = num1 + num2;
		printValue(num1);
		printValue(num2);
		return total;
	}

	public static void printValue (int val)
	{
		System.out.println("the value is: " + val);
	}

	public static void printValue (double val)
	{
		System.out.println("the value is: " + val);
	}
}
