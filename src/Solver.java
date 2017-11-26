import javax.swing.DefaultListModel;

public class Solver {
	
	private GUI  gui;
	private DefaultListModel<FeatureCollection> training,unsolved;
	
	public Solver() {
		training = new DefaultListModel<FeatureCollection>();
		unsolved = new DefaultListModel<FeatureCollection>();
		gui = new GUI(training,unsolved);
		
	}
	
	
	public static void main(String[] args) {
		new Solver();	
	}
}

