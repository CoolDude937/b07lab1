
public interface DeliverableItem {
	public double getLength();

	public double getHeight();

	public double getWidth();

	public int hashCode();

	public String toString();

	public boolean equals(Object obj);

	public String determineBoxSize();
}
