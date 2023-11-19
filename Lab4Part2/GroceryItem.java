public class GroceryItem extends AbstractItem implements DeliverableItem{
	
	public GroceryItem(String id, String name, double length, double width, double height) {
		super(id, name, length, width, height);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof GroceryItem))
			return false;
		GroceryItem other = (GroceryItem) obj;
		if (this.identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!this.identifier.equals(other.identifier))
			return false;
		return true;
	}
	
	public String determineBoxSize() {
		double length = this.getLength();
		double width = this.getWidth();
		double height = this.getHeight();
		double max = length;
		if(max < width)
			max = width;
		if(max < height)
			max = height;
		if(max < 10)
			return "small";
		else if(max < 20)
			return "medium";
		else if(max < 30)
			return "large";
		else
			return "x-large";
	}
}
