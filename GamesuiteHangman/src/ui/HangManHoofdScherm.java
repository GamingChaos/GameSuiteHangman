package ui;

import java.awt.BorderLayout;

import domain.HangMan;

public class HangManHoofdScherm extends GameMainWindow {

	private static final long serialVersionUID = 1L;
	private HangMan spel; 
	
	public HangManHoofdScherm(HangMan spel, HangmanPaneel spelpaneel){
		super("Hangman - "+spel.getSpeler().getNaam(), spel.getTekening());	
		
		spelpaneel.setTekenVenster(getTekenvenster());
		this.add(spelpaneel, BorderLayout.SOUTH);
	}
	
	public void start() {
		this.pack();
		this.setVisible(true);		
	}
}