package Lab1;

public class AB {
	
	public static void main(String[] args)	{
		System.out.print("--Input number A: ");
		double a = Input.inputNumber();
		
		System.out.print("--Input number B: ");
		double b = Input.inputNumber();
		
		System.out.print("\n--A + B = " + (a + b));
		System.out.print("\n--A - B = " + (a - b));
		System.out.print("\n--A * B = " + (a * b));
		System.out.print("\n--A % B = " + (a % b));
		System.out.print("\n--A / B = " + (a / b));
		System.out.print("\n--A + + = " + (a++));
		System.out.print("\n--B - - = " + (b--));
		
		int c = (a > b) ? 0 : 1;
		if(c == 0)	{
			System.out.print("\n-- A > B");
		}
		else	{
			System.out.print("\n--A <= B");
		}
		
	}
}
