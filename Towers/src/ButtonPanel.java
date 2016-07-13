import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Holds all the buttons needed for the conventional interactive mode
 * 
 * @author Tom Langwaldt
 *
 */
public class ButtonPanel extends JPanel {

	private static final String INTERACTIVE_HELP_TEXT = "1. Select one Rod to move disks from \n" + 
														"2. Select one Rod to move disks to \n" + "3. Press \"Commit\" to actually move the disks \n\n" + 
														"Press \"Reset\" to stop the game and start anew \n";

	private GameView view;

	/**
	 * Creates all the buttons which will be needed in the interactive mode
	 * 
	 * @param view
	 *            The main view which holds the button panel
	 */
	public ButtonPanel(GameView view) {
		this.view = view;

		JButton commitBtn = new JButton("Commit");
		JButton resetBtn = new JButton("Reset");
		JButton helpBtn = new JButton("Help");

		commitBtn.addActionListener(this::commitEvent);
		resetBtn.addActionListener(this::resetEvent);
		helpBtn.addActionListener(this::helpEvent);

		this.add(commitBtn);
		this.add(resetBtn);
		this.add(helpBtn);
	}

	/**
	 * Callback to the main view if the user presses the commit button.
	 * 
	 * @param event
	 *            Not used
	 */
	private void commitEvent(ActionEvent event) {
		view.commitButtonEvent(event);
	}

	/**
	 * Callback to the main view if the user presses the reset button.
	 * 
	 * @param event
	 *            Not used
	 */
	private void resetEvent(ActionEvent event) {
		view.resetButtonEvent(event);
	}

	/**
	 * Callback to the main view if the user presses the help button.
	 * 
	 * @param event
	 *            Not used
	 */
	private void helpEvent(ActionEvent event) {
		view.showError(INTERACTIVE_HELP_TEXT);
	}
}
