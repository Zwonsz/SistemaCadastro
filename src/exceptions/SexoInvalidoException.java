package exceptions;

public class SexoInvalidoException extends RuntimeException {

    public SexoInvalidoException() {
        super("Sexo digitado inválido");
    }

    public SexoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public SexoInvalidoException(String message) {
        super(message);
    }
}
