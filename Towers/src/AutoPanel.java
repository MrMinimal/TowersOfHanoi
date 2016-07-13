import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AutoPanel extends JPanel {
	
	private static final String AUTO_HELP_TEXT 			= 	"Press \"Start\" to make the game solve itself \n"		+
															"Press \"Reset\" to stop the game and start anew \n";
													
	private GameView view;
	private boolean isAutoPlayMode;
	
	public AutoPanel(GameView view) {
		super();
		
		this.view = view;
		this.isAutoPlayMode = isAutoPlayMode;
		
		JButton startAutoplayBtn = new JButton("Start");
		JButton resetAutoplayBtn = new JButton("Reset");
		JButton helpBtn 	= new JButton("Help");
		
		startAutoplayBtn.addActionListener(this::startEvent);
		resetAutoplayBtn.addActionListener(this::resetEvent);
		helpBtn.addActionListener(this::helpEvent);
		
		this.add(startAutoplayBtn);
		this.add(resetAutoplayBtn);
		this.add(helpBtn);
	}
	
	private void startEvent(ActionEvent event)
	{
		view.startButtonEvent(event);
	}
	
	private void resetEvent(ActionEvent event)
	{
		view.resetButtonEvent(event);
	}
	
	private void helpEvent(ActionEvent event)
	{		
		view.showError(AUTO_HELP_TEXT);
	}
}
