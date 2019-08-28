package garzKasinoJava;
import java.util.Scanner;  // Import the Scanner class

public class Games {
	 
	 //The class games has three key variables, input, the name of the game and the output.
	int input = 0;
	String gameName = "TestGame";
	int payout = -9;
	Scanner methodChoice = new Scanner(System.in);
	String[] gameMethods = {"Roulette", "Dice"}; 
	int saldo;
	String option = "yes";
	
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
	/*
	 * This methods makes the user choose a method, and how much you want to bet.
	 */
	public void chooseGameMethod() {
		System.out.println("Choose a game method, currently there are Roulette or Dice, or you can exit with something else!");
		this.gameName = methodChoice.nextLine();
		int index = findIndex(this.gameMethods, this.gameName);
		if (index >= 0) {
			System.out.println("How much do you wanna bet?");
			int bet = methodChoice.nextInt();
			if (index == 0) {
				Roulette testGame = new Roulette();
				testGame.input = bet;
				testGame.step();
				this.saldo += testGame.payout;
			}
			else {
				Dice testGame = new Dice();
				testGame.input = bet;
				testGame.step();
				this.saldo += testGame.payout;
			}
			System.out.println("Your current saldo is: "+ this.saldo);
			System.out.println("Wanna play again? In that case write yes");
			methodChoice.nextLine();
			this.option = methodChoice.nextLine();
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Games testGame = new Games();
		testGame.saldo = 100;
		while(testGame.option.equals("yes")) {
			testGame.chooseGameMethod();
		}
		
	}

}
