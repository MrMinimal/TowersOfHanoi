
public class MainGame {
	
	public static void main(String[] args) {
		Settings settings = GameModeCreator.parseSettings(args);
		
		// MVC Objects	
		GameModel 		model;			// Holds the neccessary data for the game
		GameView 		view;			// Displays the data if the controller tells it to
		GameController 	controller;		// Handles the interaction between the data and the GUI
		
		model 		= new GameModel(settings);
		view 		= new GameView();
		controller	= new GameController(model, view);
		
		model.moveDisks(0, 1);
	}
}
