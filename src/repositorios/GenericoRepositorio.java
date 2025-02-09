package repositorios;

import java.util.ArrayList;

public abstract class GenericoRepositorio<TipoEntidade> {

    private final ArrayList<TipoEntidade> lista = new ArrayList<>();

    public ArrayList<TipoEntidade> listar() {
        return lista;
    }

    public void salvar(TipoEntidade entidade) {
        listar().add(entidade);
    }

    public abstract TipoEntidade buscar(String identificador);

    //public abstract void atualizar(T t, T novaT);

    public boolean remover(TipoEntidade entidade) {
        return listar().remove(entidade);
    }
}
