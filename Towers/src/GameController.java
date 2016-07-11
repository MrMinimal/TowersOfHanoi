import java.util.ArrayList;
import java.util.Stack;

public class GameController {

	private GameModel gameModel;
	private GameView gameView;
	
	private GameController()
	{
	 System.err.println("GameController's constructor should never be called!");
    }
	
	public GameController(GameModel gameModel, GameView gameView)
	{
		this.gameModel = gameModel;
		this.gameView = gameView;
		init();
		if(gameModel.getSettings().getMode().equals(gameModel.getSettings().getMode().AUTOPLAY))
		{
			int disks = gameModel.getSettings().getTotalDisks();
			Stack<Disk> rod1 = gameModel.getRods().get(0);
			Stack<Disk> rod2 = gameModel.getRods().get(1);
			Stack<Disk> rod3 = gameModel.getRods().get(2);
			AutoplaySolve(disks,rod1,rod2,rod3);
		}else
		{
			// TODO: get selected rods from view
			//InteractiveSolve();
		}
		
	}
	
	public void AutoplaySolve(int diskCount,Stack<Disk> rod1,Stack<Disk> rod2,Stack<Disk> rod3)
	{
		if(diskCount == 1)
		{
			gameModel.moveDisks(rod1, rod3);
			refresh();
		}else
		{
			AutoplaySolve(diskCount-1, rod1,rod3,rod2);
			gameModel.moveDisks(rod1, rod2);
			refresh();
			
			AutoplaySolve(diskCount-1,rod2,rod1,rod3);
		}
	}
	//if commit-button pressed
	public void InteractiveSolve(Stack<Disk> rod1, Stack<Disk> rod2)
	{
		if(rod1.isEmpty())
		{
			//throw exception
		}else
		if(rod1.peek().getRadius() > rod2.peek().getRadius())
		{
			//throw exception
		}else{
		gameModel.moveDisks(rod1, rod2);
		refresh();
		}
	}
	
	private void init()
	{
		Stack<Disk> originRod = gameModel.getRods().get(0);
		for(int i = 0; i < originRod.size(); i++)
		{
			gameView.drawDisk(0, originRod.get(i));
		}
		gameView.updateView();
		check();
	}
	
	private void refresh()
	{
		gameView.resetView();
		for(int i = 0; i < gameModel.getRods().size(); i++)
		{
			Stack<Disk> originRod = gameModel.getRods().get(i);
			for (int j = 0; j < originRod.size(); j++)
			{
				gameView.drawDisk(i, originRod.get(j));
			}
		}
		gameView.updateView();
	}
	private void check()
	{
		if(gameModel.getRods().get(2).size() == gameModel.getSettings().getTotalDisks())
		{
			//finish, ausgabe auf panel 
		}
	}
}
