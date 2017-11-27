import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * kNNStrategy finds the closest neighbors for the unsolvedFeature listed in the unsolvedEntity
 * kNNStrategy 
 */

public class kNNStrategy {

	// Initialize the number of neighbors, Hashmap, Example
	private int numberOfNeighbors;
	private HashMap<Double, Example> resultList;
	private Example unsolvedEntity;
	private Feature unsolvedFeature;
	private double tally = 0;
	
	/* After constructor is called:
	 * n is the number of neighbors unsolved is comparing to
	 * Hashmap(key: the result between the training example and unsolved, value: list of features of the key training example)
	 * unsolvedEntity is the chosen entity to solve using solveKNN()
	 */ 
	public kNNStrategy(int n, HashMap<Double,Example> resultList, Example unsolvedEntity) {
		this.numberOfNeighbors = n;
		this.resultList = resultList;
		this.unsolvedEntity = unsolvedEntity;
	}
	
	/* This method is the kNN Solver
	 * There will be some slight confusion of how this works.
	 * In steps: 1. unsolvedFeature will find the empty Feature of an Entity.
	 * 			 2. sortedKeys is created locally to store an array of keys in resultList from least to greatest
	 * 			 3. kKey is created and store the number of keys of the resultList specified in numberOfNeighbors
	 * 			 4. k then loops through kKeys and find the value of the unsolvedFeature in the training Entity and sums together
	 * 			 5. @return gives the average of the unsolved Feature
	 */
	public double solveKNN() {

		double temp = 0;
		this.unsolvedFeature = unsolvedEntity.getUnsolvedFeature(); 						// Step 1: Finds the empty Feature and store it into unsolvedFeature
		
		List<Double> sortedKeys = new ArrayList<Double>(resultList.size()); 				// Step 2: Sorting keys from least to greatest in a temp List
		sortedKeys.addAll(resultList.keySet());
		Collections.sort(sortedKeys);
		
		List<Double> kKeys = new ArrayList<Double>();
		
		// get Kth smallest keys
		for (int i = 0; i < numberOfNeighbors; i++) {										// Step 3: Add neighbors(n number) to new list
			kKeys.add(sortedKeys.get(i));
		}
			
		for (double k : kKeys) {															// Step 4: Sum of the training examples unsolved Value
			tally += resultList.get(k).getFeature(unsolvedFeature.GetName()).GetValue();
		}
		
		return tally/numberOfNeighbors;														// Step5: output new solved unsolvedValue in unsolvedFeature

	}
	
}
