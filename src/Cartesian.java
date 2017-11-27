
public class Cartesian implements Feature {
	
	private String name;
	private Double x, y;
	private static final String TYPE = "Cartesian";
	public Cartesian(String s) {
		name = s;

	}
	public Cartesian(String s,Double d1, Double d2) {
		name = s;
		x = d1;
		y = d2;
	}
	@Override
	public String GetName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void Strategy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean CompareTo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double GetValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString() {
		if(x != null) {
			return "("+x+"," + y+ ") ("+name+")";
		}else {
			return name +" (Cartesian)";
		}
		
	}
	public String getType() {
		return TYPE;
	}
}
