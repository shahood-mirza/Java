//this is a practice program designed to teach programmers about classes and objects
//the program compares two objects of the same class and outputs the results

public class CompareObjects 
{
	public static void main(String[] args) 
	{
		Test a = new Test(4);
		Test b = new Test(4);  //new object created, thus they are not equal
		//Test b = a;  //this does not create a new object, so it is referring to the same memory location

		if (a == b)
			System.out.println("equal");
		else
			System.out.println("not equal");

		if (a.equals(b))
			System.out.println("a is equal to b");
		else
			System.out.println("a is NOT equal to b");
	}
}

class Test
{
	int a;

	public Test(int a )
	{
		this.a = a;
	}

	public boolean equals(Test obj)
	{
		if (this.a == obj.a)
			return true;
		else
			return false;
	}
}