//this is a practice program designed to teach programmers about classes and objects

import java.util.*;

public class ClassMembers 
{
	public static void main(String[] args) 
	{
		//Distance d = new Distance();
		//Distance d1 = new Distance();

		//d.getPoints();
		//d1.getPoints();
		
		//d.displayDistance();
		//d1.displayDistance();

		Distance d2 = new Distance(76, 34);
		d2.displayDistance();
	}
}
class Distance
{
	double pointA;
	double pointB;

	public Distance()  //default, no argument constructor
	{
		//pointA = 55;
		//pointB = 44;
		getPoints();
	}

	public Distance(double a, double b)
	{
		pointA = a;
		pointB = b;
	}

	public void getPoints()
	{
		Scanner in = new Scanner (System.in);
		System.out.printf("Point A: ");
		pointA = in.nextDouble();
		System.out.printf("Point B: ");
		pointB = in.nextDouble();
	}

	public void displayDistance()
	{
		System.out.println("from point A to point B is " + (pointA - pointB));
	}
}