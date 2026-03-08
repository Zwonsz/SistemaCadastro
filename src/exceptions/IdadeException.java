package exceptions;

public class IdadeException extends IllegalArgumentException {

    public IdadeException() {
        super("Idade inválida");
    }

    public IdadeException(String message) {
        super(message);
    }
}
