//this is a practice program designed to teach programmers about methods and passing variables to them

public class  VariablePassing
{
	public static void main(String[] args) 
	{
		int val = 6;

		System.out.println("from the main before modify: " + val);
		modify(val);
		System.out.println("from the main before modify: " + val);
	}

	public static void modify(int val)  //when passing a variable a copy is passed, not the variable itself
	{
		val = 5;
		System.out.println("from modify: " + val);
		return;
	}
}