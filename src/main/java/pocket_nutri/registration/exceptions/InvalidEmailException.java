package pocket_nutri.registration.exceptions;

public class InvalidEmailException extends Exception {
    public InvalidEmailException() {
        super(String.format("The email is invalid!"));

    }

}
