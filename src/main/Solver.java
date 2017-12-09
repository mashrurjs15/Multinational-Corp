/**
 * Author: Adam Staples, Eric Morrisette
 * Date: Dec 8th 2017
 * Purpose: This is the main and controller class of the project. It handles all action listeners and is where everything
 * stems from. It creates the GUI, the model lists and called Example and crate features. All new examples are added to the lists
 * created in this class. 
 */
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
		//create lists to be used for the view
		featuresModel = new Example();
		trainingModel = new ExampleCollection();
		unsolvedModel = new ExampleCollection();

		view = new GUI();
		view.setFeatures(featuresModel.getFeatures());
		view.setTraining(trainingModel.getExample());
		view.setUnsolved(unsolvedModel.getExample());
		view.setUp();
		
		//Create action listeners//
		createActionListeners();		
	}
	
	/**
	 * This function adds actionListeners to all the buttons to be used in the view.
	 */
	public void createActionListeners() {
		//addfeature
		view.getAddFeature().addActionListener(new ActionListener() {
			/*
			 * Add action listener for when the add feature button is pressed. This will create a new default feature(with a null value)
			 * and add it to the feature list. THis list will not contain features with values as it is just the list that we use to 
			 * run through exactly what features we need to create when adding them to the unsolved and training lists..
			 * (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
		    public void actionPerformed(ActionEvent e) {
		    	int i = 0;
		    	try {
		    		String t = view.typeOption();//prompt the user for the feature they wish to add
		    		if(t.equals("Cartesian")) {//if the feature is a cartesian ask how many elements it will have
		    			i = view.valueIntOption("How many points will your cartesian have?", false);
		    		}
			    	String v = view.valueStringOption("What is the name of the new Feature?",false);//prompt user for the name of the new feature
			    	String s = view.metricOption();//prompt user for the metric to be used for that feature.
			    	Metric m;
			    	//depeneding on the option selected for the metric create a new instance of that metric.
			    	//TODO this could be done with ENUMS
			    	if(s.equals("Euclidian")) {
			    		m = new Euclidian();
			    	}else if(s.equals("AbsoluteDifference")) {
			    		m = new AbsoluteDifference();
			    	}else if(s.equals("Difference")) {
			    		m = new Difference();
			    	}else {
			    		m = new BooleanCompare();
			    	}
			    	//once selected create a new feature
			    	featuresModel.addGenericFeature(t,v,m,i);
		    	}catch(Exception n){
		    		//if there is an exception print an error message and go back to open gui
		    		view.error(n);
		    	}
				}  
		});
		
		//removeFeature Button Listener
		view.getRemoveFeature().addActionListener(new ActionListener() {
			/*
			 * Add action listener for when the remove feature button is pressed. THis button will remove the current
			 *  selected feature from the featureModel list and therefore the view also
			 * (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent e) {
				  featuresModel.getFeatureList().removeElementAt(view.getFeatures().getSelectedIndex());
			}  
				});
		
		//AddUnsolved
		view.getAddUnsolved().addActionListener(new ActionListener() {
			/*
			 * Add action listener for when the add unsolved button is pressed. This will call the createExample() method with
			 * the unsolvedModel list and create a new examples for the list then add it.
			 * (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
		    public void actionPerformed(ActionEvent e) {
		    	createExample(unsolvedModel);//pass the unsolved list
				}
		});
		
		//RemoveUnsolved
		view.getRemoveUnsolved().addActionListener(new ActionListener() {
			/*
			 * Add action listener for when the remove Unsolved button is pressed. .
			 * (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
		    public void actionPerformed(ActionEvent e) {
		    	try {
		    		unsolvedModel.getExample().removeElementAt(view.getUnsolved().getSelectedIndex());
				}catch(Exception n){
					if((n instanceof ArrayIndexOutOfBoundsException) == false) {
						view.error(n);
					}else {
						//if nothing is selected print out a message saying specifically that.
						view.error("There must be an example selected before removing one.");
					}
				}
					
				}
		});
		
		//EditUnsolved
		view.getEditUnsolved().addActionListener(new ActionListener() {
			/*
			 * Add action listener for when the edit unsolved button is pressed. This will allow you completely re enter the values
			 * for the currently selected unsolved example.
			 * (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultListModel<Feature> f = view.getUnsolved().getSelectedValue().getFeatureList();
					for (int i = 0; i < f.size();i++) {
						//save the current feature
						Feature feature = f.getElementAt(i);
						//depending on the feature change the value accordingly and with the correct prompt.
						if(feature instanceof Cartesian) {
							if(view.getUNKNOWN_FLAG() == 1) {
								feature.SetValue(view.valueListOption(feature.GetName(),((Cartesian) feature).getNumber(),false));
							}else {
								feature.SetValue(view.valueListOption(feature.GetName(),((Cartesian) feature).getNumber(),true));
							}
						}else if(feature instanceof Number) {
							if(view.getUNKNOWN_FLAG() == 1) {
								feature.SetValue(view.valueDoubleOption("What is the Double value of the feature " + feature.GetName(),false));
							}else {
								feature.SetValue(view.valueDoubleOption("What is the Double value of the feature " + feature.GetName()+ "\nEnter a '?' if this feature is unknown.",true));
							}
						}else if (feature instanceof Boolean){
							if(view.getUNKNOWN_FLAG() == 1) {
								feature.SetValue(view.valueStringOption("What is the Boolean value of the feature " + feature.GetName(),false));
							}else {
								feature.SetValue(view.valueStringOption("What is the boolean value of the feature " + feature.GetName()+ "\nEnter a '?' if this feature is unknown.",true));
							}
						}else if (feature instanceof Colour){
							if(view.getUNKNOWN_FLAG() == 1) {
								feature.SetValue(view.colourOption("What colour do you want for the feature " + feature.GetName(),false));
							}else {
								feature.SetValue(view.colourOption("What colour do you want for the feature " + feature.GetName() + "\nSelect the 'UNKNOWN' option if the feature is unknown",true));
							}
						}else{
							if(view.getUNKNOWN_FLAG() == 1) {
								feature.SetValue(view.valueIntOption("What is the % of the feature "+ feature.GetName()+"\n0 = no damage, 100 max damage",false));
							}else {
								feature.SetValue(view.valueIntOption("What is the % of the feature "+ feature.GetName()+"\n0 = no damage, 100 max damage\nEnter a '?' if this feature is unknown.", true));
							}
						}
					}
					
				
				if(view.getUNKNOWN_FLAG() == 0) {
					throw new IOException();
				}else {
					view.setUNKNOWN_FLAG(0);
				}
				
			}catch(Exception n) {
				if(n instanceof IOException) {
					view.error("For the unknown list, there must be an unknown feature in the example.");
				}else {
					view.error(n);
				}
				}
					
					//unsolved.addElement(createEntity());
				}
		});
		
		//addTraining Button Listener
		view.getAddTraining().addActionListener(new ActionListener() {
			/*
			 * Add action listener for when the add training button is pressed. This will call the createExample() method with
			 * the trainingModel list and create a new examples for the list then add it.
			 * (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
		    public void actionPerformed(ActionEvent e) {
		    	view.setUNKNOWN_FLAG(1);
		    	createExample(trainingModel);
				}  
		});
		
		//editTraining
		view.getEditTraining().addActionListener(new ActionListener() {
			/*
			 * Add action listener for when the edit training button is pressed. This will allow you completely re enter the values
			 * for the currently selected training example.
			 * (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultListModel<Feature> f = view.getTraining().getSelectedValue().getFeatureList();
					for (int i = 0; i < f.size();i++) {
						//save the current feature
						Feature feature = f.getElementAt(i);
						//depending on the feature change the value accordingly and with the correct prompt.
						if(feature instanceof Cartesian) {
							feature.SetValue(view.valueListOption(feature.GetName(),((Cartesian) feature).getNumber(),false));
						}else if(feature instanceof Number) {
							feature.SetValue(view.valueDoubleOption("What is the Double value of the feature " + feature.GetName() ,false));
						}else if (feature instanceof Boolean){
							feature.SetValue(view.valueStringOption("What is the Boolean value of the feature " + feature.GetName(),false));
						}else if (feature instanceof Colour){
							feature.SetValue(view.colourOption("What colour do you want for the feature " + feature.GetName(),false));
						}else{
							feature.SetValue(view.valueIntOption("What is the % of the feature "+ feature.GetName()+"\n0 = no damage, 100 max damage",false));
						}
					}
					view.getTraining().repaint();
				}catch(Exception n) {
					if((n instanceof NullPointerException) == false) {
						
						view.error(n);
					}else {
						//if nothing is selected print out a message saying specifically that.
						view.error("There must be an example selected before removing one.");
					}
			}
			}
		});
		
		//RemoveTraining
		view.getRemoveTraining().addActionListener(new ActionListener() {
			/*
			 * Add action listener for when the remove Training button is pressed. THis button will remove the current selected training example
			 * fromt the model list and therefore the view also.
			 * (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent e) {
				try {
					trainingModel.getExample().removeElementAt(view.getTraining().getSelectedIndex());
				}catch(Exception n){
					if((n instanceof  ArrayIndexOutOfBoundsException) == false) {
						view.error(n);
					}else {
						//if nothing is selected print out a message saying specifically that.
						view.error("There must be an example selected before removing one.");
					}
					
				}
				
			}
		});
		
		//Solve
		view.getSolve().addActionListener(new ActionListener() {
			/*
			 * Add action listener for when the solve button is pressed. This button prompts the user for a k value
			 * and then runs the kNNStrategy class to solve the unsolved examples vs the training examples.
			 * (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent e) {	
				int k = 0;
				//ask for a k value;
				try {
					k = view.valueIntOption("Please enter the value of k that will be used.",false);
				} catch (Exception n) {
					view.error(n);
				}
				kNNAnswer = new kNNStrategy(k,unsolvedModel, trainingModel);

				view.printKNN(kNNAnswer.solveKNN());
				
			}
		});
		
		//Reset
		view.getReset().addActionListener(new ActionListener() {
			/*
			 * Add action listener for when the reset button is pressed. This button will set all the current model lists back to
			 * their empty state.
			 * (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
		    public void actionPerformed(ActionEvent e) {
		    		resetLists();
				}
		});
		
		//Save
		view.getSave().addActionListener(new ActionListener() {
			 /*Add action listener for when the Save button is pressed. Once pressed it saves the current defaultListModels into
			  * arraylists and then exports them using serializable. The file it is saved to by default it is called lastSession.ser.
			  * and is located in the default directory. 
		     * (non-Javadoc)
		     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		     */
		    public void actionPerformed(ActionEvent e) {
		    	try {
					 FileOutputStream fileOut = new FileOutputStream("lastSession.ser");//save classes to file
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         //DefaultListModel doesn't play nicely with Serializable so put them in ArrayLists then export
			         ArrayList<Example> t = new ArrayList<Example>();
			         ArrayList<Example> u = new ArrayList<Example>();
			         ArrayList<Feature> f = new ArrayList<Feature>();
			         //export the arraylists
			         for(int i = 0; i< trainingModel.getExample().size();i++) {
			        	 t.add(trainingModel.getExample().getElementAt(i));
			         }
			         for(int i = 0; i< unsolvedModel.getExample().size();i++) {
			        	 u.add(unsolvedModel.getExample().getElementAt(i));
			         }
			         for(int i = 0; i< featuresModel.getFeatures().size();i++) {
			        	 f.add(featuresModel.getFeatures().getElementAt(i));
			         }
			         //write each individually
			        out.writeObject(t);
			        out.writeObject(u);
			        out.writeObject(f);
			        //close all the files
			        out.close();
			        fileOut.close();
			      } catch (IOException i) {
			         i.printStackTrace();
			      }
				}
		});
		
		//Load
		view.getLoad().addActionListener(new ActionListener() {
				    @SuppressWarnings("unchecked")
				    /*Add action listener for when the Load button is pressed. Once pressed it loads the .ser file currently
				     * in the default directory into the lists (after reseting them). by default it is called lastSession.ser.
				     * (non-Javadoc)
				     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
				     */
					public void actionPerformed(ActionEvent e) {
				    	try {
				    		resetLists();
					        FileInputStream fileIn = new FileInputStream("LastSession.ser");
					        ObjectInputStream in = new ObjectInputStream(fileIn);
					        //the lists are written in the file as arraylists so save them as such
					        ArrayList<Example> t = (ArrayList<Example>) in.readObject();
					        ArrayList<Example> u = (ArrayList<Example>) in.readObject();
					        ArrayList<Feature> f =(ArrayList<Feature>) in.readObject();
					        //copy each array list to the coressponding model list
					        for(Feature b: f) {
					         		featuresModel.getFeatures().addElement(b);;
					        }
					        for(Example b: u) {
					         		unsolvedModel.getExample().addElement(b);;
					        }
					        for(Example b: t) {
					         		trainingModel.getExample().addElement(b);;
					        }
					        
					        //close the files
					        in.close();
					        fileIn.close();
					    }catch (IOException | ClassNotFoundException i) {
					        i.printStackTrace();
					        view.error(i);
					        return;
					      }
						}
				});
				
	}
	
	/**
	 * This function takes an Example Collection (in our case training or unsolved) and adds a new example to it.
	 * It runs through the featuresModel list and for each feature creates a new one with prompts for values 
	 * then adds it to an example.
	 * 
	 * @param e
	 */
	private void createExample(ExampleCollection e) {	
		Feature feature;
		ArrayList<Number> numList = new ArrayList<Number>();//list for the cartesian 
		Example newE = new Example();//this iwll be our new example that we add at the end
		
		//if there is no features yet don't add an example.
		if(featuresModel.getFeatureList().size() == 0) {
			view.error("There are no features. \nAdd features before adding examples.");
		}
		try {
			//iterate through all of the features currently implemented
			for(int i = 0; i<featuresModel.getFeatureList().size();i++) {
				feature = featuresModel.getFeatureList().getElementAt(i);
				switch(feature.getType()) {
					//for each feature in the list create a new feature and add it, to the example
					//maybe could use generics here, also ENUMS but ran out of time.
					case "Cartesian": 
						if(view.getUNKNOWN_FLAG() == 1) {
							numList = view.valueListOption(feature.GetName(),((Cartesian) feature).getNumber(),false);
							newE.addFeature(feature.GetName(),feature.GetMetric(),numList,((Cartesian) feature).getNumber());
						}else {
							numList = view.valueListOption(feature.GetName(),((Cartesian) feature).getNumber(),true);
							newE.addFeature(feature.GetName(),feature.GetMetric(),numList,((Cartesian) feature).getNumber());
						}
						break;
					case "Number": 
						if(view.getUNKNOWN_FLAG() == 1) {
							newE.addFeature(feature.GetName(),feature.GetMetric(),view.valueDoubleOption("What is the Double value of the feature " + feature.GetName(),false));
						}else {
							newE.addFeature(feature.GetName(),feature.GetMetric(),view.valueDoubleOption("What is the Double value of the feature " + feature.GetName()+ "\nEnter a '?' if this feature is unknown.",true));
						}
						break;
					case "Boolean":
						if(view.getUNKNOWN_FLAG() == 1) {
							newE.addFeature(feature.GetName(),feature.GetMetric(), view.valueStringOption("What is the Boolean value of the feature " + feature.GetName(),false));
						}else {
							newE.addFeature(feature.GetName(),feature.GetMetric(), view.valueStringOption("What is the boolean value of the feature " + feature.GetName()+ "\nEnter a '?' if this feature is unknown.",true));
						}
						break;
					case "Colour":
						if(view.getUNKNOWN_FLAG() == 1) {
							newE.addFeature(feature.GetName(),feature.GetMetric(),view.colourOption("What colour do you want for the feature " + feature.GetName(),false));
						}else {
							newE.addFeature(feature.GetName(),feature.GetMetric(),view.colourOption("What colour do you want for the feature " + feature.GetName() + "\nSelect the 'UNKNOWN' option if the feature is unknown",true));
						}
						break;
					case "DamagePercent":
						if(view.getUNKNOWN_FLAG() == 1) {
							newE.addFeature(feature.GetName(),feature.GetMetric(),view.valueIntOption("What is the % of the feature "+ feature.GetName()+"\n0 = no damage, 100 max damage",false));
						}else {
							newE.addFeature(feature.GetName(),feature.GetMetric(),view.valueIntOption("What is the % of the feature "+ feature.GetName()+"\n0 = no damage, 100 max damage\nEnter a '?' if this feature is unknown.", true));
						}
						break;
				}
				
			}
			if(view.getUNKNOWN_FLAG() == 0) {
				throw new IOException();
			}
			view.setUNKNOWN_FLAG(0);
			e.addExample(newE);
		}catch(Exception n) {
			if(n instanceof IOException) {
				view.error("For the unknown list, there must be an unknown feature in the example.");
			}else {
				view.error(n);
			}
		}
	}
	
	/**
	 * This function simply sets all the models to their default clear state. This is used in the reset and load button actionlisteners.
	 */
	public void resetLists() {
		//remove all elements from the three model lists
		trainingModel.getExample().removeAllElements();
		unsolvedModel.getExample().removeAllElements();
		featuresModel.getFeatureList().removeAllElements();
	}
	
	/**
	 * Simply returns the list of features currently held by the solver.
	 * 
	 * @return the list of features currently held by the solver
	 */
	public DefaultListModel<Feature> getFeatures() {
		return featuresModel.getFeatureList();
	}

	/**
	 * main function that runs solver
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Solver();	
	}
}

