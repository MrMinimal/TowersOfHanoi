import java.util.ArrayList;
import java.util.Stack;

public class GameController {

	private GameModel gameModel;
	private GameView gameView;
	private Stack<Disk> originRod; //TODO: schoener
	
	private boolean isMoving;
	
	private GameController()
	{
	 System.err.println("GameController's constructor should never be called!");
    }
	
	public GameController(GameModel gameModel, GameView gameView)
	{
		this.gameModel = gameModel;
		this.gameView = gameView;
		init();
		/*if(gameModel.getSettings().getMode().equals(gameModel.getSettings().getMode().AUTOPLAY))
		{
			isMoving = true;
			int disks = getSettings().getTotalDisks();
			Stack<Disk> rod1 = getRods().get(0);
			Stack<Disk> rod2 = getRods().get(1);
			Stack<Disk> rod3 = getRods().get(2);
			new AutoplaySolve(this, isMoving);
		}*/
		
	}
	
	public void interactiveSolve(int from, int to)
	{
		// sanity checks
		if (from < 0) 
		{
			gameView.showError("Please select a rod to move from!");
			return;
		}
		
		if (to < 0) 
		{
			gameView.showError("Please select a rod to!");
			return;
		}
		
		Stack<Disk> fromRod = getRods().get(from);
		Stack<Disk> toRod = getRods().get(to);
		validate(fromRod,toRod);
		check();
	}
	
	//if commit-button pressed
	public void validate(Stack<Disk> rod1, Stack<Disk> rod2)
	{
		if(rod1.isEmpty())
		{
			gameView.showError("There are no disks at that rod for moving!");
			return;
		}
		
		if(rod2.isEmpty())
		{
			// No radius comparison needed
			gameModel.moveDisks(rod1, rod2);
			refresh();
		}
		else
		{
			if(rod1.peek().getRadius() > rod2.peek().getRadius() )
			{
				gameView.showError("The disk is bigger than the disk of the destination rod!");
			}
			else
			{
				gameModel.moveDisks(rod1, rod2);
				refresh();
			}
		}
	}
	
	private void init()
	{
		originRod = gameModel.getRods().get(0);
		for(int i = 0; i < originRod.size(); i++)
		{
			gameView.drawDisk(0, originRod.get(i));
		}
		gameView.updateView();
		check();
	}
	
	public void refresh()
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
	public void check()
	{
		if(gameModel.getRods().get(2).size() == gameModel.getSettings().getTotalDisks())
		{
			gameView.showError("Congrats! You got it!"); 
			isMoving = false;
		}
	}
	
	public void reset()
	{
		gameModel.reset();
		refresh();
	}
	
	public void moveDisks(Stack<Disk> rod1, Stack<Disk> rod2)
	{
		gameModel.moveDisks(rod1, rod2);
	}
	
	public Settings getSettings()
	{
		return gameModel.getSettings();
	}
	
	public ArrayList<Stack<Disk>> getRods()
	{
		return gameModel.getRods();
	}
}
