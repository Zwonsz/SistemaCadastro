package exceptions;

public class ListaVaziaException extends RuntimeException {

    public ListaVaziaException(){
        super("Lista vazia");
    }

    public ListaVaziaException(String message) {
        super(message);
    }
}
