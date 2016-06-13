
public class Disk {
	private float radius;
	
	private DiskColor color; 
	
	private Disk()
	{
		System.err.println("Disk's default constructor should never be called");
	}
	
	public Disk(float radius, DiskColor color){
		this.radius = radius;
		this.color 	= color;
	}
}
