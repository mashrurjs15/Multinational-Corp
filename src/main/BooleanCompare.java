package main;

import java.io.Serializable;

public class BooleanCompare implements Metric, Serializable {

	@Override
	public double getDistance(Feature f, Feature f2) {
		
		// compare names if they are equal return 0, else return 1
		
		if (f.GetValue().equals(f2.GetValue()))return 0;
		return 1;
	}
	
	public String getName() {
		return "BooleanCompare";
	}

	

}
