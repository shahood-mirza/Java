//this is a practice program designed to teach programmers about classes and constructors

public class DefaultConstructor
{
	public static void main(String[] args) 
	{
		Distance d = new Distance();
		d.display();
	}
}

class Distance
{
	double pointA;
	public Distance()  //default no argument constructor is similar to this (BLANK)
	{
	}
	public Distance(double a)
	{
		pointA = a;
	}
	public void display()
	{
		System.out.println("Distance is here");
	}
}