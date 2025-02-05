package repositorios;

import entidades.Exame;

public class ExameRepositorio extends CrudRepositorio<Exame> {
    @Override
    public boolean atualizar(Exame exame, Exame novaEntidade) {
        return false;
    }
}
