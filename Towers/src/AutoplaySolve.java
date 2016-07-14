import java.util.Stack;

/**
 * The class AutoplaySolve handles the solving of the game automatically and is
 * realized as a thread. It is solved by an algorithm, that is called when the
 * the thread starts. It has a reference to the controller.
 * 
 * 
 * @author Leoni
 *
 */
public class AutoplaySolve extends Thread {

	GameController gameController;

	private static final int SECONDS_FACTOR = 100;

	/**
	 * Creates a Thread for automatically solving the game.
	 * 
	 * @param gameController
	 *            the controller of the MVC design
	 * @see GameController
	 */
	public AutoplaySolve(GameController gameController) {
		this.gameController = gameController;
		this.start();

	}

	/**
	 * Overrides the run method where the automatically solving method is
	 * called.
	 */
	@Override
	public void run() {
		Autoplay(gameController.getSettings().getTotalDisks(), gameController.getRods().get(0),
				gameController.getRods().get(1), gameController.getRods().get(2));
	}

	/**
	 * Solves the game with an algorithm @link After every moved disk the next
	 * move is delayed by the value set in the settings.
	 * 
	 * @param diskCount
	 *            number of disks
	 * @param rod1
	 *            the first rod in the game with its disks
	 * @param rod2
	 *            the second rod in the game with its disks
	 * @param rod3
	 *            the third rod in the game with its disks
	 */
	public void Autoplay(int diskCount, Stack<Disk> rod1, Stack<Disk> rod2, Stack<Disk> rod3) {
		if (diskCount == 1) {
			gameController.moveDisks(rod1, rod3);
			gameController.refresh();
			try {
				this.sleep(gameController.getSettings().getStepDelay() * SECONDS_FACTOR);
			} catch (InterruptedException e) {

			}
		} else {
			Autoplay(diskCount - 1, rod1, rod3, rod2);

			gameController.moveDisks(rod1, rod3);
			gameController.refresh();

			try {
				this.sleep(gameController.getSettings().getStepDelay() * SECONDS_FACTOR);
			} catch (InterruptedException e) {

			}

			Autoplay(diskCount - 1, rod2, rod1, rod3);
		}
	}
}
