public abstract class AbstractItem {
	String identifier;
	String label;
	double length;
	double width;
	double height;
	
	public AbstractItem(String identifier, String label, double length, double width, double height) {
		this.identifier = identifier;
		this.label = label;
		this.length = length;
		this.width = width;
		this.height = height;
	}

	public double getLength() {
		return length;
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return label;
	}
}
