import java.util.ArrayList;
import java.util.Stack;

// class which holds all relevant data for the game
public class GameModel {
	
	private Settings settings;

	private ArrayList<Stack<Disk>> rods;

	private GameModel() {
		System.err.println("GameModel's constructor should never be called!");
	}

	public GameModel(Settings settings) {
		this.settings = settings;

		this.rods = new ArrayList<Stack<Disk>>( settings.getRodCount() );
		
		// add rods to the list
		for (int i = 0; i < settings.getRodCount(); i++) {
			this.rods.add(new Stack<Disk>());
		}

		fillFirstRod();
	}

	// fills the first rod with disks, according to the settings passed in the
	// constructor
	private void fillFirstRod() {

		for (int i = 0; i < settings.getTotalDisks(); i++) {
			DiskColor color = new DiskColor();	
			
			float widthInPercent = (float)i / settings.getTotalDisks();
			Disk disk = new Disk(1.0f - widthInPercent, color);

			this.rods.get(0).push(disk);
		}
	}
	
	public void reset()
	{
		if (rods.isEmpty())
		{
			return;
		}
		
		ArrayList<Disk> allDisks = new ArrayList<Disk>(settings.getTotalDisks());
		
		for (Stack<Disk> rod : rods)
		{
			while (!rod.isEmpty())
			{
				allDisks.add(rod.pop());
			}
		}
		
		allDisks.sort(new DiskSizeComperator());
		
		for (int i = allDisks.size() - 1; i >= 0; i--) {
			Disk disk = allDisks.remove(i);
			
			this.rods.get(0).push(disk);
		}
	}

	// TODO: throw exception in case a rod is empty
	public void moveDisks(int from, int to) {
		Stack<Disk> originRod = this.rods.get(from); 	// from which rod a disk is removed
														
		Stack<Disk> destiRod = this.rods.get(to); 		// to which rod a disk is moved to

		// temporarily store the removed disk
		Disk removedDisk = originRod.pop();

		destiRod.push(removedDisk);
	}
	
	public void moveDisks(Stack<Disk> rod1, Stack<Disk> rod2)
	{
		Stack<Disk> originRod = rod1; 	// from which rod a disk is removed
		
		Stack<Disk> destiRod = rod2; 		// to which rod a disk is moved to

		// temporarily store the removed disk
		Disk removedDisk = originRod.pop();

		destiRod.push(removedDisk);
	}
	
	public Settings getSettings()
	{
		return settings;
	}
	
	public ArrayList<Stack<Disk>> getRods()
	{
		return rods;
	}
}
