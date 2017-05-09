package domain;

public class Driehoek {
	private Punt punt1, punt2, punt3;
	public Driehoek(Punt punt1, Punt punt2, Punt punt3){
		setHoekPunten(punt1, punt2, punt3);
			
		
	}
	private void setHoekPunten(Punt punt1, Punt punt2, Punt punt3) {
		if(punt1 == null || punt2 == null || punt3 == null) throw new DomainException("punten mogen niet null zijn");
		if(punt1.equals(punt2) || punt1.equals(punt3) || punt2.equals(punt3)) throw new DomainException("punten mogen niet hetzelfde zijn!");
		if((punt2.getX() - punt1.getX())*(punt3.getY() - punt1.getY()) == (punt3.getX() - punt1.getX())*(punt2.getY() - punt1.getY())) throw new DomainException("Punten mogen niet op een lijn liggen");
		this.punt1 = punt1;
		this.punt2 = punt2;
		this.punt3 = punt3;
		
	}
	
	public Punt getHoekPunt1(){
		return punt1;
	}
	public Punt getHoekPunt2(){
		return punt2;
		
	}
	public Punt getHoekPunt3(){
		return punt3;
	}
	@Override
	public boolean equals(Object o){
		if(o instanceof Driehoek){
			Driehoek d = (Driehoek) o;
			if(getHoekPunt1() == d.getHoekPunt1() || getHoekPunt1() == d.getHoekPunt2() || getHoekPunt1() == d.getHoekPunt3() && getHoekPunt2() == d.getHoekPunt2()|| getHoekPunt2() == d.getHoekPunt1() || getHoekPunt2() == d.getHoekPunt3() && getHoekPunt3() == d.getHoekPunt3() || getHoekPunt3() == d.getHoekPunt1() || getHoekPunt3() == d.getHoekPunt2()) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString(){
		return "Driehoek: hoekpunt1: " + getHoekPunt1().toString() + " - hoekpunt2: " + getHoekPunt2().toString() + " - hoekpunt3: " + getHoekPunt3().toString(); 
	}
}
