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
	/**
	 * Creates new Cartesian feature and adds it to the list of features in example.
	 * 
	 * @param s Name of Feature
	 * @param m Metric of feature
	 * @param d2 list of Numbers or elements in the cartesian feature
	 * @param num size of list
	 */
	public void addFeature(String s, Metric m, ArrayList<Number> d2, int num) {
		features.addElement(new Cartesian(s,m,d2,num));
	}
	
	/**
	 * Creates new Boolean feature and adds it to the list of features in example.
	 * 
	 * @param s Name of Feature
	 * @param m Metric of feature
	 * @param v String representaion of the boolean value
	 */
	public void addFeature(String s, Metric m,  String v) {
		features.addElement(new Boolean(s,m,v));
	}
	
	/**
	 * Creates new Number feature and adds it to the list of features in example.
	 * 
	 * @param s Name of Feature
	 * @param m Metric of feature
	 * @param d1 value of the number held in the Number
	 */
	public void addFeature(String s, Metric m,  Double d1) {
		features.addElement(new Number(s,m,d1));
	}
	
	/**
	 * Creates new Colour feature and adds it to the list of features in example.
	 * 
	 * @param s Name of Feature
	 * @param m Metric of feature
	 * @param c Colour ENUM to be added as a feature
	 */
	public void addFeature(String s, Metric m,  Colour.COLOURS c) {
		features.addElement(new Colour(s,m,c));
	}
	
	/**
	 * Creates new DamagePercent feature and adds it to the list of features in example.
	 * 
	 * @param s Name of Feature
	 * @param m Metric of feature
	 * @param num int value representing the percentage
	 */
	public void addFeature(String s, Metric m,  int num) {
		features.addElement(new DamagePercent(s,m,num));
	}
	
	/**
	 * This creates a feature with no value  used only for the generic list of features that appear at the top of the GUI
	 * 
	 * @param t type of feature
	 * @param s Name of feature
	 * @param m	metric of feature
	 * @param i length of string if necessary
	 */
	public void addGenericFeature(String t,String s, Metric m, int i){
		//I tried generics so hard.... they are the worst
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
