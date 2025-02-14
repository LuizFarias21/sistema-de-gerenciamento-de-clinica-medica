package controladores;

public class TratamentoControlador<TipoEntidade> extends GenericoControlador<TipoEntidade> {
    @Override
    public void listar() {

    }

    @Override
    public TipoEntidade buscar(String identificador) {
        return null;
    }

    @Override
    public void atualizar() {

    }

    @Override
    public void remover(String identificador) {

    }

    // Aqui vai ficar métodos comuns a todos os controladores, provavelmente o buscar ou algo do tipo..
}
