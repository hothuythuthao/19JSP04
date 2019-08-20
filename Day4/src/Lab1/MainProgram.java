package Lab1;

public class MainProgram {

	public static void main(String[] args) {

		Animal[] aniArr = new Animal[5];

		Dog dog = new Dog("God", 7);

		Tiger tiger = new Tiger("Regit", 3);

		Elephant elephant = new Elephant("Tnahpele", 9);

		Parrot parrot = new Parrot("Torrap", 7);

		Dove dove = new Dove("Evod", 1);

		aniArr[0] = dog;
		aniArr[1] = tiger;
		aniArr[2] = elephant;
		aniArr[3] = parrot;
		aniArr[4] = dove;

		System.out.printf("%-14s %-15s", "Name", "Age");
		System.out.println();
		for (Animal animal : aniArr) {
			System.out.printf("%-15s", animal.getName());
			System.out.printf("%-15d", animal.getAge());
			System.out.println();
		}
	}
}
