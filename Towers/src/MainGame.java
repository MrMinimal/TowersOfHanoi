import java.util.Random;

import javax.swing.JOptionPane;

public class MainGame {
	
	public static void main(String[] args) {
		Settings settings = GameModeCreator.parseSettings(args);
		
		// MVC Objects	
		GameModel 		model;			// Holds the necessary data for the game
		GameView 		view;			// Displays the data if the controller tells it to
		GameController 	controller;		// Handles the interaction between the data and the GUI
		
		model 			= new GameModel(settings);
		view 			= new GameView(settings.getWindowHeight(), settings.getWindowWidth(), settings.getRodCount(), settings.getTotalDisks());				// TODO: remove hard coded window size and rod count
		controller		= new GameController(model, view);	
		
		view.assignController(controller);
		
		//model.moveDisks(0, 1);
		
		// TODO: remove debug disks
		Random rnd = new Random();
		
//		view.drawDisk(0, new Disk(0.5f, new DiskColor(rnd.nextInt(256),  rnd.nextInt(256), rnd.nextInt(256))));
//		view.drawDisk(0, new Disk(0.5f, new DiskColor(rnd.nextInt(256),  rnd.nextInt(256), rnd.nextInt(256))));
//		view.drawDisk(0, new Disk(0.5f, new DiskColor(rnd.nextInt(256),  rnd.nextInt(256), rnd.nextInt(256))));
//		view.drawDisk(1, new Disk(0.5f, new DiskColor(rnd.nextInt(256),  rnd.nextInt(256), rnd.nextInt(256))));
//		view.drawDisk(2, new Disk(0.5f, new DiskColor(rnd.nextInt(256),  rnd.nextInt(256), rnd.nextInt(256))));
//		view.drawDisk(2, new Disk(0.5f, new DiskColor(rnd.nextInt(256),  rnd.nextInt(256), rnd.nextInt(256))));
		
		view.showError("OMG WTF BBQ");
		
		System.out.println("ich bin eine Biene");
    }
}