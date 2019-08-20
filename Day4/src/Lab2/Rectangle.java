package Lab2;

public class Rectangle extends Shape {
	private int length;
	private int width;
	
	public Rectangle() {
		super();
	}
	
	public Rectangle(int length, int width) {
		super();
		this.length = length;
		this.width = width;
	}
	
	public Rectangle(String color, int length, int width)	{
		super(color);
		this.length = length;
		this.width = width;
	}

	public double Area()	{
		return length * width;
	}

	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + "]";
	}
	
}
