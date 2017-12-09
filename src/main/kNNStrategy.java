package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * kNNStrategy finds the closest neighbors for the unsolvedFeature listed in the unsolvedEntity
 * kNNStrategy will make use of example collections and find the empty feature from the feature list
 * kNN will pop out a new frame window of the list of results for the testing example(s)
 */
public class kNNStrategy {

	// Initialize the number of neighbors, Hash map, Example
	private int numberOfNeighbors; // Store the value of neighbors the user want to compare the test example with.
	private ExampleCollection unsolvedExampleCollection, solvedExampleCollection; // Initialize collection of solved n unsolved examples.

	// Final Lists after comparing test with training.
	private HashMap<Double, Feature> resultList; // Hash map (Key: normalized result of the compared features, Feature of training example that will fill the test Feature
	private ArrayList<Object> finalResultKNNList; // List of answers for the empty feature of the test example
	private double finalKNNResult = 0; // The final KNN Result after dividing with numberOfNeighbors

	/*
	 * After constructor is called: n is the number of neighbors unsolved is
	 * comparing to Hashmap(key: the result between the training example and
	 * unsolved, value: list of features of the key training example) unsolvedEntity
	 * is the chosen entity to solve using solveKNN()
	 */
	public kNNStrategy(int n, ExampleCollection unsolvedExampleCollection, ExampleCollection solvedExampleCollection) {
		this.numberOfNeighbors = n; // n closest neighbors to compare with.
		this.solvedExampleCollection = solvedExampleCollection; // Collection of training examples with given features.
																// All will have the same amount of features
		this.unsolvedExampleCollection = unsolvedExampleCollection; // Collection of unsolved test examples with one
																	// empty feature.
	}

	/*
	 * This method is the kNN Solver There will be some slight confusion of how this
	 * works. In steps: 1. unsolvedFeature will find the empty Feature of an Entity.
	 * 2. sortedKeys is created locally to store an array of keys in resultList from
	 * least to greatest 3. kKey is created and store the number of keys of the
	 * resultList specified in numberOfNeighbors 4. k then loops through kKeys and
	 * find the value of the unsolvedFeature in the training Entity and sums
	 * together 5. @return gives the average of the unsolved Feature
	 */
	public ArrayList<Object> solveKNN() {

		// List of result in the orders of training examples (eg. result is the trainingN with testingM)
		double result = 0;
		String ofUnsolved; // The name of the empty feature that was found in the test example.
		finalResultKNNList = new ArrayList<Object>();

		// Iterate through the list of examples in the testing collection (eg. Testing 1 then 'check next loop')
		for (int i = 0; i < unsolvedExampleCollection.getExample().size(); i++) { 

			ArrayList<Double> temp = new ArrayList<>();

			// Find the unsolved feature from the testing example then find the name of that feature.
			ofUnsolved = unsolvedExampleCollection.getExample().getElementAt(i).getUnsolvedFeature().GetName(); 

			// ofUnsolved feature will then be avoided in calculation since none of the
			// metric would work with the testing example due to the fact that it is empty.
			// Feature inValidCalculationFeature = solvedExampleCollection.getExample().getElementAt(i).getFeature(ofUnsolved);
			// Store the feature of the training example that can't be part of the calculation.
			for (int j = 0; j < solvedExampleCollection.getExample().size(); j++) { // Iterate through the list of examples in the training collection

				// Iterate through the features of training example j and save getDistance result into getDistanceCalculation
				for (int p = 0; p < solvedExampleCollection.getExample().getElementAt(j).getFeatures().size(); p++) { 
					if (solvedExampleCollection.getExample().getElementAt(j).getFeatureIndex(p).GetName()
							.equals(ofUnsolved)) {
						if (ofUnsolved.equals("Boolean")) {
						}
					}						
					else { 
						Feature chosenTrainingFeature = solvedExampleCollection.getExample().getElementAt(j)
								.getFeatureIndex(p); // store training feature to work with
						Feature chosenTestingFeature = unsolvedExampleCollection.getExample().getElementAt(i)
								.getFeatureIndex(p); // store testing feature to work with

						result += exampleComparisonCalculation(chosenTrainingFeature, chosenTestingFeature, p);
					}
				}
				temp.add(result); // add the result of that training and trainer into temp array. (Eg result for t1, then t2, then t3)
				result = 0; // reset result back to 0
				// temp should have a list of results for each training example with the testing example at i
			}

			resultList = new HashMap<Double, Feature>(); // Hashmap helps organize set of results
			int j = 0; // temporary counter to iterate through list
			for (Double d : temp) {
				// d(t) is the key. The value is the unsolved feature solved of training example
				resultList.put(d, solvedExampleCollection.getExample().getElementAt(j).getFeature(ofUnsolved)); 
				j++;
			}

			List<Double> sortedKeys = new ArrayList<Double>(resultList.size());
			sortedKeys.addAll(resultList.keySet());
			Collections.sort(sortedKeys); // All the results are sorted from least to greatest with its corresponding feature
			List<Double> kKeys = new ArrayList<Double>();

			for (int c = 0; c < numberOfNeighbors; c++) {
				kKeys.add(sortedKeys.get(c)); // Only use n amount of results
			}
			
			/*
			 * This is the last part of the method that'll finish up creating the list of results and solves accordingly
			 * TO NOTE Some features aren't fully tested and may not work - Boolean, Number works perfectly
			 * =============================================================================================================
			 * Color works if it is filled, have not implement color for UNKNOWN.
			 * Cartesian works if it is filled, have not implement coordinate implementation
			 * PercentDamage does not work, have not worked on this part
			 */
			double booleanTemp = 0;
			for (double k : kKeys) {
				if (resultList.get(k).getType() == "Boolean") {
					booleanTemp += Double.parseDouble(resultList.get(k).GetValue().toString());
					if ((booleanTemp / numberOfNeighbors) > 0.5)
						finalKNNResult = numberOfNeighbors;
					else
						finalKNNResult = 0;
				} else {
					finalKNNResult += (Double) resultList.get(k).GetValue();
				}
			}
			finalResultKNNList.add(finalKNNResult / numberOfNeighbors); // store the result of i unsolved Feature value into List.
			finalKNNResult = 0; // reset
		}
		return finalResultKNNList;

	}

