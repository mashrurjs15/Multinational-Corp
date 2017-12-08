package main;
import javax.swing.*;

import main.Colour.COLOURS;

import java.awt.*;
import java.util.ArrayList;


public class GUI{
	private JFrame frame;
	//private Solver controller;
	private JList<Example> training, unsolved;
	private JList<Feature> features;
	private JMenu menu, saveBar, featuresBar;
	private JMenuBar menuBar;
	private JMenuItem  reset, addFeature, removeFeature, solve, save, load;
	private JButton addTraining, editTraining, removeTraining, addUnsolved, editUnsolved, removeUnsolved;
	@SuppressWarnings("unused")
	private JScrollPane unsolvedPane, trainingPane, featuresPane;
	private JLabel trainingLabel, unsolvedLabel, featuresLabel;
	private static final String[] TYPES = {"Number","Cartesian","Boolean", "Colour", "DamagePercent"};
	private static final COLOURS[] KNOWN_COLOURS = {COLOURS.RED, COLOURS.ORANGE,COLOURS.YELLOW,COLOURS.GREEN,COLOURS.BLUE,COLOURS.INDIGO,COLOURS.VIOLET};
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
		featuresBar = new JMenu("Features add/remove");
		saveBar = new JMenu("Save/Load");
		solve = new JMenuItem("Solve Examples");
		save = new JMenuItem("Save Session");
		load = new JMenuItem("Load previous Session");
		addFeature = new JMenuItem("Add feature");
		removeFeature = new JMenuItem("Remove feature");
		reset = new JMenuItem("Reset all lists");
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
		menuBar.add(saveBar);
		menuBar.add(featuresBar);
		saveBar.add(save);
		saveBar.add(load);
		menu.add(solve);
		menu.add(reset);
		featuresBar.add(addFeature);
		featuresBar.add(removeFeature);
		
		
		
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
	
	public String valueStringOption(String s) throws Exception {
		String str = (String)JOptionPane.showInputDialog(frame,
				s);
		if(str == null || (str != null && ("".equals(str))))   
		{
		    throw new Exception();
		}
		return str;
		
	}
	
	public String valueStringUnknownOption(String s) throws Exception {
		String str = (String)JOptionPane.showInputDialog(frame,
				s);
		if(str == null || (str != null && ("".equals(str))))   
		{
		    throw new Exception();
		}
		if (str.equals("?")) {
			UNKNOWN_FLAG = 1;
			return null;
		}
		return str;
	}
	
