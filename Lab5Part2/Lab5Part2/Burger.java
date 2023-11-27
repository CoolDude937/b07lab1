import java.util.Scanner;

public class Burger implements ConsumerItem{
	String type;
	
	@Override
	public void customize() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the burger type: ");
		type = scan.next();
		scan.close();
	}

	@Override
	public void prepare() {
		System.out.println("Preparing " + type + " burger");
	}

	@Override
	public void box() {
		System.out.println("Boxing " + type + " burger");
	}
}
