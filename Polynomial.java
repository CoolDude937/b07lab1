//try to see if I need to import the Math library later

public class Polynomial {
	double[] coefficients;

	public Polynomial() {
		coefficients = [0];
	}

	public Polynomial(double[] inputPolynomial) {
		//this.inputPolynomial = coefficients - cheryl answer
		
		//double check if either of these work
		coefficients = inputPolynomial.clone();
	}
	
	public double add(Polynomial another_polynomial) {
		int length1 = coefficients.length;
		int length2 = another_polynomial.length;
		
		//take the minimum of the 2 lengths cuz we only need the shorter one to run 
		//the for loop
		int shorter_length = min(length1, length2);
		
		//also check if this works
		double[] sum_polynomial = new Polynomial();
		
		for (int i = 0; i < shorter_length; i++){
			sum_polynomial[i] = coefficients[i] + another_polynomial[i];
		}
		
		return sum_polynomial;
	}
	
	public double evaluate(double x_value) {
		for (int i = 0; i < coefficients.length; i++) {
			
		}
	}
}
