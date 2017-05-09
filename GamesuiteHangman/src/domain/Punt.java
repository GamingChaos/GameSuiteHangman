package domain;

public class Punt {
	private int x = 0;
	private int y = 0;
	public Punt(int x, int y ){
		this.setX(x);
		this.setY(y);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public boolean equals(Object o){
		if(o instanceof Punt){
			Punt p = (Punt) o;
			if(this.getX() == p.getX() && this.getY() == p.getY()) return true;
			
		}
		return false;
	}
	@Override
	public String toString(){
		return "(" + getX() + ", " + getY() + ")";
	}
}
