import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

public class Solver {
	
	private GUI  view;
	private ExampleCollection trainingModel,unsolvedModel;
	private Example featuresModel;
	
	public Solver() {
		featuresModel = new Example();
		trainingModel = new ExampleCollection();
		unsolvedModel = new ExampleCollection();

		view = new GUI(this);
		view.setFeatures(featuresModel.getFeatures());
		view.setTraining(trainingModel.getExample());
		view.setUnsolved(unsolvedModel.getExample());
		view.setUp();
		
		//set up all the ActionListeners
		createActionListeners();
		//Create action listeners//
		
		
				
	}
	
	private void createExample(ExampleCollection e) {	
		Feature s;
		Example newE = new Example();
		
		for(int i = 0; i<featuresModel.getFeatureList().size();i++) {
			s = featuresModel.getFeatureList().getElementAt(i);
			switch(s.getType()) {
			case "Cartesian": newE.addFeature("Cartesian",s.GetName(),view.xOption(s.GetName()), view.yOption(s.GetName()));
							break;
			case "Number": newE.addFeature("Number",s.GetName(),view.valueDoubleOption(s.GetName()), null);
							break;
			case "Boolean": newE.addFeature( "Boolean",view.valueStringOption(s.GetName()),null, null);
							break;
			}
		}
		e.addExample(newE);
	}
	
	
	public void createActionListeners() {
		//addFeature Button Listener
				view.getAddFeature().addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    	featuresModel.addFeature (view.typeOption(),view.nameOption("new"),null,null);
						}  
				});
				
				//removeFeature Button Listener
				view.getRemoveFeature().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						  featuresModel.getFeatureList().removeElementAt(view.getFeatures().getSelectedIndex());
					}  
						});
				
				//AddUnsolved
				view.getAddUnsolved().addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    	createExample(unsolvedModel);
						}
				});
				
				//RemoveUnsolved
				view.getRemoveUnsolved().addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {	
							unsolvedModel.getExample().removeElementAt(view.getUnsolved().getSelectedIndex());
						}
				});
				
				//EditUnsolved
				view.getEditUnsolved().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {	
							//unsolved.addElement(createEntity());
						}
				});
				
				//addTraining Button Listener
				view.getAddTraining().addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    	createExample(trainingModel);
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
						trainingModel.getExample().removeElementAt(view.getTraining().getSelectedIndex());
					}
				});
	}


	
	
	public DefaultListModel<Feature> getFeatures() {
		return featuresModel.getFeatureList();
	}


	public GUI getGui() {
		return view;
	}


	public void setGui(GUI gui) {
		this.view = gui;
	}


	public ExampleCollection getTraining() {
		return trainingModel;
	}


	public void setTraining(ExampleCollection training) {
		this.trainingModel = training;
	}


	public ExampleCollection getUnsolved() {
		return unsolvedModel;
	}


	public void setUnsolved(ExampleCollection unsolved) {
		this.unsolvedModel = unsolved;
	}


	public static void main(String[] args) {
		new Solver();	
	}
}

