import java.util.Random;

/**
 * A DiskColor holds colors in the RGB-format and a value for the alpha
 * transparency.
 * 
 * @author Leoni Kaiser
 *
 */
public class DiskColor {
	private int r;
	private int g;
	private int b;

	private float a;

	/**
	 * Creates a randomized disk color.
	 */
	public DiskColor() {
		Random rnd = new Random();

		this.r = rnd.nextInt(256);
		this.g = rnd.nextInt(256);
		this.b = rnd.nextInt(256);
	}

	/**
	 * Creates a disk color with the specified red, green and blue value in the
	 * range (0...255) and a value of transparency in the range (0.0 - 1.0).
	 * 
	 * @param r
	 *            value of the red part of the color (0...255)
	 * @param g
	 *            value of the green part of the color (0...255)
	 * @param b
	 *            value of the blue part of the color (0...255)
	 * @param a
	 *            value of the transparency of the color (0.0 - 1.0)
	 */
	public DiskColor(int r, int g, int b, float a) {
		this.r = r;
		this.g = g;
		this.b = b;

		// set transparency
		this.a = a;
	}

	/**
	 * Creates a disk color with the specified red, green and blue value in the
	 * range (0...255), and a fixed transparency of 1.0.
	 * 
	 * @param r
	 *            value of the red part of the color (0...255)
	 * @param g
	 *            value of the green part of the color (0...255)
	 * @param b
	 *            value of the blue part of the color (0...255)
	 */
	public DiskColor(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;

		// set transparency
		this.a = 1.0f;
	}

	/**
	 * Gets the value of the red part of the color.
	 * 
	 * @return a value that specifies the red part
	 */
	public int getR() {
		return r;
	}

	/**
	 * Gets the value of the green part of the color.
	 * 
	 * @return a value that specifies the green part
	 */
	public int getG() {
		return g;
	}

	/**
	 * Gets the value of the blue part of the color.
	 * 
	 * @return a value that specifies the blue part
	 */
	public int getB() {
		return b;
	}

	/**
	 * Gets the value of the transparency of the color.
	 * 
	 * @return a procentual value between (0.0 - 1.0) of the transparency of the
	 *         color
	 */
	public float getA() {
		return a;
	}
}
