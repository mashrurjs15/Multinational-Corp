package main;

import java.io.Serializable;

/**
 * The feature abstract class contains all functions required by Features.
 * 
 */

public abstract class Feature implements Serializable {

	// the metric of the feature.
	public Metric metric;

	// null_flag used to distiguish unknown testing features.
	public boolean null_flag;

	public abstract String GetName();

	public abstract void SetName(String s);

	public abstract Object GetValue();

	public abstract void SetValue(Object v);

	public abstract void SetMetric(Metric m);

	public abstract Metric GetMetric();

	public abstract boolean isEmpty();

	public abstract String getType();

	public abstract String toString();

}
