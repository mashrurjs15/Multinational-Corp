package main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * kNNStrategy finds the closest neighbors for the unsolvedFeature listed in the unsolvedEntity
 * kNNStrategy 
 */

public class kNNStrategy {

	// Initialize the number of neighbors, Hash map, Example
	private int numberOfNeighbors; 												  // Store the value of neighbors the user want to compare the test example with.
	private ExampleCollection unsolvedExampleCollection, solvedExampleCollection; // Initialize collection of solved n unsolved examples. 
	
	// Final Lists after comparing test with training.
	private HashMap<Double, Feature> resultList; 								  // Hash map (Key: normalized result of the compared features, Feature:********
	private ArrayList<Double> finalResultList; 									  // List of answers for the empty feature of the test example
	private double tally = 0; 													  // Forgot what this does.*******************************
	
	/* After constructor is called:
	 * n is the number of neighbors unsolved is comparing to
	 * Hashmap(key: the result between the training example and unsolved, value: list of features of the key training example)
	 * unsolvedEntity is the chosen entity to solve using solveKNN()
	 */ 
	public kNNStrategy(int n, ExampleCollection unsolvedExampleCollection, ExampleCollection solvedExampleCollection) {
		this.numberOfNeighbors = n;												  // n closest neighbors to compare with.
		this.solvedExampleCollection = solvedExampleCollection; 				  // Collection of training examples with given features. All will have the same amount of features
		this.unsolvedExampleCollection = unsolvedExampleCollection; 			  // Collection of unsolved test examples with one empty feature.
	}
	

	/* This method is the kNN Solver
	 * There will be some slight confusion of how this works.
	 * In steps: 1. unsolvedFeature will find the empty Feature of an Entity.
	 * 			 2. sortedKeys is created locally to store an array of keys in resultList from least to greatest
	 * 			 3. kKey is created and store the number of keys of the resultList specified in numberOfNeighbors
	 * 			 4. k then loops through kKeys and find the value of the unsolvedFeature in the training Entity and sums together
	 * 			 5. @return gives the average of the unsolved Feature
	 */
	public ArrayList<Double> solveKNN() {
		
		// unsolvedExampleCollection, solvedExampleCollection
		ArrayList<Double> temp = new ArrayList<>();
		ArrayList<Double> maxList = new ArrayList<>(); // List of maximum value of each features from the group of training collection. Should be in the same order as the collection since it'll store in l.
		double result = 0;
		String ofUnsolved; // The name of the empty feature that was found in the test example.
		Metric m;
		
		// Create list of maximum value from all the training examples. Max value
		createMaxList(maxList);
		
		for(int i = 0; i < unsolvedExampleCollection.getExample().size(); i++) { // Iterate through the list of examples in the testing collection (eg. Testing 1 then 'check next loop')
			 ofUnsolved = unsolvedExampleCollection.getExample().getElementAt(i).getUnsolvedFeature().GetName(); // Find the unsolved feature from the testing example then find the name of that feature.
			 
			 // ofUnsolved feature will then be avoided in calculation since none of the metric would work with the testing example due to the fact that it is empty.
			 Feature inValidCalculationFeature = solvedExampleCollection.getExample().getElementAt(i).getFeature(ofUnsolved); // Store the feature of the training example that can't be part of the calculation.
			 ArrayList<Double> temp2 = new ArrayList<>();
			 for(int j = 0; j < solvedExampleCollection.getExample().size(); j++) {	// Iterate through the list of examples in the training collection
				 
				 for(int p = 0; p < solvedExampleCollection.getExample().getElementAt(j).getFeatures().size(); p++) { // Iterate through the features of training example j
					 if(solvedExampleCollection.getExample().getElementAt(j).getFeatureIndex(p).equals(inValidCalculationFeature)) {} // If the feature is equal to the empty testing feature, ignore and go to next feature
					 else { // empty feature is ignored and now we figure out the getDistance with the indexed feature
						 Feature chosenTrainingFeature = solvedExampleCollection.getExample().getElementAt(j).getFeatureIndex(p); // store training feature to work with
						 Feature chosenTestingFeature = unsolvedExampleCollection.getExample().getElementAt(j).getFeatureIndex(p); // store testing feature to work with
						 
						 // Each condition checks for the Type of Feature
						 if (chosenTrainingFeature.getType().equals("Number")) {
							 AbsoluteDifference comp = new AbsoluteDifference();	 
							 temp2.add(comp.getDistance(chosenTrainingFeature, chosenTestingFeature));
						 }
						 if (chosenTrainingFeature.getType().equals("Boolean")) {
							 BooleanCompare comp = new BooleanCompare();	 
							 temp2.add(comp.getDistance(chosenTrainingFeature, chosenTestingFeature));
						 }
						 if (chosenTrainingFeature.getType().equals("Cartesian")) {
							 Euclidian comp = new Euclidian();	 
							 temp2.add(comp.getDistance(chosenTrainingFeature, chosenTestingFeature));
						 }
						 
					 }
				 }
				 for(int q = 0 ; q < temp2.size(); q++) {
					 result += temp2.get(q)/maxList.get(q);
				 }
				 temp.add(result);

				 resultList = new HashMap<Double,Feature>();
				 
				 for (Double d : temp) {
					 resultList.put(d, solvedExampleCollection.getExample().getElementAt(j).getFeatureIndex(j));
				 }
				 
				 List<Double> sortedKeys = new ArrayList<Double>(resultList.size());
				 sortedKeys.addAll(resultList.keySet());
				 Collections.sort(sortedKeys);
				 List<Double> kKeys = new ArrayList<Double>();

				 for (int c = 0; i < numberOfNeighbors; c++) {
					 kKeys.add(sortedKeys.get(c));
					 }
				 for (double k : kKeys) {
					 tally += (Double)resultList.get(k).GetValue();
					 }
				 finalResultList.add(tally/numberOfNeighbors);

			 }
			 
			 
		}
		return finalResultList;
		
	}
	
