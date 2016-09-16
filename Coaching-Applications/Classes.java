//this is a practice program designed to teach programmers about classes

public class  Classes
{
	public static void main(String[] args) 
	{
		Test t;  //create a variable of a Test type
		t = new Test();  //create an object of Tets class and assign to the variable t

		t.runSayHello();  //call sayHello method

		System.out.println("the age is: " + MyVars.age);
		MyVars.sayAge();
	}
}

class Test
{
	private void sayHello()
	{
		System.out.println("hello from sayHello");
	}
	public void runSayHello()
	{
		sayHello();
	}
}

class MyVars
{
	public static int age = 33;
	public static void sayAge()
	{
		System.out.println("the age is: " + age);
	}
}