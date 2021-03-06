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

public abstract class  Vorm implements Drawable {
	public abstract Omhullende getOmhullende();
	boolean zichtbaar = true;
	
	public boolean isZichtbaar(){
		return zichtbaar;
	}
	
	public void setZichtbaarheid(boolean zichtbaarheid){
		this.zichtbaar = zichtbaarheid;
	}
}