/**
* Hangmang Game
* *
* @author  JanRomo
* @author  bramdeman1
* @author  Kenzo1997
* @author  GamingChaos
* @author  CyllosBE
* *
* @version Pre-alfa
* @since   2017-05-08
* 
*/

package domain;

public class Punt {
	//Maak variabelen voor Punt
	private int x = 0;
	private int y = 0;

	//Punt constructor voor gegeven x en y
	public Punt(int x, int y ){
		this.setX(x);
		this.setY(y);
	}
	
	//Geef x terug
	public int getX() {
		return x;
	}
	
	//Zet x
	private void setX(int x) {
		this.x = x;
	}
	
	//Geef y terug
	public int getY() {
		return y;
	}
	
	//Zet y
	private void setY(int y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Punt){
			Punt p = (Punt) o;
			//Als x en y gelijk zijn
			if(this.getX() == p.getX() && this.getY() == p.getY()) return true;		
		}
		
		return false;
	}
	
	@Override
	public String toString(){
		return "(" + getX() + ", " + getY() + ")";
	}
}
