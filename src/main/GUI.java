package main;

import javax.swing.*;

import main.Colour.COLOURS;

import java.awt.*;
import java.util.ArrayList;

public class GUI {
	private JFrame frame;
	private JList<Example> training, unsolved;
	private JList<Feature> features;
	private JMenu menu, saveBar, featuresBar;
	private JMenuBar menuBar;
	private JMenuItem reset, addFeature, removeFeature, solve, save, load;
	private JButton addTraining, editTraining, removeTraining, addUnsolved, editUnsolved, removeUnsolved;
	@SuppressWarnings("unused")
	private JScrollPane unsolvedPane, trainingPane, featuresPane;
	private JLabel trainingLabel, unsolvedLabel, featuresLabel;
	private static final String[] TYPES = { "Number", "Cartesian", "Boolean", "Colour", "DamagePercent" };
	private static final COLOURS[] KNOWN_COLOURS = { COLOURS.RED, COLOURS.ORANGE, COLOURS.YELLOW, COLOURS.GREEN,
			COLOURS.BLUE, COLOURS.INDIGO, COLOURS.VIOLET };
	private static final String[] TYPES_METRICS = { "Euclidian", "BooleanCompare", "Difference", "AbsoluteDifference" };
	private int UNKNOWN_FLAG = 0;

	/**
	 * setUp() initializes all components and places them on the frame of the GUI.
	 * Its a fun one to read. GoodLuck
	 */
	public void setUp() {
		// initiate all GUI objects
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

		// setup overall frame
		frame.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		frame.setJMenuBar(menuBar);

		// setup scrollpanes
		training.setSize(20, 40);
		unsolved.setSize(20, 40);
		features.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		training.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		unsolved.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// setup all menu bars
		menuBar.add(menu);
		menuBar.add(saveBar);
		menuBar.add(featuresBar);
		saveBar.add(save);
		saveBar.add(load);
		menu.add(solve);
		menu.add(reset);
		featuresBar.add(addFeature);
		featuresBar.add(removeFeature);

		// Place all buttons and labels where they should on on the frame
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.gridx = 0;
		c.gridy = 0;
		frame.add(featuresLabel, c);
		c.weightx = 0.0;
		c.weighty = .5;
		c.gridx = 1;
		c.gridy = 0;
		frame.add(features, c);
		c.weightx = 0.25;
		c.weighty = 0.0;
		c.gridx = 0;
		c.gridy = 5;
		frame.add(addTraining, c);
		c.weightx = 0.25;
		c.weighty = 0.0;
		c.gridx = 0;
		c.gridy = 3;
		frame.add(editTraining, c);
		c.weightx = 0.25;
		c.weighty = 0.0;
		c.gridx = 0;
		c.gridy = 4;
		frame.add(removeTraining, c);
		c.weightx = 0.25;
		c.weighty = 0.0;
		c.gridx = 1;
		c.gridy = 5;
		frame.add(addUnsolved, c);
		c.weightx = 0.25;
		c.weighty = 0.0;
		c.gridx = 1;
		c.gridy = 4;
		frame.add(removeUnsolved, c);
		c.weightx = 0.25;
		c.weighty = 0.0;
		c.gridx = 1;
		c.gridy = 3;
		frame.add(editUnsolved, c);
		c.weightx = 0.5;
		c.weighty = 0.8;
		c.gridx = 0;
		c.gridy = 2;
		frame.add(training, c);
		c.weightx = 0.5;
		c.weighty = 0.0;
		c.gridx = 0;
		c.gridy = 1;
		frame.add(trainingLabel, c);
		c.weightx = 0.5;
		c.weighty = 0.8;
		c.gridx = 1;
		c.gridy = 2;
		frame.add(unsolved, c);
		c.weightx = 0.5;
		c.weighty = 0.0;
		c.gridx = 1;
		c.gridy = 1;
		frame.add(unsolvedLabel, c);

		// show frame
		frame.setSize(1500, 600);
		frame.setVisible(true);

	}

	/**
	 * This function opens a dialog box that prompts the user for a String and
	 * returns that input
	 * 
	 * @param s
	 *            Message that will be on pane
	 * @param unknown
	 *            boolean that represent whether or not the user will be prompted
	 *            for an unknown value or not
	 * @return the input given by the user
	 * @throws Exception
	 */
	public String valueStringOption(String s, boolean unknown) throws Exception {
		String str = (String) JOptionPane.showInputDialog(frame, s);
		if (str == null || (str != null && ("".equals(str)))) {
			throw new Exception();
		}
		if (unknown == true & str.equals("?")) {
			UNKNOWN_FLAG = 1;
			return null;
		}
		return str;

	}

