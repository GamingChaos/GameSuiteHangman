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

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import db.WoordLezer;
import domain.Punt;
import domain.Rechthoek;
import domain.Speler;
import domain.Tekening;
import domain.Vorm;
import domain.WoordenLijst;

public class Launcher {
	
	public static void main(String[] args) {
		Speler speler= null;
		try{
			//Maak speler aan
			String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
			speler = new Speler(naam);
			
			//Wat wil je spelen?
			String[] games = {"HangMan", "Pictionary"};
			String spel = (String) JOptionPane.showInputDialog(null, "Welk spel wil je spelen?", "Super Awesome Mega Game", JOptionPane.QUESTION_MESSAGE, null, games, games[0]);
			switch(spel){
			case "HangMan":
				HangManUi hangui = new HangManUi(speler);
				break;
			case "Pictionary":
				PictionaryUi picui = new PictionaryUi(speler);
				break;
			default: throw new IllegalArgumentException("typ de naam van het spel juist");
			}
		}
		catch(IllegalArgumentException iae){
			throw new UiException(iae);
		}
		
		//Maak punt aan
		int x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt:"));
		int y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt:"));
		Punt p = new Punt(x, y);
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + p.toString());
		
		//Maak rechthoek aan
		JOptionPane.showMessageDialog(null, "U heeft een correcte rechthoek aangemaakt: " + new Rechthoek(new Punt(Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt:")), Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt:"))), Integer.parseInt(JOptionPane.showInputDialog("De breedte van de rechthoek:")), Integer.parseInt(JOptionPane.showInputDialog("De hoogte van de rechthoek:"))).toString());
		JOptionPane.showMessageDialog(null, "... zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
		//Maak tekening aan
		String naamTekening = JOptionPane.showInputDialog("Geef de naam van je tekening");
		int keuze = Integer.parseInt(JOptionPane.showInputDialog("Wat wil je doen:\n1. vorm maken\n2. Tekening tonen\n\n0. Stoppen"));
		switch(keuze){
			case 0:
				//stoppen
				break;
			case 1:
				//vorm maken
				break;
			case 2:
				//tekening tonen
				break;
		}
	}
}
