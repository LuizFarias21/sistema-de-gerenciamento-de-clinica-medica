package repositorios;

import entidades.Consulta;
import entidades.Pessoa;
import excecoes.CadastroBloqueadoException;

import repositorios.CrudRepositorio;

import javax.swing.*;

public abstract class PessoaRepositorio<TipoPessoa extends Pessoa> extends CrudRepositorio<TipoPessoa> {

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

}
