
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CentralUnit {

	private ArrayList<GPU> GPUList;
	private HashMap<Double,GPU> BenchList;
	
	
	public CentralUnit() {
		GPUList = new ArrayList<GPU>();
		BenchList = new HashMap<Double,GPU>();
	}
	
	/** Adds a GPU to the list
	 * 
	 * @param adds GPU g to the GPUList
	 */
	public void addToList(GPU g) {
		GPUList.add(g);
	}
	
	/** Removes a GPU from the list
	 * 
	 * @param removes GPU g from List
	 */
	public void removeFromList(GPU g) {
		GPUList.remove(g);
	}
	
	public int getListSize() {
		return  GPUList.size();
	}
	
	/** Takes input from the test variables and compares it to the list of GPUS 
	 * adn assigns a price
	 *
	 *Author: Sunny, Adam 
	 * @param a is the coreClock speed
	 * @param b is the boostClock speed
	 * @param c is the memory size
	 * @param d is the company
	 * @return the price of the GPU
	 */
	public double determinePrice(double a, double b, int c, String d, int knn) {
		double bench;
		double lowest = 200;
		
		GPU lowestGPU = null;
		//compare the given test variables to every GPU in the main list
		for(GPU g: GPUList) {
			bench = 0;
			//COre clock speed is the absolute difference
			bench += (Math.abs(g.getCoreClock() - a));
			//Boost clock speed is the absolute difference
			bench += (Math.abs(g.getBoostClock() - b));
			//find the average size of the two and normalize with the highest current rate of 8
			bench += (((g.getMemorySize() + c)/2)/ 8);
			//if it is the same company add nothing if it is not add 1
			if(!g.getCompany().equals(d)) {
				bench += 1;
			}
			BenchList.put(bench, g);
			//System.out.println(bench + " " +  g.getPrice());
		}
		
		
		//Sort Bench values 
		List<Double> sortedKeys = new ArrayList<Double>(BenchList.size());
		sortedKeys.addAll(BenchList.keySet());
		Collections.sort(sortedKeys);
	
		
		// add lowest pricest of knn GPUs
		double runningPriceAverage = 0;
		for(int i = 0; i < knn ; i++) {
			System.out.println(BenchList.get(sortedKeys.get(i)).getPrice());
			runningPriceAverage += BenchList.get(sortedKeys.get(i)).getPrice();
		}
		
		//System.out.println(runningPriceAverage);
		//return the price of the chosen GPU
		return (runningPriceAverage / knn);
		
		
	}
	//Author: Adam: Eric
	public static void main(String [ ] args) {
		CentralUnit unit = new CentralUnit();
		//create class that will hold all the GPU's and compute the price
		//create GPU library with specs and add to the main list
		//this main list contains only the founders collection of the 
		//respective GPUs
		unit.addToList(new GPU(1.506,1.708,6,"Nvidia", 299.99));
		unit.addToList(new GPU(1.607,1.733,8,"Nvidia", 549.99));
		unit.addToList(new GPU(1.607,1.683,8,"Nvidia", 449.00));
		unit.addToList(new GPU(1.257,1.340,8,"AMD", 329.99));
		unit.addToList(new GPU(1.156,1.471,8,"AMD", 654.99));
		unit.addToList(new GPU(1.247,1.546,8,"AMD", 779.99));
		
		//createGUI
		GUI gui = new GUI(unit);
		
		
		
	}
}
