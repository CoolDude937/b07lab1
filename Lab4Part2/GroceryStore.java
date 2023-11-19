import java.util.HashSet;

public class GroceryStore implements Store{
	
	HashSet<GroceryItem> items;
	
	public GroceryStore() {
		items = new HashSet<GroceryItem>();
	}
	
	public void addItem(DeliverableItem item) {
		if (item instanceof GroceryItem) {
			items.add((GroceryItem)item);
		}
		else {
			throw new RuntimeException("Only add grocery items to this grocery store.");
		}
	}
	
	public void removeItem(DeliverableItem item) {
		items.remove(item);
	}
	
	public boolean itemExists(DeliverableItem item) {
		return items.contains(item);
	}
}
