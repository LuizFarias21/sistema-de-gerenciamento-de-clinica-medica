package controladores;

public abstract class GenericoControlador<TipoEntidade> {

    public abstract void listar();

    //public abstract void cadastrar();

    public abstract TipoEntidade buscar(String identificador);

    public abstract void atualizar();

    public abstract void remover(String identificador);
}
