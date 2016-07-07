import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

// Is responsible for displaying the game
public class GameView {
	
	private static float DISPLAY_HEIGHT = 0.8f;			// percentage based, e.g. 0.3f is 30% of the mainFrames height
	private static float BUTTONPANEL_HEIGHT = 0.05f;	// percentage based, e.g. 0.3f is 30% of the mainFrames height
	
	private JFrame mainFrame;
	
	private DisplayPanel displayPanel;
	private SelectionPanel selectionPanel;
	private ButtonPanel	buttonPanel;
	
	private int rodCount;
	
	private GameView()
	{
		System.err.println("GameViews's constructor should never be called!");
	}
	
	public GameView(int windowWidth, int windowHeight, int rodCount)
	{
		this.rodCount = rodCount;
		
		this.mainFrame = new JFrame("Towers of Hanoi");
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setSize(windowWidth, windowHeight);
		//this.mainFrame.setResizable(false);
		
		this.mainFrame.setLayout(new BorderLayout());
		
		fillContents(windowWidth, windowHeight);
		
		this.mainFrame.setVisible(true);
	}

	private void fillContents(int windowWidth, int windowHeight) {
		// add display
		int displayDesiredHeight = (int)(DISPLAY_HEIGHT * windowHeight);
		
		this.displayPanel = new DisplayPanel(3);
		this.displayPanel.setPreferredSize(new Dimension(0, displayDesiredHeight));
		
		this.mainFrame.getContentPane().add(this.displayPanel, BorderLayout.PAGE_START);
		
		// add selection
		this.selectionPanel = new SelectionPanel(this.rodCount);
		this.mainFrame.add(this.selectionPanel, BorderLayout.CENTER);
		
		// add buttons
		this.buttonPanel = new ButtonPanel();
		this.buttonPanel.setPreferredSize(new Dimension(0, (int)(windowHeight * BUTTONPANEL_HEIGHT) ));
		this.mainFrame.add(this.buttonPanel, BorderLayout.PAGE_END);
	}
}
