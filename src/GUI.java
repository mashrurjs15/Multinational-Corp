import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class GUI {
	private JFrame frame;
	private JList<FeatureCollection> training, unsolved;
	
	private JMenu trainingData, unsolvedData, general;
	private JMenuBar menuBar;
	private JMenuItem addTraining, addUnsolved, reset;
	private JButton edit, remove;
	
	public GUI(DefaultListModel<FeatureCollection> t, DefaultListModel<FeatureCollection> u) {
		training = new JList<FeatureCollection>(t);
		unsolved = new JList<FeatureCollection>(u);
		
		frame = new JFrame("Machine Learning");
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		trainingData = new JMenu("Training Features");
		unsolvedData = new JMenu("Unsolved Features");
		general = new JMenu("General");
		menuBar.add(general);
		menuBar.add(trainingData);
		menuBar.add(unsolvedData);
		
		addTraining = new JMenuItem("Add training features");
		addUnsolved = new JMenuItem("Add unsolved features");
		reset = new JMenuItem("Reset all to start again");
		general.add(reset);
		trainingData.add(addTraining);
		unsolvedData.add(addUnsolved);
		
		edit = new JButton("Edit selected Feature");
		remove = new JButton("Remove selected Feature");
		frame.add(edit);
		frame.add(remove);
		
		
		
		
		
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
		frame.setSize(400, 400);
	}

}
