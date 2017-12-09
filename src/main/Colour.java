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
		if(v == null|| v.ordinal() == 7) {
			name = s;
			metric = m;
			value = 9;
			colour = null;
			null_flag = true;
		}else {
			name = s;
			value = v.ordinal();
			metric = m;
			colour = v;
			null_flag = false;
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
		null_flag = false;
		value = ((COLOURS) v).ordinal();
		if(value == 7) {
			value = 9;
			null_flag = true;
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
		return null_flag;
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
