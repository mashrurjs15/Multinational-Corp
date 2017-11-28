
public interface Feature {	
	
	public String GetName();
	
	public void SetName(String s);
	
	public Object GetValue();
	
	public void SetValue(Object v);
	public void SetMetric(Metric m);
	public Metric GetMetric();
	
	public void Strategy();
	
	public boolean CompareTo();
	
	public boolean isEmpty();
	
	public String getType();
	
	public String toString();
}
