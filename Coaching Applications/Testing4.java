//this is a practice program designed to teach programmers about basic operations
//the program compares the differences between unary and binary operands 

class Testing4
{
	/*
		binary vs. unary
		binary - needs 2 operands to work
			ex. 5+5, 4/9, etc.
		unary - needs one operand to work
			ex. -4, ++5, 3--

		shorthand operators

		a = a + num; this can be written as a += num (same with other operators like *=, -=, %=, /=

		special case is when num = 1
		then a = a + num is tha same as a++ or ++a (also with negatives --a, a--)
		
		when a unary operator comes before the variable it is called prefix (++a)
		when a unary operator comes after the variable it is called postfix (a++)

		if prefix or postfix is not used in an assignment statement they produce the same results
		so ++a is the same as a++

		if used in an assignment statement they produce different results
		for prefix you do prefix first then assign
		ex. if a = 6
		b = ++a;
		a = 7, b = 7

		for postfix you assign first then postfix
		ex. if a = 6
		b = a++;
		a = 7, b = 6
	*/
	public static void main(String[] args) 
	{
		int a = 5, b = 8, c;
		b++;
		c = a++ - --b;

		System.out.println("a = " + a); //should be 6
		System.out.println("b = " + b); //should be 8
		System.out.println("c = " + c++); //should be -3
		System.out.println("c = " + c); //should be -2
	}
}
