package garzKasinoJava;
import java.util.Scanner;  // Import the Scanner class

/*  Roulette consists of a methods of winning, odds, input, random generated number
 *  and output Input and Output is inherited from the games class.
 *	The odds depends on what method you are using. 
 */
public class Roulette extends Games{
	String[] methods = {"single", "even", "third"};
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
			if (guess == ballNumber){
				return true;
			}
			else {
				return false;
			}
		case "even":
			if (ballNumber%2 == 0) {
				return true;
			}
			
			else {
				return false;
			}
		case "double":
			if ((guess == 0 && ballNumber <= 50) ||(guess == 1 && ballNumber > 50) ) {
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
		if(index <= 0) {
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
	
	/*
	 * This is the first method to make the decision on what kind of method you wanna gamble with.
	 * Choose between the ones available or you will neither win or lose.
	 */
	public void makeChoices() {
		Scanner methodChoice = new Scanner(System.in);
		System.out.println("Choose the method of choice:");
		System.out.println("In this case you can choose between single, even, double or third");
		this.method = methodChoice.nextLine();
		System.out.println("You choose " + this.method + " as method!");
		methodChoice.close();
		
	}
}
	