package repositorios;

import entidades.Medicamento;

public class MedicamentoRepositorio extends CrudRepositorio<Medicamento> {
    @Override
    public boolean atualizar(Medicamento medicamento, Medicamento novaEntidade) {
        return false;
    }
}
