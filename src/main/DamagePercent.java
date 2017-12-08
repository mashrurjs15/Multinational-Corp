package main;

public class DamagePercent extends Feature{

	private String name;
	private int value;
	private static final int NULL_VALUE = 101;
	private static final String TYPE = "DamagePercent";
	
	public DamagePercent(String s,Metric m, int v) {
		name = s;
		value = v;
		metric = m;
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
		value = (Integer) v;
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
		if(value != 0) {
			return value + "% ("+name+")";
		}else {
			return name +" (Damage%)"+ "(" + metric.getName() + ")";
		}
	}

}
