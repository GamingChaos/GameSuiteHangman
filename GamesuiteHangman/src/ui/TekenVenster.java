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

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import domain.Cirkel;
import domain.Driehoek;
import domain.LijnStuk;
import domain.Punt;
import domain.Rechthoek;
import domain.Tekening;
import domain.Vorm;

public class TekenVenster extends Canvas {

	private static final long serialVersionUID = 1L;
	private Tekening tekening = null;
	private int aantalFout;

	public TekenVenster(Tekening tekening) {
		this.setPreferredSize(new Dimension(400, 400));
		setTekening(tekening);
	}
	
	public void raiseAantalFout(){
		this.aantalFout++;
	}
	
	private void setTekening(Tekening tekening) {
		if (tekening == null) throw new UiException("Tekening mag niet null zijn");
		
		this.tekening = tekening;
	}

	public void teken() {
		repaint();
	}

	@Override
	public void paint(Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setStroke(new BasicStroke(5));
		
		for(int i = 0; i < aantalFout; i++){
			tekening.getVorm(i).teken(graphics);
		}
	}
}