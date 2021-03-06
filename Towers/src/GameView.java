import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

/**
 * The View part of the MVC design
 * 
 * @author Tom Langwaldt
 *
 */
public class GameView {

	private static float DISPLAY_HEIGHT = 0.8f; 			// percentage based, e.g. 0.3f
															// is 30% of the mainFrames
															// height
	private static float BUTTONPANEL_HEIGHT = 0.05f; 		// percentage based, e.g.
															// 0.3f is 30% of the
															// mainFrames height

	private JFrame mainFrame;

	private GameController controller;

	private DisplayPanel displayPanel;
	private SelectionPanel selectionPanel;
	private ButtonPanel buttonPanel;
	private AutoPanel autoPanel;

	private boolean isAutoPlayMode;
	private int rodCount;
	private int maxDiskAmount;

	/**
	 * Constructor without parameters should never be called.
	 */
	private GameView() {
		System.err.println("GameViews's constructor should never be called!");
	}

	/**
	 * Creates a view object for the MVC model.
	 * 
	 * @param isAutoplayMode
	 *            Indicates whether the user is allowed to move disks or an
	 *            algorithm solves the problem
	 * @param windowWidth
	 *            Width of the window in pixels
	 * @param windowHeight
	 *            Height of the window in pixels
	 * @param rodCount
	 *            Number of rods the view is supposed to display
	 * @param maxDiskAmount
	 *            Maximum number of disks which can be in the game at a time
	 */
	public GameView(boolean isAutoplayMode, int windowWidth, int windowHeight, int rodCount, int maxDiskAmount) {
		this.isAutoPlayMode = isAutoplayMode;
		this.rodCount = rodCount;
		this.maxDiskAmount = maxDiskAmount;

		this.mainFrame = new JFrame("Towers of Hanoi");
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setSize(windowWidth, windowHeight);
		// this.mainFrame.setResizable(false);

		this.mainFrame.setLayout(new BorderLayout());

		fillContents(windowWidth, windowHeight);

		this.mainFrame.setVisible(true);
	}

	/**
	 * Add all panels of the view to the main frame, including buttons and game
	 * visualization
	 * 
	 * @param windowWidth
	 *            Width of the window in pixels
	 * @param windowHeight
	 *            Height of the window in pixels
	 */
	private void fillContents(int windowWidth, int windowHeight) {
		// add display
		int displayDesiredHeight = (int) (DISPLAY_HEIGHT * windowHeight);

		this.displayPanel = new DisplayPanel(this.rodCount, this.maxDiskAmount);
		this.displayPanel.setPreferredSize(new Dimension(0, displayDesiredHeight));

		this.mainFrame.getContentPane().add(this.displayPanel, BorderLayout.PAGE_START);

		if (isAutoPlayMode) {
			this.autoPanel = new AutoPanel(this);
			this.autoPanel.setPreferredSize(new Dimension(0, (int) (windowHeight * BUTTONPANEL_HEIGHT)));
			this.mainFrame.add(this.autoPanel, BorderLayout.PAGE_END);
		} else {
			// add selection
			this.selectionPanel = new SelectionPanel(this.rodCount);
			this.mainFrame.add(this.selectionPanel, BorderLayout.CENTER);

			// add buttons
			this.buttonPanel = new ButtonPanel(this);
			this.buttonPanel.setPreferredSize(new Dimension(0, (int) (windowHeight * BUTTONPANEL_HEIGHT)));
			this.mainFrame.add(this.buttonPanel, BorderLayout.PAGE_END);
		}
	}

	/**
	 * Assigns the controller of the MVC design to the view. Is only needed for
	 * the callbacks the the controller, in case a user presses a button.
	 * 
	 * @param controller
	 *            the controller of the MVC design
	 * @see GameController
	 */
	public void assignController(GameController controller) {
		this.controller = controller;
	}

	/**
	 * Draws a disk on the display, the next time it is painted. Every
	 * consecutive call is interpreted as another disk added on top. To start
	 * over, call resetView() and add tasks again.
	 * 
	 * @param rodIndex
	 * @param disk
	 */
	public void drawDisk(int rodIndex, Disk disk) {
		DrawDiskTask task = new DrawDiskTask(disk.getRadius(), disk.getColor());
		displayPanel.addDrawTask(rodIndex, task);
	}

	/**
	 * Clear all draw tasks. After this, the only things painted are the rods
	 * and step counter.
	 * 
	 * @see DrawDiskTask
	 */
	public void resetView() {
		this.displayPanel.flushDrawTasks();
	}

	/**
	 * Manually update the view in case a disk changes
	 */
	public void updateView() {
		this.displayPanel.repaint();
	}

	/**
	 * Displays a popup with a message, centered over the main window. Prevents
	 * the user from inputting anything until OK button was pressed.
	 * 
	 * @param message
	 *            What to display inside of the popup window.
	 */
	public void showError(String message) {
		JOptionPane.showMessageDialog(this.mainFrame, message, "Towers of Hanoi", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Gets the index of the currently selected button of the "from" row.
	 * 
	 * @return The index of the pressed button, starting from the leftmost one
	 *         at index 0. Is -1 in case none is pressed.
	 */
	public int getSelectedFromButton() {
		return selectionPanel.getSelectedFromButton();
	}

	/**
	 * Gets the index of the currently selected button of the "to" row.
	 * 
	 * @return The index of the pressed button, starting from the leftmost one
	 *         at index 0. Is -1 in case none is pressed.
	 */
	public int getSelectedToButton() {
		return selectionPanel.getSelectedToButton();
	}

	/**
	 * Increment the step counter of the UI by +1.
	 */
	public void incrementStepCount() {
		displayPanel.incrementStepCount();
	}

	/**
	 * Set the step counter of the UI to 0.
	 */
	public void resetStepCount() {
		displayPanel.resetStepCount();
	}

	/**
	 * Sends the controller of the MVC design a message to handle what happens
	 * in case a user presses the commit button. Actually only needed if the UI
	 * is in interactive mode.
	 * 
	 * @param event
	 *            Holds information about the button press, not used.
	 */
	public void commitButtonEvent(ActionEvent event) {
		controller.interactiveSolve(getSelectedFromButton(), getSelectedToButton());
	}

	/**
	 * Sends the controller of the MVC design a message to handle what happens
	 * in case a user presses the reset button.
	 * 
	 * @param event
	 *            Holds information about the button press, not used.
	 */
	public void resetButtonEvent(ActionEvent event) {
		controller.reset();
	}

	/**
	 * Sends the controller of the MVC design a message to handle what happens
	 * in case a user presses the start button. Actually only needed if the UI
	 * is in autoplay mode.
	 * 
	 * @param event
	 *            Holds information about the button press, not used.
	 */
	public void startButtonEvent(ActionEvent event) {
		controller.startAutoplay();
	}
}