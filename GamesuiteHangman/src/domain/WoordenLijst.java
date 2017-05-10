package domain;

import java.util.ArrayList;
import java.util.Random;

public class WoordenLijst {
	private ArrayList<String> woordenLijst; 
	public void Woordenlijst(){
		woordenLijst = new ArrayList<>();
	}
	public void voegToe(String woord){
		if(woord == null || woord.trim().isEmpty())throw new DomainException("woord mag niet leeg zijn of null!");
		if(woordenLijst.contains(woord))throw new DomainException("woord mag niet twee keer voorkomen!");
		woordenLijst.add(woord);
	}
	
	public String getRandomWoord(){
		Random random = new Random();
		int r = random.nextInt(woordenLijst.size());
		if( woordenLijst.size() <= 0){
			return null;
		}
		else if(woordenLijst.size() == 1){
			return woordenLijst.get(0);
		}
		
		
		
		
		return woordenLijst.get(r);
		
	}
	public int getAantalWoorden(){
		return woordenLijst.size();
		
	}
	
}