	/**
	 * This function opens a dialog box that prompts the user for a Double and
	 * returns that input
	 * 
	 * @param s
	 *            Message that will be on pane
	 * @param unknown
	 *            boolean that represent whether or not the user will be prompted
	 *            for an unknown value or not
	 * @return the input given by the user
	 * @throws Exception
	 */
	public Double valueDoubleOption(String s, boolean unknown) throws Exception {
		while (true) {
			String str = (String) JOptionPane.showInputDialog(frame, s);

			if (str == null || (str != null && ("".equals(str)))) {
				throw new Exception();
			}
			if (unknown == true & str.equals("?")) {
				UNKNOWN_FLAG = 1;
				return null;
			} else {
				try {
					return Double.valueOf(str);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(frame, "The number entered must be a double!", "Input Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	/**
	 * This function opens a dialog box that prompts the user for a String input and
	 * then a Double input. these values represent a Cartesian vector as a complex
	 * feature made up of Numbers
	 * 
	 * @param s
	 *            Message that will be on pane
	 * @param length
	 *            the length of the cartesian feature that we are looking for inputs
	 *            for
	 * @param unknown
	 *            boolean that represent whether or not the user will be prompted
	 *            for an unknown value or not
	 * @return the input given by the user
	 * @throws Exception
	 */
	public ArrayList<Number> valueListOption(String s, int length, boolean unknown) throws Exception {
		ArrayList<Number> d = new ArrayList<Number>();
		int j = 0;

		if (unknown == true) {
			String str = valueStringOption(
					"What is the name of the 0th element of the Cartesian?\nEnter a '?' if this feature is unknown.",
					false);
			if (str.equals("?")) {
				UNKNOWN_FLAG = 1;
				return null;
			}
			Double newNum = valueDoubleOption("What is the value of the 0th element of the Cartesian?", false);
			d.add(new Number(str, null, newNum));
			j++;
		}
		for (int i = 0 + j; i < length; i++) {
			String str = valueStringOption("What is the name of the " + i + " element of the Cartesian?", false);
			Double newNum = valueDoubleOption("What is the value of the " + i + " element of the Cartesian?", false);
			d.add(new Number(str, null, newNum));
		}
		return d;
	}

	/**
	 * This function prompts the user for a type of feature, via a drop down box
	 * 
	 * @return a string representation of the feature chosen
	 * @throws Exception
	 */
	public String typeOption() throws Exception {
		String str = (String) JOptionPane.showInputDialog(frame, "Choose one", "Input", JOptionPane.INFORMATION_MESSAGE,
				null, TYPES, TYPES[0]);
		if (str == null || (str != null && ("".equals(str)))) {
			throw new Exception();
		}
		return str;
	}

	/**
	 * This function prompts the user for a type of metric, via a drop down box
	 * 
	 * @return a string representation of the metric chosen
	 * @throws Exception
	 */
	public String metricOption() throws Exception {
		String str = (String) JOptionPane.showInputDialog(frame, "Choose a Metric for Feature", "Input",
				JOptionPane.INFORMATION_MESSAGE, null, TYPES_METRICS, TYPES_METRICS[0]);
		if (str == null || (str != null && ("".equals(str)))) {
			throw new Exception();
		}
		return str;
	}

	/**
	 * This function prompts the user for a type of COLOUR, via a drop down box
	 * 
	 * @return the colour chosen by user
	 * @throws Exception
	 */
	public COLOURS colourOption(String s, boolean unknown) throws Exception {
		COLOURS[] set = null;
		if (unknown = true) {
			set = COLOURS.values();
		} else {
			set = KNOWN_COLOURS;

		}

		COLOURS c = (COLOURS) JOptionPane.showInputDialog(frame, s, "Input", JOptionPane.INFORMATION_MESSAGE, null, set,
				set[0]);
		if (c == null || (c != null && ("".equals(c)))) {
			throw new Exception();
		}
		if (c == COLOURS.UNKNOWN) {
			UNKNOWN_FLAG = 1;
		}
		return c;
	}

	/**
	 * This function opens a dialog box that prompts the user for an int and returns
	 * that input
	 * 
	 * @param s
	 *            Message that will be on pane
	 * @param unknown
	 *            boolean that represent whether or not the user will be prompted
	 *            for an unknown value or not
	 * @return the input given by the user
	 * @throws Exception
	 */
	public int valueIntOption(String s, boolean unknown) throws Exception {
		Double d;
		if (unknown == true) {
			d = valueDoubleOption(s, true);
			if (d == null) {
				return -1;
			}
		} else {
			d = valueDoubleOption(s, false);
		}
		int i = d.intValue();
		try {
			if (i <= 100 || i >= 0) {
				return i;
			} else {
				throw new Exception();
			}
		} catch (Exception n) {
			error("The value entered was not a correct percentage");
		}

		return 0;
	}

	/**
	 * This function prints an error message to the frame via a panel. Printing a
	 * generic message to the screen
	 * 
	 * @param n
	 *            the error that was reported, currently not in use but for testing
	 *            purposes is useful.
	 */
	public void error(Exception n) {
		JOptionPane.showMessageDialog(frame,
				"\nOne of the entries you have entered was incorrect or the process was quit early.\n Please try again",
				"Input Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * This function prints an error message to the frame via a panel. The message
	 * is dependent on the param
	 * 
	 * @param s
	 *            The message that will be displayed on the pane.
	 */
	public void error(String s) {
		JOptionPane.showMessageDialog(frame, s, "Input Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * This function prints to the screen a pane with the results from the knn
	 * problem solution.
	 * 
	 * @param s
	 *            the list of Doubles sent by the KNN solver
	 */
	public void printKNN(ArrayList<Object> s) {
		JOptionPane.showMessageDialog(frame, "The kNN for each test in order is:" + s.toString(), "kNN List",
				JOptionPane.INFORMATION_MESSAGE);
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

	public JList<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(DefaultListModel<Feature> feature) {
		features = new JList<Feature>(feature);
	}

	public JMenuItem getRemoveFeature() {
		return removeFeature;
	}

	public JMenuItem getAddFeature() {
		return addFeature;
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

	public JMenuItem getSave() {
		return save;
	}

	public JMenuItem getLoad() {
		return load;
	}
}
