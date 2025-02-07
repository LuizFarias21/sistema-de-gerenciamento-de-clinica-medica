package interfaces;

import javax.swing.*;

public abstract class BaseInterface {

    public void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void exibirMensagemInfo(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public abstract void exibirInterface();


}
