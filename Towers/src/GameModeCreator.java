
// Provides a static method to parse the applications parameters in order to retrieve
// a GameObject with set settings
public abstract class GameModeCreator{
	
	private final static int DISK_INDEX = 0;			// at which position in the arguments the "disk amount" is expected
	private final static int MIN_DISKAMOUNT = 4;
	
	private GameModeCreator() {
		System.err.println("GameModeCreators default constructor should never be called");
	}
	
	// Returns all the settings input via the parameters of the main application
	public static Settings parseSettings(String[] settings){
		int totalDisks 					= 0;		// not zero in case a disk amount was passed
		int delay 						= 1;		// default value one second unless set otherwise via arguments
		Settings.InteractionMode mode 	= Settings.InteractionMode.INTERACTIVE;
		
		// iterate over arguments
		for (int i = 0; i < settings.length; i++){
			
			String value = settings[i];
			
			// parse disk number
			if (i == DISK_INDEX){
				try{
					// try to check whether a disk amount was passed, stays at default value, if none was passed
					totalDisks = Integer.parseInt(settings[i]);
				}catch (NumberFormatException e){
					// TODO handle exception
				}
			}

			// mode
			if (value.contains("autoplay")){
				mode = Settings.InteractionMode.AUTOPLAY;
			}
			
			// parse delay
			if (value.contains("delay")){
				// The last value passed to the application is the delay
				// It is expected that there is a delay provided if the arguments contain "delay"
				delay = Integer.parseInt(settings[settings.length - 1]);
			}
		}
		
		// requirement for the application
		if (totalDisks < MIN_DISKAMOUNT){
			totalDisks = MIN_DISKAMOUNT;
		}
		
		// holds all settings parsed
		return new Settings(mode, totalDisks, delay);
	}
}
