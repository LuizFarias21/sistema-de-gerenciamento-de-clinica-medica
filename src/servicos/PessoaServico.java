package servicos;

import entidades.Pessoa;
import excecoes.DadoInvalidoException;
import repositorios.PessoaRepositorio;
import java.util.ArrayList;

public class PessoaServico<TipoPessoa extends Pessoa> extends GenericoServico<TipoPessoa> {

    private PessoaRepositorio<TipoPessoa> pessoaRepositorio;

    public PessoaServico(PessoaRepositorio<TipoPessoa> pessoaRepositorio) {
        this.pessoaRepositorio = pessoaRepositorio;
    }

    @Override
    public void cadastrar(TipoPessoa tipoPessoa) throws DadoInvalidoException {
        if (pessoaRepositorio.buscar(tipoPessoa.getCpf()) != null) {
            throw new DadoInvalidoException("Cadastro bloqueado! Já existe um registro com o CPF: " + tipoPessoa.getCpf());
        }
        pessoaRepositorio.salvar(tipoPessoa);
    }

    @Override
    public TipoPessoa buscar(String cpf) throws DadoInvalidoException {
        TipoPessoa tipoPessoa = pessoaRepositorio.buscar(cpf);
        if (tipoPessoa == null) {
            throw new DadoInvalidoException("Nenhum registro encontrado para o CPF: " + cpf);
        }
        return tipoPessoa;
    }

    @Override
    public ArrayList<TipoPessoa> listar() throws DadoInvalidoException {
        if (pessoaRepositorio.listar().isEmpty()) {
            throw new DadoInvalidoException("Nenhum registro encontrado!");
        }
        return pessoaRepositorio.listar();
    }

    @Override
    public void atualizar(TipoPessoa tipoPessoa, TipoPessoa novaEntidade) throws DadoInvalidoException {

    }

//    public void atualizar(String cpf, String novoNome, String novoCpf, LocalDate novaDataNascimento) throws DadoInvalidoException {
//        Pessoa pessoa = pessoaRepositorio.buscar(cpf);
//        if (pessoa == null) {
//            throw new DadoInvalidoException("Nenhum registro encontrado!");
//        }
//        pessoaRepositorio.remover(pessoa);
//        Pessoa novaPessoa = (Pessoa) new Paciente(novoNome, novoCpf, novaDataNascimento, ((Paciente) pessoa).getHistoricoMedico());
//        pessoaRepositorio.salvar(novaPessoa);
//        //pessoaRepositorio.atualizar(t, novaT);
//    }

    @Override
    public void excluir(String cpf) throws DadoInvalidoException {
        TipoPessoa tipoPessoa = pessoaRepositorio.buscar(cpf);
        if (tipoPessoa == null) {
            throw new DadoInvalidoException("Nenhum registro encontrado para o CPF: " + cpf);
        }
        pessoaRepositorio.remover(tipoPessoa);
    }
}


