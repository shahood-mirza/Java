//this is a practice program designed to teach programmers about basic calculations and the use of constants

class Testing3 
{
	/*
		area = PI x Rad X Rad
		circ = 2 x PI x Rad
		task: calculate the area given the value of the circumference
	*/

	public static void main(String[] args) 
	{
	double rad, area, circ;
	final double PI = 3.14159; //'final' is used to make PI a constant so it cannot be changed; it must be initialized when declared
							   //java convention is that constants are named using all caps
	circ = 90;
	
	rad = circ / (2 * PI);
	
	area = PI * rad * rad;
	
	System.out.println("The radius of a circle with a given circumference of " + circ + " is " + rad + " and the area with that radius is " + area);
	}
}
