package domain;

public class DomainException extends RuntimeException{
	public DomainException(Exception exception){
		super(exception);
	}
	
	public DomainException(String message){
		super(message);
	}
}