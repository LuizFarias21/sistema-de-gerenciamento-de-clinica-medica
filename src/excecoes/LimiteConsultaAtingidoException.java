package excecoes;

public class LimiteConsultaAtingidoException extends Exception {
    public LimiteConsultaAtingidoException() {
        super("Limite de consultas no dia atingidos!");
    }
}
