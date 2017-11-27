
public class Boolean implements Feature {

	private String name;
	private static final String TYPE = "Boolean";
	
	public Boolean(String s) {
		name = s;
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
		return name + " (Boolean)";
	}
	
	public String getType() {
		return TYPE;
	}
	
}
