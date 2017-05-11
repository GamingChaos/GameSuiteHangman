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

import java.util.ArrayList;
import java.util.Random;

public class WoordenLijst {
	private ArrayList<String> woordenLijst = new ArrayList<>(); 
	
	public WoordenLijst(){
		woordenLijst = new ArrayList<>();
	}
	
	public void voegToe(String woord){
		if( woord == null || woord.trim().isEmpty()) throw new DomainException("woord mag niet leeg zijn of null!");
		if(woordenLijst.contains(woord)) throw new DomainException("woord mag niet twee keer voorkomen!");
		
		woordenLijst.add(woord);
	}
	
	
	public String getRandomWoord(){
		Random random = new Random();
		
		if( woordenLijst.size() <= 0){
			return null;
		}
		else if(woordenLijst.size() == 1){
			return woordenLijst.get(0);
		}
		
		return woordenLijst.get(random.nextInt(woordenLijst.size()));
	}
	
	public int getAantalWoorden(){
		return woordenLijst.size();
		
	}
}