	public Double valueDoubleOption(String s) throws Exception {
		while(true) {
			String str = (String)JOptionPane.showInputDialog(frame,
					s);
		
		if(str == null || (str != null && ("".equals(str))))   
		{
		    throw new Exception();
		}
		try {
			return Double.valueOf(str);
		}catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frame,"The number entered must be a double!","Input Error",JOptionPane.ERROR_MESSAGE);
		}
		}
	}
	
	public Double valueDoubleUnknownOption(String s) throws Exception {
		String str;
		while(true) {
		try{
			str = JOptionPane.showInputDialog(frame,
					s, "Value",JOptionPane.OK_OPTION);
			if(str == null || (str != null && ("".equals(str))))   
			{
			    throw new Exception();
			}
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
	
	public ArrayList<Number> valueListOption(String s, int length) throws Exception {
		ArrayList<Number> d = new ArrayList<Number>();
		for(int i = 0; i <length;i++) {
				String str = valueStringOption("What is the name of the "+ i +" element of the Cartesian?");
				Double newNum = valueDoubleOption("What is the value of the "+ i +" element of the Cartesian?");
    			d.add(new Number(str,null,newNum));
		}
		return d;
	}
	
	public ArrayList<Number> valueListUnknownOption(String s, int length) throws Exception {
		ArrayList<Number> d = new ArrayList<Number>();
		String str = valueStringOption("What is the name of the 1st element of the Cartesian?\nEnter a '?' if this feature is unknown.");
		if(str.equals("?")) {
			UNKNOWN_FLAG = 1;
			return null;
		}else {
			Double newNum = valueDoubleOption("What is the name of the 1st element of the Cartesian?");
			d.add(new Number(str,null,newNum));
			for(int i = 0; i <length;i++) {
				str = valueStringOption("What is the name of the "+ i +" element of the Cartesian?");
				newNum = valueDoubleOption("What is the value of the "+ i +" element of the Cartesian?");
    			d.add(new Number(str,null,newNum));
		}
		return d;
		}
	}
	
	// Where kNN is used
	
	public Integer kOption() throws Exception {
		while(true) {
		String str = (String)JOptionPane.showInputDialog(frame,
					"What is the value of k do you want to solve with?", "k Value");
		if(str == null || (str != null && ("".equals(str))))   
		{
		    throw new Exception();
		}
		try {
			return Integer.valueOf(str);
		}
		catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frame,"The number entered must be an integer!","Input Error",JOptionPane.ERROR_MESSAGE);
		}
		}
	}
	
	
	public String typeOption() throws Exception {
		String str = (String) JOptionPane.showInputDialog(frame,
				"Choose one", "Input",
				JOptionPane.INFORMATION_MESSAGE, null,
				TYPES, TYPES[0]);
		if(str == null || (str != null && ("".equals(str))))   
		{
		    throw new Exception();
		}
		return str;
	}
	
	// Work on this metric option for the gui
	public String metricOption() throws Exception {
		String str = (String) JOptionPane.showInputDialog(frame,
				"Choose a Metric for Feature", "Input",
				JOptionPane.INFORMATION_MESSAGE, null,
				TYPES_METRICS, TYPES_METRICS[0]);
		if(str == null || (str != null && ("".equals(str))))   
		{
		    throw new Exception();
		}
		return str;
	}
	
	public COLOURS colourOption(String s) throws Exception{
		
		COLOURS c = (COLOURS) JOptionPane.showInputDialog(frame,
				s, "Input",
				JOptionPane.INFORMATION_MESSAGE, null,
				KNOWN_COLOURS, KNOWN_COLOURS[0]);
		if(c == null || (c != null && ("".equals(c))))   
		{
		    throw new Exception();
		}
		return c;
	}
	
	public COLOURS colourUnknownOption(String s) throws Exception{
		
		COLOURS c = (COLOURS) JOptionPane.showInputDialog(frame,
				s, "Input",
				JOptionPane.INFORMATION_MESSAGE, null,
				COLOURS.values(), COLOURS.values());
		if(c == null || (c != null && ("".equals(c))))   
		{
		    throw new Exception();
		}
		if(c.equals(COLOURS.UNKNOWN)) {
			return null;
		}
				return c;
	}
	
	
	public int valueIntOption(String s, int unknown) throws Exception {
		Double d;
		if(unknown == 0) {
			d = valueDoubleOption(s);
		}else {
			d = valueDoubleUnknownOption(s);
			if(d == null) {
				return 0;
			}
		}
		int i = d.intValue();
		try {
			if(i<=100 || i>=0) {
				return i;
			}else {
				throw new Exception();
			}
		}catch(Exception n) {
			error("The value entered was not a correct percentage");
		}
		
		return 0;
	}
	
	public void error(Exception n) {
		JOptionPane.showMessageDialog(frame, "\nOne of the entries you have entered was incorrect or the process was quit early.\n Please try again","Input Error",JOptionPane.ERROR_MESSAGE);
	}
	
	public void error(String s) {
		JOptionPane.showMessageDialog(frame,s,"Input Error",JOptionPane.ERROR_MESSAGE);
	}
	 
	public int cartesianNumber() throws Exception {
		String str = null;
		try {
			str = (String)JOptionPane.showInputDialog(frame,
					"How many points will your cartesian have?");
			if(str == null || (str != null && ("".equals(str))))   
			{
			    throw new Exception();
			}
			return(Integer.valueOf(str));
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame,"The number entered must be a double!","Input Error",JOptionPane.ERROR_MESSAGE);
		}
		return (Integer) null;
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

	public JMenuItem getSave() {
		return save;
	}

	public void setSave(JMenuItem save) {
		this.save = save;
	}

	public JMenuItem getLoad() {
		return load;
	}

	public void setLoad(JMenuItem load) {
		this.load = load;
	}
	
}
