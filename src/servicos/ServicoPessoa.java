package servicos;

import entidades.Pessoa;
import excecoes.CadastroBloqueadoException;

import javax.swing.*;

public class ServicoPessoa<TipoPessoa extends Pessoa> extends ServicoCrud<TipoPessoa> {

    @Override
    public void salvar(TipoPessoa pessoa) {

        if (buscar(pessoa.getCpf()) == null) {
            getListaEntidades().add(pessoa);
            return;
        }

        try {
            throw new CadastroBloqueadoException(pessoa);
        } catch (CadastroBloqueadoException e) {
            JOptionPane.showMessageDialog(null,
                    "O CPF " + pessoa.getCpf() + " já está cadastrado!",
                    "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public TipoPessoa buscar(String cpf) {
        for (TipoPessoa pessoa : getListaEntidades()){
            if(pessoa.getCpf().equals(cpf)){
                return pessoa;
            }
        }
        return null;
    }

    @Override
    public boolean atualizar(TipoPessoa pessoa, TipoPessoa novaPessoa) {
        if (pessoa != null) {

            pessoa.setNome(novaPessoa.getNome());
            pessoa.setCpf(novaPessoa.getCpf());
            pessoa.setDataNascimento(novaPessoa.getDataNascimento());

            return true;
        }
        return false;
    }
}
