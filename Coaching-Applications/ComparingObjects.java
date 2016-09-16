//this is a practice program designed to teach programmers about classes and objects

public class ComparingObjects
{
	public static void main(String[] args) 
	{
		Students s = new Students();
		s.setName("Mary");
		s.setAge(18);
		//System.out.println(s.toString());  //explicit call to toString
		System.out.println(s); //implicit call to toString

		Students d = new Students();
		d.setName("Josh");
		d.setAge(22);
		System.out.println(d.toString());
		
		int totalAge = s.calcTotalAge(d);
		System.out.println("The total age is: " + totalAge);
	}
}
class Students
{
	private String name;
	private int age;

	public int calcTotalAge (Students std)
	{
		//this.age - is the value of the age data member of the calling object
		//std.age - is the value of the age data member of the object that we accept as an object
		return this.age + std.age;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String toString()
	{
		return "the students name is " + name + " and the age is " + age;
	}
}