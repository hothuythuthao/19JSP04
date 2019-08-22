package Lab3;

import Lab1.Input;

public class SumOdd {
	public static void main(String[] args) {
		int n = 0;
		double s = 0;
		double[] arr = new double[10];
		for (int i = 0; i < 10; i++) {
			System.out.print("--Input number " + i + " : ");
			arr[i] = Input.inputNumber();
		}

		do {
			if (arr[n] % 2 == 0) {
				s = s + arr[n];
			}
			n++;
		} while (n < 10);
		System.out.print("\n--Sum of 10 odd is : " + s);
	}
}
