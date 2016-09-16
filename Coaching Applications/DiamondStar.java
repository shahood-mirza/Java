//this is a practice program designed to teach programmers about nested for loops
//the program shows how you can use loops to easily create visual patterns

public class DiamondStar
{
	public static void main(String[] args) 
	{
		int i, j, x;

		for (i = 0; i<5; i++)
		{
			for (x=3; x>=i; x--)
			{
				System.out.printf(" ");
			}
			for (j=0; j<=i; j++)
			{
				System.out.printf("**");
			}
			System.out.println();
		}

		for (i=0; i<5; i++)
		{
			for (x=0; x<i; x++)
			{
				System.out.printf(" ");
			}
			for (j=5; j>i; j--)
			{
				System.out.printf("**");
			}
			System.out.println();
		}
	}
}
