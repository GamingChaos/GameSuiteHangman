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

import javax.swing.JOptionPane;

import domain.Punt;
import domain.Rechthoek;
import domain.Speler;
import domain.Vorm;

public class Launcher {

	public static void main(String[] args) {
		try{
			//Maak speler aan
			String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
			Speler speler = new Speler(naam);
			
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
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
