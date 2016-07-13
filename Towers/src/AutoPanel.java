import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * JPanel which holds the buttons only present if the main frame is in autoplay
 * mode.
 * 
 * @author Tom Langwaldt
 *
 */
public class AutoPanel extends JPanel {

	private static final String AUTO_HELP_TEXT = "Press \"Start\" to make the game solve itself \n"
			+ "Press \"Reset\" to stop the game and start anew \n";

	private GameView view;
	private boolean isAutoPlayMode;

	/**
	 * Creates a JPanel with all the buttons and sets the callbacks if the user
	 * presses them.
	 * 
	 * @param view
	 *            The view which holds the AutoPanel
	 */
	public AutoPanel(GameView view) {
		super();

		this.view = view;
		this.isAutoPlayMode = isAutoPlayMode;

		JButton startAutoplayBtn = new JButton("Start");
		JButton resetAutoplayBtn = new JButton("Reset");
		JButton helpBtn = new JButton("Help");

		startAutoplayBtn.addActionListener(this::startEvent);
		resetAutoplayBtn.addActionListener(this::resetEvent);
		helpBtn.addActionListener(this::helpEvent);

		this.add(startAutoplayBtn);
		this.add(resetAutoplayBtn);
		this.add(helpBtn);
	}

	/**
	 * Callback to the main view if the user presses the start button.
	 * 
	 * @param event
	 *            Not used
	 */
	private void startEvent(ActionEvent event) {
		view.startButtonEvent(event);
	}

	/**
	 * Callback to the main view if the user presses the reset button.
	 * 
	 * @param event
	 */
	private void resetEvent(ActionEvent event) {
		view.resetButtonEvent(event);
	}

	/**
	 * Callback to the main view if the user presses the help button.
	 * 
	 * @param event
	 */
	private void helpEvent(ActionEvent event) {
		view.showError(AUTO_HELP_TEXT);
	}
}
