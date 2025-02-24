package servicos;

import entidades.Exame;
import excecoes.DadoInvalidoException;
import repositorios.ExameRepositorio;
import repositorios.TratamentoRepositorio;

public class ExameServico extends TratamentoServico<Exame> {

    private ExameRepositorio exameRepositorio;

    public ExameServico(ExameRepositorio exameRepositorio) {
        super(exameRepositorio);
        this.exameRepositorio = exameRepositorio;
    }
}
