package JavaBasics;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean endGame = false;
		String initMsg = "Enter the number of rounds between 1 and 10";
		String errorMsgRounds = "Sorry, you entered the wrong number of rounds";
		
		//Loop through the game until the user specifically tells the game to end
		while(endGame == false) {
			output(initMsg);
			String input = input();
			int userRoundsInput = Integer.parseInt(input);
		
			if(isInputValid(input)) {
				endGame = play(userRoundsInput);
			}
			else {
				output(errorMsgRounds);
			}
		}
	}

	private static boolean play(int numberOfRounds) {
	
		//Initialise values for the number of draws, user wins and computer wins
		boolean end = false;
		int draw = 0;
		int userWin = 0;
		int computerWin = 0;
		
		//Play the game of rock paper scissors until the remaining number of rounds is 0
		while(end == false) {
			try {
				String initMsg = "Please input Rock, Paper, Scissors where Rock = 1, Paper = 2, and Scissors = 3";
				output(initMsg);
				
				//User selects values from 1 to 3
				String userInput = input();
				int userIntegerInput = Integer.parseInt(userInput);
		
				Random computerSelection = new Random();
				
				//Computer randomly selects values from 1 to 3
				int computerInput = computerSelection.nextInt(4) + 1;
				
				if(userIntegerInput < 1 || userIntegerInput > 3) {
					output("Sorry, but this number is not valid");
					continue;
				}
				else if(userIntegerInput == computerInput) {
					draw += 1;
				}
				else if(computerInput == 1 && userIntegerInput == 2) {
					userWin += 1;
				}
				else if(computerInput == 2 && userIntegerInput == 3) {
					userWin += 1;
				}
				else {
					computerWin += 1;
				}
				numberOfRounds -= 1;
			
				if(numberOfRounds == 0) {
					end = true;
				}
			}
			//Tell the user that they have entered wrong values
			catch (NumberFormatException e) {
				output("Sorry, you entered wrong values for Rock, Paper, Scissors");
				e.printStackTrace();
			}
		}
		//Decide who the winner is and output the results
		getWinner(draw, computerWin, userWin);
		
		//Ask the user if they want to play again.
		return endGame();
		
	}
	private static boolean endGame() {
		
		//Ask the user if they want to play again
		//Use the while loop to check whether the input is valid.
		boolean userDecisionValid = false;
		while(userDecisionValid == false) {
			output("Would you like to play again?");
			String userDecision = input();
			
			if(userDecision.equals("yes")) {
				userDecisionValid = true;
				return false;
			}
			else if(userDecision.equals("no")) {
				output("Thanks for playing!");
				userDecisionValid = true;
				return true;
			}
		}
		return false;		
	}
	
	private static void getWinner(int draw, int computerWin, int userWin) {
		
		//Output the number of draws, computer wins and user wins to the console.
		output("The number of draws: " + draw);
		output("The number of computer wins: " + computerWin);
		output("The number of user wins: " + userWin);
		
		//Check who wins
		if(computerWin > userWin) {
			output("Computer wins!");
			return;
		}
		else if(userWin > computerWin) {
			output("user wins!");
			return;
		}
		else {
			output("Nobody wins!");
			return;
		}
	}

	private static boolean isInputValid(String input) {
		
		//Check if the user input is valid
		boolean result = false;
		
		int tempInput = Integer.parseInt(input);
		
		if(tempInput >= 1 && tempInput <= 10) {
			result = true;
		}
		
		return result;
	}

	private static String input() {
		// Generates user input
		Scanner newScanner = new Scanner(System.in);
		String input = newScanner.nextLine();
		
		return input;
	}

	private static void output(String msg) {
		// Prints output to the console
		System.out.println(msg);
		return;
	}
}
