package servicos;

import entidades.Tratamento;
import excecoes.DadoInvalidoException;
import repositorios.TratamentoRepositorio;

public abstract class TratamentoServico<TipoTratamento extends Tratamento> extends GenericoServico<TipoTratamento> {

    private final TratamentoRepositorio<TipoTratamento> tratamentoRepositorio;

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
        verificarTratamentoNulo(tratamento);
        return tratamento;
    }

    @Override
    public void atualizar(TipoTratamento tratamento, TipoTratamento novoTratamento) throws DadoInvalidoException {
        verificarTratamentoNulo(tratamento);
        tratamentoRepositorio.atualizar(tratamento, novoTratamento);
    }

    @Override
    public void remover(String identificador) throws DadoInvalidoException {
        TipoTratamento tratamento = tratamentoRepositorio.buscar(identificador);
        verificarTratamentoNulo(tratamento);
        tratamentoRepositorio.remover(tratamento);
    }

    public void verificarTratamentoNulo(Tratamento tratamento) throws DadoInvalidoException {
        if (tratamento == null) throw new DadoInvalidoException("Nenhum tratamento encontrado!");
    }
}
