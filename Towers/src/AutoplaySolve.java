import java.util.Stack;

public class AutoplaySolve extends Thread{

	GameController gameController;
	boolean isMoving;
	
	private static final int SECONDS_FACTOR = 100;
	
	
	public AutoplaySolve(GameController gameController, boolean isMoving)
	{
		this.gameController = gameController;
		this.isMoving = isMoving;
		this.start();
	
	}
	
	@Override
	public void run() 
	{
		Autoplay(gameController.getSettings().getTotalDisks(),gameController.getRods().get(0),gameController.getRods().get(1),gameController.getRods().get(2));	
	}
	
	public void Autoplay(int diskCount,Stack<Disk> rod1,Stack<Disk> rod2,Stack<Disk> rod3)
	{
		if(diskCount == 1)
		{
			gameController.moveDisks(rod1, rod3);
			gameController.refresh();
			try {
				this.sleep(gameController.getSettings().getStepDelay() * SECONDS_FACTOR);
			} catch (InterruptedException e) {
				
			}
		}
		else
		{
			Autoplay(diskCount-1, rod1,rod3,rod2);
			
			gameController.moveDisks(rod1, rod3);
			gameController.refresh();
			
			try {
				this.sleep(gameController.getSettings().getStepDelay() * SECONDS_FACTOR);
			} catch (InterruptedException e) {
				
			}
			
			Autoplay(diskCount-1,rod2,rod1,rod3);
		}
	}
}
