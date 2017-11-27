import java.util.ArrayList;

public class Cartesian implements Feature {
	
	private String name;
	private ArrayList<Double> values;
	private static final String TYPE = "Cartesian";
	public Cartesian(String s) {
		name = s;

	}
	public Cartesian(String s,ArrayList<Double> value) {
		name = s;
		this.values = value;
	}
	
	@Override
	public String GetName() {
		return name;
	}
	
	@Override
	public void SetName(String s) {
		name = s;
	}
	
	public ArrayList<Double> GetValue() {
		// TODO Auto-generated method stub
		return values;
	}
	
	@Override
	public void SetValue(Object v) {
		values = (ArrayList<Double>)v; 
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

	
	
	public String toString() {
		if(values == null) {
			return name + " ("+TYPE+")";
		}else {
			String s = "< ";
			for(Double d : values ) {
				s = s + ", " + d.toString();
			}s = s + "> ("+name+")";
			return s;
		}
		
		
		
	}
	public String getType() {
		return TYPE;
	}
	
	
	
}
