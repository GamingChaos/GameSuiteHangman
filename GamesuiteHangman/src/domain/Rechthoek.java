package domain;


public class Rechthoek extends Vorm {
	private int breedte, hoogte;
	Punt hoek;
	
	public Rechthoek(Punt hoek, int breedte, int hoogte){
		setLinkerBovenhoek(hoek);
		setBreedte(breedte);
		setHoogte(hoogte);
	}
	
	private void setLinkerBovenhoek(Punt hoek){
		if(hoek == null || hoek.equals(null)) throw new DomainException("De positie mag niet niets zijn!");
		this.hoek = hoek;
	}
	
	private void setBreedte(int breedte){
		if(breedte <= 0) throw new DomainException("De breedte mag niet kleiner zijn dan 0");
		this.breedte = breedte;
	}
	
	private void setHoogte(int hoogte){
		if(hoogte <= 0) throw new DomainException("De hoogte mag niet kleiner zijn dan 0");
		this.hoogte = hoogte;
	}
	
	public Punt getLinkerBovenhoek(){
		return hoek;
	}
	
	public int getBreedte(){
		return breedte;
	}
	
	public int getHoogte(){
		return hoogte;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Rechthoek){
			Rechthoek r = (Rechthoek) o;
			if(getBreedte() == r.getBreedte() && getHoogte() == r.getHoogte() && getLinkerBovenhoek() == r.getLinkerBovenhoek()) return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "Rechtoek: positie: " + getLinkerBovenhoek().toString() + " - breedte: " + getBreedte() + " - hoogte: " + getHoogte();
	}
}
