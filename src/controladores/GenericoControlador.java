package controladores;

import java.time.LocalDate;

public abstract class GenericoControlador<TipoEntidade> {

    public abstract String listar();

    public abstract void cadastrar();

    public abstract TipoEntidade buscar();
    //public abstract TipoEntidade buscar(String identificador);

    public abstract void atualizar();

    public abstract void remover();
}
