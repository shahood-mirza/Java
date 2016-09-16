//this is a practice program designed to teach programmers about basic exception handling in java
//the program shows how certain exceptions can be handled gracefully

import javax.swing.*;

public class ExceptionHandling2 
{
	public static void main(String[] args) 
	{
		String in = JOptionPane.showInputDialog(null, "enter a String");

		try
		{
			int val = Integer.parseInt(in);
			System.out.println("the integer is: " + val);
		}
		catch (Exception e)
		{
			System.out.println("please enter an integer");
		}
		finally
		{
			System.out.println("an example of basic exception handling");
		}
	}
}
