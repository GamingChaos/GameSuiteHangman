package domain;

public class Speler {
private String naam;
private int score = 0;
	public Speler(String naam) {
		setNaam(naam);
		
	}

	
	private void setNaam(String naam) {
		if(  naam == null ||  naam.trim().isEmpty() )throw new DomainException("naam mag niet leeg zijn en mag ook niet null zijn!");
		this.naam = naam;
	}

	public String getNaam() {
		return naam;
	}

	public int getScore() {
		return score;
	}

	public void addToScore(int positiveScore) {
		score += positiveScore;
		if(score < 0)throw new DomainException("score mag geen negatief getal zijn!");
		
		
		
	}
	@Override
	public boolean equals(Object o){
		boolean result = false;
		if(o instanceof Speler){
			Speler S = (Speler)o;
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
