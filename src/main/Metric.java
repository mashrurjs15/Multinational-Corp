package main;

import java.io.Serializable;

public interface Metric {

	public double getDistance(Feature f, Feature f2);

	public String getName();
}
