package main;
import java.util.ArrayList;

public class Cartesian extends Feature {
	
	private String name;
	private ArrayList<Double> values;
	private static final String TYPE = "Cartesian";
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
	

	public String GetName() {
		return name;
	}
	

	public void SetName(String s) {
		name = s;
	}
	
	public ArrayList<Double> GetValue() {
		// TODO Auto-generated method stub
		return values;
	}
	

	public void SetValue(Object v) {
		values = (ArrayList<Double>)v; 
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
