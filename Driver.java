import java.util.Arrays;
import java.io.File;

public class Driver {
	public static void main(String [] args) {
		Polynomial p = new Polynomial();
		if ((p.coefficients == null) || (p.exponents == null))
		{
			System.out.println("Bruh this polynomial empty");
		}
		else{
			System.out.println(p.evaluate(3));
		}
		double [] c1 = {5, 6, 4};
		int [] e1 = {3, 0, 2};
		Polynomial p1 = new Polynomial(c1, e1);
		double [] c2 = {-2, -9, 3};
		int [] e2 = {1, 4, 7};
		Polynomial p2 = new Polynomial(c2, e2);
		Polynomial s = p1.add(p2);
		System.out.println(Arrays.toString(s.coefficients));
		System.out.println(Arrays.toString(s.exponents));
		System.out.println("s(0.1) = " + s.evaluate(0.1));
		if(s.hasRoot(1))
		System.out.println("1 is a root of s");
		else
		System.out.println("1 is not a root of s");

		//test multiply
		Polynomial productPolynomial = p1.multiply(p2);
		System.out.println("Here is where we multiply our two polynomials");
		System.out.println(Arrays.toString(productPolynomial.coefficients));
		System.out.println(Arrays.toString(productPolynomial.exponents));

		//test file constructor
		System.out.println("Here is where we print out the polynomial from a file");
		File text = new File("C:\\Users\\mazhi\\OneDrive\\Documents\\GitHub\\b07lab1\\textPolynomial.txt");
		Polynomial polynomial_fromfile = new Polynomial(text);
		System.out.println("Here is the polynomial from the file:");
		System.out.println(Arrays.toString(polynomial_fromfile.coefficients));
		System.out.println(Arrays.toString(polynomial_fromfile.exponents));

		//test file writer
		double[] test_coefficents = new double[] {4, -2, 5};
		int[] test_exponents = new int[] {2, 5, 0};
		Polynomial somePolynomial = new Polynomial(test_coefficents, test_exponents);
		System.out.println("Here is where we save our polynomial to a file");
		somePolynomial.saveToFile("newPolynomial.txt");
	}
}
