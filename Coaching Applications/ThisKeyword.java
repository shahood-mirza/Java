//this is a practice program designed to teach programmers about classes and objects, specifically the 'this' keyword
//the program shows the importance of where and when to use 'this' when creating classes and objects

public class ThisKeyword 
{
	public static void main(String[] args) 
	{
		Distance d = new Distance(77, 22);
		d.display();
		//d.setPointA(66);
		//d.display();
	}
}

class Distance
{
	double pointA;
	double pointB;

	public Distance()  //default, no argument constructor
	{
		pointA = 55;
		pointB = 44;
	}

	public Distance(double pa)  //in this constructor, pointB is uninitialized, thisis why we use the "this" statement to call the other constructor
	{
		this();
		pointA = pa;
	}
	
	public Distance(double pa, double pb)
	{
		this(pa);
		pointA = pa;
		pointB = pb;
	}

	public void setPointA (double pointA)
	{
		this.pointA = pointA;  //using "this", it uses the object from the class, instead of the object from the method argument
	}

	public void getPoints()
	{
		this.pointB = pointB;
	}

	public void display()
	{
		System.out.println("from point A to point B is " + (pointA - pointB));
	}
}