	/*
	 * exampleComparisonCalculation is used to calculate the feature using certain metrics
	 * the method will check thorugh list of condition of which type the feature holds
	 * @param chosenTrainingFeature: Feature, chosenTestingFeature: Feater, p: int
	 * @return return a double
	 */
	public double exampleComparisonCalculation(Feature chosenTrainingFeature, Feature chosenTestingFeature, int p) {

		// Each condition checks for the Type of Feature and use the chosen metric and
		// store it into a list of calculations
		// CONDITION FOR BOOLEAN
		if (chosenTrainingFeature.getType().equals("Boolean") && chosenTestingFeature.getType().equals("Boolean")) {
			BooleanCompare comp = new BooleanCompare();
			return comp.getDistance(chosenTrainingFeature, chosenTestingFeature); // Adds straight to result since we don't normalize booleans
		}
		// CONDITION FOR NUMBER
		if (chosenTrainingFeature.getType().equals("Number") && chosenTestingFeature.getType().equals("Number")) {
			AbsoluteDifference comp = new AbsoluteDifference();
			double absTemp;
			double absResult = 0;

			for (int v = 0; v < solvedExampleCollection.getExample().size(); v++) {
				absTemp = (Double) solvedExampleCollection.getExample().getElementAt(v).getFeatureIndex(p).GetValue();
				if (absResult < absTemp)
					absResult = absTemp;
			}
			return comp.getDistance(chosenTrainingFeature, chosenTestingFeature) / absResult;
		}
		// CONDITION FOR CARTESIAN
		if (chosenTrainingFeature.getType().equals("Cartesian") && chosenTestingFeature.getType().equals("Cartesian")) {
			Euclidian comp = new Euclidian();
			Feature carTemp;
			double carResult = 0;
			double carTemp2;

			// For this index, we know its at cartesian, thus this index stays true for every example.
			// To get maximum for normalize, we want to compare all distance of training to THIS test example
			for (int v = 0; v < solvedExampleCollection.getExample().size(); v++) {

				carTemp = solvedExampleCollection.getExample().getElementAt(v).getFeatureIndex(p);
				carTemp2 = comp.getDistance(carTemp, chosenTestingFeature);
				if (carResult < carTemp2)
					carResult = carTemp2;
			}
			return comp.getDistance(chosenTrainingFeature, chosenTestingFeature) / carResult;
		}
		// CONDITION FOR COLOR
		if (chosenTrainingFeature.getType().equals("Colour") && chosenTestingFeature.getType().equals("Colour")) {
			AbsoluteDifference comp = new AbsoluteDifference();
			double absTemp2;
			double absResult2 = 0;

			for (int v = 0; v < solvedExampleCollection.getExample().size(); v++) {

				double d = Double.parseDouble(
						solvedExampleCollection.getExample().getElementAt(v).getFeatureIndex(p).GetValue().toString());
				System.out.println(d);
				absTemp2 = d;
				if (absResult2 < absTemp2)
					absResult2 = absTemp2;
			}
			return comp.getDistance(chosenTrainingFeature, chosenTestingFeature) / absResult2;
		}
		// CONDITION FOR DAMAGE PERCENT
		if (chosenTrainingFeature.getType().equals("DamagePercent")
				&& chosenTestingFeature.getType().equals("DamagePercent")) {
			AbsoluteDifference comp = new AbsoluteDifference();
			double absResult3 = 100;

			return comp.getDistance(chosenTrainingFeature, chosenTestingFeature) / absResult3;
		}
		return 0;
	}
}
