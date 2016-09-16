//this is a practice program designed to teach programmers about classes and objects

public class ClassesAndObjects 
{
	public static void main(String[] args) 
	{
		Student std = new Student();
		std.sayName();
		Student std1 = new Student("Mary");
		std1.sayName();

		//std.setName ("Jane");
		//std.sayName();
	}
}

class Student
{
	private String name;

	public Student()
	{
		System.out.println("Student is being Constructed");
		this.name = ("Steven");
	}

	public Student (String name)
	{
		System.out.println("Student is being Constructed");
		this.name = name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void sayName()
	{
		System.out.println("my name is " + name);
	}
}