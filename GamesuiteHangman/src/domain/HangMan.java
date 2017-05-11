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

import ui.TekeningHangMan;

public class HangMan {
	private Speler speler;
	private WoordenLijst woordenlijst;
	private TekeningHangMan tekening;
	private HintWoord woord;
	private boolean gewonnen;
	
	public HangMan(Speler speler, WoordenLijst woordenlijst) throws Exception{
		try{
			setSpeler(speler);
			setWoordenlijst(woordenlijst);
			tekening = new TekeningHangMan();
			woord = new HintWoord(woordenlijst.getRandomWoord());
			this.gewonnen = false;
		}
		catch(IllegalArgumentException iae){
			throw new DomainException(iae);
		}
	}
	public WoordenLijst getWoordenlijst() {
		return woordenlijst;
	}
	private void setWoordenlijst(WoordenLijst woordenlijst) {
		if(woordenlijst == null)
			throw new IllegalArgumentException("geef een geldige woordenlijst");
		this.woordenlijst = woordenlijst;
	}
	private void setSpeler(Speler speler) {
		if(speler == null) 
			throw new IllegalArgumentException("Speler mag niet leeg zijn");
		this.speler = speler;
	}
	public String getHint() {
		return this.woord.toString();
	}

	public Object getSpeler() {
		return this.speler;
	}

	public TekeningHangMan getTekening() {
		return this.tekening;
	}
	public boolean isGewonnen() {
		return this.gewonnen;
	}
	public boolean isGameOver() {
		return !gewonnen;
	}
	public boolean raad(char letter) {
		return this.woord.raad(letter);		
	}
}
