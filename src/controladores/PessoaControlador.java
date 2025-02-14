package controladores;

import entidades.Paciente;
import entidades.Pessoa;
import excecoes.DadoInvalidoException;
import servicos.PessoaServico;
import visoes.GenericoVisao;

import java.util.ArrayList;

public abstract class PessoaControlador<TipoPessoa extends Pessoa> extends GenericoControlador<TipoPessoa> {

    private PessoaServico<TipoPessoa> pessoaServico;

    public PessoaControlador(PessoaServico<TipoPessoa> pessoaServico) {
        this.pessoaServico = pessoaServico;
    }

    @Override
    public void listar() {
        String mensagem = "";

        try {

            ArrayList<TipoPessoa> listaPessoas = pessoaServico.listar();

            for (TipoPessoa pessoa : listaPessoas) {
                mensagem +=  pessoa.getCpf() + " - " + pessoa.getNome() + "\n";
                mensagem += "---------------------------------\n";
            }

            GenericoVisao.exibirMensagemInfo(mensagem);

        } catch (DadoInvalidoException e ) {
            GenericoVisao.exibirMensagemErro(e.getMessage());
        }
    }

    @Override
    public TipoPessoa buscar(String cpf) {
        try {

            TipoPessoa pessoa = pessoaServico.buscar(cpf);
            GenericoVisao.exibirMensagemInfo("Pessoa encontrado: " + pessoa.getNome());
            return pessoa;
            } catch (DadoInvalidoException e ) {
                GenericoVisao.exibirMensagemErro(e.getMessage());
            }
            return null;

    }

    @Override
    public void remover(String cpf) {
        try {
            pessoaServico.remover(cpf);
            GenericoVisao.exibirMensagemInfo("Registro do paciente com o " + cpf + " foi excluído com sucesso!");
        } catch (DadoInvalidoException e) {
            GenericoVisao.exibirMensagemErro(e.getMessage());
        }
    }
}
