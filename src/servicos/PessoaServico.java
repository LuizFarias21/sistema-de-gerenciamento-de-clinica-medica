package servicos;

import entidades.Pessoa;
import excecoes.CpfInvalidoException;
import repositorios.PessoaRepositorio;

import java.util.ArrayList;

public class PessoaServico<T extends Pessoa> {

    private PessoaRepositorio<T> pessoaRepositorio;

    public PessoaServico(PessoaRepositorio<T> pessoaRepositorio) {
        this.pessoaRepositorio = pessoaRepositorio;
    }

    public void cadastrar(T t) throws CpfInvalidoException {
        if (pessoaRepositorio.buscar(t.getCpf()) != null) {
            throw new CpfInvalidoException("Cadastro bloqueado! Já existe um registro com o CPF: " + t.getCpf());
        }
        pessoaRepositorio.salvar(t);
    }

    public T buscar(String cpf) throws CpfInvalidoException {
        T t = pessoaRepositorio.buscar(cpf);
        if (t == null) {
            throw new CpfInvalidoException("Nenhum registro encontrado para o CPF: " + cpf);
        }
        return t;
    }

    public ArrayList<T> listar() {
        return pessoaRepositorio.listar();
    }
}


