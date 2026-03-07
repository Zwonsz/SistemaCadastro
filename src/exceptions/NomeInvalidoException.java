package exceptions;

public class NomeInvalidoException extends IllegalArgumentException {

    public NomeInvalidoException() {
        super("Nome digitado inválido");
    }

    public NomeInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public NomeInvalidoException(String message) {

        super(message);

    }
}
