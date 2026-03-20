package exceptions;

public class SalvarArquivoException extends RuntimeException {

    public SalvarArquivoException(){
        super("Erro ao salvar arquivo");
    }

    public SalvarArquivoException(String message) {
        super(message);
    }
}
