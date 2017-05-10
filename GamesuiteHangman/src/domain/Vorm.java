package domain;

public abstract class  Vorm implements Drawable {
	
	
	
	public abstract Omhullende getomhullende();
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Vorm){
			Vorm v = (Vorm) o;
			if(getomhullende() == v.getomhullende()) return true;
			
			
			
			}
		return false;
		}

	@Override
	public abstract String toString();
	}

