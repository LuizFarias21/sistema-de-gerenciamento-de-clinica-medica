package servicos;

import excecoes.DadoInvalidoException;
import java.util.ArrayList;

public abstract class GenericoServico<TipoEntidade> {

    public abstract void cadastrar(TipoEntidade entidade) throws DadoInvalidoException;

    public abstract TipoEntidade buscar(String identificador) throws DadoInvalidoException;

    public abstract ArrayList<TipoEntidade> listar() throws DadoInvalidoException;

    public abstract boolean atualizar(TipoEntidade entidade, TipoEntidade novaEntidade) throws DadoInvalidoException;

    public abstract void excluir(String identificador) throws DadoInvalidoException;
}
