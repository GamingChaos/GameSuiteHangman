package domain;

public class Cirkel {
	//Maak variabelen voor Cirkel
	private Punt middelpunt;
	private int radius;
	
<<<<<<< HEAD
	public Cirkel(int x, int y, int radius){
			this(new Punt(x, y), radius);
	}
	
=======
	//Cirkel constructor voor punt en radius gegeven
>>>>>>> 67bf7bd8f9f8bcb3ae075d27c416067063b87717
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
<<<<<<< HEAD
	
	
	
=======
	//Cirkel constructor voor x, y en radius
	public Cirkel(int x, int y, int radius){
		try{
			//Zet variabelen via eerste cirkel constructor
			new Cirkel(new Punt(x, y), radius);
		}
		catch(IllegalArgumentException iae){
			throw new DomainException(iae);
		}
	}
	//Zet het middelpunt
>>>>>>> 67bf7bd8f9f8bcb3ae075d27c416067063b87717
	public void setMiddelpunt(Punt middelpunt) throws IllegalArgumentException{
		if(middelpunt  == null)
			throw new IllegalArgumentException("geef een geldig punt op");
		this.middelpunt = middelpunt;
	}
	
	//Zet de radius
	public void setRadius(int radius) throws IllegalArgumentException{
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
}
