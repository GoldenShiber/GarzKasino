package garzKasinoJava;


public class HellWorld {
	int val;
	
	public void rollDice(){
		this.val = (int) (Math.random()*7);
		System.out.println(this.val);
	}
	
	public static void main(String[] args) {
		 HellWorld die = new HellWorld();
		die.rollDice();
	  }

}
