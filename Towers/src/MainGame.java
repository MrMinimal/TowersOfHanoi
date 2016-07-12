import java.util.Random;

import javax.swing.JOptionPane;

public class MainGame {
	
	public static void main(String[] args) {
		Settings settings = GameModeCreator.parseSettings(args);
		
		// MVC Objects	
		GameModel 		model;			// Holds the necessary data for the game
		GameView 		view;			// Displays the data if the controller tells it to
		GameController 	controller;		// Handles the interaction between the data and the GUI
		
		boolean isAutoPlayMode = (settings.getMode() == Settings.InteractionMode.AUTOPLAY);
		
		model 			= new GameModel(settings);
		view 			= new GameView(isAutoPlayMode, settings.getWindowHeight(), settings.getWindowWidth(), settings.getRodCount(), settings.getTotalDisks());				// TODO: remove hard coded window size and rod count
		controller		= new GameController(model, view);	
		
		view.assignController(controller);
    }
}