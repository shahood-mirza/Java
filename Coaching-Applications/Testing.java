class Testing 
{
	/* 
		Create a java application that would
		calculate the total of the three declared and 
		intialized numbers. the program should display the 
		outputs in a user friendly format. eg. Display
		the values of the variables as well as the value 
		of the calculated total.

		We will use float datatype to store numbers.
			
		Any floating type number is treated as a double datatype
		by default. so, the statement like this: 
		float a = 4.5; - this will fail. 
		The reason: we have a float variable to the left of the equal sign 
		and we have a double value to the right of the equal sign.

		So, we have to specify that the value is a floating point value and not double.
		This is done by appending letter f to the end of the number:
		float a = 4.5f; - this will work
	*/
	public static void main(String[] args) 
	{
		// step one: declare variables
		float num1;
		float num2;
		float num3;
		//float total;
		// step two: intialize the variables with values (assign values)
		num1 = 4.3f;
		num2 = 3.2f;
		num3 = 8.5f;
		/* 
			we do not need to initialize the value of total as
			it ill be intialized later in the program.
		*/ 
		// step three: calculate the total and display the result
		//total = num1 + num2 + num3;
		//don't forget the brackets to change the order of calculations, otherwise concatenation will occur
		System.out.println("The total of " + num1 + " and " + num2 + " and " + num3 + " is equal to " + (num1 + num2 + num3));
	}
}
