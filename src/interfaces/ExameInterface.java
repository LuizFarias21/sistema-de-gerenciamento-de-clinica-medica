package interfaces;

import java.time.LocalDate;
import javax.swing.*;

import controladores.ExameControlador;

public class ExameInterface extends GenericoInterface {

    private ExameControlador exameControlador;

    public ExameInterface(ExameControlador exameControlador) {
        this.exameControlador = exameControlador;
    }

    @Override
    public void exibirInterface() {
        while (true) {

            String[] opcoes = {"Cadastrar Exame", "Buscar Exame", "Listar Exames",
                    "Atualizar Exame", "Remover Exame", "Voltar"};

            // Exibe a caixa de texto com a opção selecionada
            int escolha = JOptionPane.showOptionDialog(null, "Menu Exame", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            // Verificar escolha do usuário
            switch (escolha) {
                case 0: // cadastrar exame
                    cadastrar();
                    break;
                case 1: // buscar exame
                    buscar();
                    break;
                case 2: // listar exames
                    listar();
                    break;
                case 3: // atualizar exame
                    atualizar();
                    break;
                case 4: // remover exame
                    deletar();
                    break;
                case 5: // voltar
                    return;
            }
        }
    }

    @Override
    public void cadastrar() {
        String nome = JOptionPane.showInputDialog("Digite o nome do exame:");
        LocalDate dataExame = LocalDate.parse(JOptionPane.showInputDialog("Digite a data do exame (YYYY-MM-DD):"));
        
        // Supondo que o exame tenha um campo para o tipo, por exemplo:
        String tipo = JOptionPane.showInputDialog("Digite o tipo do exame:");

        exameControlador.cadastrarExame(nome, dataExame, tipo);
    }

    @Override
    public void buscar() {
        String nome = JOptionPane.showInputDialog("Digite o nome do exame:");
        exameControlador.buscarExame(nome);
    }

    @Override
    public void listar() {
        exameControlador.listarExames();
    }

    @Override
    public void atualizar() {
        String nome = JOptionPane.showInputDialog("Digite o nome do exame que deseja atualizar:");
        String novoNome = JOptionPane.showInputDialog("Digite o novo nome do exame:");
        LocalDate novaDataExame = LocalDate.parse(JOptionPane.showInputDialog("Digite a nova data do exame (YYYY-MM-DD):"));
        String novoTipo = JOptionPane.showInputDialog("Digite o novo tipo do exame:");

        exameControlador.atualizarExame(nome, novoNome, novaDataExame, novoTipo);
    }

    @Override
    public void deletar() {
        String nome = JOptionPane.showInputDialog("Digite o nome do exame:");
        exameControlador.excluirExame(nome);
    }

}
