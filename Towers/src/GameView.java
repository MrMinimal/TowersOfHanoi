import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

// Is responsible for displaying the game
public class GameView {
	
	private static float DISPLAY_HEIGHT = 0.8f;			// percentage based, e.g. 0.3f is 30% of the mainFrames height
	private static float BUTTONPANEL_HEIGHT = 0.05f;	// percentage based, e.g. 0.3f is 30% of the mainFrames height
	
	private JFrame mainFrame;
	
	private GameController controller;
	
	private DisplayPanel displayPanel;
	private SelectionPanel selectionPanel;
	private ButtonPanel	buttonPanel;
	
	private int rodCount;
	private int maxDiskAmount;
	
	private GameView()
	{
		System.err.println("GameViews's constructor should never be called!");
	}
	
	public GameView(int windowWidth, int windowHeight, int rodCount, int maxDiskAmount)
	{
		this.rodCount = rodCount;
		this.maxDiskAmount = maxDiskAmount;
		
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
		
		this.displayPanel = new DisplayPanel(this.rodCount, this.maxDiskAmount);
		this.displayPanel.setPreferredSize(new Dimension(0, displayDesiredHeight));
		
		this.mainFrame.getContentPane().add(this.displayPanel, BorderLayout.PAGE_START);
		
		// add selection
		this.selectionPanel = new SelectionPanel(this.rodCount);
		this.mainFrame.add(this.selectionPanel, BorderLayout.CENTER);
		
		// add buttons
		this.buttonPanel = new ButtonPanel(this);
		this.buttonPanel.setPreferredSize(new Dimension(0, (int)(windowHeight * BUTTONPANEL_HEIGHT) ));
		this.mainFrame.add(this.buttonPanel, BorderLayout.PAGE_END);
	}
	
	// draw a disk on the display the next time it is painted
	// Every consecutive call is interpreted as another disk added on top.
	// To start over, call resetView() and add tasks again
	public void drawDisk(int rodIndex, Disk disk){
		
		DrawDiskTask task = new DrawDiskTask(disk.getRadius(), disk.getColor());
		displayPanel.addDrawTask(rodIndex, task);
	}
	
	public void resetView()
	{
		this.displayPanel.flushDrawTasks();
	}
	
	// manually apply changes to UI
	public void updateView()
	{
		this.displayPanel.repaint();
	}
	
	// Display popup dialog
	public void showError(String message)
	{
		JOptionPane.showMessageDialog(this.mainFrame, message, "Towers of Hanoi", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public int getSelectedFromButton()
	{
		return selectionPanel.getSelectedFromButton();
	}
	
	public int getSelectedToButton()
	{
		return selectionPanel.getSelectedToButton();
	}

	public void assignController(GameController controller) {
		this.controller = controller;
	}

	public void commi1tButtonEvent(ActionEvent event) {
		// TODO tell controller to do shit
	}

	public void resetButtonEvent(ActionEvent event) {
		// TODO Auto-generated method stub
	}
}