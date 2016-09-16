//this is a practice program designed to teach programmers about basic casting and converting
//the program shows how to convert string values to integer

public class CastExample
{
	public static void main(String[] args) 
	{
		String strVal = "55";

		//int intVal = (int)strVal; //fails because the datatypes are not 
		int intVal = Integer.parseInt(strVal); //success

		System.out.println(intVal);

		int order = (int)(Math.floor(Math.random()*11111));
		String temp = 1+order;
		int new = Integer.parseint(temp);

		System.out.println(intVal);
	}
}
