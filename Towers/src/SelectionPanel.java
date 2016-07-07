import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

// Holds the UI elements for the selection of the disk movement
public class SelectionPanel extends JPanel implements ActionListener{
	
	private JPanel fromSelectionPanel;
	private JPanel toSelectionPanel;
	
	private SelectionPanel()
	{
		System.err.println("SelectionPanel's constructor should never be called!");
	}
	
	public SelectionPanel(int rodCount) {
		this.setLayout(new GridLayout(2, 1));
		
		fromSelectionPanel = new JPanel();
		toSelectionPanel = new JPanel();
		
		this.add(fromSelectionPanel);
		this.add(toSelectionPanel);
		
		addSelectionButtons(rodCount, "from", fromSelectionPanel);
		addSelectionButtons(rodCount, "to", toSelectionPanel);
	}
	
	private ButtonGroup addSelectionButtons(int rodCount, String btnLabel, JPanel target)
	{		
		target.setLayout(new GridLayout(1, rodCount));
		
		ButtonGroup group = new ButtonGroup();
		
		for (int i = 0; i < rodCount; i++)
		{
			JToggleButton toggle = new JToggleButton(btnLabel);
			toggle.addActionListener(this);
			group.add(toggle);
			target.add(toggle);
		}
		
		return group;
	}

	public void actionPerformed(ActionEvent arg0) {
		
	}
}
