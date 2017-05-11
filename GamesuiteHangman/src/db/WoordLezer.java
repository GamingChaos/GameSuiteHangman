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
 void woordenLezer(String bestand)throws FileNotFoundException{
		
		File hangmanWoorden = new File("hangman.txt");
		Scanner scannerFile = new Scanner(hangmanWoorden);
		Scanner scannerLijn = new Scanner(scannerFile.nextLine());
		
		while(scannerLijn.hasNext()){
			WoordenLijst woordenLijst = new WoordenLijst();
			woordenLijst.voegToe(scannerLijn.nextLine());
			
		}
		
	}
 
 

}
