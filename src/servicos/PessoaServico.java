package servicos;

import entidades.Pessoa;
import excecoes.DadoInvalidoException;
import repositorios.PessoaRepositorio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class PessoaServico<TipoPessoa extends Pessoa> extends GenericoServico<TipoPessoa> {

    private PessoaRepositorio<TipoPessoa> pessoaRepositorio;

    public PessoaServico(PessoaRepositorio<TipoPessoa> pessoaRepositorio) {
        super(pessoaRepositorio);
        this.pessoaRepositorio = pessoaRepositorio;
    }

    public void cadastrar(TipoPessoa pessoa) throws DadoInvalidoException {
        String cpf = pessoa.getCpf();

        if (validarCpf(cpf)) {
            throw new DadoInvalidoException("Cadastro bloqueado! Você precisa digitar um CPF válido!");
        }

        if (validarCpfDuplicado(cpf)) {
            throw new DadoInvalidoException("Cadastro bloqueado! Já existe um registro com o CPF: " + pessoa.getCpf());
        }

        pessoaRepositorio.cadastrar(pessoa);
    }

    @Override
    public TipoPessoa buscar(String cpf) throws DadoInvalidoException {
        TipoPessoa pessoa = pessoaRepositorio.buscar(cpf);

        if (validarCpf(cpf)) {
            throw new DadoInvalidoException("Você precisa digitar um CPF válido!");
        }

        if (pessoa == null) {
            throw new DadoInvalidoException("Nenhum registro encontrado para o CPF: " + cpf);
        }
        return pessoa;
    }

    public boolean validarCpf(String cpf) {

        // Segue o formato XXX.XXX.XXX-XX?
        Pattern cpfPattern = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}");
        Matcher cpfMatcher = cpfPattern.matcher(cpf);
        boolean validarPadrao = cpfMatcher.matches();
        boolean validarCampo = cpf.trim().isEmpty();

        if (!validarPadrao || validarCampo) return true;
        return false;
    }

    public boolean validarCpfDuplicado(String cpf) {
        for (Pessoa pessoa : pessoaRepositorio.getListaPessoas()) {
            if (pessoa.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public void atualizar(TipoPessoa pessoa, TipoPessoa novaEntidade) throws DadoInvalidoException {
        String cpf = novaEntidade.getCpf();

        if (validarCpf(cpf)) {
            throw new DadoInvalidoException("Atualização bloqueada! Você precisa digitar um CPF válido!");
        }

        if (validarCpfDuplicado(cpf)) {
            throw new DadoInvalidoException("Atualização bloqueada! Já existe um registro com o CPF: " + novaEntidade.getCpf());
        }

        pessoaRepositorio.atualizar(pessoa, novaEntidade);
    }
}


