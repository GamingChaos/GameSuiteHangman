package domain;

public class Cirkel {
	private Punt middelpunt;
	private int radius;
	
	public Cirkel(Punt punt, int radius){
		try{
			setMiddelpunt(punt);
			setRadius(radius);
		}
		catch(IllegalArgumentException iae){
			throw new DomainException(iae);
		}
		
	}
	
	public void setMiddelpunt(Punt middelpunt) throws IllegalArgumentException{
		if(middelpunt  == null)
			throw new IllegalArgumentException("geef een geldig punt op");
		this.middelpunt = middelpunt;
	}
	
	public void setRadius(int radius) throws IllegalArgumentException{
		if(radius <= 0)
			throw new IllegalArgumentException("geef een geldige radius op");
		this.radius = radius;
	}
	
	public Punt getMiddelpunt(){
		return this.middelpunt;
	}
	
	public int getRadius(){
		return this.radius;
	}
	
	@Override
	public boolean equals(Object o){
		boolean result = false;
		
		if(o instanceof Cirkel){
			Cirkel c = (Cirkel) o;
			if(c.getRadius() == this.radius && c.getMiddelpunt().equals(this.middelpunt))
				result = true;
		}
		return result;
	}
	
	@Override
	public String toString(){
		return "Cirkel: Middelpunt: " + this.middelpunt.toString() + " - straal: " + this.radius;
	}
}
