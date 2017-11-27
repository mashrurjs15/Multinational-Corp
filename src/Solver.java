import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Solver {
	
	private GUI  view;
	private EntityCollection model;
	private DefaultListModel<Entity> training,unsolved, features;
	
	public Solver() {
		features = new DefaultListModel<Entity>();
		training = new DefaultListModel<Entity>();
		unsolved = new DefaultListModel<Entity>();

		view = new GUI(this);
		
		// Create action listeners //
		
		//addFeature Button Listener
		view.getAddFeature().addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	features.addElement(createFeature());
				}  
		});
		
		//removeFeature Button Listener
		view.getRemoveFeature().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  features.removeElementAt(view.getFeatures().getSelectedIndex());
			}  
				});
		
		//addTraining Button Listener
		view.getAddTraining().addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	//training.addElement(createEntity(training));
				}  
		});
		
		//AddUnsolved
		view.getAddUnsolved().addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
					createEntity(unsolved);
				}
		});
		
		//RemoveUnsolved
		view.getRemoveUnsolved().addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {	
					unsolved.removeElementAt(view.getUnsolved().getSelectedIndex());
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
				training.removeElementAt(view.getTraining().getSelectedIndex());
			}
		});
				
	}
	
	private Entity createFeature() {
		String name = view.nameOption("new");
		String type = view.typeOption();
		return new Entity(name);
		
	}
	
	private void createEntity(DefaultListModel<Entity> list) {	
		String s;
		//Entity e = new Entity();
		for(int i = 0; i<features.size();i++) {
			s = features.getElementAt(i).toString();
			switch(s) {
			case "Cartesian": Double x = view.xOption(s);
							Double y = view.yOption(s);
							
							break;
			case "Number": Double a = view.valueDoubleOption(s);
							break;
			case "Boolean": String value = view.valueStringOption(s);
							break;
			}
			if(training == list) {
				
			}
		}
		//return e;
	}
		


	
	
	public DefaultListModel<Entity> getFeatures() {
		return features;
	}

	public void setFeatures(DefaultListModel<Entity> features) {
		this.features = features;
	}

	public GUI getGui() {
		return view;
	}


	public void setGui(GUI gui) {
		this.view = gui;
	}


	public DefaultListModel<Entity> getTraining() {
		return training;
	}


	public void setTraining(DefaultListModel<Entity> training) {
		this.training = training;
	}


	public DefaultListModel<Entity> getUnsolved() {
		return unsolved;
	}


	public void setUnsolved(DefaultListModel<Entity> unsolved) {
		this.unsolved = unsolved;
	}


	public static void main(String[] args) {
		new Solver();	
	}
}

