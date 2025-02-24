package controladores;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class GenericoControlador<TipoEntidade> {

    //public abstract String listar(ArrayList<TipoEntidade> listaEntidades);

    public abstract void cadastrar();

    public abstract TipoEntidade buscar();
    //public abstract TipoEntidade buscar(String identificador);

    public abstract void atualizar();

    public abstract void remover();
}
