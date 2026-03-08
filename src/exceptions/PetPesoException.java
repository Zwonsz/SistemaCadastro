package exceptions;

public class PetPesoException extends IllegalArgumentException {
    public PetPesoException(String message) {
        super(message);

    }

    public PetPesoException() {
        super("Peso do inválido");
    }
}
