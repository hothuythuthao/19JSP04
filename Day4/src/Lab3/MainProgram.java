package Lab3;

import Lab3.Rectangle;
import Lab3.Shape;
import Lab3.Triangle;

public class MainProgram {
	public static void main(String[] args)	{
		Triangle triangle = new Triangle("Black", 4, 5);
		processShape(triangle);
		
		Rectangle rectangle = new Rectangle("White", 7, 3);
		processShape(rectangle);
	}
	
	public static void processShape(Shape shape)	{
		System.out.println(shape.getColor());
		System.out.println(shape.Area());
	}
}
