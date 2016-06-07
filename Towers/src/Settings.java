// Holds all relevant data for the start of the game
public class Settings {
	
	public enum InteractionMode {
		AUTOPLAY,
		INTERACTIVE
	}
	
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
