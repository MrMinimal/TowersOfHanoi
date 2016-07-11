import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

// Holds all buttons of the UI
public class ButtonPanel extends JPanel {
	
	private GameView view;
	
	public ButtonPanel(GameView view) {
		// TODO: mach schoen 
		
		this.view = view;
		
		JButton commitBtn = new JButton("Commit"); 
		JButton resetBtn = new JButton("Reset");
		
		commitBtn.addActionListener(this::commitEvent);
		resetBtn.addActionListener(this::resetEvent);
		
		this.add(commitBtn);
		this.add(resetBtn);
	}
	
	private void commitEvent(ActionEvent event)
	{
		view.commi1tButtonEvent(event);
	}
	
	private void resetEvent(ActionEvent event)
	{
		view.resetButtonEvent(event);
	}
}
