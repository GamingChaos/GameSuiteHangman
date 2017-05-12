package db;

import java.io.*;
import java.util.Scanner;

import domain.DomainException;
import ui.UiException;

public class HighScoresWriter {
	File highScore;
	
	public HighScoresWriter(){
		highScore = new File("highScores.txt");
		try {
			PrintWriter writer = new PrintWriter(highScore);
			if(!highScore.exists()){
				highScore.createNewFile();
				writer.println("De highscores zijn:");
				writer.close();
			}
		} 
		catch (FileNotFoundException fnf) {
			throw new UiException(fnf);
		}
		catch (IOException e) {
			throw new UiException(e);
		}
	}
	
	public void writeHighScore(String score){
		PrintWriter writer;
		try {
			writer = new PrintWriter(highScore);
			writer.println(score);
			writer.close();
		} 
		catch (FileNotFoundException e) {
			throw new UiException(e);
		}
	}
	
	public void scanHightScore(String naam){
		try{
			Scanner scannerFile = new Scanner(highScore);
			boolean gevonden = false;
				while(gevonden == false && scannerFile.hasNextLine()){
					Scanner scannerLijn = new Scanner(scannerFile.nextLine());
					scannerLijn.useDelimiter("/");
					String spelerNaam = scannerLijn.next();
					if(spelerNaam.equals(naam))
						gevonden = true;
				}
		}
		catch(FileNotFoundException fnf){
			throw new UiException(fnf);
		}
	}
}
