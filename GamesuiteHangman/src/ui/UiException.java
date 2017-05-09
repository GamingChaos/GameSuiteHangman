package ui;

public class UiException extends RuntimeException {
	public UiException(Exception exception){
		super(exception);
	}
	
	public UiException(String message){
		super(message);
	}
}
