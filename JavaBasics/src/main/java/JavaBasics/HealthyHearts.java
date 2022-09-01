package JavaBasics;

import java.util.Scanner;

public class HealthyHearts {

	public static void main(String[] args) {
		
		String initMsg = "Please enter your age";
		output(initMsg);
		boolean programEnd = false;
		
		while(programEnd == false) {
			try {
				//Find the maximum heart rate given the age of the user
				int userAge = Integer.parseInt(input());
				int maxHeartRate = calculateHeartRate(userAge);	
				output("Your maximum heart rate should be "+maxHeartRate+" beats per minute");
			
				//Output the range for the heart rate zone to the console
				double max = maxHeartRate * 0.85;
				double min = maxHeartRate * 0.5;
				output("Your target heart rate zone is "+Math.round(min)+"-"+Math.round(max));
				
				//Tell the program to stop asking the user for his age
				programEnd = true;
			}
			catch (NumberFormatException e) {
				System.out.println("Please enter a valid number");
			}
		}
		
	}
	private static int calculateHeartRate(int userAge) {
		//Calculates the maximum heart rate
		int maxHeartRate = 220 - userAge;
		return maxHeartRate;
		
	}
	private static String input() {
		//Takes the input
		Scanner myScanner = new Scanner(System.in);
		String userInput = myScanner.nextLine();
		return userInput;
	}

	private static void output(String output) {
		//Outputs a value to the console
		System.out.println(output);
		return;
	}

}
