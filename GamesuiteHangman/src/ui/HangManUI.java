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
import domain.HintWoord;

public class HangManUi {
	public static void play(){
		HintWoord woord;
		try {
			woord = new HintWoord("krokodil");
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
			if(woord.isGeraden()){
				String[] jaNee = {"Ja", "Nee"};
				String opnieuw = JOptionPane.showInputDialog(jaNee, "Gefeliciteerd! U heeft gewonnen! \nWilt u nog eens spelen?");
				if(opnieuw.equals("Ja"))
					play();
				else{
					System.out.println("goed gespeeld, gefeliciteerd!");
					System.exit(0);
				}
			}
			boolean geraden = woord.raad(letterString.charAt(0));
			if(geraden)
				vorigeRonde = 1;
			else
				vorigeRonde = 2;
		}
		String[] jaNee = {"Ja", "Nee"};
		String opnieuw = JOptionPane.showInputDialog(jaNee, "Jammer! U heeft Verloren! \nWilt u nog eens spelen?");
		if(opnieuw.equals("Ja"))
			play();
		else{
			System.out.println("Volgende keer beter");
			System.exit(0);
		}
	}
}
