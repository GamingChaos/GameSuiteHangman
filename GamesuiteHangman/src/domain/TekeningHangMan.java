package domain;

import java.util.ArrayList;
import java.util.List;

public class TekeningHangMan extends Tekening {
	private List<Vorm> vormen = new ArrayList<Vorm>();

	public TekeningHangMan(String naam) {
		super(naam);
		vormen = new ArrayList<Vorm>();

		Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);
		vormen.add(galgBodem);
		Vorm galgstaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));
		vormen.add(galgstaaf);
		Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));
		vormen.add(hangbar);
		Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));
		vormen.add(koord);
		Vorm hoofd = new Cirkel(new Punt(280, 125), 25);
		vormen.add(hoofd);
		Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
		vormen.add(lijf);
		Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
		vormen.add(beenLinks);
		Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
		vormen.add(beenRechts);
		Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
		vormen.add(voetLinks);
		Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
		vormen.add(voetRechts);
		Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
		vormen.add(armLinks);
		Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
		vormen.add(armRechts);
		Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
		vormen.add(handLinks);
		Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
		vormen.add(handRechts);
	}

	public void voegVormToe(Vorm vorm) {
		if (vorm == null)
			throw new DomainException("vorm moet bestaan");
	
		vormen.add(vorm);
	}

	public List getLijst() {
		return vormen;
	}

	public int getGrootte() {
		return vormen.size();
	}

	public List getAantalZichtbare() {
		List zichtbare = new ArrayList<Vorm>();
		
		for (Vorm vorm : vormen) {
			if (vorm.isZichtbaar())
				zichtbare.add(vorm);
		}
		
		return zichtbare;
	}

	public void zetVolgendeZichtbaar() {
		if (getAantalZichtbare().size() == vormen.size()) throw new DomainException("Alles is al zichtbaar");
		
		for (Vorm vorm : vormen) {
			if (vorm.isZichtbaar() == false) {
				vorm.setZichtbaarheid(true);
				break;
			}
		}
	}
	public Vorm getVorm(int index){
		return vormen.get(index);
	}

	public void reset() {
		for (int i = 3; i < vormen.size(); i++) {
			if (vormen.get(i).isZichtbaar() == true) {
				vormen.get(i).setZichtbaarheid(false);
			}
		}

	}
	
	public void verwijder(Vorm vorm){
		if(!vormen.contains(vorm)) throw new DomainException("Vorm zit niet in de lijst");
		vormen.remove(vorm);
	}

	public int getAantalOnzichtbaar() {
		int temp = 0;
		for(Vorm vorm: vormen){
			if(vorm.isZichtbaar() == false){
				temp++;
			}
		}
		return temp;
	}
}
