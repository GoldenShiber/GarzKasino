package garzKasinoJava;

public class Roulette extends Games{
	//Roulette consists of a methods of winning, odds, input, random generated number and output
	// Input and Output is inherited from the games class.
	String[] methods = {"single", "even", "double", "third"};
	int[] odds = {36, 2, 3, 4};
	int guess;
	int ballNumber;

	
	public void rollTable() {
		ballNumber = (int)Math.random()*100;
	}
	
	public boolean winCondition(String method) {
		switch(method) {
		case "single":
			if (guess == ballNumber){
				return true;
			}
		case "even":
			if (ballNumber%2 == guess) {
				return true;
			}
		case "double":
			if ((guess == 0 && ballNumber <= 50) ||(guess == 1 && ballNumber > 50) ) {
				return true;
			}
		}
		return true;
	}
	
}
