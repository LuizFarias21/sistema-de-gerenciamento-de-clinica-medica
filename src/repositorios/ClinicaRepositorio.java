package repositorios;

public class ClinicaRepositorio<T> extends BaseRepositorio<T> {

    @Override
    public T buscar(String identificador) {
        int id = Integer.parseInt(identificador);
        return listar().get(id);
    }
}
