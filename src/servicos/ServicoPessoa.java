package servicos;

import entidades.Pessoa;
import excecoes.CadastroBloqueadoException;

import javax.swing.*;

public class ServicoPessoa<TipoPessoa extends Pessoa> extends ServicoCRUD<TipoPessoa> {

    @Override
    public void salvar(TipoPessoa pessoa) {

        if (buscar(pessoa.getCPF()) == null) {
            getListaEntidades().add(pessoa);
            return;
        }

        try {
            throw new CadastroBloqueadoException(pessoa);
        } catch (CadastroBloqueadoException e) {
            JOptionPane.showMessageDialog(null,
                    "O CPF " + pessoa.getCPF() + " já está cadastrado!",
                    "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public TipoPessoa buscar(String CPF) {
        for (TipoPessoa pessoa : getListaEntidades()){
            if(pessoa.getCPF().equals(CPF)){
                return pessoa;
            }
        }
        return null;
    }

    @Override
    public boolean atualizar(TipoPessoa pessoa, TipoPessoa novaPessoa) {
        if (pessoa != null) {

            pessoa.setNome(novaPessoa.getNome());
            pessoa.setCPF(novaPessoa.getCPF());
            pessoa.setDataNascimento(novaPessoa.getDataNascimento());

            return true;
        }
        return false;
    }
}
