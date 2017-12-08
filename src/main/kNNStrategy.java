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
	private HashMap<Double, Feature> resultList; 								  // Hash map (Key: normalized result of the compared features, Feature of training example that will fill the test Feature
	private ArrayList<Double> finalResultKNNList; 									  // List of answers for the empty feature of the test example
	private double finalKNNResult = 0; 													  // The final KNN Result after dividing with numberOfNeighbors
	
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
		
		 // List of result in the orders of training examples (eg. result is the trainingN with testingM)
		ArrayList<Double> maxList = new ArrayList<>(); // List of maximum value of each features from the group of training collection. Should be in the same order as the collection since it'll store in l.
		double result = 0;
		String ofUnsolved; // The name of the empty feature that was found in the test example.
		finalResultKNNList = new ArrayList<Double>();

		for(int i = 0; i < unsolvedExampleCollection.getExample().size(); i++) { // Iterate through the list of examples in the testing collection (eg. Testing 1 then 'check next loop')
 
			 ArrayList<Double> temp = new ArrayList<>();
			 ofUnsolved = unsolvedExampleCollection.getExample().getElementAt(i).getUnsolvedFeature().GetName(); // Find the unsolved feature from the testing example then find the name of that feature.
		
			 // ofUnsolved feature will then be avoided in calculation since none of the metric would work with the testing example due to the fact that it is empty.
			 //Feature inValidCalculationFeature = solvedExampleCollection.getExample().getElementAt(i).getFeature(ofUnsolved); // Store the feature of the training example that can't be part of the calculation.

			 for(int j = 0; j < solvedExampleCollection.getExample().size(); j++) {	// Iterate through the list of examples in the training collection
				 
				 for(int p = 0; p < solvedExampleCollection.getExample().getElementAt(j).getFeatures().size(); p++) { // Iterate through the features of training example j and save getDistance result into getDistanceCalculation
					 if(solvedExampleCollection.getExample().getElementAt(j).getFeatureIndex(p).GetName().equals(ofUnsolved)) {
						 if(ofUnsolved.equals("Boolean")) {} // Do nothing since maxList doesn't have anything to do with Boolean
						 else {}// maxList.remove(p); //Remove the maxList value since we want it to match with the getDistanceCalculation for later
						 
					 } // If the feature is equal to the empty testing feature, ignore and go to next feature
					 else { // empty feature is ignored and now we figure out the getDistance with the indexed feature
						 
						 Feature chosenTrainingFeature = solvedExampleCollection.getExample().getElementAt(j).getFeatureIndex(p); // store training feature to work with
						 Feature chosenTestingFeature = unsolvedExampleCollection.getExample().getElementAt(i).getFeatureIndex(p); // store testing feature to work with
						 
						 // Each condition checks for the Type of Feature and use the chosen metric and store it into a list of calculations
						 if (chosenTrainingFeature.getType().equals("Boolean") && chosenTestingFeature.getType().equals("Boolean")) {
							 BooleanCompare comp = new BooleanCompare();	 
							 result += comp.getDistance(chosenTrainingFeature, chosenTestingFeature); // Adds straight to result since we don't normalize booleans
						 }
						 if (chosenTrainingFeature.getType().equals("Number") && chosenTestingFeature.getType().equals("Number")) {
							 AbsoluteDifference comp = new AbsoluteDifference();
							 double temp4;
							 double result2 = 0;
	
							 for(int v = 0; v < solvedExampleCollection.getExample().size(); v++) {
								 temp4 = (Double)solvedExampleCollection.getExample().getElementAt(v).getFeatureIndex(p).GetValue();
								 if(result2 < temp4) result2 = temp4;
							 }
							 result += comp.getDistance(chosenTrainingFeature, chosenTestingFeature)/result2;
						 }
						 if (chosenTrainingFeature.getType().equals("Cartesian") && chosenTestingFeature.getType().equals("Cartesian")) {
							 Euclidian comp = new Euclidian();
							 Feature temp5;
							 double result2 = 0;
							 double temp3;

							 //For this index, we know its at cartesian, thus this index stays true for every example.
							 //To get maximum for normalize, we want to compare all distance of training to THIS test example
							 for(int v = 0; v < solvedExampleCollection.getExample().size(); v++) {
								 
								 temp5 = solvedExampleCollection.getExample().getElementAt(v).getFeatureIndex(p);
								 temp3 = comp.getDistance(temp5, chosenTestingFeature);
								 if(result2 < temp3) result2 = temp3;
							 }
							 result += comp.getDistance(chosenTrainingFeature, chosenTestingFeature)/result2;
						 }
						 // CONDITION FOR COLOR
						 
						 // CONDITION FOR DAMAGE PERCENT
						 
					 }
				 }
				 temp.add(result); // add the result of that training and trainer into temp array. (Eg result for t1, then t2, then t3)
				 result = 0; // reset result back to 0
				 // temp should have a list of results for each training example with the testing example at i
			 }

			 resultList = new HashMap<Double,Feature>();
			 
			 
			 int j = 0;
				 for (Double d : temp) {
					 resultList.put(d, solvedExampleCollection.getExample().getElementAt(j).getFeature(ofUnsolved)); // d(t) is the key. The value is the unsolved feature solved of training example
					 j++;
				 }
			 
			 
			 List<Double> sortedKeys = new ArrayList<Double>(resultList.size());
			 sortedKeys.addAll(resultList.keySet());
			 Collections.sort(sortedKeys); // All the results are sorted from least to greatest with its corresponding feature
			 List<Double> kKeys = new ArrayList<Double>(); 

			 for (int c = 0; c < numberOfNeighbors; c++) {
				 kKeys.add(sortedKeys.get(c)); // Only use n amount of results
				 }
			 for (double k : kKeys) {
				 finalKNNResult += (Double)resultList.get(k).GetValue();
				 }
			 finalResultKNNList.add(finalKNNResult/numberOfNeighbors); // store the result of i unsolved Feature value into List.
			 finalKNNResult = 0; // reset
		 }
		return finalResultKNNList;
		
	}	
}
