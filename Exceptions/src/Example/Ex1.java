package Example;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int a[] = new int[2];
			System.out.println(a[3]);
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			System.out.println("Error is " + aiobe);
		}
	}

}
