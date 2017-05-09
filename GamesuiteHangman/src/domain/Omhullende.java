package domain;

public class Omhullende {
private Punt linkerBovenhoek;
private int breedte,hoogte;


	public Omhullende(Punt linkerBovenhoek, int breedte, int hoogte) {
		setHoogte(hoogte);
		setBreedte(breedte);
		setLinkerBovenhoek(linkerBovenhoek);
		
	}

	public Punt getLinkerBovenhoek() {
		return linkerBovenhoek;
	}

	private void setLinkerBovenhoek(Punt linkerBovenhoek) {
		if(linkerBovenhoek == null )throw new DomainException("linkerBovenhoek mag niet null zijn!");
		this.linkerBovenhoek = linkerBovenhoek;
	}

	public int getBreedte() {
		return breedte;
	}

	private void setBreedte(int breedte) {
		if(breedte < 0)throw new DomainException("breedte mag niet kleiner zijn dan 0");
		this.breedte = breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	private void setHoogte(int hoogte) {
		if(hoogte < 0)throw new DomainException("hoogte mag niet kleiner zijn dan 0");
		this.hoogte = hoogte;
	}
	
	public int minimaleX(){
		return linkerBovenhoek.getX();
	}
	
	public int maximaleX(){
		return linkerBovenhoek.getX() + breedte;
	}
	
	public int minimaleY(){
		return linkerBovenhoek.getY();
	}
	
	public int maximaleY(){
		return linkerBovenhoek.getY() + hoogte;
	}
	@Override
	public boolean equals(Object o){
		boolean result = false;
		if(o instanceof Omhullende){
			Omhullende O = (Omhullende)o;
			if(this.getLinkerBovenhoek().equals(O.linkerBovenhoek) && this.breedte == O.breedte && this.hoogte == O.hoogte ){
			result = true;	
			}
			
		}
		
		return result;
	
		
	}
	@Override
	public String toString(){
		return "linkerBovenhoek: " + linkerBovenhoek + "\n breedte: " + breedte + "\n hoogte: " + hoogte;
		
	}
}

	
