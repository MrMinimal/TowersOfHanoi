import java.util.Comparator;

public class DiskSizeComperator implements Comparator<Disk> {

	@Override
	public int compare(Disk o1, Disk o2) {
		
		if (o1.getRadius() > o2.getRadius())
		{
			return 1;
		}
		
		if (o1.getRadius() < o2.getRadius())
		{
			return -1;
		} 
		
		return 0;
	}
}
