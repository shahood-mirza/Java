//this is a practice program designed to teach programmers about objects and classes
//the program shows how objects can be passed and how to use their data

public class PassingObjects 
{
	public static void main(String[] args) 
	{
		Distance d1 = new Distance(44);
		Distance d2 = new Distance(55);
		Distance d3 = new Distance(77);
		Distance total = new Distance(0);

		total.findTotal(d1, d2, d3);


		System.out.println("the total distance is: " + total);

	}
}

class Distance
{
	private int dist;

	public void findTotal(Distance obj, Distance obj1, Distance obj2)
	{
		this.dist = obj.dist + obj1.dist + obj2.dist;
	}

	public String toString()
	{
		return "" + dist;
	}

	public Distance(int dist)
	{
		this.dist = dist;
	}
}
