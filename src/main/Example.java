package main;
 import javax.swing.DefaultListModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Example implements Serializable {
	private DefaultListModel<Feature> features;
	
	public Example() {
		features = new DefaultListModel<Feature>();
	}
	public Example(String s, String t) {
		features = new DefaultListModel<Feature>();
	}

	public DefaultListModel<Feature> getFeatures() {
		return features;
	}
	
	public void addFeature(String type, String s, Metric m, Double d1, ArrayList<Double> d2, String v, int cartNum) {
		if(type == "Cartesian") {
			features.addElement(new Cartesian(s,m,d2,cartNum));
		}else if(type == "Boolean") {
			features.addElement(new Boolean(s,m,v));
		}else {
			features.addElement(new Number(s,m,d1));
		}
	}

	public void setFeatures(DefaultListModel<Feature> features) {
		this.features = features;
	}
	
	public Feature getUnsolvedFeature() {
		
		for(int i = 0; i < features.size(); i++) {
			if(features.get(i).isEmpty()) return features.get(i);
		}
		return null;
	}
	
	public Feature getFeature(String s) {
		
		for(int i = 0; i < features.size(); i++) {
			if(s.equals(features.getElementAt(i).GetName())) return features.get(i);
		}
		return null;
	}
	
	public Feature getFeatureIndex(int i) {
		if(i<features.getSize()) {
			return features.get(i);
		}
		return null;
	}
	
	public DefaultListModel<Feature> getFeatureList(){
		return features;
	}
	
	@Override
	public String toString() {
		String ret = "";
		for(int i =0; i < features.size();i++) {
			ret +="\t"+ features.getElementAt(i).toString() + "//";
		}
		return ret;
	}
}
