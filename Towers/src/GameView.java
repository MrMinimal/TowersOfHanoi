import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

// Is responsible for displaying the game
public class GameView {
	
	private static float DISPLAY_HEIGHT = 0.8f;			// percentage based, e.g. 0.3f is 30% of the mainFrames height
	
	private JFrame mainFrame;
	
	private DisplayPanel display;
	
	private GameView()
	{
		System.err.println("GameViews's constructor should never be called!");
	}
	
	public GameView(int windowWidth, int windowHeight)
	{
		mainFrame = new JFrame("Towers of Hanoi");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(windowWidth, windowHeight);
		mainFrame.setResizable(false);
		
		mainFrame.setLayout(new BorderLayout());
		
		fillContents(windowWidth, windowHeight);
		
		mainFrame.setVisible(true);
	}

	private void fillContents(int windowWidth, int windowHeight) {
		// add display
		int displayDesiredHeight = (int)(DISPLAY_HEIGHT * windowHeight);
		
		this.display = new DisplayPanel(3);
		this.display.setPreferredSize(new Dimension(0, displayDesiredHeight));
		
		mainFrame.getContentPane().add(this.display, BorderLayout.PAGE_START);
	}
}
