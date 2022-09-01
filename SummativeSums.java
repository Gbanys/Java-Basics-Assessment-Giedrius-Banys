package JavaBasics;

public class SummativeSums {

	public static void main(String[] args) {
		
		//Store array of arrays in a multidimensional array
		int mainArray[][] = {{1, 90, -33, -55, 67, -16, 28, -55, 15},
		{999, -60, -77, 14, 160, 301},
		{ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99 }};
		
		//Output the sum of each array by looping through the multidimensional array
		for(int i = 0; i < mainArray.length; i++) {
			output("#" + (i+1) + " " + "Array Sum: " + sum(mainArray[i]));
		}
		
	}
	public static int sum(int inputArray[]) {
		
		//Calculates the sum of each array
		int sum = 0;
		
		for(int i = 0; i < inputArray.length; i++) {
			sum += inputArray[i];
		}
		return sum;
	}
	public static void output(String output) {
		//Print the output to the console
		System.out.println(output);
		return;
	}
}
