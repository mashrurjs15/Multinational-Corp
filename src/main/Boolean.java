package main;

public class Boolean extends Feature {

	private String name, value;
	
	private static final String TYPE = "Boolean";
	
	public Boolean(String s, Metric m) {
		this.name = s;
		this.metric = m;
		this.value = null;
	}
	
	public Boolean(String s,Metric m, String v) {
		name = s;
		value = v;
		metric = m;
	}

	public void SetMetric(Metric m) {
		metric = m;
	}
	public Metric GetMetric() {
		return metric;
	}
	
	public String GetName() {
		return name;
	}
	
	public void SetName(String s) {
		name = s;
	}

	public String GetValue() {
		return value;
	}

	public void SetValue(Object v) {
		value = (String)v;
		
	}

	public void Strategy() {
		// TODO Auto-generated method stub
		
	}

	public boolean CompareTo() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public String toString() {
		if(value == null) {
			return name + " (Boolean)" + "("+metric.getName()+")";
		}else {
			return value + " ("+name+")";
		}

	}
	
	public String getType() {
		return TYPE;
	}

	
	
	
}
