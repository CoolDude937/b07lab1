import java.util.Arrays;

public class Polynomial {
	double[] coefficients;

	public Polynomial() {
		coefficients = new double[] {0};
	}

	public Polynomial(double[] inputPolynomial) {
		coefficients = inputPolynomial.clone();
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
			sum_polynomial = new Polynomial(another_polynomial.coefficients);
		}
		else
		{
			sum_polynomial = new Polynomial(coefficients);
		}
		
		for (int i = 0; i < shorter_length; i++){
			sum_polynomial.coefficients[i] = coefficients[i] + another_polynomial.coefficients[i];
		}
		
		return sum_polynomial;
	}
	
	public double evaluate(double x_value) {
        double solution = 0;
		for (int i = 0; i < coefficients.length; i++) {
			solution += coefficients[i]*(Math.pow(x_value, i));
		}
        return solution;
	}

    public boolean hasRoot(double potential_root) {
        if (evaluate(potential_root) == 0) {
            return true;
        }
        return false;
    }
}
