//this is a practice program designed to teach programmers about float and double calculations and string concatenation

class Testing2
{
	/*
		create a java program that will first calculate the total of the three floating point values and then calculate
		the average of those values. display the output in a user friendly format
	*/

	public static void main(String[] args) 
	{
		//declare five variables with one statement
		double num1, num2, num3, total, average;
		//initialize the variables
		num1 = 5.4;
		num2 = 3.9;
		num3 = 2.3;
		//calculate the total
		total = num1 + num2 + num3;
		//calculate the average
		average = total / 3;
		//display the result
		System.out.println("the total of " + num1 + " and " + num2 + " and " + num3 + " is equal to " + total + " and the average is equal to " + average);
	}
}
