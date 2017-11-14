/**
 * 
 * @author Andrew
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;

public class SimpleMachine {
	private ArrayList<HouseInfo> HouseList;
	private HashMap<Double, HouseInfo> PriceList;

	public SimpleMachine() {
		HouseList = new ArrayList<HouseInfo>();
		PriceList = new HashMap<Double, HouseInfo>();
	}

	/** Adds a house to the list
	 * 
	 * @param adds another house to the HouseList list
	 */
	public void addToList(HouseInfo h) {
		HouseList.add(h);
	}

	/** Removes a house from the list
	 * 
	 * @param removes a house from the List
	 */
	public void removeFromList(HouseInfo h) {
		HouseList.remove(h);
	}
	
	/** Gives us the size of the House
	 * 
	 * @return list of all the houses
	 */
	public int getListSize() {
		return  HouseList.size();
	}
	
	/** Takes input from the test variables and compares it to the list of Houses and assigns a price
	 * 
	 * @param x is the x-coordinate
	 * @param y is the y-coordinate
	 * @param s is the square feet of the house
	 * @param a is the age of the house
	 * @param knn is the k nearest neighbor
	 * @return the price of the house
	 */
	public double determinePrice(double x, double y, int s, String a, int knn) {
		double finalRating;
		double temp;
		
		for(HouseInfo h: HouseList) {
			
			finalRating = 0; 								// Testing result set to zero
			
			finalRating += (Math.abs(h.getSqft() - s)); 	// Test result with sq foot feature
			
			temp = Math.pow((h.getCoordinateX() - x),2); 	// Calculating Euclidean distance between the two points, check for coordinate X.
			temp += Math.pow((h.getCoordinateY() - y),2);	// Calculating Euclidean distance between the two points, check for coordinate Y.
			
			Math.sqrt(temp);
			Math.abs(temp);
			finalRating += temp;							// Test result with coordinate feature
			
			if(!h.getAge().equals(a)) {						// Test result with the age using discrete value
				finalRating += 1;
			}

			PriceList.put(finalRating, h);

		}
		
		// Sort Price Values
		List<Double> sortedKeys = new ArrayList<Double>(PriceList.size());
		sortedKeys.addAll(PriceList.keySet());
		Collections.sort(sortedKeys);
		
		// add lowest price of knn Houses
		double runningPriceAverage = 0;
		for(int i = 0; i < knn ; i++) {
			System.out.println(PriceList.get(sortedKeys.get(i)).getPrice());
			runningPriceAverage += PriceList.get(sortedKeys.get(i)).getPrice();
		}
		
		return (runningPriceAverage / knn);
	}
	
	public static void main(String [ ] args) {
		SimpleMachine unit = new SimpleMachine();
		//create class that will hold all the houses and compute the price
		//create House library with specs and add to the main list
		//this main list contains only the founders collection of the
		//respective GPUs
		
		unit.addToList(new HouseInfo(12, 25, 1200, "new", 500000, 1000));
		unit.addToList(new HouseInfo(10, 50, 1000, "old", 300000, 600));
		unit.addToList(new HouseInfo(30, 100, 800, "new", 400000, 670));
		unit.addToList(new HouseInfo(64, 70, 500, "new", 280000, 400));
		unit.addToList(new HouseInfo(15, 30, 1000, "new", 350000, 700));
		unit.addToList(new HouseInfo(100, 40, 1300, "old", 540000, 1100));
		unit.addToList(new HouseInfo(90, 70, 600, "old", 320000, 500));
		
		// create GUI
		GUI gui = new GUI(unit);
	}
}
