package ui;

import javax.swing.JOptionPane;

import domain.Punt;
import domain.Rechthoek;
import domain.Speler;

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
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
