//this is a practice program designed to teach programmers about strings and string functions
//this program counts the number of a specific letter contained in a harcoded string

public class LettersInString
{
	public static void main(String[] args) 
	{
		String s = "Welcome to Java";

		System.out.println("e: " + LetterCount(s, 'e'));
	}
	public static int LetterCount (String s, char check)
	{
		int counter = 0;
		int length = s.length();
	
		for (int i = 0; i < length - 1; i++)
		{
			int temp = s.indexOf(s.charAt(i), i);
			if (temp == i)
			{
				counter++;
			}
		}		
		return counter;
	}
}
