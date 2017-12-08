package main;
 import javax.swing.DefaultListModel;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
	
	public void addFeature(String s, Metric m, ArrayList<Number> d2, int num) {
		features.addElement(new Cartesian(s,m,d2,num));
	}
	
	public void addFeature(String s, Metric m,  String v) {
		features.addElement(new Boolean(s,m,v));
	}
	
	public void addFeature(String s, Metric m,  Double d1) {
		features.addElement(new Number(s,m,d1));
	}
	
	public void addFeature(String s, Metric m,  Colour.COLOURS c) {
		features.addElement(new Colour(s,m,c));
	}
	
	public void addFeature(String s, Metric m,  int num) {
		features.addElement(new DamagePercent(s,m,num));
	}
	
	public void addGenericFeature(String t,String s, Metric m, int i){
		switch(t) {
		case "Cartesian":
			features.addElement(new Cartesian(s,m,i));
			break;
		case "Number":
			features.addElement(new Number(s,m));
			break;
		case "Boolean":
			features.addElement(new Boolean(s,m));
			break;
		case "Colour":
			features.addElement(new Colour(s,m));
			break;
		case "DamagePercent":
			features.addElement(new DamagePercent(s,m));
			break;
		}
	}

	public void setFeatures(DefaultListModel<Feature> features) {
		this.features = features;
	}
	
	public Feature getUnsolvedFeature() {		
		for(int i = 0; i < features.size(); i++) {
			if(features.get(i).isEmpty()) return features.get(i);
		}
		return null; // there is no empty features Thus this testing example should've been in the training list or was made incorrectly
	}
	
	public Feature getFeature(String s) {		
		for(int i = 0; i < features.size(); i++) {
			if(s.equals(features.getElementAt(i).GetName())) return features.get(i);
		}
		return null;
	}
	
	public Feature getFeatureIndex(int i) {		
		if(i < features.getSize()) {
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
