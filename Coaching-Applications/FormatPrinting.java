//this is a practice program designed to teach programmers about basic calculations with the math library and output formatting

import java.text.DecimalFormat;
import java.util.*;

public class FormatPrinting 
{
	public static void main(String[] args) 
	{
		double dblNum1 = 4.5;
		double dblNum2 = 3.33;
		double dblRes = dblNum1 / dblNum2;

		System.out.println("the result is: " + dblRes);

		int res = 5 + 7;
		System.out.println("the result is " + res + "and it was calculated"); //originally concatenation was used
		//System.out.printf("the result is PLACEHOLDER", VALUE FOR PLACEHOLDER); //now we can use placeholders

		int intV = 5;
		float fltV = 5.5f;
		double dblV = 3.5;
		String strV = "Computer";
		
		System.out.printf("int: %d, flt: %f, dbl: %f, str: %s\n\n", intV, fltV, dblV, strV);

		double dblRes2 = intV + fltV + dblV;
		//print result as the value of the variable
		System.out.printf("the result is %f\n\n", dblRes2);
		//print result as the static value
		System.out.printf("the result is %f\n\n", 14.0);
		//print result as a calculation
		System.out.printf("the result is %f\n\n", intV + fltV + dblV);

		//lengths
		System.out.printf(">123456789<\n");
		System.out.printf(">%9d<\n", 345);
		System.out.printf(">%-9d<\n", 345);
		System.out.printf(">%9.1f<\n", 45.6789);
		System.out.printf(">%-9.1f<\n", 45.6789);
		System.out.printf(">%9s<\n", "Java");
		System.out.printf(">%-9s<\n", "Java");

		//what is going to happen when the length of the value exceeds the length specified in the placeholder
		System.out.printf(">%9.1f<\n", 12345467891233.45676);
		//it will still be printed in full, no truncation will occur


		//Formatting numbers
		DecimalFormat f = new DecimalFormat ("$###,###.00");
		double a = 12345.67;
		System.out.printf(f.format(a)+ "\n");

		//Math library
		System.out.println("The value of PI is " + Math.PI + "\n\n\n\n");

		//formula for calculating the area of a circle is pi*r^2

		//Step 1 - create a scanner
		Scanner s = new Scanner (System.in);
		
		//Step 2 - prompt for the value of the radius and accept it
		//create a variable of the double type and save the accepted value in it
		System.out.printf("Enter the value of Radius: ");
		double dblRad = s.nextDouble();
		
		//Step 3 - calculate the area
		double dblArea = Math.PI * Math.pow(dblRad, 2);
		
		//Step 4 - display result
		System.out.printf("The radius is %5.2f and the area is %5.2f\n\n", dblRad, dblArea);
	}
}
