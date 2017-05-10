package domain;

public class LijnStuk extends Vorm implements Drawable {
	//Maak variabelen voor Lijnstuk
	private Punt start, einde;
	
	//Lijnstuk constructor voor start en einde gegeven
	public LijnStuk(Punt start, Punt einde) {
		setStartEnEindPunt(start,einde);
	}
	//Zet start en eindepunt variabelen
	public void setStartEnEindPunt(Punt start, Punt einde) throws DomainException {
		//Test of start en einde geldig zijn
		if(start == null || einde == null)throw new DomainException("Start en einde mag niet null zijn!");
		//Test of startpunt != eindpunt
		if(start.equals(einde))throw new DomainException("startpunt mag niet gelijk zijn aan eind punt!"); 
		this.start = start;
		this.einde =einde;
		
	}
	//Geef startpunt terug
	public Punt getStartPunt() {
		return start;
	}
	//Geef eindpunt terug
	public Punt getEindPunt() {
		return einde;
	}
	
	@Override
	public boolean equals(Object o){
		boolean result =false;
		if(o instanceof LijnStuk){
			LijnStuk l =(LijnStuk)o;
			//Als start en eindpunt gelij zijn
			if(this.getStartPunt().equals(l.getStartPunt()) && this.getEindPunt().equals(l.getEindPunt())){
				result = true;
			}
		}
		return result;
	}
	@Override
	public String toString(){
		return "start: " + start + "\n einde: " + einde;
	}
	@Override
	public Omhullende getOmhullende() {
		return new Omhullende(new Punt(minX(), minY()), einde.getX() - start.getX(), maxY() - minY() );
	}
	
	private int minX()
	{
		return start.getX() < einde.getX() ? start.getX() : einde.getX();
	}
	
	private int minY()
	{
		return start.getY() < einde.getY() ? start.getY() : einde.getY();
	}
	
	private int maxX()
	{
		return start.getX() > einde.getX() ? start.getX() : einde.getX();
	}
	
	private int maxY()
	{
		return start.getY() > einde.getY() ? start.getY() : einde.getY();
	}
}
