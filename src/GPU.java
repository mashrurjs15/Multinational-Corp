
public class GPU {
	private double coreClock;
	private double boostClock;
	private int memorySize;
	private String company;
	private double price;
	
	/** Set of specifications for Graphics Card
	 * 
	 * @param a is the core clock of the GPU
	 * @param b is the boost clock of the GPU
	 * @param c is the memory process of the GPU
	 * @param d is the Company name for the GPU
	 * @param e is the price of the GPU
	 */	
	public GPU(double a, double b, int c, String d, double e) {
		coreClock = a;
		boostClock = b;
		memorySize = c;
		company = d;
		price = e;
		
	}
	
	/** Returns the core clock of the GPU which can be used for the calculation.
	 *  This is one of the 5 features used to determine the price of the test.
	 * 
	 * @return core clock of the GPU
	 */
	public double getCoreClock() {
		return coreClock;
	}
	
	/** Set the core clock with the given double
	 * 
	 * @param coreClock - set the core clock with the chosen parameter
	 */
	public void setCoreClock(double coreClock) {
		this.coreClock = coreClock;
	}
	
	/** Returns the price of the GPU which can be used for the calculation.
	 *  This is one of the 5 features used to determine the price of the test.
	 * 
	 * @return the price of the GPU
	 */
	public double getPrice() {
		return price;
	}
	
	/** Set the price with the given double
	 * 
	 * @param price - set the price with the chosen parameter
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/** Return the boosted clock of the GPU which can be used for the calculation.
	 *  This is one of the 5 features used to determine the price of the test.
	 * 
	 * @return the boost clock of the GPU
	 */
	public double getBoostClock() {
		return boostClock;
	}
	/** Set the boost clock with the given double
	 * 
	 * @param boostClock - set the boost clock with the chosen parameter
	 */
	public void setBoostClock(double boostClock) {
		this.boostClock = boostClock;
	}
	
	/** Return the memory size of the GPU which can be used for the calculation.
	 *  This is one of the 5 features used to determine the price of the test.
	 * 
	 * @return the memory of the GPU
	 */
	public int getMemorySize() {
		return memorySize;
	}

	/** Set the memory size with the given integer
	 * 
	 * @param memorySize - set the memory size with the chosen parameter
	 */
	public void setMemorySize(int memorySize) {
		this.memorySize = memorySize;
	}

	/** Return the company name of the GPU which can be used for the calculation.
	 *  This is one of the 5 features used to determine the price of the test.
	 * 
	 * @return the company name of the GPU
	 */
	public String getCompany() {
		return company;
	}

	/** Set the Company name with the given String
	 * 
	 * @param company - set the company name with the chosen parameter
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
}
