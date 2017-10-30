import java.util.ArrayList;
import java.util.Scanner;

public class CentralUnit {

	private ArrayList<GPU> GPUList;
	
	
	public CentralUnit() {
		GPUList = new ArrayList<GPU>();
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
	
	/** Takes input from the test variables and compares it to the list of GPUS 
	 * adn assigns a price
	 *
	 * @param a is the coreClock speed
	 * @param b is the boostClock speed
	 * @param c is the memory size
	 * @param d is the company
	 * @return the price of the GPU
	 */
	public double determinePrice(double a, double b, int c, String d) {
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
			System.out.println(bench);
			//if the current bench is lower than the saved one or the first bench
			//then set the new lowest to be the current bench. And save that GPU
			if(bench < lowest) {
				lowest = bench;
				lowestGPU = g;
			}
		}
		//return the price of the chosen GPU
		return lowestGPU.getPrice();
		
		
	}
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
		
		//create scanner to use instead of GUI currently
		Scanner sc = new Scanner(System.in);
		
		//ask user for the test case variables
		//these should be consistent with 
		System.out.println("Enter the Core Clock speed of the test.\n");
		double newCore = sc.nextDouble();
		System.out.println("You entered: " + newCore);
		System.out.println("Enter the Boost Clock speed of the test.\n");
		double newBoost = sc.nextDouble();
		System.out.println("You entered: " + newBoost);
		System.out.println("Enter the Memory Size of the test.\n");
		int newSize = sc.nextInt();
		System.out.println("You entered: " + newSize);
		System.out.println("Enter the Company of the test.\n");
		String newComp = sc.next();
		System.out.println("You entered: " + newComp);
		
		//the price is subject to the input fomr the library. Depending
		//on the company that made the GPU prices may change eg. MSI/EVGA
		double price = unit.determinePrice(newCore, newBoost, newSize, newComp);
		GPU newGPU = new GPU(newCore,newBoost,newSize,newComp,price);
		
		System.out.println("\n");
		System.out.println(price);
		
		sc.close();
		
	}
}
