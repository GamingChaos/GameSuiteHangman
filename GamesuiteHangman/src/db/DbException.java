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

package db;

public class DbException extends RuntimeException{
	public DbException(Exception exception){
		super(exception);
	}
	
	public DbException(String message){
		super(message);
	}
}