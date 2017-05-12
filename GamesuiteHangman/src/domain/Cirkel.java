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

import java.awt.Graphics;

public class Cirkel extends Vorm implements Drawable{
	//Maak variabelen voor Cirkel
	private Punt middelpunt;
	private int radius;
	
	//Cirkel constructor voor punt en radius gegeven
	public Cirkel(Punt punt, int radius){
		try{
			//Zet variabelen
			setMiddelpunt(punt);
			setRadius(radius);
		}
		catch(IllegalArgumentException iae){
			throw new DomainException(iae);
		}
	}

	//Cirkel constructor voor x, y en radius
	public Cirkel(int x, int y, int radius){
		this(new Punt(x, y), radius);
	}
	
	//Zet het middelpunt
	private void setMiddelpunt(Punt middelpunt) throws IllegalArgumentException{
		if(middelpunt  == null)
			throw new IllegalArgumentException("geef een geldig punt op");
		this.middelpunt = middelpunt;
	}
	
	//Zet de radius
	private void setRadius(int radius) throws IllegalArgumentException{
		if(radius <= 0)
			throw new IllegalArgumentException("geef een geldige radius op");
		this.radius = radius;
	}
	
	//Geef middepunt terug
	public Punt getMiddelpunt(){
		return this.middelpunt;
	}
	
	//Geef radius terug
	public int getRadius(){
		return this.radius;
	}
	
	@Override
	public boolean equals(Object o){
		boolean result = false;
		if(o instanceof Cirkel){
			Cirkel c = (Cirkel) o;
			//Als middelpunten en radia gelijk zijn
			if(this.getMiddelpunt().equals(c.getMiddelpunt()) && this.getRadius() == c.getRadius())
				result = true;
		}
		return result;
	}
	
	@Override
	public String toString(){
		return "Cirkel: Middelpunt: " + this.middelpunt.toString() + " - straal: " + this.radius;
	}

	@Override
	public Omhullende getOmhullende() {
		return new Omhullende(new Punt(middelpunt.getX() - radius, middelpunt.getY() - radius), radius * 2, radius * 2);
	}

	@Override
	public void teken(Graphics graphics) {
		if(isZichtbaar()){
			graphics.fillOval(getMiddelpunt().getX()-getRadius(), 
					getMiddelpunt().getY()-getRadius(), 2*getRadius(), 2*getRadius());
		}	
	}
}
