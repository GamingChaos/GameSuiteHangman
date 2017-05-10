package domain;

import java.util.ArrayList;

public class HintWoord {
	private ArrayList<HintLetter> woordLijst;
	private String woordString;
	
	public HintWoord(String woord) throws Exception{
		try{
			this.addWoord(woord);
			this.woordString = woord;
		}
		catch(IllegalArgumentException iae){
			throw new DomainException(iae);
		}
	}
	
	public boolean raad(char letter){
		boolean result = false;
		for(int i = 0; i < woordLijst.size(); i++){
			if(woordLijst.get(i).raad(letter) == true)
				result = true;
		}
		return result;
	}
	
	public boolean isGeraden(){
		int aantal = 0;
		for(int i = 0; i < woordLijst.size(); i++){
			if(woordLijst.get(i).isGeraden() == true){
				aantal++;
			}
		}
		if(aantal == woordLijst.size())
			return true;
		return false;
	}
	
	public String getWoord(){
		return woordString;
	}
	
	public String toString(){
		return woordString;
	}
	
	private void addWoord(String woord) throws Exception{
		if(woord == null || woord.trim().isEmpty())
			throw new IllegalArgumentException("geef een woord op");
		if(woord.length() < 1)
			throw new IllegalArgumentException("geef een geldig woord op");
		for(int i = 0; i <= woord.length(); i++){
			this.woordLijst.add(new HintLetter(woord.charAt(i)));
		}
	}
}