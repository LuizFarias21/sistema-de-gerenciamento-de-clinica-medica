package visoes;

import controladores.PessoaControlador;
import entidades.Pessoa;

public abstract class PessoaVisao<TipoPessoa extends Pessoa> extends GenericoVisao<TipoPessoa> {

    private PessoaControlador<TipoPessoa> pessoaControlador;

    public PessoaVisao(PessoaControlador<TipoPessoa> pessoaControlador) {
        this.pessoaControlador = pessoaControlador;
    }

    @Override
    public void cadastrar() {
        pessoaControlador.cadastrar();
    }

    @Override
    public void buscar() {
        pessoaControlador.buscar();
    }

//    @Override
//    public void listar() {
//        pessoaControlador.listar();
//    }

    @Override
    public void atualizar() {
        pessoaControlador.atualizar();
    }

    @Override
    public void remover() {
        pessoaControlador.remover();
    }
}
