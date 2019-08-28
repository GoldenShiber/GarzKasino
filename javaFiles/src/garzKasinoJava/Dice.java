package garzKasinoJava;
//import java.util.Scanner;  // Import the Scanner class
import java.util.stream.IntStream;

/*
 * A game of dice consists of a pair of dices being thrown.
 * They pay-out depends on how risky the guess is following standard dice rules.
 */
public class Dice extends Games{
	int[] easyField = {3, 4, 9, 10, 11};
	int[] hardField = {2, 12};
	String[] methods = {"easyField", "hardField", "seven"};
	int[] odds = {1, 2, 4};
	int diceRoll = 0;
	String method;
	
	void rollDie() {
		this.diceRoll += (int)(Math.random()*7);
		this.diceRoll += (int)(Math.random()*7);
	}
	
	/*
	 * The win condition depends on the method of winning.
	 */
	boolean winCondition(String method) {
		switch(method) {
		case "easyField":
			if (IntStream.of(this.easyField).anyMatch(x -> x == this.diceRoll)) {
				return true;
			}
			else {
				return false;
			}
		case "hardField":
			if (IntStream.of(this.hardField).anyMatch(x -> x == this.diceRoll)) {
				return true;
			}
			else {
				return false;
			}
		case "seven":
			if (this.diceRoll == 7) {
				return true;
			}
			else {
				return false;
			}
		default:
			return false;
		}
	}
	
	/*
	 * The pay out function determines the outcome of your game.
	 * Currently you can only win three methods, and if the method is bad, no change of pay out is done..
	 */
	void payout() {
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
	
	/*
	 * The Step method that the game proceeds by, each different game has a different step method of winning!
	 */
	void setup(){
		System.out.println("Choose the method of choice:");
		System.out.println("In this case you can choose between easyField, hardField, seven");
		this.method = methodChoice.nextLine();
		while(findIndex(this.methods, this.method) < 0) {
			System.out.println("You choose a method that is not implemented... \n "
					+ "Please choose between easyField, hardField, seven\"");
			this.method = methodChoice.nextLine();
		}
		rollDie();
		//methodChoice.close();
	}
	
	void step() {
		setup();
		System.out.println("The rolled value is: "+this.diceRoll);
		payout();
	}
}

