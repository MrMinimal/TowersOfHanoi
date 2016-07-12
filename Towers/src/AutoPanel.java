import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AutoPanel extends JPanel {
	
	private GameView view;
	
	public AutoPanel(GameView view) {
		super();
		
		this.view = view;
		
		JButton startAutoplay = new JButton("Start");
		JButton resetAutoplay = new JButton("Reset");
		
		startAutoplay.addActionListener(this::startEvent);
		resetAutoplay.addActionListener(this::resetEvent);
		
		this.add(startAutoplay);
		this.add(resetAutoplay);
	}
	
	private void startEvent(ActionEvent event)
	{
		view.startButtonEvent(event);
	}
	
	private void resetEvent(ActionEvent event)
	{
		view.resetButtonEvent(event);
	}
}
