//this is a practice program designed to teach programmers about casting and converting
//the program shows how to convert string inputs into integers

import javax.swing.*;

public class CastExample2 
{
	public static void main(String[] args) 
	{
		int intVal;
		String strVal;

		strVal = JOptionPane.showInputDialog(null, "enter an integer");

		intVal = Integer.parseInt(strVal);
		
		System.out.println("The integer entered is: " + intVal);
		
		System.exit(0);
	}
}
