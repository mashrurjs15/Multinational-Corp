package main;

public class DamagePercent extends Feature {

	private String name;
	private int value;
	private static final int NULL_VALUE = -1;
	private static final String TYPE = "DamagePercent";

	public DamagePercent(String s, Metric m) {
		name = s;
		value = 0;
		metric = m;
	}

	public DamagePercent(String s, Metric m, int v) {
		if (v == NULL_VALUE)
			null_flag = true;
		else
			null_flag = false;
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
		if ((Integer) v == NULL_VALUE)
			null_flag = true;
		else
			null_flag = false;
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
	public boolean isEmpty() {

		return null_flag;
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public String toString() {
		if (value != 0) {
			return value + "% (" + name + ")";
		} else {
			return name + " (Damage%)" + "(" + metric.getName() + ")";
		}
	}

}
