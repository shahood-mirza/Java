//this is a practice program designed to teach programmers about scanner inputs
//the program teaches how to use the scanner and when/how to clear its buffer

import java.util.Scanner;

/*
there is no need to clear the buffer if you read a numeric value

there is no need to clear the buffer if this is the first time you 
call nextLine - the buffer is empty

there is no need to clear the buffer if a call to nextLine was made
just prior to the current statement - because nextLine reads entire 
buffer, including any enter keys the might have been there

your MUST clear the buffer if you read a numeric value from the console
and are attempting to use nextLine to read a string
*/

public class  TryScanner
{
	public static void main(String[] args) 
	{
// do we need to clear the buffer at this point? - NO

		System.out.println("what is your age? ");

		int intAge = keysIn.nextInt();

// do we need to clear the buffer at this point? - YES

		System.out.println("Enter your first name: ");
		keysIn.nextLine(); // clear the buffer
		String strFirst = keysIn.nextLine();

// do we need to clear the buffer at this point? - NO

		System.out.println("Enter your last name: ");
		String strLast = keysIn.nextLine();

		System.out.println("your age is: " + intAge + " and your name is: " + strFirst + " " + strLast);

////////////////////////////////////////////////////////////////////////////////////////

		Scanner keysIn = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		int num = keysIn.nextInt();
		System.out.println("Your int: " + num);
		
		System.out.println("---------");
		System.out.println("Enter a floating-point value:");
		double num2 = keysIn.nextDouble();
		System.out.println("Your floating-point: " + num2);
		
		System.out.println("---------");
		System.out.println("Now enter a string.");
		//clear the buffer
		keysIn.nextLine();
		String str = keysIn.nextLine();
		System.out.println(str);

	}
}