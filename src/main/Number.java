package main;

public class Number implements Feature{
	private String name;
	private Double value;
	private Metric metric;
	private static final String TYPE = "Number";
	

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

	@Override
	public String GetName() {
		return name;
	}
	
	@Override
	public void SetName(String s) {
		name = s;
	}

	@Override
	public Double GetValue() {
		return value;
	}

	@Override
	public void SetValue(Object v) {
		value = (Double)v;
	}


	@Override 
	public void Strategy() {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public boolean CompareTo() {
		// TODO Auto-generated method  stub
		return false;
	}

	@Override
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
