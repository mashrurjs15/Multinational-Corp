
public class Boolean implements Feature {

	private String name, value;
	
	private static final String TYPE = "Boolean";
	
	public Boolean(String s, String v) {
		name = s;
		value = v;
	}

	@Override
	public String GetName() {
		return name;
	}
	
	@Override
	public void SetName(String s) {
		name = s;
	}

	@Override
	public String GetValue() {
		return value;
	}

	@Override
	public void SetValue(Object v) {
		value = (String)v;
		
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
		if(value == null) {
			return name + " (Boolean)";
		}else {
			return value + " ("+name+")";
		}

	}
	
	public String getType() {
		return TYPE;
	}

	
	
	
}
