package main;
import java.util.ArrayList;

public class Cartesian extends Feature {
	
	private String name;
	private ArrayList<Number> values;
	private static final String TYPE = "Cartesian";
	private int number;
	public Cartesian(String s) {
		name = s;

	}
	public Cartesian(String s, Metric m, int i) {
		this.name = s;
		this.metric = m;
		this.number = i;
		this.values = null;
	}
	public Cartesian(String s,Metric m, ArrayList<Number> value, int num) {
		name = s;
		this.values = value;
		this.metric = m;
		this.number = num;
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
	
	public ArrayList<Number> GetValue() {
		// TODO Auto-generated method stub
		return values;
	}
	

	public void SetValue(Object v) {
		values = (ArrayList<Number>)v; 
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
			String s = "<";
			for(Number d : values ) {
				s = s  + d.toString()+ ", ";
			}
			s = s.substring(0, s.length()-2);
			s = s + "> ("+name+")";
			return s;
		}
		
		
		
	}
	public String getType() {
		return TYPE;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
}
