package Lab3;

public class Triangle extends Shape {
	private int base;
	private int height;
	
	public Triangle() {
		super();
	}

	public Triangle(int base, int height) {
		super();
		this.base = base;
		this.height = height;
	}
	
	public Triangle(String color, int base, int height)	{
		super(color);
		this.base = base;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Triangle [base=" + base + ", height=" + height + "]";
	}
	
	public double Area()	{
		return 0.5 * base * height;
	}
}
