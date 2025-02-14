package servicos;

import entidades.Tratamento;
import excecoes.DadoInvalidoException;
import repositorios.TratamentoRepositorio;

public abstract class TratamentoServico<TipoTratamento extends Tratamento> extends GenericoServico<TipoTratamento> {

    private TratamentoRepositorio<TipoTratamento> tratamentoRepositorio;

    public TratamentoServico(TratamentoRepositorio<TipoTratamento> tratamentoRepositorio) {
        super(tratamentoRepositorio);
        this.tratamentoRepositorio = tratamentoRepositorio;
    }

    @Override
    public void cadastrar(TipoTratamento tratamento) throws DadoInvalidoException {
        if (tratamento != null) tratamentoRepositorio.cadastrar(tratamento);
        throw new DadoInvalidoException("Dados não válidos!");
    }

    @Override
    public TipoTratamento buscar(String identificador) throws DadoInvalidoException {
        TipoTratamento tratamento = tratamentoRepositorio.buscar(identificador);
        if (tratamento == null) throw new DadoInvalidoException("Nenhum tratamento encontrado!");
        return tratamento;
    }

    @Override
    public void remover(String identificador) throws DadoInvalidoException {
        TipoTratamento tratamento = tratamentoRepositorio.buscar(identificador);
        if (tratamento == null) throw new DadoInvalidoException("Nenhum tratamento encontrado!");
        tratamentoRepositorio.remover(tratamento);
    }
}
