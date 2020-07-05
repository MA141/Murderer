package all;

public class InvalidInput extends Exception {
	private static final long serialVersionUID = -3253783497875164380L;

	public InvalidInput() {
	      super();
	   }

	   public InvalidInput(String message) {
	      super(message);
	   }
}