package repositorios;

import entidades.Consulta;

public class ConsultaRepositorio extends CrudRepositorio<Consulta> {
    @Override
    public boolean atualizar(Consulta consulta, Consulta novaEntidade) {
        return false;
    }
}
