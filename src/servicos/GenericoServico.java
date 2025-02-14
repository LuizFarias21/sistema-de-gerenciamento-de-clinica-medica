package servicos;

import excecoes.DadoInvalidoException;
import repositorios.GenericoRepositorio;

import java.util.ArrayList;

public abstract class GenericoServico<TipoEntidade> {

    private GenericoRepositorio<TipoEntidade> genericoRepositorio;

    public GenericoServico(GenericoRepositorio<TipoEntidade> genericoRepositorio) {
        this.genericoRepositorio = genericoRepositorio;
    }

    public ArrayList<TipoEntidade> listar() throws DadoInvalidoException {
        if (genericoRepositorio.listar().isEmpty()) {
            throw new DadoInvalidoException("Nenhum registro encontrado!");
        }
        return genericoRepositorio.listar();
    }

    public abstract void cadastrar(TipoEntidade entidade) throws DadoInvalidoException;

    public abstract TipoEntidade buscar(String identificador) throws DadoInvalidoException;

    public abstract void atualizar(TipoEntidade entidade, TipoEntidade novaEntidade) throws DadoInvalidoException;

    public void remover(String identificador) throws DadoInvalidoException {
        TipoEntidade entidade = buscar(identificador);
        genericoRepositorio.remover(entidade);
    }
}
