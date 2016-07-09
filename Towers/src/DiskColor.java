// holds colors in RGB, can contain a value for alpha transparency
public class DiskColor {
	private int r;
	private int g;
	private int b;

	private float a;		// transparency, value between 0.0f and 1.0f
	
	private DiskColor()
	{
		System.err.println("DiskColor's default constructor should never be called");
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
	
	public int getR() {
		return r;
	}

	public int getG() {
		return g;
	}

	public int getB() {
		return b;
	}

	public float getA() {
		return a;
	}
}
