public class EBook extends AbstractItem{
	
	public EBook(String isbn, String title) {
		super(isbn, title, 0, 0, 0);
	}

	@Override
	public double getLength() {
		throw new RuntimeException();
	}

	@Override
	public double getHeight() {
		throw new RuntimeException();
	}

	@Override
	public double getWidth() {
		throw new RuntimeException();
	}
}
