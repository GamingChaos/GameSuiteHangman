package domain;

public class LijnStuk extends Vorm {
private Punt start;
private Punt einde;
	public LijnStuk(Punt start, Punt einde) {
		setStartEnEindPunt(start,einde);
	}

	public void setStartEnEindPunt(Punt start, Punt einde) {
		if(start == null || einde == null)throw new DomainException("Start en einde mag niet null zij!");
		if(start.equals(einde))throw new DomainException("startpunt mag niet gelijk zijn aan eind punt!"); 

		this.start = start;
		this.einde =einde;
		
	}

	public Punt getStartPunt() {
		
		return start;
	}

	public Punt getEindPunt() {
		return einde;
	}
	
	@Override
	public boolean equals(Object o){
		boolean result =false;
		if(o instanceof LijnStuk){
			LijnStuk L =(LijnStuk)o;
			if(this.getStartPunt().equals(L.getStartPunt()) && this.getEindPunt().equals(L.getEindPunt())){
				result = true;
			}
		}
		return result;
	}
	@Override
	public String toString(){
		String info;
		info = "start: " + start + "\n einde: " + einde;	
		return info;
	}
}
