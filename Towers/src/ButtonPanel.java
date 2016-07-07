import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

// Holds all buttons of the UI
public class ButtonPanel extends JPanel {
	
	public ButtonPanel() {
		// TODO: mach schoen 
		this.add(new JButton("Commit"));
		this.add(new JButton("Reset"));
	}
}
