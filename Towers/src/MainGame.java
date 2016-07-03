
public class MainGame {
	
	public static void main(String[] args) {
		Settings settings = GameModeCreator.parseSettings(args);
		
		// MVC Objects	
		GameModel 		model;			// Holds the necessary data for the game
		GameView 		view;			// Displays the data if the controller tells it to
		//GameController 	controller;		// Handles the interaction between the data and the GUI
		
		model 			= new GameModel(settings);
		view 			= new GameView(600, 800);				// TODO: remove hard coded window size
		//controller	= new GameController(model, view);
		
		// New comment
		model.moveDisks(0, 1);
		
		System.out.println("ich bin eine Biene");
	}
}