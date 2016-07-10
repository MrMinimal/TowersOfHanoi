import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JPanel;

// Displays the towers and the rings placed on them
public class DisplayPanel extends JPanel {

	private static final float ROD_WIDTH = 0.02f;		// percentage based, e.g. 0.3f is 30% of the panels width
	private static final float ROD_HEIGHT = 0.8f;		// percentage based, e.g. 0.3f is 30% of the panels height
	private static final float BASE_HEIGHT = 0.04f;		// percentage based, e.g. 0.3f is 30% of the panels height
	private static final float DISK_BEVEL = 0.3f;		// percentage based, e.g. 0.3f is 30% of the disks width
	
	private int rodCount;
	private float diskHeight;					// max height a disk can have in order to fit all of them onto one rod
	
	private ArrayList<ArrayList<DrawDiskTask>> rods;
	
	private DisplayPanel() {
		System.err.println("DisplayPanel's constructor should never be called!");
	}
	
	public DisplayPanel(int rodCount, int maxDiskAmount)
	{	
		this.rodCount = rodCount;
		this.diskHeight = ROD_HEIGHT / maxDiskAmount;					
	
		this.rods = new ArrayList<ArrayList<DrawDiskTask>>(rodCount);
		
		for (int i = 0; i < rodCount; i++) {
			this.rods.add(new ArrayList<DrawDiskTask>());
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		// Draw base plate
		int baseWidth = this.getWidth();
		int baseHeight = (int)(this.getHeight() * BASE_HEIGHT);
		int basePosY = this.getHeight() - baseHeight;
		
		g.setColor(Color.BLACK);
		g.fillRect(0, basePosY, baseWidth, baseHeight);
		
	
		// Draw rods and according disks for each one
		for (int i = 1; i <= rodCount; i++){
			int rodWidth = (int)(this.getWidth() * ROD_WIDTH);
			int rodHeight = (int)(this.getHeight() * ROD_HEIGHT);
			
			int rodOffsetX = getWidth() / this.rodCount;
			
			int rodPosX = (int)( (rodOffsetX * i) - (rodWidth / 2) - (rodOffsetX / 2) );
			int rodPosY = (this.getHeight() - rodHeight) - baseHeight;
			
			g.setColor(Color.BLACK);
			g.fillRect(rodPosX, rodPosY, rodWidth, rodHeight );
			
			// draw disks for current rod
			for (int j = 1; j <= this.rods.get(i - 1).size(); j++)
			{
				DrawDiskTask task = (DrawDiskTask)this.rods.get(i - 1).get(j - 1);
				
				int diskWidthPx = (int)(this.getWidth() * 0.2f);
				int diskHeightPx = (int)(this.getHeight() * diskHeight);
				
				int diskPosX = (int)((rodOffsetX * i) - (diskWidthPx / 2) - (rodOffsetX / 2));
				int diskPosY = (int)(this.getHeight() - baseHeight - (diskHeightPx * j));
				
				int diskBevel = (int)(diskWidthPx * DISK_BEVEL);
				
				DiskColor diskColor = task.getColor();
				Color finalColor = new Color(diskColor.getR(), diskColor.getG(), diskColor.getB());
				g.setColor(finalColor);
				
				g.fillRoundRect(diskPosX, diskPosY, diskWidthPx, diskHeightPx, diskBevel, diskBevel);
			}
		}
	}
	
	// add tasks which will be drawn the next time the paint method is called
	public void addDrawTask(int rod, DrawDiskTask task)
	{
		this.rods.get(rod).add(task);
	}
	
	public void flushDrawTasks()
	{
		for (ArrayList<DrawDiskTask> rod : rods)
		{
			rod.clear();
		}
	}
}
