package excecoes;
import entidades.Pessoa;

public class CadastroBloqueadoException extends Exception {
    public CadastroBloqueadoException(Pessoa pessoa) {
        super("O CPF: " + pessoa.getCpf() + " ja consta no registro de pacientes.");
    }
}
