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
import java.util.ArrayList;

import javax.swing.JOptionPane;

import db.WoordLezer;
import domain.HintWoord;
import domain.Speler;
import domain.Tekening;
import domain.WoordenLijst;

public class HangManUi {
	private Tekening tekening;
	private Speler speler;
	private ArrayList<String> letters;
	
	public HangManUi(Speler speler){
		this.tekening = new Tekening(speler.getNaam());
		GameMainWindow view = new GameMainWindow(speler.getNaam(), tekening);
		view.setVisible(true);
		view.teken();
		play();
	}
	
	public void play(){
		HintWoord woord;
		try {
			WoordenLijst l = new WoordLezer("HangMan.txt").lees();
			woord = new HintWoord(l.getRandomWoord());
		} 
		catch (Exception e){
			throw new UiException(e);
		}
		
		int vorigeRonde = 0;
		for(int i = 0; i < 10; i++){
			String letterString;
			switch(vorigeRonde){
				case 0: 
					letterString = JOptionPane.showInputDialog("Rarara, welk woord zoeken we? \n" + woord.toString() + "\nGeef een letter:");
					if(letterString.length() == 1){
						break;	
					}
					else{
						boolean goeieGok = false;
						while(goeieGok == false){
							letterString = JOptionPane.showInputDialog("We zoeken een LETTER! \nRarara, welk woord zoeken we? \n" + woord.toString() + "\nGeef een letter:");
							if(letterString.length() == 1)
								goeieGok = true;
						}
					}
					break;
				case 1:
					letterString = JOptionPane.showInputDialog("Goeie gok! \nRarara, welk woord zoeken we? \n" + woord.toString() + "\nGeef een letter:");
					if(letterString.length() == 1)
						break;
					else{
						boolean goeieGok = false;
						while(goeieGok == false){
							letterString = JOptionPane.showInputDialog("We zoeken een LETTER! \nRarara, welk woord zoeken we? \n" + woord.toString() + "\nGeef een letter:");
							if(letterString.length() == 1)
								goeieGok = true;
						}
					}
					break;
				case 2:
					letterString = JOptionPane.showInputDialog("Rarara, welk woord zoeken we? \n" + woord.toString() + "\nGeef een letter:");
					if(letterString.length() == 1)
						break;
					else{
						boolean goeieGok = false;
						while(goeieGok == false){
							letterString = JOptionPane.showInputDialog("We zoeken een LETTER! \nRarara, welk woord zoeken we? \n" + woord.toString() + "\nGeef een letter:");
							if(letterString.length() == 1)
								goeieGok = true;
						}
					}
					break;
					default: throw new UiException("Default exception at SwitchCase in playfunction");
			}
			
			boolean geraden = woord.raad(letterString.charAt(0));
			if(geraden){
				vorigeRonde = 1;
				i--;
				letters.add(letterString);
			}
			else
				vorigeRonde = 2;
			if(woord.isGeraden()){
				speler.addToScore(1);
				String[] jaNee = {"Ja", "Nee"};
				String opnieuw = JOptionPane.showInputDialog(jaNee, "Gefeliciteerd! U heeft gewonnen! \nWilt u nog eens spelen?");
				if(opnieuw.equals("Ja"))
					play();
				else{
					System.out.println("goed gespeeld, gefeliciteerd!");
					System.out.println("Uw score was: " + speler.getScore());
					System.exit(0);
				}
			}
		}
		String[] jaNee = {"Ja", "Nee"};
		String opnieuw = JOptionPane.showInputDialog(jaNee, "Jammer! U heeft Verloren!\nHet juiste woord was "+woord.getWoord() + "\nWilt u nog eens spelen?");
		if(opnieuw.equals("Ja"))
			play();
		else{
			System.out.println("Volgende keer beter");
			System.out.println("Uw score was: " + speler.getScore());
			System.exit(0);
		}
	}
}