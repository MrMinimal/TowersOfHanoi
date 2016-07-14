/**
 * A disk specifies the properties of a torus and has a radius and a color.
 * 
 * @author Leoni Kaiser
 *
 */
public class Disk {

	private float radius;
	private DiskColor color;

	/**
	 * Constructor without parameters should never be called.
	 */
	private Disk() {
		System.err.println("Disk's default constructor should never be called");
	}

	/**
	 * Creates a disk with a radius and a specific color.
	 * 
	 * @param radius
	 *            a percentual value of the size of the disk
	 * @param color
	 *            color defined as RGB of the disk
	 * @see DiskColor
	 */
	public Disk(float radius, DiskColor color) {
		this.radius = radius;
		this.color = color;
	}

	/**
	 * Gets the radius of the disk.
	 * 
	 * @return a percentage based value of the size of the disk
	 */
	public float getRadius() {
		return radius;
	}

	/**
	 * Gets the color of the disk.
	 * 
	 * @return the current color as RGB of the disk
	 */
	public DiskColor getColor() {
		return color;
	}
}
