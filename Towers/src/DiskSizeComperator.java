import java.util.Comparator;

/**
 * Compares the size of two disks.It implements a @see{@link Comparator} of the
 * type disk.
 * 
 * It overrides the method @see {@link Comparator#compare(Object, Object)}.
 * 
 * @author Leoni Kaiser
 *
 */
public class DiskSizeComperator implements Comparator<Disk> {

	/**
	 * Gets a value to difference the relation of two disks. Returns -1 if the
	 * first given disk is smaller than the other disk. Returns 1 if the first
	 * given disk is bigger. Returns 0 if they are equal.
	 */
	@Override
	public int compare(Disk o1, Disk o2) {

		if (o1.getRadius() > o2.getRadius()) {
			return 1;
		}

		if (o1.getRadius() < o2.getRadius()) {
			return -1;
		}

		return 0;
	}
}