	// Create list of maximum value from all the training examples.
	public void createMaxList(ArrayList<Double> maxList) {
		// Step 1: Iterate through list of solved examples and find the MAXIMUM value of each feature from the list of solved examples. This will be used for "Normalizing"
		for(int k = 0; k < solvedExampleCollection.getExample().size(); k++) { 													 // Iterate through the list of examples in the training collection (eg. Training 1 then 'check next loop')
					
			for(int l = 0; l < solvedExampleCollection.getExample().getElementAt(k).getFeatures().size(); l++) { 				 // Iterate through the list of features at element k (eg. k is Training 1, iterate through the list of feature of Training 1)
						
				if(solvedExampleCollection.getExample().getElementAt(k).getFeatureIndex(l).GetName().equals("Boolean")) {}  	 // If the training's feature at element l is a boolean, do nothing. We can't normalize a discrete value. Instead we'll make use of other features
				else if(solvedExampleCollection.getExample().getElementAt(k).getFeatureIndex(l).GetName().equals("Cartesian")) { // maximum cannot be done from (0,0). Need the origin to be the cartesian of the test example.
					// Need to use Euclidean equation here to input maximum normalization.
				}
				else if(maxList.get(l) == null || maxList.get(l) < (Double)solvedExampleCollection.getExample().getElementAt(k).getFeatureIndex(l).GetValue()) { // List starts at 0 and stores training value if it's not boolean.
					maxList.add((Double)solvedExampleCollection.getExample().getElementAt(k).getFeatureIndex(l).GetValue()); // This works before calculation. and only works for Difference of "Number"		
				}
				else {} // this can replace the second else if condition since we checked for boolean and cartesian but incase were adding two new features, we'll leave this here.
			}
		}
	}
	
}
