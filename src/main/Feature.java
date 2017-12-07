package main;

import java.io.Serializable;

public abstract class Feature implements Serializable {	
	
	public Metric metric;
	
	public abstract String GetName();
	
	public abstract void SetName(String s);
	
	public abstract Object GetValue();
	
	public abstract void SetValue(Object v);
	
	public abstract void SetMetric(Metric m);
	
	public abstract Metric GetMetric();
	
	public abstract void Strategy();
	
	public abstract boolean CompareTo();
	
	public abstract boolean isEmpty();
	
	public abstract String getType();
	
	public abstract String toString();
	
}
