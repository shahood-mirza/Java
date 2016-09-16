//this is a practice program designed to teach programmers about basic boolean operations

public class LogicalExpressions
{
	public static void main(String[] args) 
	{
		int a = 5, b = 2, c = 4, d = 6, e = 3;
		System.out.println("1. " + (a == 5));
		System.out.println("2. " + (b * d == c * c));
		System.out.println("3. " + (d % b * c > 5 || c % b * d < 7));
		System.out.println("4. " + (d % b * c > 5 && c % b * d < 7));
	}
}
