
public class DrawDiskTask {

	private float radius;
	private DiskColor color;

	private DrawDiskTask() {
		System.err.println("DrawDiskTask's constructor should never be called!");
	}

	public DrawDiskTask(float radius, DiskColor color) {
		this.radius = radius;
		this.color = color;
	}
	
	public float getRadius() {
		return radius;
	}

	public DiskColor getColor() {
		return color;
	}
}
