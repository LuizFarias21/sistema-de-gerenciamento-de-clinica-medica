package repositorios;

import entidades.Tratamento;

public abstract class TratamentoRepositorio<TipoTratamento extends Tratamento> extends GenericoRepositorio<TipoTratamento> {

    @Override
    public TipoTratamento buscar(String id) {
        for (TipoTratamento tratamento : listar()) {
            if (tratamento.getId().equals(id)) return tratamento;
        }
        return null;
    }
}
