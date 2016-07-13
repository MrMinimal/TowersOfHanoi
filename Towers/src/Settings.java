/**
 * Holds all data for the game which was passed via command line arguments. 
 * This includes the InteractionMode of the game, 
 * differenced in the Autoplay- and Interactive - Mode, the step delay, the total number of disks in the game and the size of the window.
 * <p>
 * That class can only be called with arguments, there is no default constructor.
 */
public class Settings {

	public enum InteractionMode {
		AUTOPLAY, INTERACTIVE
	}

	private static final int ROD_COUNT = 3; // for now only 3, could potentially
											// set more via settings

	private static final int windowHeight 	= 600;
	private static final int windowWidth 	= 800;

	private InteractionMode mode;
	private int totalDisks;
	private int stepDelay;

	/**
	 * Constructor without parameters should never be called.
	 */
	private Settings() {
		System.err.println("Settings default constructor should never be called");
	}

	/**
	 * Creates settings with specifying the InteractionMode, the number of Disks
	 * and the step delay for the Autoplay-Mode.
	 * 
	 * @param mode the mode the game is played with. Options are AUTOPLAY and
	 * INTERACTIVE.
	 * 
	 * @param totalDisks the number of disks in the game.
	 * 
	 * @param stepDelay time how fast the disks should be moved in the
	 * Autoplay-Mode.
	 */
	public Settings(InteractionMode mode, int totalDisks, int stepDelay) {
		this.mode = mode;
		this.totalDisks = totalDisks;
		this.stepDelay = stepDelay;
	}

	/**
	 * Gets the height of the window.
	 * 
	 * @return the value of window height.
	 */
	public static int getWindowHeight() {
		return windowHeight;
	}

	/**
	 * Gets the Width of the window.
	 * 
	 * @return the value of the window width.
	 */
	public static int getWindowWidth() {
		return windowWidth;
	}

	/**
	 * Returns the number of rods in the game.
	 * 
	 * @return the number of the rods.
	 */
	public int getRodCount() {
		return ROD_COUNT;
	}

	/**
	 * Gets the Mode of the game that is currently set.
	 * 
	 * @return the InteractionMode of that game.
	 */
	public InteractionMode getMode() {
		return mode;
	}

	/**
	 * Returns the total number of Disks in the whole game.
	 * 
	 * @return
	 */
	public int getTotalDisks() {
		return totalDisks;
	}

	public int getStepDelay() {
		return stepDelay;
	}
}
