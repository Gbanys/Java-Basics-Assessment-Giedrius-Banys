package JavaBasics;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;

public class DogGenetics {

	public static void main(String[] args) {

		String initMsg = "Please write the name of your dog";
		output(initMsg);
		String userDogInput = input();
		
		//Tell the program to start generating the report
		generateReport(userDogInput);	
	}
	
	private static void generateReport(String userDogInput) {
		
		//Create an array of dog breeds and random percentages
		String[] dogs = {"St.Bernard", "Chihuahua", "Dramatic RedNosed Asian Pug", "Common Cur", "King Doberman"};
		ArrayList<Double> percentages = generatePercentages(dogs.length);
		HashMap<String, Long> dogList = new HashMap<String, Long>();
		
		//Put the name of each dog and a percentage into the hash map.
		for(int i = 0; i < dogs.length; i++) {
			dogList.put(dogs[i], Math.round(percentages.get(i)));
		}
		
		//Print the report and output the values inside the hash map to the console
		output("Well then, I have this highly reliable report on "+userDogInput+"'s prestigious "
		+ "background right here\n");
		output(userDogInput + " is\n");
		
		for(String i : dogList.keySet()) {
			output(dogList.get(i) + "%: " + i);
		}
		
		output("Wow, that's quite a dog\n");
	}

	private static ArrayList<Double> generatePercentages(int numOfDogs) {
		
		//Generate a random percentage value for each dog where the percentages must add up to 100%
		double totalPercentage = 1;
		ArrayList<Double> percentages = new ArrayList<Double>();
		
		while(numOfDogs > 0) {
			Random dogSeed = new Random();
			double randomPercentage = dogSeed.nextDouble();
			
			if(numOfDogs == 1) {
				randomPercentage = totalPercentage;
				numOfDogs -= 1;
				percentages.add(randomPercentage * 100);
			}
			else if(randomPercentage > totalPercentage) {
				continue;
			}
			else {
				percentages.add(randomPercentage * 100);
				totalPercentage -= randomPercentage;
				numOfDogs -=1;
			}
			
		}
		return percentages;
		
	}
	
	//Function allows the user to input value
	public static String input() {
		Scanner myScanner = new Scanner(System.in);
		String userInput = myScanner.nextLine();
		return userInput;
	}
	//Function which outputs to the console
	public static void output(String output) {
		System.out.println(output);
		return;
	}
}
