import javax.swing.*;


import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
	private JFrame frame;
	private JList<FeatureCollection> training, unsolved;
	
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem addTraining, addUnsolved, reset;
	private JButton edit, remove;
	private JScrollPane unsolvedPane, trainingPane;
	private JLabel trainingLabel, unsolvedLabel;
	
	public GUI(DefaultListModel<FeatureCollection> t, DefaultListModel<FeatureCollection> u) {
		Handler handler = new Handler();
		training = new JList<FeatureCollection>(t);
		unsolved = new JList<FeatureCollection>(u);
		
		frame = new JFrame("Machine Learning");	
		frame.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		menuBar.add(menu);
		
		addTraining = new JMenuItem("Add training features");
		addTraining.addActionListener(handler);
		addUnsolved = new JMenuItem("Add unsolved features");
		addUnsolved.addActionListener(handler);
		reset = new JMenuItem("Reset all to start again");
		menu.add(reset);
		menu.add(addTraining);
		menu.add(addUnsolved);
		
		edit = new JButton("Edit selected Feature");
		remove = new JButton("Remove selected Feature");
		c.weightx = 0.5;
	    c.weighty = 0.0;
	    c.gridx = 0;
	    c.gridy = 2;
		frame.add(edit,c);
		c.weightx = 0.5;
	    c.weighty = 0.0;
	    c.gridx = 1;
	    c.gridy = 2;
		frame.add(remove,c);
		
		trainingPane = new JScrollPane();
		unsolvedPane = new JScrollPane();
		trainingLabel = new JLabel("Training Features");
		unsolvedLabel = new JLabel("UnsolvedFeatures");
		c.weightx = 0.5;
	    c.weighty = 0.8;
	    c.gridx = 0;
	    c.gridy = 1;
		frame.add(trainingPane,c);
		c.weightx = 0.5;
	    c.weighty = 0.0;
	    c.gridx = 0;
	    c.gridy = 0;
		frame.add(trainingLabel,c);
		c.weightx = 0.5;
	    c.weighty = 0.8;
	    c.gridx = 1;
	    c.gridy = 1;
		frame.add(unsolvedPane,c);
		c.weightx = 0.5;
	    c.weighty = 0.0;
	    c.gridx = 1;
	    c.gridy = 0;
		frame.add(unsolvedLabel,c);
		
		
		
		
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
		frame.setSize(400, 400);
	}
	
	private class Handler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
	
			if(e.getSource() == addTraining) {
				
			}
			if(e.getSource() == addUnsolved) {
				
			}
			if(e.getSource() == edit) {
				
			}
			if(e.getSource() == remove) {
				
			}
			if(e.getSource() == reset) {
				
			}
		}
	}

}
