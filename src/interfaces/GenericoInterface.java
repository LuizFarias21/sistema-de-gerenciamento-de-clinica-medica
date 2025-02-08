package interfaces;

import javax.swing.*;

public abstract class GenericoInterface {

    public void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void exibirMensagemInfo(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public abstract void exibirInterface();

    public abstract void cadastrar();

    public abstract void buscar();

    public abstract void listar();

    public abstract void atualizar();

    public abstract void deletar();
}
