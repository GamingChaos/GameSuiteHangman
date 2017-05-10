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

public class HintLetter {
	private char letter;
	private boolean geraden;
	
	public HintLetter(char letter){
			this.letter = letter;
			this.geraden = false;
	}

	public boolean raad(char letter){
		if(letter == this.getLetter()){
			this.geraden = true;
			return isGeraden();
		}
		else
			return false;
	}
	
	public char toChar(){
		return this.getLetter();
	}
	
	public char getLetter(){
		return this.letter;
	}
	
	public boolean isGeraden(){
		return this.geraden;
	}
}
