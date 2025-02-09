package repositorios;

public class ClinicaRepositorio<TipoEntidade> extends GenericoRepositorio<TipoEntidade> {

    @Override
    public TipoEntidade buscar(String identificador) {
        int id = Integer.parseInt(identificador);
        return listar().get(id);
    }

//    @Override
//    public void atualizar(T t, T novaT) {
//
//    }
}
