package repositorios;

import java.util.ArrayList;

public abstract class GenericoRepositorio<TipoEntidade> {
    private final ArrayList<TipoEntidade> lista = new ArrayList<>();

    public void cadastrar(TipoEntidade entidade) {
        lista.add(entidade);
    }

    protected abstract TipoEntidade buscar(String identificador);

    public void atualizar(TipoEntidade entidade, TipoEntidade novaEntidade) {
        lista.set(getLista().indexOf(entidade), novaEntidade);
    }

    public void remover(TipoEntidade entidade) {
        lista.remove(entidade);
    }

    public ArrayList<TipoEntidade> getLista() {
        return lista;
    }
}