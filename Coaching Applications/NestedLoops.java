//this is a practice program designed to give programmers an introduction to nested loops

public class  NestedLoops
{
	public static void main(String[] args) 
	{
		int i,j;

		for (i=0; i<5; i++)
		{
			for (j=0; j<=i; j++)
			{
				System.out.printf("*");
			}

			System.out.println();
		}
	}
}
