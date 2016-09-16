//this is a practice program designed to give programmers a basic introduction to java variables
//the program shows how variables need values before they can be used in code

class Testing5 
{
	//in java all variables have to be initialized before they are referenced (used)
	public static void main(String[] args) 
	{
		// the following code will fail - will not compile as the variables have not been initialized
		int a;
		float b;
		double c;
		String s;

		System.out.println("int a = " + a);
		System.out.println("float b = " + b);
		System.out.println("double c = " + c);
		System.out.println("String s = " + s);
	}
}
