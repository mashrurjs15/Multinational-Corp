import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GUI{
	private JFrame frame;
	//private Solver controller;
	private JList<Example> training, unsolved;
	private JList<Feature> features;
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem  reset, addFeature, removeFeature, solve;
	private JButton addTraining, editTraining, removeTraining, addUnsolved, editUnsolved, removeUnsolved;
	@SuppressWarnings("unused")
	private JScrollPane unsolvedPane, trainingPane, featuresPane;
	private JLabel trainingLabel, unsolvedLabel, featuresLabel;
	private static final String[] TYPES = {"Number","Cartesian","Boolean"};
	private static final String[] TYPES_METRICS = {"Euclidian", "BooleanCompare", "Difference", "AbsoluteDifference"};
	private int UNKNOWN_FLAG = 0;
	
	public GUI(Solver cl) {
		//controller = cl;
	}
	
	public void setUp() {
		
		//initiate all GUI objects
		frame = new JFrame("Machine Learning");
		featuresPane = new JScrollPane(features);
		trainingPane = new JScrollPane(training);
		unsolvedPane = new JScrollPane(unsolved);
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		solve = new JMenuItem("Solve Examples");
		addFeature = new JMenuItem("Add feature");
		removeFeature = new JMenuItem("Remove feature");
		reset = new JMenuItem("Reset all to start again");
		featuresLabel = new JLabel("Features");
		addTraining = new JButton("Add to training List");
		editTraining = new JButton("Edit training list");
		removeTraining = new JButton("Remove from training List");
		addUnsolved = new JButton("Add to unsolved List");
		editUnsolved = new JButton("Edit unsolved list");
		removeUnsolved = new JButton("Remove from unsolved List");
		trainingLabel = new JLabel("Training Entities");
		unsolvedLabel = new JLabel("Unsolved Entities");
		
		//setup overall frame
		frame.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		frame.setJMenuBar(menuBar);
		
		//setup scrollpanes
		training.setSize(20,40);
		unsolved.setSize(20,40);
		features.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		training.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		unsolved.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//setup all menu bars
		menuBar.add(menu);
		menu.add(solve);
		//menu.add(reset);
		menu.add(addFeature);
		menu.add(removeFeature);
		
		
		
		//Place all buttons and labels where they should on on the frame
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
		c.weightx = 0.25;
	    c.weighty = 0.0;
	    c.gridx = 0;
	    c.gridy = 5;
	    frame.add(addTraining,c);
	    c.weightx = 0.25;
	    c.weighty = 0.0;
	    c.gridx = 0;
	    c.gridy = 3;
		frame.add(editTraining,c);
		c.weightx = 0.25;
	    c.weighty = 0.0;
	    c.gridx = 0;
	    c.gridy = 4;
	    frame.add(removeTraining,c);
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
		
		//show frame
		frame.setSize(800, 400);
		frame.setVisible(true);
		
	}
	
	public String valueStringOption(String s) {
		return (String)JOptionPane.showInputDialog(frame,
				"What is the value/name of the "+ s + " feature?", "Name");
	}
	
	public String valueStringUnknownOption(String s) {
		String str = (String)JOptionPane.showInputDialog(frame,
				"What is the name of the "+ s + " feature? \nEnter '?' if it is unknown.", "Name");
		if (str.equals("?")) {
			UNKNOWN_FLAG = 1;
			return null;
		}
		return str;
	}
	
	public Double valueDoubleOption(String s) {
		while(true) {
		try{
			return Double.valueOf(JOptionPane.showInputDialog(frame,
					"What is the (Double) value of the "+s+" feature?", "Value"));
		}catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frame,"The number entered must be a double!","Input Error",JOptionPane.ERROR_MESSAGE);
		}
		}
	}
	
	public Double valueDoubleUnknownOption(String s) {
		String str;
		while(true) {
		try{
			str = JOptionPane.showInputDialog(frame,
					"What is the (Double) value of the "+s+" feature? Enter '?' if it is unknown.", "Value");
			if(str.equals("?")) {
				UNKNOWN_FLAG = 1;
				return null;
			}else {
				
				return Double.parseDouble(str);
			}
		}catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frame,"The number entered must be a double!","Input Error",JOptionPane.ERROR_MESSAGE);
		}
		}
	}
	
	public ArrayList<Double> valueListOption(String s) {
		ArrayList<Double> d = new ArrayList<Double>();
		d.add(Double.valueOf(JOptionPane.showInputDialog(frame,
				"What is the next (Double) value of the "+s+" feature?", "Value")));
		while(true) {
			int reply = JOptionPane.showConfirmDialog(frame, "Would you like to add another value?", "Another value", JOptionPane.YES_NO_OPTION);
	        if (reply == JOptionPane.YES_OPTION) {
	        	try{
	    			d.add(Double.valueOf(JOptionPane.showInputDialog(frame,
	    					"What is the next (Double) value of the "+s+" feature?", "Value")));
	    		}catch (NumberFormatException e){
	    			JOptionPane.showMessageDialog(frame,"The number entered must be a double!","Input Error",JOptionPane.ERROR_MESSAGE);
	    		}
	        }else {
	        	break;
	        }
		}
		return d;
	}
	
	public ArrayList<Double> valueListUnknownOption(String s) {
		ArrayList<Double> d = new ArrayList<Double>();
		String str;
		str = JOptionPane.showInputDialog(frame,
				"What is the next (Double) value of the "+s+" feature? Enter '?' if it us unknown.", "Value");
		System.out.println(str);
		if(str.equals("?")) {
			UNKNOWN_FLAG = 1;
			return null;
		}else {
			try{
				d.add(Double.valueOf(str));
    		}catch (NumberFormatException e){
    			JOptionPane.showMessageDialog(frame,"The number entered must be a double!","Input Error",JOptionPane.ERROR_MESSAGE);
    		}
		}
		while(true) {
			int reply = JOptionPane.showConfirmDialog(frame, "Would you like to add another value?", "Another value", JOptionPane.YES_NO_OPTION);
	        if (reply == JOptionPane.YES_OPTION) {
	        	try{
	        		d.add(Double.valueOf(JOptionPane.showInputDialog(frame,
	    					"What is the next (Double) value of the "+s+" feature?", "Value")));
	    			
	    		}catch (NumberFormatException e){
	    			JOptionPane.showMessageDialog(frame,"The number entered must be a double!","Input Error",JOptionPane.ERROR_MESSAGE);
	    		}
	        }else {
	        	break;
	        }
		}
		return d;
	}
	
	// Where kNN is used
	
	public Integer kOption() {
		while(true) {
		try{
			return Integer.valueOf(JOptionPane.showInputDialog(frame,
					"What is the value of k do you want to solve with?", "k Value"));
		}catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frame,"The number entered must be an integer!","Input Error",JOptionPane.ERROR_MESSAGE);
		}
		}
	}
	
	
	public String typeOption() {
		return (String) JOptionPane.showInputDialog(frame,
				"Choose one", "Input",
				JOptionPane.INFORMATION_MESSAGE, null,
				TYPES, TYPES[0]);
	}
	
	// Work on this metric option for the gui
	public String metricOption() {
		return (String) JOptionPane.showInputDialog(frame,
				"Choose a Metric for Feature", "Input",
				JOptionPane.INFORMATION_MESSAGE, null,
				TYPES_METRICS, TYPES_METRICS[0]);
	}
	
	
	
	
	
	public int getUNKNOWN_FLAG() {
		return UNKNOWN_FLAG;
	}

	public void setUNKNOWN_FLAG(int uNKNOWN_FLAG) {
		UNKNOWN_FLAG = uNKNOWN_FLAG;
	}

	public JMenuItem getSolve() {
		return solve;
	}

	public void setSolve(JMenuItem solve) {
		this.solve = solve;
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
