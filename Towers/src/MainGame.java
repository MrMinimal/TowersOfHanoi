import java.util.Random;

import javax.swing.JOptionPane;

/**
 * Saves the settings passed via command line into a Settings object.
 * Instantiates the Model View Controller objects and assigns the references they have with each other.
 */
public class MainGame {
	
	public static void main(String[] args) {
		Settings settings = GameModeCreator.parseSettings(args);
		
		// MVC Objects	
		GameModel 		model;
		GameView 		view;		
		GameController 	controller;		
		
		boolean isAutoPlayMode = (settings.getMode() == Settings.InteractionMode.AUTOPLAY);
		
		model 			= new GameModel(settings);
		view 			= new GameView(isAutoPlayMode, settings.getWindowHeight(), settings.getWindowWidth(), settings.getRodCount(), settings.getTotalDisks());				// TODO: remove hard coded window size and rod count
		controller		= new GameController(model, view);	
		
		// view needs a reference to the controller for the Button pressed callbacks to it
		view.assignController(controller);
    }
}