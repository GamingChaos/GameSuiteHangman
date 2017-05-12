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

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import domain.Tekening;

public class GameMainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private TekenVenster tekenvenster;

	public GameMainWindow(String titel, Tekening tekening){
		super(titel);
		TekenVenster tekenvenster = new TekenVenster(tekening);
		setTekenvenster(tekenvenster);

		JPanel tekeningPaneel = new JPanel();
		tekeningPaneel.setBackground(Color.white);
		tekeningPaneel.setBorder(BorderFactory.createMatteBorder( 3, 3, 3, 3, Color.darkGray));
		tekeningPaneel.add(tekenvenster);

		this.setLayout(new BorderLayout());
		this.add(tekeningPaneel, BorderLayout.CENTER);
		this.pack();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void teken(){
		getTekenvenster().teken();
	}
	
	public void raiseAantalFout(){
		tekenvenster.raiseAantalFout();
	}
	
	protected TekenVenster getTekenvenster() {
		return tekenvenster;
	}

	private void setTekenvenster(TekenVenster tekenvenster) {
		this.tekenvenster = tekenvenster;
	}
}