
public interface Store {
	public void addItem(DeliverableItem item);
	
	void removeItem(DeliverableItem item);
	
	public boolean itemExists(DeliverableItem item);
}
