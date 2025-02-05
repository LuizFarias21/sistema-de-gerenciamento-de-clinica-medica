package repositorios;

import java.util.ArrayList;

public abstract class CrudRepositorio<Entidade> {

    private final ArrayList<Entidade> listaEntidades = new ArrayList<>();

    // Adicionar uma nova entidade na lista de entidades
    public void salvar(Entidade entidade) {
        if (entidade != null) {
            listaEntidades.add(entidade);
        }
    }

    // Buscar uma entidade pelo identificador
    public Entidade buscar(String identificador){
        int id = Integer.parseInt(identificador);
        return listaEntidades.get(++id);
    }

    // Atualizar uma entidade pelo identificador com sua nova entidade
    public abstract boolean atualizar(Entidade entidade, Entidade novaEntidade);

    // Remover entidade da lista de entidades
    public boolean remover(Entidade entidade) {

        if (entidade != null) {
            getListaEntidades().remove(entidade);
            return true;
        }

        return false;
    }

    public ArrayList<Entidade> getListaEntidades() {
        return listaEntidades;
    }

}
