package domain;

public class Punt {
	//Maak variabelen voor Punt
	int x = 0;
	int y = 0;
	
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
	public void setX(int x) {
		this.x = x;
	}
	//Geef y terug
	public int getY() {
		return y;
	}
	//Zet y
	public void setY(int y) {
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
