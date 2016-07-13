import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

// Holds all buttons of the UI
public class ButtonPanel extends JPanel {
	
	private static final String INTERACTIVE_HELP_TEXT 	= 	"1. Select one Rod to move disks from \n"				+
															"2. Select one Rod to move disks to \n"					+
															"3. Press \"Commit\" to actually move the disks \n\n"	+
															"Press \"Reset\" to stop the game and start anew \n";
	
	private GameView view;
	
	public ButtonPanel(GameView view) {
		// TODO: mach schoen 
		
		this.view = view;
		
		JButton commitBtn 	= new JButton("Commit"); 
		JButton resetBtn 	= new JButton("Reset");
		JButton helpBtn 	= new JButton("Help");
		
		commitBtn.addActionListener(this::commitEvent);
		resetBtn.addActionListener(this::resetEvent);
		helpBtn.addActionListener(this::helpEvent);
		
		this.add(commitBtn);
		this.add(resetBtn);
		this.add(helpBtn);
	}
	
	private void commitEvent(ActionEvent event)
	{
		view.commi1tButtonEvent(event);
	}
	
	private void resetEvent(ActionEvent event)
	{
		view.resetButtonEvent(event);
	}

	private void helpEvent(ActionEvent event)
	{		
		view.showError(INTERACTIVE_HELP_TEXT);
	}
}
