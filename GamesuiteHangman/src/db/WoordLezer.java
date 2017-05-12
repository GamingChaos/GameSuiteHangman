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

package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import domain.WoordenLijst;
//juiste versie
public class WoordLezer {
	private WoordenLijst lijst;
	private String bestand;
	
	public WoordLezer(String bestand) 
	{
		this.bestand = bestand;
	}
	
	public WoordenLijst lees() throws FileNotFoundException
	{
		Scanner s = new Scanner(new File(bestand));
		lijst = new WoordenLijst();
		
		while(s.hasNext())
			lijst.voegToe(s.nextLine());
		
		s.close();
		return lijst;
	}
}
