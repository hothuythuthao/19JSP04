package Lab2;

public class Shape {
	private String color;
	
	public Shape() {
		super();
	}

	public Shape(String color) {
		super();
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double Area()	{
		return 0;
	}

	@Override
	public String toString() {
		return "Shape [color=" + color + "]";
	}
	
}
