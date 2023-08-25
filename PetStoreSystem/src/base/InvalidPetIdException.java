package base;

import java.lang.Exception;

public class InvalidPetIdException extends Exception {
	public InvalidPetIdException(String message) {
		super(message);
	}
}
