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

package ui;

public class UiException extends RuntimeException {
	public UiException(Exception exception){
		super(exception);
	}
	
	public UiException(String message){
		super(message);
	}
}
