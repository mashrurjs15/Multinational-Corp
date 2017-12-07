package main;
import java.util.ArrayList;

public class Cartesian implements Feature {
	
	private String name;
	private ArrayList<Double> values;
	private static final String TYPE = "Cartesian";
	private Metric metric;
	public Cartesian(String s) {
		name = s;

	}
	public Cartesian(String s,Metric m, ArrayList<Double> value) {
		name = s;
		this.values = value;
		this.metric = m;
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
			return name + " ("+TYPE+")"+ "("+metric.getName()+")";
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
