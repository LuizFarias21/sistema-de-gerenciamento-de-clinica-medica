package servicos;

import java.util.ArrayList;

public class BaseServico<Entidade> {

    private final ArrayList<Entidade> listaEntidades = new ArrayList<>();

    // Adicionar uma nova entidade na lista de entidades
    public void salvar(Entidade entidade) {
        if (entidade != null) {
            listaEntidades.add(entidade);
        }
    }

    // Buscar uma entidade pelo identificador
    public Entidade buscar(String identificador){
        return null;
    }

    // Atualizar uma entidade pelo identificador com sua nova entidade
    public boolean atualizar(Entidade entidade, Entidade novaEntidade) {
        return false;
    }

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
