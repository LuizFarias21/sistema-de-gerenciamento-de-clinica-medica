package repositorios;

import entidades.Tratamento;

public abstract class TratamentoRepositorio<TipoTratamento extends Tratamento> extends GenericoRepositorio<TipoTratamento> {

    @Override
    public TipoTratamento buscar(String id) {
        for (TipoTratamento tratamento : getLista()) {
            boolean idCorrespondente = tratamento.getId().equals(id);
            if (idCorrespondente) return tratamento;
        }
        return null;
    }
}