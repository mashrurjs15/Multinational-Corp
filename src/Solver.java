import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

public class Solver {
	
	private GUI  view;
	private ExampleCollection trainingModel,unsolvedModel;
	private Example featuresModel;
	private kNNStrategy kNNAnswer;
	
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
			case "Cartesian": if(view.getUNKNOWN_FLAG() == 1) {
									newE.addFeature("Cartesian",s.GetName(),s.GetMetric(),null,view.valueListOption(s.GetName()),null);
								}else {
									newE.addFeature("Cartesian",s.GetName(),s.GetMetric(),null, view.valueListUnknownOption(s.GetName()),null);
								}
							break;
			case "Number": if(view.getUNKNOWN_FLAG() == 1) {
								newE.addFeature("Number",s.GetName(),s.GetMetric(),view.valueDoubleOption(s.GetName()), null,null);
							}else {
								newE.addFeature("Number",s.GetName(),s.GetMetric(),view.valueDoubleUnknownOption(s.GetName()), null,null);
							}
							break;
			case "Boolean":if(view.getUNKNOWN_FLAG() == 1) {
								newE.addFeature( "Boolean",s.GetName(),s.GetMetric(),null,null, view.valueStringOption(s.GetName()));
							}else {
								newE.addFeature( "Boolean",s.GetName(),s.GetMetric(),null,null, view.valueStringUnknownOption(s.GetName()));
							}
							break;
			}
		}
		view.setUNKNOWN_FLAG(0);
		e.addExample(newE);
	}
	
	
	public void createActionListeners() {
		//addFeature Button Listener
				view.getAddFeature().addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    	String t = view.typeOption();
				    	String v = view.valueStringOption("new");
				    	String s = view.metricOption();
				    	Metric m;
				    	if(s.equals("Euclidian")) {
				    		m = new Euclidian();
				    	}else if(s.equals("AbsoluteDifference")) {
				    		m = new AbsoluteDifference();
				    	}else if(s.equals("Difference")) {
				    		m = new Difference();
				    	}else {
				    		m = new BooleanCompare();
				    	}
			
				    		
				    	featuresModel.addFeature (t,v, m,null,null,null);
				    	
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
							DefaultListModel<Feature> f = view.getUnsolved().getSelectedValue().getFeatureList();
							for (int i = 0; i < f.size();i++) {
								if(f.getElementAt(i) instanceof Cartesian) {
									f.getElementAt(i).SetValue(view.valueListOption(f.getElementAt(i).GetName()));
								}else if(f.getElementAt(i) instanceof Number) {
									f.getElementAt(i).SetValue(view.valueDoubleOption(f.getElementAt(i).GetName()));
								}else {
									f.getElementAt(i).SetValue(view.valueStringOption(f.getElementAt(i).GetName()));
								}
								
							}
							
							//unsolved.addElement(createEntity());
						}
				});
				
				//addTraining Button Listener
				view.getAddTraining().addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    	view.setUNKNOWN_FLAG(1);
				    	createExample(trainingModel);
						}  
				});
				
				//EditTraining
				view.getEditTraining().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {	
						DefaultListModel<Feature> f = view.getTraining().getSelectedValue().getFeatureList();
						for (int i = 0; i < f.size();i++) {
							if(f.getElementAt(i) instanceof Cartesian) {
								f.getElementAt(i).SetValue(view.valueListOption(f.getElementAt(i).GetName()));
							}else if(f.getElementAt(i) instanceof Number) {
								f.getElementAt(i).SetValue(view.valueDoubleOption(f.getElementAt(i).GetName()));
							}else {
								f.getElementAt(i).SetValue(view.valueStringOption(f.getElementAt(i).GetName()));
							}
							
						}
					}
				});
				
				//RemoveTraining
				view.getRemoveTraining().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {	
						trainingModel.getExample().removeElementAt(view.getTraining().getSelectedIndex());
					}
				});
				
				//Solve
				view.getSolve().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {	
						Integer k = view.kOption();
						
						
						kNNAnswer = new kNNStrategy(k,unsolvedModel, trainingModel);
						kNNAnswer.solveKNN();
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

