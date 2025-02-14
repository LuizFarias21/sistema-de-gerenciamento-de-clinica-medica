package visoes;

import javax.swing.*;

public abstract class GenericoVisao<TipoEntidade> {

    public static void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void exibirMensagemInfo(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public abstract void exibirVisao();

    public abstract void cadastrarVisao();

    public abstract void buscarVisao();

    public abstract void listarVisao();

    public abstract void atualizarVisao();

    public abstract void excluirVisao();
}
