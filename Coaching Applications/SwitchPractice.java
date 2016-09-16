//this is a practice program designed to teach programmers about switch-case and if-else statements
//the program compares switch-case to if-else to show the differences between both methods

import java.util.*;

public class SwitchPractice 
{
	public static void main(String[] args) 
	{
		Scanner keysIn = new Scanner (System.in);

		System.out.println("MENU");
		System.out.println("1. run winword");
		System.out.println("2. run excel");
		System.out.println("3. exit");
		System.out.printf("Enter your choice:_ ");

		int choice = keysIn.nextInt();

		switch (choice)
		{
			case 1:
			//case 11:						 //if using 2 or more values for one result, this is how it will be written, NOTE: AND/OR etc. operators can not be used
				System.out.println("run winword.......");
				break;
			case 2:
				System.out.println("run excel.......");
				break;
			case 3:
				System.out.println("exit from program........");
				break;
			default:
				System.out.println("Invalid choice, please re-enter");
		}

		if (choice == 1)                 // this if is the same as the above switch, but which looks simpler?
			System.out.println("run winword.......");
		else if (choice == 2)
			System.out.println("run excel.......");
		else if (choice == 3)
			System.out.println("exit from program........");
		else
			System.out.println("Invalid choice, please re-enter");
	}
}
