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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JOptionPane;

import db.WoordLezer;
import domain.HintWoord;
import domain.Speler;
import domain.Tekening;
import domain.TekeningHangMan;
import domain.WoordenLijst;

public class HangManUI {
	private Tekening tekening;
	private Speler speler;
	private ArrayList<String> letters;
	private GameMainWindow view;
	
	public HangManUI(Speler speler){
		this.tekening = new TekeningHangMan(speler.getNaam());
		letters = new ArrayList<String>();
		view = new GameMainWindow(speler.getNaam(), tekening);
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
		int aantalFout = 0;
		
		while(aantalFout <= 12){
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
			for(String s : letters){
				if(s.equals(letterString)){
					aantalFout--;
				}
			}
			boolean geraden = woord.raad(letterString.charAt(0));
			if(geraden)
				vorigeRonde = 1;
			else{
				vorigeRonde = 2;
				aantalFout++;
				view.raiseAantalFout();
			}
			view.teken();
			if(woord.isGeraden()){
				File soundfile = new File("applause-01.wav");
				try{
					//info geven over soundfile
					//haal het geluid uit soundfile
					AudioInputStream soundFormatLenght = AudioSystem.getAudioInputStream(soundfile);
					//zoek de lengte en het formaat soundFormatLenght, zorgt ervoor dat we kunnen starten en stoppen
					DataLine.Info info = new DataLine.Info(Clip.class, soundFormatLenght.getFormat());
					//zet het geluid in het geheugen 
					//een clip = een audiobestand dat kan worden geladen voor het wordt afgespeeld
					//geef een clip een lengte en formaat
					Clip clip = (Clip) AudioSystem.getLine(info);
					//zet het audiobestand in de clip
					clip.open(soundFormatLenght);
					//start de clip
					clip.start();
				}
				catch (Exception e) {
		               throw new UiException(e);
		        }
				
				this.speler.addToScore(1);
				String[] jaNee = {"Ja", "Nee"};
				String opnieuw = (String) JOptionPane.showInputDialog(null, "Gefeliciteerd! U heeft gewonnen! \nWilt u nog eens spelen?", "Super Awesome Mega Game", JOptionPane.QUESTION_MESSAGE, null, jaNee, jaNee[0]);
				if(opnieuw.equals("Ja")){
					view.resetAantalFout();
					view.teken();
					play();
				}
				else{
					System.out.println("goed gespeeld, gefeliciteerd!");
					System.out.println("Uw score was: " + speler.getScore());
					System.exit(0);
				}
			}
		}
		String[] jaNee = {"Ja", "Nee"};
		String opnieuw = (String) JOptionPane.showInputDialog(null, "Jammer! U heeft verloren! \nWilt u nog eens spelen?", "Super Awesome Mega Game", JOptionPane.QUESTION_MESSAGE, null, jaNee, jaNee[0]);
		if(opnieuw.equals("Ja"))
			play();
		else{
			System.out.println("Volgende keer beter");
			System.out.println("Uw score was: " + speler.getScore());
			System.exit(0);
		}
	}
}
