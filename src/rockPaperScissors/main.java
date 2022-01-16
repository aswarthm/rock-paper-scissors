package rockPaperScissors;

import java.util.*;
import java.lang.Math;


/*
rock > scissor
scissor > paper
paper > rock

us = paper 2
pc = rock 0

us-pc = 2 -> pc wins
us-pc = -2 -> us wins

paper 2
scissors 1

us - pc < 0  -> us wins

 */

public class main {

	static int userScore = 0;
	static int pcScore = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int max = 2;
		int min = 0;
		
		ArrayList<String> choices = new ArrayList<String>();
		choices.add("rock"); //0
		choices.add("scissors"); //1
		choices.add("paper"); //2
		
		int userChoice = 0;
		int pcChoice;
		String userInput;
		String play = "y";
		
		System.out.println("How many round would you like to play?");
		int rounds = sc.nextInt();
		
		while(rounds > 0) {
			int validChoice = -1;
			while(validChoice == -1) {
				System.out.print("Enter your move: ");
				System.out.println("Rock, Paper, Scissors");
				userInput = sc.next();
				userChoice = choices.indexOf(userInput.toLowerCase());
				
				if(userChoice == -1) {
					System.out.println("Plis enter valid choice");
				}
				else {
					
					validChoice++;
				}
			}
			
			pcChoice = (int) Math.floor(Math.random() * (max - min + 1) + min);
			
			System.out.println("Your choice:" + choices.get(userChoice) + "	" + "AI's choice: " + choices.get(pcChoice));
			System.out.println();
			
			int decision = userChoice - pcChoice;
			
			if(decision == 0) { //draw
				System.out.println("Tis a Draw");
			}
			else if(decision == 2) { //pc wins
				pcScore++;
				System.out.println("AI Wins :(");
			}
			else if(decision == -2) { //user wins
				userScore++;
				System.out.println("You Wins :)");
			}
			else if(decision < 0) { //user wins
				userScore++;
				System.out.println("You Wins :)");
			}
			else { //pc wins
				pcScore++;
				System.out.println("AI Wins :(");
			}
			
			System.out.println();

			printScore();
			
			
/*
			System.out.println("Would you like to continue playing???(y/n)");
			play = sc.next().toLowerCase();
			System.out.println();
			System.out.println();*/
			
			rounds--;
			System.out.println("Rounds left: " + rounds);
		}
		
		//System.out.println(userChoice);
		//System.out.println(pcChoice);

	}
	
	static void printScore() {
		System.out.println("Your Score: " + userScore + "	" + "AI's Score: " + pcScore);
		if(userScore > pcScore) {
			System.out.println("You're winninggg!!!");
		}
		else if(userScore < pcScore){
			System.out.println("You're losing!");
		}
		System.out.println();
	}

}
