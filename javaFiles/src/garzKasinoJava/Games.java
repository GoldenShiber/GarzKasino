package garzKasinoJava;
import java.util.Scanner;  // Import the Scanner class

public class Games {
	 
	 //The class games has three key variables, input, the name of the game and the output.
	int input = 0;
	String gameName = "TestGame";
	int payout = -9;
	
	public void gamblingResult() {
		System.out.println("The input was "+ input+ " the chosen game was "+ gameName+ "and the result was "+
				payout+ " in Garzbucks");
	}
	
	/*
	 * The find index method is used to determine if the method is allowed in the legal methods of gambling.
	 */
	public int findIndex(String[] options, String item) {
		for(int i = 0; i < options.length; i++) {
			if(options[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Games testGame = new Games();
		testGame.gamblingResult();
		Roulette testRoulette = new Roulette();
		String mode = "even";
		testRoulette.rollTable();
		testRoulette.makeChoices();
		System.out.println(testRoulette.ballNumber);
		System.out.println(testRoulette.winCondition(mode));
	}

}
