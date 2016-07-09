
public class MainGame {
	
	public static void main(String[] args) {
		Settings settings = GameModeCreator.parseSettings(args);
		
		// MVC Objects	
		GameModel 		model;			// Holds the necessary data for the game
		GameView 		view;			// Displays the data if the controller tells it to
		//GameController 	controller;		// Handles the interaction between the data and the GUI
		
		model 			= new GameModel(settings);
		view 			= new GameView(600, 800, settings.getRodCount(), settings.getTotalDisks());				// TODO: remove hard coded window size and rod count
		//controller	= new GameController(model, view);
		
		model.moveDisks(0, 1);
		
		// TODO: remove debug disks
		view.drawDisk(0, new Disk(0.5f, new DiskColor(200,  0, 0)));
		view.drawDisk(0, new Disk(0.5f, new DiskColor(0,  255, 0)));
		view.drawDisk(0, new Disk(0.5f, new DiskColor(0,  0, 255)));
		view.drawDisk(1, new Disk(0.5f, new DiskColor(0,  0, 255)));
		view.drawDisk(2, new Disk(0.5f, new DiskColor(0,  255, 0)));
		view.drawDisk(2, new Disk(0.5f, new DiskColor(255,  0, 0)));
		
		System.out.println("ich bin eine Biene");
	}
}