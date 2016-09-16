//this is a practice program designed to give programmers an introduction to methods

import java.util.*;

public class  Methods
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner (System.in);
		
		int val1 = 4;
		int val2 = 7;
		int tot = 0;

		tot = calculateTotal(val1, val2);
		
		printValue(tot);
	}

	public static int calculateTotal (int num1, int num2)
	{
		int total = num1 + num2;
		printValue(num1);
		printValue(num2);
		return total;  //in a non-void method you must have a return statement or there will be an error
	}

	public static void printValue (int val)
	{
		System.out.println("the value is: " + val);
		//return;  //in a void method you can use return but only for empty values, it can NOT return any values
	}
}
