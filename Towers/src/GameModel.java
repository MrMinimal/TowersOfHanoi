import java.util.ArrayList;
import java.util.Stack;

// class which holds all relevant data for the game
public class GameModel {
	private static final int ROD_AMOUNT = 3;

	private Settings settings;

	private ArrayList<Stack<Disk>> rods = new ArrayList<Stack<Disk>>(ROD_AMOUNT);

	private GameModel() {
		System.err.println("GameModel's constructor should never be called!");
	}

	public GameModel(Settings settings) {
		this.settings = settings;

		// add rods to the list
		for (int i = 0; i < ROD_AMOUNT; i++) {
			this.rods.add(new Stack());
		}

		fillFirstRod();
	}

	// fills the first rod with disks, according to the settings passed in the
	// constructor
	private void fillFirstRod() {

		for (int i = 0; i < settings.getTotalDisks(); i++) {
			DiskColor color = new DiskColor(255, 0, 0);	// TODO: randomze the color
			Disk disk = new Disk(5, color); // TODO: remove hard coded radius

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
}
