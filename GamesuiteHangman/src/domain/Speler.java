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

public class Speler {
	//Maak variavbelen voor Speler
	private String naam;
	private int score = 0;
	//Speler constructor met gegeven naam
	public Speler(String naam) {
		setNaam(naam);	
	}
	
	//Zet naam
	private void setNaam(String naam) throws DomainException {
		//Als naam niets is
		if(naam == null || naam.trim().isEmpty())throw new DomainException("naam mag niet leeg zijn en mag ook niet null zijn!");
		this.naam = naam;
	}
	//geeft naam
	public String getNaam() {
		return naam;
	}
	//Geeft score
	public int getScore() {
		return score;
	}
	//Voegt score toe aan bestaande score
	public void addToScore(int positiveScore) throws DomainException {
		if(score + positiveScore < 0) throw new DomainException("score mag geen negatief getal zijn!");
		score += positiveScore;
	}
	
	@Override
	public boolean equals(Object o){
		boolean result = false;
		if(o instanceof Speler){
			Speler S = (Speler)o;
			//Als naam en score gelijk is
			if(this.naam.equals(S.naam) && this.score == S.score){
				result =true;
			}
		}
		
		return result;
		
	}
	
	
	@Override
 public String toString(){
	 String info;
	 info = "naam speler: " + naam + "\n" + "score: " + score ;
	 
	return info;
	 
 }

}
