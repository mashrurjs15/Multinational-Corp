package main;
import javax.swing.DefaultListModel;

public class ExampleCollection {

	private DefaultListModel<Example> example;
	
	public ExampleCollection() {
		example = new DefaultListModel<Example>();
	}
	
	public void addExample(Example e) {
		example.addElement(e);
	}
	
	public void removeExample(Example x) {
		example.removeElement(x);
	}

	public DefaultListModel<Example> getExample() {
		return example;
	}

	public void setExample(DefaultListModel<Example> example) {
		this.example = example;
	}
	
	
}
