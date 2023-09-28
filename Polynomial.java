import java.util.Arrays;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Polynomial {
	double[] coefficients;
	int[] exponents;

	public Polynomial() {
		coefficients = null;
		exponents = null;
	}

	public Polynomial(double[] inputCoefficients, int[] inputExponents) {
		//only clone if not null
		if (inputCoefficients != null){
			coefficients = inputCoefficients.clone();
		}
		else {
			coefficients = null;
		}
		
		//same for exponents
		if (inputExponents != null){
			exponents = inputExponents.clone();
		}
		else {
			exponents = null;
		}
	}

	//helper function to determine if a value is a coefficient or not within a polynomial array
	public boolean isCoefficient(String[] polynomial_Array, int index_of_value){
		//middle cases
		if ((index_of_value + 1 < polynomial_Array.length) && (index_of_value - 1 >= 0)){
			if (!polynomial_Array[index_of_value - 1].equals("x")) {
				if ( polynomial_Array[index_of_value + 1].equals("x") ||
				polynomial_Array[index_of_value + 1].equals("-") || 
				polynomial_Array[index_of_value + 1].equals("+")){
					return true;
				}
			}
		}
		//first index
		if (index_of_value == 0){
			if (polynomial_Array[index_of_value + 1].equals("+") || 
			polynomial_Array[index_of_value + 1].equals("-") || 
			polynomial_Array[index_of_value + 1].equals("x")){
				return true;
			}
		}
		//last index
		if(index_of_value == polynomial_Array.length - 1){
			if ((polynomial_Array[index_of_value - 1].equals("+")) ||
			(polynomial_Array[index_of_value - 1].equals("-"))){
				return true;
			}
		}
		return false;
	}	

	//helper function to determine if a value is an exponent or not within a polynomial array
	public boolean isExponent(String[] polynomial_Array, int index_of_value){

		//make sure we aint out of bounds
		if (index_of_value <= 0 || index_of_value >= polynomial_Array.length){
			return false;
		}
		if ( polynomial_Array[index_of_value - 1].equals("x")){
			return true;
		}
		return false;
	}


	//helper function to remove an element from an array but for doubles
	public double[] removeElement(double[] arr, int remove_index){
		double[] newArr = new double[arr.length - 1];
		int length_to_index = 0;
        //for loop to find the length to the index to be removed
        for (int i = 0; i < arr.length; i++) {
            if (length_to_index == remove_index){
                break;
            }
			length_to_index++;
        }

        System.arraycopy(arr, 0, newArr, 0, length_to_index);
         
        int length_to_end = 0;
        //for loop to find the length to the rest of the array
        for (int i = remove_index + 1; i < arr.length; i++){
            length_to_end++;
        }

        System.arraycopy(arr, remove_index+1, newArr, length_to_index, length_to_end);
        
		return newArr;
	}

	//helper function to remove an element from an array but for ints
	public int[] removeElement(int[] arr, int remove_index){
		int[] newArr = new int[arr.length - 1];
		int length_to_index = 0;
        //for loop to find the length to the index to be removed
        for (int i = 0; i < arr.length; i++) {
            if (length_to_index == remove_index){
                break;
            }
			length_to_index++;
        }

        System.arraycopy(arr, 0, newArr, 0, length_to_index);
         
        int length_to_end = 0;
        //for loop to find the length to the rest of the array
        for (int i = remove_index + 1; i < arr.length; i++){
            length_to_end++;
        }

        System.arraycopy(arr, remove_index+1, newArr, length_to_index, length_to_end);
        
		return newArr;
	}

	public Polynomial add(Polynomial another_polynomial) {
		//lengths of both polynomials
		int length1;
		int length2;
		//only read length if it is not null
		if (exponents != null && another_polynomial.exponents != null){
			length1 = exponents.length;
			length2 = another_polynomial.exponents.length;
		}
		//else one of them is null, return accordingly
		else if (exponents == null){
			return another_polynomial;
		}
		else if (another_polynomial.exponents == null){
			return this;
		}
		else {
			return null;
		}

		//variable to hold the biggest exponent, as that will help us get the length of the sum polynomial.
		int biggest_exponent = 0;

		//loop to find this
		for (int i = 0; i < length1; i++) {
			if (exponents[i] > biggest_exponent){
				biggest_exponent = exponents[i];
			}
		}
		//loop again for the second exponents array
		for (int i = 0; i < length2; i++) {
			if (another_polynomial.exponents[i] > biggest_exponent){
				biggest_exponent = another_polynomial.exponents[i];
			}
		}

		//the max length of the new polynomial is the biggest exponent +1.
		int max_length = biggest_exponent + 1;

		//arrays for the sum polynomial
		double[] sum_coefficients = new double[max_length];
		Arrays.fill(sum_coefficients, 0.0);
		int[] sum_exponents = new int[max_length];
		Arrays.fill(sum_exponents, 0);

		//loops to add the exponents in
		for (int i = 0; i < max_length; i++){
			for(int j = 0; j < length1; j++){
				if (i == exponents[j]) {
					sum_exponents[i] = exponents[j];
				}
			}
			for(int j = 0; j < length2; j++){
				if (i == another_polynomial.exponents[j]) {
					sum_exponents[i] = another_polynomial.exponents[j];
				}
			}
		}

		//loops to add coefficients in
		for (int j = 0; j < length1; j++){
			sum_coefficients[exponents[j]] += coefficients[j];
			
		}
		for (int j = 0; j< length2; j++){
			sum_coefficients[another_polynomial.exponents[j]] += another_polynomial.coefficients[j];
		}

		//for loops to remove redundant values
		for (int i = 0; i < max_length; i++){
			// System.out.println(Arrays.toString(sum_coefficients));
			// System.out.println(Arrays.toString(sum_exponents));
			for (int j = 0; j < max_length; j++){
				if (sum_coefficients[j] == 0.0){
					sum_coefficients = removeElement(sum_coefficients, j);
					sum_exponents = removeElement(sum_exponents, j);
					max_length--;
				}
			}
			//System.out.println(Arrays.toString(sum_exponents));
		}
		// System.out.println(Arrays.toString(sum_coefficients));
		// System.out.println(Arrays.toString(sum_exponents));

		//but if the polynomial is the 0 polynomial, just return null.
		if (sum_coefficients.length == 1 && sum_coefficients[0] == 0.0 || sum_exponents.length == 1 && sum_exponents[0] == 0){
			return null;
		}

		//construct the polynomial and return
		Polynomial sum_Polynomial = new Polynomial(sum_coefficients, sum_exponents);
		return sum_Polynomial;
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

		if ((length1 == 0) || (length2 == 0)){
			Polynomial product_Polynomial = new Polynomial();
			return product_Polynomial;
		}
		
		//calculate total length of the product polynomial (can remove redundancy later)
		int product_length = length1 + length2 + 2;

		//declare empty arrays to use for the product polynomial
		double[] product_coefficients = new double[product_length];
		int[] product_exponents = new int[product_length];

		//make this into a polynomial ahead of time, so we can use add() method 
		Polynomial product_Polynomial = new Polynomial(product_coefficients, product_exponents);

		//nested for loop to multiply polynomials, the length does not matter this time cuz we are multiplying
		for (int i = 0; i < length1; i++){
			for (int j = 0; j < length2; j++) {
				double[] current_value = {coefficients[i] * inputPolynomial.coefficients[j]};
				int[] current_exponent = {exponents[i] + inputPolynomial.exponents[j]};
				//new polynomial to add to product_Polynomial
				Polynomial temp_Polynomial = new Polynomial(current_value, current_exponent);

				product_Polynomial = product_Polynomial.add(temp_Polynomial);
			}
		}

		return product_Polynomial;
	}

	public Polynomial(File filePolynomial) {
    try {
		Polynomial newPolynomial = new Polynomial();

		//temp polynomial to add
		Polynomial tempPolynomial = new Polynomial();
		double[] temp_coefficients;
		int[] temp_exponents;

        BufferedReader reader = new BufferedReader(new FileReader(filePolynomial));
        String polynomial_as_a_String = reader.readLine();
		String[] polynomial_as_an_Array = polynomial_as_a_String.split("");
        for (int i = 0; i < polynomial_as_an_Array.length; i++){
			if (isCoefficient(polynomial_as_an_Array, i)){
				//check if its negative
				if (i != 0 && polynomial_as_an_Array[i - 1].equals("-")){
					temp_coefficients = new double[] {-Double.parseDouble(polynomial_as_an_Array[i])};
				}
				else{
					temp_coefficients = new double[] {Double.parseDouble(polynomial_as_an_Array[i])};

				}
				//check if its a coefficient
				if (isExponent(polynomial_as_an_Array, i + 2)){
					temp_exponents = new int[] {Integer.parseInt(polynomial_as_an_Array[i + 2])};
				}
				//else it is a constant
				else {
					temp_exponents = new int[] {0};
				}
				tempPolynomial = new Polynomial(temp_coefficients, temp_exponents);
				newPolynomial = newPolynomial.add(tempPolynomial);
			}
		}


		coefficients = newPolynomial.coefficients.clone();
		exponents = newPolynomial.exponents.clone();

        reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + filePolynomial.getAbsolutePath());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error reading the file: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void saveToFile(String fileName){
		try {
			String polynomialString = "";
			//I will convert stuff to int cuz it looks better :)
			for (int i = 0; i < coefficients.length; i++){
				//if the coefficient is not the first one, we need a plus sign.
				if (coefficients[i] > 0.0 && i != 0){
					polynomialString = polynomialString + "+" + (int)coefficients[i];
				}
				//if its negative, the negative sign is added in with the double. if it is the first one, then no need for + sign.
				else {
					polynomialString = polynomialString + (int)coefficients[i];
				}
				//then do exponent, but only put down an x if the exponent is nonzero.
				if (exponents[i] != 0){
					polynomialString = polynomialString + "x" + exponents[i];
				}
			}
			FileWriter writer = new FileWriter(fileName);
			writer.write(polynomialString);
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("alright clearly you didn't write to the file properly.");
		}

	}
}
