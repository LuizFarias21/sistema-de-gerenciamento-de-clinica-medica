package visoes;

import javax.swing.*;

import excecoes.DadoInvalidoException;

public abstract class GenericoVisao {

    public void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void exibirMensagemInfo(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public abstract void exibirVisao() throws DadoInvalidoException;

    public abstract void cadastrarVisao() throws DadoInvalidoException;

    public abstract void buscarVisao() throws DadoInvalidoException;

    public abstract void listarVisao() throws DadoInvalidoException;

    public abstract void atualizarVisao();

    public abstract void excluirVisao() throws DadoInvalidoException;
}
