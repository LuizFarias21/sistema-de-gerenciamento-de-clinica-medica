package repositorios;

import entidades.Paciente;

import java.util.ArrayList;

public abstract class BaseRepositorio<Entidade> {

    private final ArrayList<Entidade> lista = new ArrayList<>();

    // Adicionar uma nova entidade na lista de entidades
    public void salvar(Entidade entidade) {
//        if (entidade != null) {
//            lista.add(entidade);
//        }
        lista.add(entidade);
    }

    // Buscar uma entidade pelo identificador
    public Entidade buscar(String identificador) {
        int id = Integer.parseInt(identificador);
        return lista.get(++id);
    }

    public ArrayList<Entidade> listar() {
        return lista;
    }

    // Atualizar uma entidade pelo identificador com sua nova entidade
    public abstract void atualizar(Entidade entidade, Entidade novaEntidade);

    // Remover entidade da lista de entidades
    public boolean remover(Entidade entidade) {

        if (entidade != null) {
            getLista().remove(entidade);
            return true;
        }

        return false;
    }

    public ArrayList<Entidade> getLista() {
        return lista;
    }
}
