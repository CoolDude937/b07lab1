import java.util.HashSet;

public class Library implements Store{
	
	HashSet<Book> books;
	
	public Library() {
		books = new HashSet<Book>();
	}
	
	public void addItem(DeliverableItem item) {
		if (item instanceof Book) {
			books.add((Book)item);
		}
		else {
			throw new RuntimeException("Only add books to this library.");
		}
	}
	
	public void removeItem(DeliverableItem item) {
		books.remove(item);
	}
	
	public boolean itemExists(DeliverableItem item) {
		return books.contains(item);
	}

}
