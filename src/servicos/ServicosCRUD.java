package servicos;

import java.util.ArrayList;

public abstract class ServicosCRUD<T> {

    public ArrayList<T> lista = new ArrayList<>();

    public abstract void adicionar(T objeto);

    public abstract T buscar(String ID);

    public abstract void atualizar(String ID, T novo);

    public abstract void remover(String ID);
}

