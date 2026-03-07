package exceptions;

public class TipoInvalidoException extends IllegalArgumentException {

    public TipoInvalidoException() {
        super("Tipo inválido");
    }

    public TipoInvalidoException(String s) {
        super(s);
    }

    public TipoInvalidoException(String message, Throwable causa) {
        super(message, causa);
    }
}
