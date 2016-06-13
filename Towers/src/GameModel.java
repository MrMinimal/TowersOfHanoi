import java.util.ArrayList;
import java.util.Stack;

// class which holds all relevant data for the game
public class GameModel {
	private static final int rodNumber = 3;

	private Settings settings;

	private ArrayList<Stack<Disk>> rods = new ArrayList<Stack<Disk>>(3);

	private GameModel() {
		System.err.println("This constructor should never be called!");
	}

	public GameModel(Settings settings) {
		this.settings = settings;

		// add rods to the list
		for (int i = 0; i < rodNumber; i++) {
			this.rods.add(new Stack());
		}
		
		fillFirstRod();
	}
	
	// fills the first rod with disks, according to the settings passed in the constructor
	private void fillFirstRod(){
		
		for (int i = 0; i < settings.getTotalDisks(); i++){
			DiskColor 	color 		= new DiskColor(255, 0, 0);
			Disk 		disk 		= new Disk(5, color);			// TODO: remove hard coded radius	
			
			this.rods.get(0).push(disk); 				
		}
	}
}
