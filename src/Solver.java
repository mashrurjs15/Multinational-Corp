import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Solver {
	
	private GUI  view;
	private ExampleCollection model;
	private ExampleCollection training,unsolved;
	private Example features;
	
	public Solver() {
		features = new Example();
		training = new ExampleCollection();
		unsolved = new ExampleCollection();

		view = new GUI(this);
		view.setFeatures(features.getFeatures());
		view.setTraining(training.getExample());
		view.setUnsolved(unsolved.getExample());
		view.setUp();
		
		// Create action listeners //
		
		//addFeature Button Listener
		view.getAddFeature().addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	features.addFeature (view.typeOption(),view.nameOption("new"),null,null);
				}  
		});
		
		//removeFeature Button Listener
		view.getRemoveFeature().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  features.getFeatureList().removeElementAt(view.getFeatures().getSelectedIndex());
			}  
				});
		
		//addTraining Button Listener
		view.getAddTraining().addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	createExample(training);
				}  
		});
		
		//AddUnsolved
		view.getAddUnsolved().addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	createExample(unsolved);
				}
		});
		
		//RemoveUnsolved
		view.getRemoveUnsolved().addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {	
					unsolved.getExample().removeElementAt(view.getUnsolved().getSelectedIndex());
				}
		});
		
		//EditUnsolved
		view.getEditUnsolved().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
					//unsolved.addElement(createEntity());
				}
		});
		
		//EditTraining
		view.getEditTraining().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
					//unsolved.addElement(createEntity());
			}
		});
		
		//RemoveTraining
		view.getRemoveTraining().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				training.getExample().removeElementAt(view.getTraining().getSelectedIndex());
			}
		});
				
	}
	
	private Example createFeature() {
		String name = view.nameOption("new");
		String type = view.typeOption();
		return new Example();
		
	}
	
	private void createExample(ExampleCollection e) {	
		Feature s;
		Example newE = new Example();
		
		
		for(int i = 0; i<features.getFeatureList().size();i++) {
			s = features.getFeatureList().getElementAt(i);
			switch(s.getType()) {
			case "Cartesian": Double x = view.xOption(s.GetName());
							Double y = view.yOption(s.GetName());
							newE.addFeature("Cartesian",s.GetName(),x, y);
							
							break;
			case "Number": Double a = view.valueDoubleOption(s.GetName());
							newE.addFeature("Number",s.GetName(),a, null);
							break;
			case "Boolean": String value = view.valueStringOption(s.GetName());
							newE.addFeature( "Boolean",value,null, null);
							break;
			}
		}
		e.addExample(newE);
	}
		


	
	
	public DefaultListModel<Feature> getFeatures() {
		return features.getFeatureList();
	}


	public GUI getGui() {
		return view;
	}


	public void setGui(GUI gui) {
		this.view = gui;
	}


	public ExampleCollection getTraining() {
		return training;
	}


	public void setTraining(ExampleCollection training) {
		this.training = training;
	}


	public ExampleCollection getUnsolved() {
		return unsolved;
	}


	public void setUnsolved(ExampleCollection unsolved) {
		this.unsolved = unsolved;
	}


	public static void main(String[] args) {
		new Solver();	
	}
}

