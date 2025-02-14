package repositorios;

import java.util.ArrayList;

public abstract class GenericoRepositorio<TipoEntidade> {

    private final ArrayList<TipoEntidade> lista = new ArrayList<>();

    // Retorna a lista de entidades
    public ArrayList<TipoEntidade> listar() {
        return lista;
    }

    // Adiciona uma entidade para a lista
    public void cadastrar(TipoEntidade entidade) {
        listar().add(entidade);
    }

    // Busca uma entidade pelo identificador e retorna o objeto encontrado
    public abstract TipoEntidade buscar(String identificador);

    // Modifica dados já existentes das entidades
    public abstract void atualizar(TipoEntidade entidade, TipoEntidade novaEntidade);

    // Deleta entidade da lista de entidades
    public boolean remover(TipoEntidade entidade) {
        return listar().remove(entidade);
    }
}