//this is a practice program designed to teach programmers about switch-case steaments
//the program accepts user input and displays a day based on the entered number

import java.util.*;

public class SwitchToDay
{
	public static void main(String[] args) 
	{
		Scanner keysIn = new Scanner (System.in);
		System.out.printf("Enter a number from 1-7: ");
		int number = keysIn.nextInt();
		String day = "";
		
		if (numDay < 1 || numday > 7)  //using this if, we will validate the data before continuing to the switch, if invalid, this will exit the program
		{							   //in this case we will not need the default in the switch
			System.out.println("invalid number, try again");
			System.exit(0);
		}

		switch (number)
		{
			case 1:
				day = "Sunday";
				break;
			case 2:
				day = "Monday";
				break;
			case 3:
				day = "Tuesday";
				break;
			case 4:
				day = "Wednesday";
				break;
			case 5:
				day = "Thursday";
				break;
			case 6:
				day = "Friday";
				break;
			case 7:
				day = "Saturday";
				break;
			//default:
			//	day  = "an invalid input";
		}

		System.out.println(number + " is " + day);
	}
}