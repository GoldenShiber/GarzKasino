package garzKasinoJava;

public class Games {
	 
	 //The class games has three key variables, input, the name of the game and the output.
	int input = 0;
	String gameName = "TestGame";
	int payout = -9;
	
	public void gamblingResult() {
		System.out.println("The input was "+ input+ " the chosen game was "+ gameName+ "and the result was "+
				payout+ " in Garzbucks");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Games testGame = new Games();
		testGame.gamblingResult();

	}

}
