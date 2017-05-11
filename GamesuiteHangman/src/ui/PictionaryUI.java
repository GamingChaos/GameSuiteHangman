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

import domain.Speler;
import domain.Tekening;

public class PictionaryUi {
	private Tekening tekening;
	private Speler speler;
	
	public PictionaryUi(Speler speler){
		tekening = new Tekening(speler.getNaam());
		GameMainWindow view = new GameMainWindow(speler.getNaam(), tekening);
		view.setVisible(true);
		view.teken();
		play();
	}
	public static void play(){
		System.exit(0);
	}
}
