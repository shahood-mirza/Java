//this is a practice program designed to teach programmers about if statements, user input and conditional operators
//the program takes a percentage grade and converts it to a letter

import java.util.Scanner;

public class GetLetterGrade 
{
	public static void main(String[] args) 
	{
		Scanner keysIn = new Scanner(System.in);
		System.out.print("Enter the final grade: ");
		double grade = keysIn.nextDouble();
		String letter = "";

		if (grade < 50)
		{
			letter = "F";
		}
		else if (grade >= 50 && grade < 60)  //without the second condition (&&) the code will never go further than grade 'D'
		{
			letter = "D";
		} 
		else if (grade >= 60 && grade < 65)
		{
			letter = "C";
		}
		else if (grade >= 65 && grade < 70)
		{
			letter = "C+";
		}
		else if (grade >= 70 && grade < 75)
		{
			letter = "B";
		}
		else if (grade >= 75 && grade < 80)
		{
			letter = "B+";
		}
		else if (grade >= 80 && grade < 90)
		{
			letter = "A";
		}
		else //if (grade >= 90)
		{
			letter = "A+";
		}

		System.out.println("Letter grade: " + letter);
	}
}