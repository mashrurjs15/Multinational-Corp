package main;

import java.io.Serializable;

public class Colour extends Feature{

	public enum COLOURS implements Serializable{
		RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET, UNKNOWN
	}
	
	private String name;
	private int value;
	private COLOURS colour;
	private static final int NULL_VALUE = 9;
	private static String TYPE = "Colour";
	
	public Colour(String s, Metric m) {
		this.name = s;
		this.metric = m;
		this.value= 9;
		colour = null;
	}
	
	public Colour(String s,Metric m, COLOURS v){
		if(v == null) {
			name = s;
			metric = m;
			value = 9;
			colour = null;
		}else {
			name = s;
			value = v.ordinal();
			metric = m;
			colour = v;
		}
		

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
	public Object GetValue() {
		return value;
	}

	@Override
	public void SetValue(Object v) {
		colour = (COLOURS) v;
		value = ((COLOURS) v).ordinal();
		if(value == 8) {
			value = 9;
		}
				
	}

	@Override
	public void SetMetric(Metric m) {
		metric = m;
		
	}

	@Override
	public Metric GetMetric() {
		return metric;
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
	public String getType() {
		return TYPE;
	}

	@Override
	public String toString() {
		if(value != NULL_VALUE) {
			return colour + " ("+name+")";
		}else {
			return name +" (Colour)"+ "(" + metric.getName() + ")";
		}
		
	}

}
