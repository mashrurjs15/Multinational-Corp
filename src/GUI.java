import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class GUI{
	private JFrame frame;
	private Solver controller;
	private JList<Example> training, unsolved;
	private JList<Feature> features;
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem  reset, addFeature, removeFeature;
	private JButton addTraining, editTraining, removeTraining, addUnsolved, editUnsolved, removeUnsolved;
	private JScrollPane unsolvedPane, trainingPane, featuresPane;
	private JLabel trainingLabel, unsolvedLabel, featuresLabel;
	private static final String[] TYPES = {"Number","Cartesian","Boolean"};
	
	public GUI(Solver cl) {
		controller = cl;
	}
	
	public void setUp() {
		frame = new JFrame("Machine Learning");	
		frame.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		training.setSize(20,40);
		unsolved.setSize(20,40);
		
		featuresPane = new JScrollPane(features);
		trainingPane = new JScrollPane(training);
		unsolvedPane = new JScrollPane(unsolved);
		features.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		training.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		unsolved.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		menuBar.add(menu);
		

		addFeature = new JMenuItem("Add feature");
		removeFeature = new JMenuItem("Remove feature");
		reset = new JMenuItem("Reset all to start again");
		menu.add(reset);
		menu.add(addFeature);
		menu.add(removeFeature);
		
		featuresLabel = new JLabel("Features");
		
		c.weightx = 0.0;
	    c.weighty = 0.0;
	    c.gridx = 0;
	    c.gridy = 0;
	    frame.add(featuresLabel,c);
	    c.weightx = 0.0;
	    c.weighty = .5;
	    c.gridx = 1;
	    c.gridy = 0;
		frame.add(features,c);
		
		addTraining = new JButton("Add to training List");
		editTraining = new JButton("Edit training list");
		removeTraining = new JButton("Remove from training List");
		addUnsolved = new JButton("Add to unsolved List");
		editUnsolved = new JButton("Edit unsolved list");
		removeUnsolved = new JButton("Remove from unsolved List");
		c.weightx = 0.25;
	    c.weighty = 0.0;
	    c.gridx = 0;
	    c.gridy = 5;
	    frame.add(addTraining,c);
		c.weightx = 0.25;
	    c.weighty = 0.0;
	    c.gridx = 0;
	    c.gridy = 4;
	    frame.add(removeTraining,c);
	    c.weightx = 0.25;
	    c.weighty = 0.0;
	    c.gridx = 0;
	    c.gridy = 3;
		frame.add(editTraining,c);
		c.weightx = 0.25;
	    c.weighty = 0.0;
	    c.gridx = 1;
	    c.gridy = 5;
	    frame.add(addUnsolved,c);
		c.weightx = 0.25;
	    c.weighty = 0.0;
	    c.gridx = 1;
	    c.gridy = 4;
	    frame.add(removeUnsolved,c);
	    c.weightx = 0.25;
	    c.weighty = 0.0;
	    c.gridx = 1;
	    c.gridy = 3;
		frame.add(editUnsolved,c);
		
		trainingLabel = new JLabel("Training Entities");
		unsolvedLabel = new JLabel("Unsolved Entities");
		c.weightx = 0.5;
	    c.weighty = 0.8;
	    c.gridx = 0;
	    c.gridy = 2;
		frame.add(training,c);
		c.weightx = 0.5;
	    c.weighty = 0.0;
	    c.gridx = 0;
	    c.gridy = 1;
		frame.add(trainingLabel,c);
		c.weightx = 0.5;
	    c.weighty = 0.8;
	    c.gridx = 1;
	    c.gridy = 2;
		frame.add(unsolved,c);
		c.weightx = 0.5;
	    c.weighty = 0.0;
	    c.gridx = 1;
	    c.gridy = 1;
		frame.add(unsolvedLabel,c);
		
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
		frame.setSize(800, 400);
	}
	
	public String nameOption(String s) {
		return (String)JOptionPane.showInputDialog(frame,
				"What is the name of the "+ s + " feature?", "Name");
	}
	
	public Double xOption(String s) {
		return Double.parseDouble(JOptionPane.showInputDialog(frame,
				"What is the x value of s?", "X"));
	}
	
	public Double yOption(String s) {
		return Double.parseDouble(JOptionPane.showInputDialog(frame,
				"What is the y value of s?", "Y"));
	}
	
	public Double valueDoubleOption(String s) {
		return Double.valueOf(JOptionPane.showInputDialog(frame,
				"What is the (Double) value of the "+s+" feature?", "Value"));
	}
	
	public String valueStringOption(String s) {
		return (String)JOptionPane.showInputDialog(frame,
				"What is the (String) value of the "+ s+" feature?", "Value");
	}
	
	public String typeOption() {
		return (String) JOptionPane.showInputDialog(frame,
				"Choose one", "Input",
				JOptionPane.INFORMATION_MESSAGE, null,
				TYPES, TYPES[0]);
	}
	
	public JList<Feature> getFeatures() {
		return features;
	}


	public void setFeatures(DefaultListModel<Feature> feature) {
		features = new JList<Feature>(feature);
	}


	public JMenuItem getRemoveFeature() {
		return removeFeature;
	}


	public void setRemoveFeature(JMenuItem removeFeature) {
		this.removeFeature = removeFeature;
	}


	public JMenuItem getAddFeature() {
		return addFeature;
	}


	public void setAddFeature(JMenuItem addFeature) {
		this.addFeature = addFeature;
	}


	public void setAddTraining(JButton addTraining) {
		this.addTraining = addTraining;
	}


	public void setAddUnsolved(JButton addUnsolved) {
		this.addUnsolved = addUnsolved;
	}


	public JButton getAddTraining() {
		return addTraining;
	}


	public JButton getAddUnsolved() {
		return addUnsolved;
	}

	public JMenuItem getReset() {
		return reset;
	}


	public void setReset(JMenuItem reset) {
		this.reset = reset;
	}


	public JButton getEditTraining() {
		return editTraining;
	}


	public void setEditTraining(JButton editTraining) {
		this.editTraining = editTraining;
	}


	public JButton getRemoveTraining() {
		return removeTraining;
	}


	public void setRemoveTraining(JButton removeTraining) {
		this.removeTraining = removeTraining;
	}


	public JButton getEditUnsolved() {
		return editUnsolved;
	}


	public void setEditUnsolved(JButton editUnsolved) {
		this.editUnsolved = editUnsolved;
	}


	public JButton getRemoveUnsolved() {
		return removeUnsolved;
	}


	public JList<Example> getTraining() {
		return training;
	}


	public void setTraining(DefaultListModel<Example> defaultListModel) {
		training = new JList<Example>(defaultListModel);
		
	}


	public JList<Example> getUnsolved() {
		return unsolved;
	}


	public void setUnsolved(DefaultListModel<Example> unsolve) {
		unsolved = new JList<Example>(unsolve);
	}


	public void setRemoveUnsolved(JButton removeUnsolved) {
		this.removeUnsolved = removeUnsolved;
	}
}
