package Example;

public class Ex1 implements Runnable {
	private Thread t;
	private String threadName;
	
	Ex1(String name)	{
		threadName = name;
		System.out.println("Creating " + threadName);
	}
	
	public void run()	{
		System.out.println("Running " + threadName);
	}
	
	public void star()	{
		System.out.println("Starting " + threadName);
		if(t == null)	{
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
