//this is a practice program designed to teach programmers about the scope of variables

public class  VariableScope
{
	static int val = 5;

	public static void main(String[] args) 
	{
		System.out.println("from the main: " + val);
		display ();
	}

	public static void display()
	{
		System.out.println(val);
		return;
	}
}