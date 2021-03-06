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

public class DomainException extends RuntimeException{
	public DomainException(Exception exception){
		super(exception);
	}
	
	public DomainException(String message){
		super(message);
	}
}