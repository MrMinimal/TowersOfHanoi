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

// Holds the UI elements for the selection of the disk movement
public class SelectionPanel extends JPanel {
	
	private JPanel fromSelectionPanel;
	private JPanel toSelectionPanel;
	
	private ArrayList<JToggleButton> fromButtons;
	private ArrayList<JToggleButton> toButtons;
	
	private ButtonGroup fromGroup;
	private ButtonGroup toGroup;
	
	private SelectionPanel()
	{
		System.err.println("SelectionPanel's constructor should never be called!");
	}
	
	public SelectionPanel(int rodCount) {
		fromButtons = new ArrayList<JToggleButton>(rodCount);
		toButtons 	= new ArrayList<JToggleButton>(rodCount);
		
		this.setLayout(new GridLayout(2, 1));
		
		fromSelectionPanel = new JPanel();
		toSelectionPanel = new JPanel();
		
		this.add(fromSelectionPanel);
		this.add(toSelectionPanel);
		
		fromGroup 	= addSelectionButtons(rodCount, "from", fromSelectionPanel, fromButtons);
		toGroup 	= addSelectionButtons(rodCount, "to", toSelectionPanel, toButtons);
	}
	
	private ButtonGroup addSelectionButtons(int rodCount, String btnLabel, JPanel target, ArrayList<JToggleButton> toggleButtons)
	{		
		target.setLayout(new GridLayout(1, rodCount));
		
		ButtonGroup group = new ButtonGroup();
		
		for (int i = 1; i <= rodCount; i++)
		{
			JToggleButton toggle = new JToggleButton(btnLabel + " " + i);
			
			group.add(toggle);
			target.add(toggle);
			
			// save reverences to toggle button for later
			toggleButtons.add(toggle);
		}
		
		return group;
	}
	
	public int getSelectedFromButton() {
		
		for (int i = 0; i < fromButtons.size(); i++)
		{
			JToggleButton toggle = fromButtons.get(i);
			
			if (toggle.isSelected())
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public int getSelectedToButton() {
		
		for (int i = 0; i < toButtons.size(); i++)
		{
			JToggleButton toggle = toButtons.get(i);
			
			if (toggle.isSelected())
			{
				return i;
			}
		}
		
		return -1;
	}
}