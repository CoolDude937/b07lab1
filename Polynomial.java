import java.util.Arrays;

public class Polynomial {
	double[] coefficients;
	int[] exponents;

	public Polynomial() {
		coefficients = new double[] {0};
		exponents = new int[] {0};
	}

	public Polynomial(double[] inputCoefficients, int[] inputExponents) {
		coefficients = inputCoefficients.clone();
		exponents = inputExponents.clone();
	}
	
	public Polynomial add(Polynomial another_polynomial) {
		int length1 = coefficients.length;
		int length2 = another_polynomial.coefficients.length;
		
		//take the minimum of the 2 lengths cuz we only need the shorter one to run 
		//the for loop
		int shorter_length = Math.min(length1, length2);
		
		Polynomial sum_polynomial = new Polynomial();

		if (length1 == shorter_length)
		{
			sum_polynomial = new Polynomial(another_polynomial.coefficients, another_polynomial.exponents);
		}
		else
		{
			sum_polynomial = new Polynomial(coefficients, exponents);
		}
		
		for (int i = 0; i < shorter_length; i++){
			sum_polynomial.coefficients[i] = coefficients[i] + another_polynomial.coefficients[i];
		}
		
		return sum_polynomial;
	}
	
	public double evaluate(double x_value) {
        double solution = 0;
		for (int i = 0; i < coefficients.length; i++) {
			solution += coefficients[i]*(Math.pow(x_value, exponents[i]));
		}
        return solution;
	}

    public boolean hasRoot(double potential_root) {
        if (evaluate(potential_root) == 0) {
            return true;
        }
        return false;
    }

	public Polynomial multiply(Polynomial inputPolynomial) {
		int length1 = coefficients.length;
		int length2 = inputPolynomial.coefficients.length;
		
		//calculate total length of the product polynomial, which is length1 + length2 - 1 (I think, did some test cases)
		int product_length = length1 + length2 - 1;
		
		//declare empty arrays to use for the product polynomial
		double[] product_coefficients = new double[product_length];
		int[] product_exponents = new int[product_length];
		
		Polynomial product_Polynomial = new Polynomial(product_coefficients, product_exponents);
		
		//nested for loop to multiply polynomials, the length does not matter this time cuz we are multiplying
		for (int i = 0; i < length1; i++){
			for (int j = 0; j < length2; j++) {
				product_coefficients[i + j] += coefficients[i]*inputPolynomial.coefficients[j];
				product_exponents[i + j] = exponents[i] + inputPolynomial.exponents[j];
			}
		}

		return product_Polynomial;
	}
}
