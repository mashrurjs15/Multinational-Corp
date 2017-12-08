package main;

public class Number extends Feature{
	private String name;
	private Double value;
	private static final String TYPE = "Number";
	
	public Number(String s, Metric m) {

		name = s;
		value = null;
		metric = m;
	}

	public Number(String s, Metric m, Double d) {

		name = s;
		value = d;
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

	public Double GetValue() {
		return value;
	}

	public void SetValue(Object v) {
		value = (Double)v;
	}


	public void Strategy() {
		// TODO Auto-generated method stub
		
	}
 
	public boolean CompareTo() {
		// TODO Auto-generated method  stub
		return false;
	}

	public boolean isEmpty() {
		// TODO Auto-generated  method stub
		return false;
	}

	
	public String toString() {
		if(value != null) {
			return value + " ("+name+")";
		}else {
			return name +" (Number)"+ "(" + metric.getName() + ")";
		}
		
	}
	
	public String getType() {
		return TYPE;
	}

	
	
}
