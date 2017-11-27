import javax.swing.DefaultListModel;

public class Entity {
	private String s;
	private DefaultListModel<Feature> features;
	
	public Entity(String t) {
		s = t;
	}
	
	public String getString() {
		return s;
	}

	@Override
	public String toString() {
		return s;
	}

	public DefaultListModel<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(DefaultListModel<Feature> features) {
		this.features = features;
	}
	
	

}
