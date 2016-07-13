import java.util.ArrayList;
import java.util.Stack;

/**
 * Holds the rods and the disks as well as their respective position. Is the
 * Model part of the MVC design.
 * 
 * @author Tom Langwaldt
 *
 */
public class GameModel {

	private Settings settings;

	private ArrayList<Stack<Disk>> rods;

	/**
	 * Creates the model according to the passed settings. Fills the first rod
	 * of the game with the amount of disks specified by the settings.
	 * 
	 * @param settings
	 *            Data passed via command line arguments.
	 * @see Settings
	 */
	public GameModel(Settings settings) {
		this.settings = settings;

		this.rods = new ArrayList<Stack<Disk>>(settings.getRodCount());

		// add rods to the list
		for (int i = 0; i < settings.getRodCount(); i++) {
			this.rods.add(new Stack<Disk>());
		}

		fillFirstRod();
	}

	/**
	 * Fills the first rod with disks, according to the settings passed to the
	 * constructor. Every disk gets a randomized color, on initiation.
	 */
	private void fillFirstRod() {

		for (int i = 0; i < settings.getTotalDisks(); i++) {
			DiskColor color = new DiskColor();

			float widthInPercent = (float) i / settings.getTotalDisks();
			Disk disk = new Disk(1.0f - widthInPercent, color);

			this.rods.get(0).push(disk);
		}
	}

	/**
	 * Resets the game data to its original state before any user interaction
	 * happened.
	 */
	public void reset() {
		if (rods.isEmpty()) {
			return;
		}

		ArrayList<Disk> allDisks = new ArrayList<Disk>(settings.getTotalDisks());

		for (Stack<Disk> rod : rods) {
			while (!rod.isEmpty()) {
				allDisks.add(rod.pop());
			}
		}

		allDisks.sort(new DiskSizeComperator());

		for (int i = allDisks.size() - 1; i >= 0; i--) {
			Disk disk = allDisks.remove(i);

			this.rods.get(0).push(disk);
		}
	}

	/**
	 * Moves the top disk from one rod to another.
	 * 
	 * @param originRod
	 *            The rod from which the top most disk is to be removed from
	 * @param destiRod
	 *            The rod to which the disk is moved to
	 */
	public void moveDisks(Stack<Disk> originRod, Stack<Disk> destiRod) {
		// temporarily store the removed disk
		Disk removedDisk = originRod.pop();

		destiRod.push(removedDisk);
	}

	/**
	 * Gets the settings of the game.
	 * 
	 * @return settings Set by the command line arguments
	 */
	public Settings getSettings() {
		return settings;
	}

	/**
	 * Gets all the rods.
	 * 
	 * @return A list of all the rods, starting with the leftmost one
	 */
	public ArrayList<Stack<Disk>> getRods() {
		return rods;
	}
}
