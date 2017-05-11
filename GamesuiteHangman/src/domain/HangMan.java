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

public class HangMan {
	private Speler speler;
	private WoordenLijst woordenlijst;
	private Tekening tekening;
	public HangMan(Speler speler, WoordenLijst woordenlijst){
		this.setSpeler(speler);
		this.setWoordenlijst(woordenlijst);
		this.setTekening(tekening);
	}
	private void setTekening(Tekening tekening) {
		this.tekening = tekening;
		
	}
	public WoordenLijst getWoordenlijst() {
		return woordenlijst;
	}
	private void setWoordenlijst(WoordenLijst woordenlijst) {
		this.woordenlijst = woordenlijst;
	}
	private void setSpeler(Speler speler) {
		if(speler == null) throw new DomainException("Speler mag niet leeg zijn");
		this.speler = speler;
	}
	public String getHint() {
		// TODO Auto-generated method stub
		return null;
	}
	//TODO: Maak klasse

	public Object getSpeler() {
	 return this.getSpeler();
	}

	public Tekening getTekening() {
		// TODO Auto-generated method stub
		return tekening;
	}
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean isGewonnen() {
		// TODO Auto-generated method stub
		return false;
	}
	public void raad(char letter) {
		// TODO Auto-generated method stub
		
	}
}
