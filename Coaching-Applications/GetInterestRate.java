//this is a practice program designed to teach programmers about if statements, user input and conditional operators
//the program does a basic investment calculation

import java.util.Scanner;

public class GetInterestRate 
{
	public static void main(String[] args) 
	{
		double total, rate, amount, years;

		Scanner keysIn = new Scanner(System.in);

		System.out.print("Enter the Amount Invested: ");
		amount = keysIn.nextDouble();
		
		System.out.print("Enter the Years Investing: ");
		years = keysIn.nextDouble();

		if (years >= 5)
			rate = 0.0475;
		else if (years >= 4)
			rate =  0.045;
		else if (years >= 3)
			rate =  0.04;
		else if (years >= 2)
			rate =  0.035;
		else if (years >= 1)
			rate =  0.03;
		else
			rate =  0.025;
		
		total = amount * rate;

		System.out.printf("\nYour interest per year would be: $%1.2f\n", total);
		System.out.println("At an interest rate of: " + (rate * 100) + "%\n");
	}
}