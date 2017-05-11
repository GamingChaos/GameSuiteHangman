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

public class HintWoord {
	private ArrayList<HintLetter> letterLijst;
	private String woordString;
	
	public HintWoord(String woord) throws Exception{
		try{
			letterLijst = new ArrayList<HintLetter>();
			this.addLetter(woord);
			this.woordString = woord;
		}
		catch(IllegalArgumentException iae){
			throw new DomainException(iae);
		}
	}
	
	public boolean raad(char letter){
		boolean result = false;
		for(int i = 0; i < letterLijst.size(); i++){
			if(letterLijst.get(i).raad(letter) == true)
				result = true;
		}
		return result;
	}
	
	public boolean isGeraden(){
		int aantal = 0;
		for(int i = 0; i < letterLijst.size(); i++){
			if(letterLijst.get(i).isGeraden() == true){
				aantal++;
			}
		}
		if(aantal == letterLijst.size())
			return true;
		return false;
	}
	
	public String getWoord(){
		return woordString;
	}
	
	public String toString(){
		String result = "";
		for(HintLetter h : letterLijst){
			if(h.isGeraden() == true)
				result += h.getLetter();
			else
				result += "_";
		}
		return result;
	}
	
	private void addLetter(String woord) throws Exception{
		if(woord == null)
			throw new IllegalArgumentException("geef een woord op");
		if(woord.trim().isEmpty())
			throw new IllegalArgumentException("geef een geldig woord op");
		HintLetter letter;
		for(int i = 0; i < woord.length(); i++){
			letterLijst.add(new HintLetter(woord.charAt(i)));
		}
	}
}