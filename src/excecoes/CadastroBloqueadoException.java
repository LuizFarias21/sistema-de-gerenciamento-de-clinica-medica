package excecoes;
import entidades.Pessoa;
import servicos.PessoaServico;

public class CadastroBloqueadoException extends Exception {
    public CadastroBloqueadoException(Pessoa pessoa, PessoaServico.ResultadoCPF resultado) {
        super("O cadastro da pessoa " + pessoa.getNome() + " foi bloqueado. Motivo: " + resultado);
    }
}
