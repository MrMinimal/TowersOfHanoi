import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JPanel;

/**
 * Displays the rods and the disks placed upon them
 * 
 * @author Tom Langwaldt
 *
 */
public class DisplayPanel extends JPanel {

	private static final float ROD_WIDTH = 0.02f; 	// percentage based, e.g. 0.3f
													// is 30% of the panels
													// width
	private static final float ROD_HEIGHT = 0.8f; 	// percentage based, e.g. 0.3f
													// is 30% of the panels
													// height
	private static final float BASE_HEIGHT = 0.04f; // percentage based, e.g.
													// 0.3f is 30% of the panels
													// height
	private static final float DISK_BEVEL = 0.3f; 	// percentage based, e.g. 0.3f
													// is 30% of the disks width
	private static final float DISK_WIDTH = 0.2f; 	// percentage based, e.g. 0.3f
													// is 30% of the panels
													// width

	private static final int COUNTER_OFFSET_X = 10;
	private static final int COUNTER_OFFSET_Y = 20;

	private int stepCount;

	private int rodCount;
	private float diskHeight; 	// max height a disk can have in order to fit all
								// of them onto one rod

	private ArrayList<ArrayList<DrawDiskTask>> rods;

	/**
	 * Constructor without parameters should never be called.
	 */
	private DisplayPanel() {
		System.err.println("DisplayPanel's constructor should never be called!");
	}

	/**
	 * Creates a JPanel which shows the rods and prepares the object to take
	 * draw tasks later. Sets the displayed height for the disks, so that the
	 * disks can potentially all visually fit onto one rod.
	 * 
	 * @param rodCount
	 * @param maxDiskAmount
	 */
	public DisplayPanel(int rodCount, int maxDiskAmount) {
		this.rodCount = rodCount;
		this.diskHeight = ROD_HEIGHT / maxDiskAmount;

		this.rods = new ArrayList<ArrayList<DrawDiskTask>>(rodCount);

		for (int i = 0; i < rodCount; i++) {
			this.rods.add(new ArrayList<DrawDiskTask>());
		}
	}

	/**
	 * Responsible for displaying rods, step counter and disks on the
	 * displayPanel. Called every time the main frame is resized or repaint() is
	 * called on this panel.
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		// Draw base plate
		int baseWidth = this.getWidth();
		int baseHeight = (int) (this.getHeight() * BASE_HEIGHT);
		int basePosY = this.getHeight() - baseHeight;

		g.setColor(Color.BLACK);
		g.fillRect(0, basePosY, baseWidth, baseHeight);

		// Draw rods and according disks for each one
		for (int i = 1; i <= rodCount; i++) {
			int rodWidth = (int) (this.getWidth() * ROD_WIDTH);
			int rodHeight = (int) (this.getHeight() * ROD_HEIGHT);

			int rodOffsetX = getWidth() / this.rodCount;

			int rodPosX = (int) ((rodOffsetX * i) - (rodWidth / 2) - (rodOffsetX / 2));
			int rodPosY = (this.getHeight() - rodHeight) - baseHeight;

			g.setColor(Color.BLACK);
			g.fillRect(rodPosX, rodPosY, rodWidth, rodHeight);

			// draw disks for current rod
			for (int j = 1; j <= this.rods.get(i - 1).size(); j++) {
				DrawDiskTask task = (DrawDiskTask) this.rods.get(i - 1).get(j - 1);

				int diskWidthPx = (int) (this.getWidth() * DISK_WIDTH * task.getRadius());
				int diskHeightPx = (int) (this.getHeight() * diskHeight);

				int diskPosX = (int) ((rodOffsetX * i) - (diskWidthPx / 2) - (rodOffsetX / 2));
				int diskPosY = (int) (this.getHeight() - baseHeight - (diskHeightPx * j));

				int diskBevel = (int) (diskWidthPx * DISK_BEVEL);

				DiskColor diskColor = task.getColor();
				Color finalColor = new Color(diskColor.getR(), diskColor.getG(), diskColor.getB());
				g.setColor(finalColor);

				g.fillRoundRect(diskPosX, diskPosY, diskWidthPx, diskHeightPx, diskBevel, diskBevel);
			}
		}

		// draw step counter
		g.setColor(Color.BLACK);
		g.drawString("Total steps: " + this.stepCount, COUNTER_OFFSET_X, COUNTER_OFFSET_Y);
	}

	/**
	 * Save a draw task for a disk in this object, will be drawn, the next time
	 * paint() is called.
	 * 
	 * @param rod
	 *            Index of the rod starting with the leftmost rod having an
	 *            index of 0.
	 * @param task
	 *            The task which will be added for the paint() method. Holds
	 *            information about colour and size of the disk.
	 */
	public void addDrawTask(int rod, DrawDiskTask task) {
		this.rods.get(rod).add(task);
	}

	/**
	 * Clear all draw tasks, so that new ones can be added in case the
	 * arrangement of the disks changes.
	 */
	public void flushDrawTasks() {
		for (ArrayList<DrawDiskTask> rod : rods) {
			rod.clear();
		}
	}

	/**
	 * Increase the step counter by +1.
	 */
	public void incrementStepCount() {
		this.stepCount++;
	}

	/**
	 * Set the step counter to 0.
	 */
	public void resetStepCount() {
		this.stepCount = 0;
	}
}
