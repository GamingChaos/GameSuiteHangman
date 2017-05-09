package domain;

public class Driehoek {
	private Punt punt1, punt2, punt3;
	public Driehoek(Punt punt1, Punt punt2, Punt punt3){
		setHoekPunten(punt1, punt2, punt3);
			
		
	}
	private void setHoekPunten(Punt punt1, Punt punt2, Punt punt3) {
		if(punt1 == null || punt2 == null || punt3 == null) throw new DomainException("punten mogen niet null zijn");
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
}
