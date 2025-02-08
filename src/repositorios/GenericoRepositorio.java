package repositorios;

import java.util.ArrayList;

public abstract class GenericoRepositorio<T> {

    // Lista de entidades
    private final ArrayList<T> lista = new ArrayList<>();

    // Retorna a lista de entidades
    public ArrayList<T> listar() {
        return lista;
    }

    // Adiciona uma nova entidade à lista de entidades
    public void salvar(T t) {
        listar().add(t);
    }

    // Busca uma entidade pelo identificador
    public abstract T buscar(String identificador);

    // Percorre a lista de entidades, quando encontrar a entidade mencionada, a substitui totalmente
    //public abstract void atualizar(T t, T novaT);

    // Remove uma entidade da lista de entidades
    public boolean remover(T t) {
        return listar().remove(t);
    }
}
