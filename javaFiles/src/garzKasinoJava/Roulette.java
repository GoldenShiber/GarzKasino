package garzKasinoJava;
import java.util.Scanner;  // Import the Scanner class

/*  Roulette consists of a methods of winning, odds, input, random generated number
 *  and output Input and Output is inherited from the games class.
 *	The odds depends on what method you are using. 
 */
public class Roulette extends Games{
	String[] methods = {"single", "even", "dozen"};
	int[] odds = {36, 1, 2};
	int guess;
	int ballNumber;
	String method;

	/*
	 * The Roll function rolls a ball in the alpha step with a number from 0 to 36.
	 * In the future, this will also include a color to the number.
	 */
	public void rollTable() {
		this.ballNumber = (int)(Math.random()*37);
	}
	
	/*
	 * The Win Condition function depends on the chosen method of playing the game.
	 * In the first version, you can only choose single, even or a third(dozen). 
	 * That will however be increased in the future.
	 */
	public boolean winCondition(String method) {
		switch(method) {
		case "single":
			if (guess == this.ballNumber){
				return true;
			}
			else {
				return false;
			}
		case "even":
			if (this.ballNumber%2 == this.guess) {
				return true;
			}
			
			else {
				return false;
			}
		case "dozen":
			if ((guess == 1 && this.ballNumber <= 12) ||(guess == 2 && this.ballNumber > 12 
			&& this.ballNumber <= 24) || (guess == 3 && this.ballNumber > 24 
			&& this.ballNumber <= 36) ) {
				return true;
			}
			else {
				return false;
			}
		default:
			System.out.println("The chosen game doesn't seems to exist, or it ");
			return false;
		}
	}
	
	/*
	 * The pay out function determines the outcome of your game.
	 * Currently you can only win three methods, and if the method is bad, no change of pay out is done..
	 */
	public void payout() {
		int index =findIndex(this.methods, this.method);
		if(index >= 0) {
			if (winCondition(this.method)){
				System.out.println("Congrats you won some money!");
				this.payout = this.input*this.odds[index];
			}
			else {
				System.out.println("Sorry, you lost :)");
				this.payout = -this.input;
			}
		}
		else {
			System.out.println(this.method + " Is not a valid method");
			this.payout = 0;
		}
	}
	

	/* The setup method simply asks the user for the type of game and the guess for each gamble.
	 * You must ask an valid answer if you want to continue...
	 */
	public void setup() {
		Scanner methodChoice = new Scanner(System.in);
		System.out.println("Choose the method of choice:");
		System.out.println("In this case you can choose between single, even, dozen");
		this.method = methodChoice.nextLine();
		while(findIndex(this.methods, this.method) < 0) {
			System.out.println("You choose a method that is not implemented... \n "
					+ "Please choose between single, even, third\"");
			this.method = methodChoice.nextLine();
		}
		if(this.method.equals("single")) {
			System.out.println("Choose a single number to bet on!");
			this.guess = methodChoice.nextInt();
		}
		else if(this.method.equals("even")) {
			System.out.println("Choose 1 if you want odd numbers, Choose 0 for even numbers.");
			this.guess = methodChoice.nextInt();
		}
		else {
			System.out.println("Choose on 3 package of numbers here \n "
					+ "If you want 1-12, pick 1. If you want 13-24, pick 2. If you want 25-36, pick 3.");
			this.guess = methodChoice.nextInt();
			while(this.guess <= 0 || this.guess > 3) {
				System.out.println("Choose a legit choise from: [1, 2 or 3]");
				this.guess = methodChoice.nextInt();
			}
		}
		methodChoice.close();
	}
	
	/*
	 * The Step method that the game proceedes by, each different game has a different step method!
	 */
	public void step() {
		setup();
		rollTable();
		System.out.println("The rolled value is: "+this.ballNumber);
		payout();
	}
	
}

	
