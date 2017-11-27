import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * kNNStrategy finds the closest neighbors for the unsolvedFeature listed in the unsolvedEntity
 * kNNStrategy 
 */

public class kNNStrategy {
	
	private int numberOfNeighbors;
	private HashMap<Double, Example> resultList;
	private Example unsolvedEntity;
	private Feature unsolvedFeature;
	private double tally = 0;
	
	public kNNStrategy(int n, HashMap<Double,Example> resultList, Example unsolvedEntity) {
		this.numberOfNeighbors = n;
		this.resultList = resultList;
		this.unsolvedEntity = unsolvedEntity;
	}
	
	public double solveKNN() {

		double temp = 0;
		this.unsolvedFeature = unsolvedEntity.getUnsolvedFeature(); // Finds the empty Feature and store it into unsolvedFeature
		
		List<Double> sortedKeys = new ArrayList<Double>(resultList.size());
		sortedKeys.addAll(resultList.keySet());
		Collections.sort(sortedKeys);
		
		List<Double> kKeys = new ArrayList<Double>();
		
		// get Kth smallest keys
		for (int i = 0; i < numberOfNeighbors; i++) {
			kKeys.add(sortedKeys.get(i));
		}
			
		for (double k : kKeys) {
			tally += resultList.get(k).getFeature(unsolvedFeature.GetName()).GetValue();
		}
		
		return tally/numberOfNeighbors;

	}
	
}
