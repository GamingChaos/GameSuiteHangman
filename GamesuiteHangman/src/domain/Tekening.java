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
import java.util.ArrayList;
import java.util.List;

public class Tekening implements Drawable{
	private String naam;
	private List<Vorm> vormen = new ArrayList<Vorm>();
	private static final int MIN_X = 0,  MIN_Y = 0, MAX_X = 399, MAX_Y = 399;
	
	public Tekening(String naam){
		this.setNaam(naam);
	}
	
	public String getNaam(){
		return naam;
	}
	
	public void voegToe(Vorm vorm) throws DomainException{
		if(vorm == null) throw new DomainException("Vorm mag niet null zijn");
		if(vorm.getOmhullende().minimaleX() < getMinX()) throw new DomainException("mag niet buiten de tekening vormen aanmaken");
		if(bevat(vorm)) throw new DomainException("Vorm is al toegevoegd");
		
		vormen.add(vorm);
	}
	
	public Vorm getVorm(int index){
		return vormen.get(index);
	}
	
	public List<Vorm> getVormLijst(){
		return vormen;
	}
	
	public int getAantalVormen(){
		return vormen.size();
	}
	
	public void verwijder(Vorm vorm){
		vormen.remove(vorm);
	}
	
	public boolean bevat(Vorm vorm){
		return vormen.contains(vorm);
	}
	
	private void setNaam(String naam) throws DomainException {
		if(naam == null || naam.trim().isEmpty()) throw new DomainException("Naam mag niet leeg zijn");
		this.naam = naam;
	}
	
	@Override
	public boolean equals(Object o){
		boolean temp = true;
		if(o == null) return false;
		if(o instanceof Tekening){
			Tekening t = (Tekening) o;
			if((getAantalVormen() == t.getAantalVormen() ) ){
				for(int i = 0 ; i < getAantalVormen(); i++){
					if(!vormen.contains(t.getVorm(i))) temp = false;
				}
			}
			else if(getAantalVormen() != t.getAantalVormen()){
				return false;
			}
		}
		return temp;
	}
	
	@Override
	public String toString(){
		String temp = "tekening met naam " + getNaam() + " bestaat uit " + getAantalVormen() + " vormen:";
		
		for(Vorm vorm: vormen){
			temp += "\n" + vorm.toString();
		}
		
		return temp;
	}
	
	public static int getMinX() {
		return MIN_X;
	}
	
	@Override
	public void teken(Graphics graphics) {
		// TODO Auto-generated method stub
		
	}

}
