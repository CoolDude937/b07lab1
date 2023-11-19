public class Book extends AbstractItem implements DeliverableItem{
	
	public Book(String isbn, String title, double length, double width, double height) {
		super(isbn, title, length, width, height);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Book))
			return false;
		Book other = (Book) obj;
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
		if(max < 5)
			return "small";
		else if(max < 15)
			return "medium";
		else
			return "large";
	}
}
