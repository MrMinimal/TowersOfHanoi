import java.util.ArrayList;
import java.util.Stack;

/**
 * The class GameController handles the interaction between the data and the
 * GUI. The Controller is part of the MVC design. It distinguish the solving in
 * interaction and autoplay, and starts a thread for solving the game
 * automatically.
 * 
 * @author Leoni Kaiser
 *
 */
public class GameController {

	private GameModel gameModel; // reference to data
	private GameView gameView; // reference to view
	private Stack<Disk> originRod;

	private AutoplaySolve solver;

	/**
	 * Constructor without parameters should never be called.
	 */
	private GameController() {
		System.err.println("GameController's constructor should never be called!");
	}

	/**
	 * Creates the associated controller for handling the data and GUI. It gets
	 * the game started by giving the GUI the initial state of the rods.
	 * 
	 * @param gameModel
	 *            the model where the data comes from.
	 * @see GameModel
	 * @param gameView
	 *            the view where the data is drawn.
	 * @see GameView
	 */
	public GameController(GameModel gameModel, GameView gameView) {
		this.gameModel = gameModel;
		this.gameView = gameView;
		init();

		if (gameModel.getSettings().getMode() == Settings.InteractionMode.AUTOPLAY) {
			// gameView.disableInteraction();
		}
	}

	/**
	 * Verifies the selected move from the player. It checks if there are rods
	 * selected for moving the disks. If the move is valid, the rods given by
	 * the passed indices. This method is called by pressing the commit-Button.
	 * 
	 * @param from
	 *            the index of the rod where the disk comes from.
	 * @param to
	 *            the index of the rod where the disk goes to.
	 */
	public void interactiveSolve(int from, int to) {
		// sanity checks
		if (from < 0) {
			gameView.showError("Please select a rod to move from!");
			return;
		}

		if (to < 0) {
			gameView.showError("Please select a rod to!");
			return;
		}

		Stack<Disk> fromRod = getRods().get(from);
		Stack<Disk> toRod = getRods().get(to);
		validate(fromRod, toRod);
		check();
	}

	/**
	 * Verifies if the origin rod has disks to move and moves the disks.
	 * 
	 * @param rod1
	 *            the rod where the disk comes from.
	 * @param rod2
	 *            the rod where the disk goes to.
	 */
	public void validate(Stack<Disk> rod1, Stack<Disk> rod2) {
		if (rod1.isEmpty()) {
			gameView.showError("There are no disks at that rod for moving!");
			return;
		}

		if (rod2.isEmpty()) {
			// No radius comparison needed
			this.moveDisks(rod1, rod2);
			refresh();
		} else {
			if (rod1.peek().getRadius() > rod2.peek().getRadius()) {
				gameView.showError("The disk is bigger than the disk of the destination rod!");
			} else {
				this.moveDisks(rod1, rod2);
				refresh();
			}
		}
	}

	/**
	 * Gets the first rod and let it draw. This method is called by the
	 * constructor.
	 */
	private void init() {
		originRod = gameModel.getRods().get(0);
		for (int i = 0; i < originRod.size(); i++) {
			gameView.drawDisk(0, originRod.get(i));
		}
		gameView.updateView();
		check();
	}

	/**
	 * Draws the view with the right data after a action. It resets the view and
	 * adds the new data to it.
	 */
	public void refresh() {
		gameView.resetView();
		for (int i = 0; i < gameModel.getRods().size(); i++) {
			Stack<Disk> originRod = gameModel.getRods().get(i);
			for (int j = 0; j < originRod.size(); j++) {
				gameView.drawDisk(i, originRod.get(j));
			}
		}
		gameView.updateView();
	}

	/**
	 * Verifies if the game is solved by comparing the count of disks on the
	 * last rod with the total number of disks saved in the settings.
	 * 
	 * @see Settings
	 * 
	 */
	public void check() {
		if (gameModel.getRods().get(2).size() == gameModel.getSettings().getTotalDisks()) {
			gameView.showError("Congrats! You got it!");
		}
	}

	/**
	 * Resets the game back to the initial state. Stops the thread and resets
	 * the step counter.
	 */
	public void reset() {
		if (solver.isAlive()) {
			solver.stop();

			solver = null;
		}

		gameModel.reset();
		gameView.resetStepCount();
		refresh();
	}

	/**
	 * Moves the disks and raises the step count.
	 * 
	 * @param rod1
	 *            the rod where the disk comes from.
	 * @param rod2
	 *            the rod where the disk goes to.
	 */
	public void moveDisks(Stack<Disk> rod1, Stack<Disk> rod2) {
		gameModel.moveDisks(rod1, rod2);
		gameView.incrementStepCount();
	}

	/**
	 * Gets the settings of the game.
	 * 
	 * @return settings set by the command line arguments
	 */
	public Settings getSettings() {
		return gameModel.getSettings();
	}

	/**
	 * Gets all the rods.
	 * 
	 * @return A list of all the rods, starting with the most left one
	 */
	public ArrayList<Stack<Disk>> getRods() {
		return gameModel.getRods();
	}

	/**
	 * Launches the autoplay mode if the start button is pressed.
	 */
	public void startAutoplay() {
		if (solver == null) {
			solver = new AutoplaySolve(this);
		}
	}
}
