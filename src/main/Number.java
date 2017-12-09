package main;

public class Number extends Feature {

	private String name;
	private Double value;
	private static final String TYPE = "Number";

	public Number(String s, Metric m) {

		name = s;
		value = null;
		metric = m;
	}

	public Number(String s, Metric m, Double d) {

		if (d == null)
			null_flag = true;
		else
			null_flag = false;
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
		if (v == null)
			null_flag = true;
		else
			null_flag = false;
		value = (Double) v;
	}

	public boolean isEmpty() {
		return null_flag;
	}

	public String toString() {
		if (value != null) {
			return value + " (" + name + ")";
		} else {
			return name + " (Number)" + "(" + metric.getName() + ")";
		}

	}

	public String getType() {
		return TYPE;
	}

}
