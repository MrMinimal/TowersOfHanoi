/**
 * Creates a task which holds informations about the disk which is to be drawn.
 * 
 * @author Tom Langwaldt
 *
 */
public class DrawDiskTask {

	private float radius;
	private DiskColor color;

	private DrawDiskTask() {
		System.err.println("DrawDiskTask's constructor should never be called!");
	}

	/**
	 * Creates a task which holds color and radius of the disk to be drawn.
	 * 
	 * @param radius
	 * @param color
	 */
	public DrawDiskTask(float radius, DiskColor color) {
		this.radius = radius;
		this.color = color;
	}

	/**
	 * Gets the radius of the disk to be drawn
	 * 
	 * @return
	 */
	public float getRadius() {
		return radius;
	}

	/**
	 * Gets the color of the disk to be drawn
	 * 
	 * @return
	 */
	public DiskColor getColor() {
		return color;
	}
}
