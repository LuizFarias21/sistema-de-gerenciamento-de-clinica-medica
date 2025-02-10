package servicos;

import excecoes.DadoInvalidoException;

import java.util.ArrayList;

public class ClinicaServico<TipoEntidade> extends GenericoServico<TipoEntidade> {

    @Override
    public void cadastrar(TipoEntidade entidade) throws DadoInvalidoException {

    }

    @Override
    public TipoEntidade buscar(String identificador) throws DadoInvalidoException {
        return null;
    }

    @Override
    public ArrayList<TipoEntidade> listar() throws DadoInvalidoException {
        return null;
    }

    @Override
    public boolean atualizar(TipoEntidade entidade, TipoEntidade novaEntidade) throws DadoInvalidoException {
        return false;
    }

    @Override
    public void excluir(String identificador) throws DadoInvalidoException {

    }
}
