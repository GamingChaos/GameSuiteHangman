package domain;

import java.util.ArrayList;
import java.util.List;

public class TekeningHangMan {
	private List<Vorm> vormen = new ArrayList<Vorm>();

	public TekeningHangMan() {
		vormen = new ArrayList<Vorm>();

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
		if (getAantalZichtbare().size() == vormen.size())
			throw new DomainException("Alles is al zichtbaar");
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
}
