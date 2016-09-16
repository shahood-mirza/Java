//this is a practice program designed to teach programmers about casting and converting
//the program shows how cast string values into double format with a GUI

import javax.swing.*;

public class CastExample3 
{
	public static void main(String[] args) 
	{
		String strVal1, strVal2;
		double dblVal1, dblVal2;
		double dblResult;

		strVal1 = JOptionPane.showInputDialog(null, "enter first double");
		strVal2 = JOptionPane.showInputDialog(null, "enter second double");

		dblVal1 = Double.parseDouble(strVal1);
		dblVal2 = Double.parseDouble(strVal2);

		dblResult = dblVal1 + dblVal2;
		
		JOptionPane.showMessageDialog(null, "The total is " + dblResult);
		
		System.exit(0);
	}
}
