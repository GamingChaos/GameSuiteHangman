package domain;

import java.util.ArrayList;
import java.util.List;

public class Tekening{
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
		if(bevat(vorm)) throw new DomainException("Vorm is al toegevoegd");
		vormen.add(vorm);
	}
	public Vorm getVorm(int index){
		return vormen.get(index);
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
	
	public void setNaam(String naam) throws DomainException {
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

}
