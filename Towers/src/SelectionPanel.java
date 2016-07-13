import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

/**
 * Holds the UI elements for the selection of the disk movement
 * 
 * @author Tom Langwaldt
 *
 */
public class SelectionPanel extends JPanel {

	private JPanel fromSelectionPanel;
	private JPanel toSelectionPanel;

	private ArrayList<JToggleButton> fromButtons;
	private ArrayList<JToggleButton> toButtons;

	private ButtonGroup fromGroup;
	private ButtonGroup toGroup;

	private SelectionPanel() {
		System.err.println("SelectionPanel's constructor should never be called!");
	}

	/**
	 * Creates all the JToggleButtons to select which rods are involved in a
	 * commit move.
	 * 
	 * @param rodCount
	 *            Number of rods in the game
	 */
	public SelectionPanel(int rodCount) {
		fromButtons = new ArrayList<JToggleButton>(rodCount);
		toButtons = new ArrayList<JToggleButton>(rodCount);

		this.setLayout(new GridLayout(2, 1));

		fromSelectionPanel = new JPanel();
		toSelectionPanel = new JPanel();

		this.add(fromSelectionPanel);
		this.add(toSelectionPanel);

		fromGroup = addSelectionButtons(rodCount, "from", fromSelectionPanel, fromButtons);
		toGroup = addSelectionButtons(rodCount, "to", toSelectionPanel, toButtons);
	}

	/**
	 * Adds a ButtonGroup of JToggleButtons to the target panel
	 * 
	 * @param rodCount
	 *            Number of rods in the game
	 * @param btnLabel
	 *            Label of the buttons (prefix without index)
	 * @param target
	 *            Panel to which buttons will be added
	 * @param toggleButtons
	 *            References to the buttons for later use
	 * @return
	 */
	private ButtonGroup addSelectionButtons(int rodCount, String btnLabel, JPanel target,
			ArrayList<JToggleButton> toggleButtons) {
		target.setLayout(new GridLayout(1, rodCount));

		ButtonGroup group = new ButtonGroup();

		for (int i = 1; i <= rodCount; i++) {
			JToggleButton toggle = new JToggleButton(btnLabel + " " + i);

			group.add(toggle);
			target.add(toggle);

			// save reverences to toggle button for later
			toggleButtons.add(toggle);
		}

		return group;
	}

	/**
	 * Gets the currently selected from-button.
	 * 
	 * @return index of the selected from button, -1 in case none is selected
	 */
	public int getSelectedFromButton() {

		for (int i = 0; i < fromButtons.size(); i++) {
			JToggleButton toggle = fromButtons.get(i);

			if (toggle.isSelected()) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Gets the currently selected to-button.
	 * 
	 * @return index of the selected from button, -1 in case none is selected
	 */
	public int getSelectedToButton() {

		for (int i = 0; i < toButtons.size(); i++) {
			JToggleButton toggle = toButtons.get(i);

			if (toggle.isSelected()) {
				return i;
			}
		}

		return -1;
	}
}