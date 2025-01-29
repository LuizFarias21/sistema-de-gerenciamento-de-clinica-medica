package servicos;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class ServicosCrud<T> {
    protected ArrayList<T> lista = new ArrayList<>();

    public abstract void adicionar(T objeto);

    public abstract T buscar(String cpf);

    public abstract void remover(String cpf);
}
