/**
 * 
 * @author Andrew, Sunny
 *
 */
public class HouseInfo {
	private int[] coordinates;
	private int sqft;
	private String age;
	private double price;
	private int rooms;
	
	/** Set of specifications for House
	 * 
	 * @param x is the x-coordinate
	 * @param y is the y-coordinate
	 * @param s is the square feet
	 * @param a is the age of the house
	 * @param p is the price of the house
	 * @param r is the square feet of the overall rooms
	 */
	public HouseInfo(int x, int y, int s, String a, double p, int r) {
		coordinates = new int[2];
		setCoordinate(x,y);
		setSqft(s);
		setAge(a);
		setPrice(p);
		setRooms(r);
	}
	
	/** Gives us the x-coordinate of the room
	 * 
	 * @return coordinate X
	 */
	public int getCoordinateX() {
		return coordinates[0];
	}
	
	/** Gives us the y-coordinate of the room
	 * 
	 * @return coordinate Y
	 */
	public int getCoordinateY() {
		return coordinates[1];
	}

	/** Set the coordinate of the house
	 * 
	 * @param x is the X-coordinate
	 * @param y is the Y-coordinate
	 */
	public void setCoordinate(int x, int y) {
		this.coordinates[0] = x;
		this.coordinates[1] = y;
		
	}
	
	/**  Gives us the square feet of the house
	 * 
	 * @return square feet of house
	 */
	public int getSqft() {
		return sqft;
	}
	
	/** Set the square feet of the house
	 * 
	 * @param sqft square feet of house
	 */
	public void setSqft(int sqft) {
		this.sqft = sqft;
	}
	
	/** Returns the age of the house
	 * 
	 * @return Age
	 */
	public String getAge() {
		return age;
	}

	/** Sets the age of the house
	 * 
	 * @param Age
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/** Gives us the price of the house
	 * 
	 * @return Price
	 */
	public double getPrice() {
		return price;
	}
	
	/** Sets the price of the house
	 * 
	 * @param price of house
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/** Gives us the number of rooms in the house
	 * 
	 * @return Rooms
	 */
	public int getRooms() {
		return rooms;
	}
	
	/** Sets the number of rooms in the house
	 * 
	 * @param rooms
	 */
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	
}
