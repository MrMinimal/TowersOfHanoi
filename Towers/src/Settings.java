// Holds all relevant data for the start of the game
public class Settings {

	public enum InteractionMode {
		AUTOPLAY, INTERACTIVE
	}

	private static final int ROD_COUNT = 3; // for now only 3, could potentially
											// set more via settings

	private static final int windowHeight = 600;
	private static final int windowWidth = 800;

	private InteractionMode mode;
	private int totalDisks;
	private int stepDelay;

	private Settings() {
		System.err.println("Settings default constructor should never be called");
	}

	public Settings(InteractionMode mode, int totalDisks, int stepDelay) {
		this.mode = mode;
		this.totalDisks = totalDisks;
		this.stepDelay = stepDelay;
	}

	public static int getWindowheight() {
		return windowHeight;
	}

	public static int getWindowwidth() {
		return windowWidth;
	}

	public int getRodCount() {
		return ROD_COUNT;
	}

	public InteractionMode getMode() {
		return mode;
	}

	public int getTotalDisks() {
		return totalDisks;
	}

	public int getStepDelay() {
		return stepDelay;
	}
}
