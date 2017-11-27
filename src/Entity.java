import javax.swing.DefaultListModel;
import java.util.List;

public class Entity {

	List<Feature> listOfFeature;
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
