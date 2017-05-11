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

public class WoordLezer {
	private WoordenLijst lijst;
	
	public WoordLezer(String bestand) throws FileNotFoundException
	{
		Scanner s = new Scanner(new File("hangman.txt"));
		lijst = new WoordenLijst();
		
		while(s.hasNext())
			lijst.voegToe(s.nextLine());
		
		s.close();
	}
	
	public WoordenLijst lees()
	{
		return lijst;
	}
}
