import java.util.List;

public class Entity {

	List<Feature> listOfFeature;
	
	public Feature getUnsolvedFeature() {
		
		for(Feature f: listOfFeature) {
			if(f.isEmpty()) return f;
		}
		return null;
	}
	
	public Feature getFeature(String s) {
		
		for (Feature f : listOfFeature) {
			if(s.equals(f.GetName())) {
				return f;
			}
		}return null;
	}
}
