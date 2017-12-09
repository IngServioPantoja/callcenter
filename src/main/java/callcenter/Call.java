package callcenter;

import java.io.Serializable;

public class Call implements Serializable {

	private static final long serialVersionUID = 1L;

	// ------------------------------ FIELDS ------------------------------

	private int duration;

	private int number;

	// --------------------------- CONSTRUCTORS ---------------------------

	public Call(int number, int duration) {
		this.number = number;
		this.duration = duration;
	}

	// --------------------- GETTER / SETTER METHODS ---------------------

	public int getDuration() {
		return duration;
	}

	public int getNumber() {
		return number;
	}
}
