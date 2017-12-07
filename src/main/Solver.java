package main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
		if(featuresModel.getFeatureList().size() == 0) {
			view.error("There are no features. \nAdd features before adding examples.");
		}
		try {
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
		}catch(Exception n) {
			view.error(n);
		}
		
	}
	
	
	public void createActionListeners() {
		//addFeature Button Listener
				view.getAddFeature().addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    	
				    	try {
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
				    	}catch(Exception n){
				    		view.error(n);
				    	}
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
				    	try {
				    		unsolvedModel.getExample().removeElementAt(view.getUnsolved().getSelectedIndex());
						}catch(Exception n){
							if((n instanceof ArrayIndexOutOfBoundsException) == false) {
								view.error(n);
							}else {
								view.error("There must be an example selected before removing one.");
							}
						}
							
						}
				});
				
				//EditUnsolved
				view.getEditUnsolved().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
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
						}catch(Exception n) {
							if((n instanceof NullPointerException) == false) {
								view.error(n);
							}else {
								view.error("There must be an example selected before removing one.");
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
						try {
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
						}catch(Exception n) {
							if((n instanceof NullPointerException) == false) {
								view.error(n);
							}else {
								view.error("There must be an example selected before removing one.");
							}
					}
					}
				});
				
				//RemoveTraining
				view.getRemoveTraining().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							trainingModel.getExample().removeElementAt(view.getTraining().getSelectedIndex());
						}catch(Exception n){
							if((n instanceof  ArrayIndexOutOfBoundsException) == false) {
								view.error(n);
							}else {
								view.error("There must be an example selected before removing one.");
							}
							
						}
						
					}
				});
				
				//Solve
				view.getSolve().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {	
						int k = 0;
						try {
							k = view.kOption();
						} catch (Exception n) {
							view.error(n);
						}
						
						
						kNNAnswer = new kNNStrategy(k,unsolvedModel, trainingModel);
						kNNAnswer.solveKNN();
					}
				});
				
				view.getReset().addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    		trainingModel.getExample().removeAllElements();
				    		unsolvedModel.getExample().removeAllElements();
				    		featuresModel.getFeatureList().removeAllElements();
						}
				});
				
				view.getSave().addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    	try {
							 FileOutputStream fileOut =
					         new FileOutputStream("lastSession.ser");
					         ObjectOutputStream out = new ObjectOutputStream(fileOut);
					         ArrayList<Example> t = new ArrayList<Example>();
					         ArrayList<Example> u = new ArrayList<Example>();
					         ArrayList<Feature> f = new ArrayList<Feature>();
					         
					         for(int i = 0; i< trainingModel.getExample().size();i++) {
					        	 t.add(trainingModel.getExample().getElementAt(i));
					         }
					         for(int i = 0; i< unsolvedModel.getExample().size();i++) {
					        	 u.add(unsolvedModel.getExample().getElementAt(i));
					         }
					         for(int i = 0; i< featuresModel.getFeatures().size();i++) {
					        	 f.add(featuresModel.getFeatures().getElementAt(i));
					         }
					        	 out.writeObject(t);
					        	 out.writeObject(u);
					        	 out.writeObject(f);
					         out.close();
					         fileOut.close();
					      } catch (IOException i) {
					         i.printStackTrace();
					      }
						}
				});
				
				view.getLoad().addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    	try {
					         FileInputStream fileIn = new FileInputStream("LastSession.ser");
					         ObjectInputStream in = new ObjectInputStream(fileIn);
					         	ArrayList<Example> t = (ArrayList<Example>) in.readObject();
					         	ArrayList<Example> u = (ArrayList<Example>) in.readObject();
					         	ArrayList<Feature> f =(ArrayList<Feature>) in.readObject();
					         	for(Feature b: f) {
					         		featuresModel.getFeatures().addElement(b);;
					         	}
					         	for(Example b: u) {
					         		unsolvedModel.getExample().addElement(b);;
					         	}
					         	for(Example b: t) {
					         		trainingModel.getExample().addElement(b);;
					         	}

					         in.close();
					         fileIn.close();
					      } catch (IOException | ClassNotFoundException i) {
					         i.printStackTrace();
					         view.error(i);
					         return;
					      }
				    	
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

