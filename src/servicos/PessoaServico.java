package servicos;

import entidades.Paciente;
import entidades.Pessoa;
import excecoes.DadoInvalidoException;
import repositorios.PessoaRepositorio;

import java.time.LocalDate;
import java.util.ArrayList;

public class PessoaServico<T extends Pessoa> {

    private PessoaRepositorio<T> pessoaRepositorio;

    public PessoaServico(PessoaRepositorio<T> pessoaRepositorio) {
        this.pessoaRepositorio = pessoaRepositorio;
    }

    public void cadastrar(T t) throws DadoInvalidoException {
        if (pessoaRepositorio.buscar(t.getCpf()) != null) {
            throw new DadoInvalidoException("Cadastro bloqueado! Já existe um registro com o CPF: " + t.getCpf());
        }
        pessoaRepositorio.salvar(t);
    }

    public T buscar(String cpf) throws DadoInvalidoException {
        T t = pessoaRepositorio.buscar(cpf);
        if (t == null) {
            throw new DadoInvalidoException("Nenhum registro encontrado para o CPF: " + cpf);
        }
        return t;
    }

    public ArrayList<T> listar() throws DadoInvalidoException {
        if (pessoaRepositorio.listar().isEmpty()) {
            throw new DadoInvalidoException("Nenhum registro encontrado!");
        }
        return pessoaRepositorio.listar();
    }

    public void atualizar(String cpf, String novoNome, String novoCpf, LocalDate novaDataNascimento) throws DadoInvalidoException {
        T t = pessoaRepositorio.buscar(cpf);
        if (t == null) {
            throw new DadoInvalidoException("Nenhum registro encontrado!");
        }
        pessoaRepositorio.remover(t);
        T novaT = (T) new Paciente(novoNome, novoCpf, novaDataNascimento, ((Paciente) t).getHistoricoMedico());
        pessoaRepositorio.salvar(novaT);
        //pessoaRepositorio.atualizar(t, novaT);
    }

    public void excluir(String cpf) throws DadoInvalidoException {
        T t = pessoaRepositorio.buscar(cpf);
        if (t == null) {
            throw new DadoInvalidoException("Nenhum registro encontrado para o CPF: " + cpf);
        }
        pessoaRepositorio.remover(t);
    }
}


