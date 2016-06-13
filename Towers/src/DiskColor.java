// holds colors in RGB, can contain a value for alpha transparency
public class DiskColor {
	private int r;
	private int g;
	private int b;
	private float a;		// transparency, value between 0.0f and 1.0f
	
	private DiskColor()
	{
		System.err.println("default constructor should never be called");
	}
	
	public DiskColor(int r, int g, int b, float a)
	{
		this.r = r;
		this.g = g;
		this.b = b;
		
		// set transparency
		this.a = a;
	}
	
	public DiskColor(int r, int g, int b)
	{
		this.r = r;
		this.g = g;
		this.b = b;
		
		// set transparency
		this.a = 1.0f;
	}
}
