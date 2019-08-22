package Lab1;

import java.util.Scanner;

public class Input {
	public static Scanner sc = new Scanner(System.in);
	
	public static double inputNumber()	{
		while(true)	{
			try	{
				double n = Double.parseDouble((sc.nextLine()));
				return n;
			}	catch(NumberFormatException ex)	{
					System.out.print("\n--Invalid! Input number again: ");
			}
		}
	}
}
