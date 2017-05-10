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


public class Rechthoek extends Vorm implements Drawable{
	//Maak variabelen voor Rechthoek
	private int breedte, hoogte;
	Punt hoek;
	
	//Rechthoek constructor voor gegeven hoekpunt, breedte, hoogte
	public Rechthoek(Punt hoek, int breedte, int hoogte){
		setLinkerBovenhoek(hoek);
		setBreedte(breedte);
		setHoogte(hoogte);
	}
	
	//Zet hoekpunt
	private void setLinkerBovenhoek(Punt hoek){
		if(hoek == null || hoek.equals(null)) throw new DomainException("De positie mag niet niets zijn!");
		this.hoek = hoek;
	}
	
	//Zet breedte
	private void setBreedte(int breedte){
		if(breedte <= 0) throw new DomainException("De breedte mag niet kleiner zijn dan 0");
		this.breedte = breedte;
	}
	
	//Zet hoogte
	private void setHoogte(int hoogte){
		if(hoogte <= 0) throw new DomainException("De hoogte mag niet kleiner zijn dan 0");
		this.hoogte = hoogte;
	}
	
	//Geeft hoekpunt
	public Punt getLinkerBovenhoek(){
		return hoek;
	}
	
	//Geeft breedte
	public int getBreedte(){
		return breedte;
	}
	
	//geeft hoogte
	public int getHoogte(){
		return hoogte;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Rechthoek){
			Rechthoek r = (Rechthoek) o;
			//Als hoekpunt en Hoogte en Breedte gelijk zijn
			if(getBreedte() == r.getBreedte() && getHoogte() == r.getHoogte() && getLinkerBovenhoek() == r.getLinkerBovenhoek()) return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "Rechtoek: positie: " + getLinkerBovenhoek().toString() + " - breedte: " + getBreedte() + " - hoogte: " + getHoogte();
	}

	@Override
	public Omhullende getOmhullende() {
		return new Omhullende(hoek, breedte, hoogte);
	}
}
