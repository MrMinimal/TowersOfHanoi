import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

// Displays the towers and the rings placed on them
public class DisplayPanel extends JPanel {

	private static final float ROD_WIDTH = 0.02f;		// percentage based, e.g. 0.3f is 30% of the panels width
	private static final float ROD_HEIGHT = 0.8f;		// percentage based, e.g. 0.3f is 30% of the panels height
	private static final float BASE_HEIGHT = 0.04f;		// percentage based, e.g. 0.3f is 30% of the panels height
	
	private int rodCount = 0;
	
	private DisplayPanel() {
		System.err.println("DisplayPanel's constructor should never be called!");
	}
	
	public DisplayPanel(int rodCount)
	{	
		this.rodCount = rodCount;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		// Draw base plate
		int baseWidth = this.getWidth();
		int baseHeight = (int)(this.getHeight() * BASE_HEIGHT);
		int basePosY = this.getHeight() - baseHeight;
		
		g.fillRect(0, basePosY, baseWidth, baseHeight);
		
		
		
		// Draw rods
		for (int i = 1; i <= rodCount; i++){
			int rodWidth = (int)(this.getWidth() * ROD_WIDTH);
			int rodHeight = (int)(this.getHeight() * ROD_HEIGHT);
			
			int rodOffsetX = getWidth() / (this.rodCount + 1);
			int rodPosX = (rodOffsetX * i) - (int)(ROD_WIDTH / 2);
			int rodPosY = (this.getHeight() - rodHeight) - baseHeight;
			
			g.fillRect(rodPosX, rodPosY, rodWidth, rodHeight );
		}
	}
}
