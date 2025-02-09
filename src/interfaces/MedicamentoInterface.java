package interfaces;

import java.time.LocalDate;
import javax.swing.*;

import controladores.MedicamentoControlador;

public class MedicamentoInterface extends GenericoInterface {

    private MedicamentoControlador medicamentoControlador;

    public MedicamentoInterface(MedicamentoControlador medicamentoControlador) {
        this.medicamentoControlador = medicamentoControlador;
    }

    @Override
    public void exibirInterface() {
        while (true) {

            String[] opcoes = {"Cadastrar Medicamento", "Buscar Medicamento", "Listar Medicamentos",
                    "Atualizar Medicamento", "Remover Medicamento", "Voltar"};

            // Exibe a caixa de texto com a opção selecionada
            int escolha = JOptionPane.showOptionDialog(null, "Menu Medicamento", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            // Verificar escolha do usuário
            switch (escolha) {
                case 0: // cadastrar medicamento
                    cadastrar();
                    break;
                case 1: // buscar medicamento
                    buscar();
                    break;
                case 2: // listar medicamentos
                    listar();
                    break;
                case 3: // atualizar medicamento
                    atualizar();
                    break;
                case 4: // remover medicamento
                    deletar();
                    break;
                case 5: // voltar
                    return;
            }
        }
    }

    @Override
    public void cadastrar() {
        String nome = JOptionPane.showInputDialog("Digite o nome do medicamento:");
        String laboratorio = JOptionPane.showInputDialog("Digite o nome do laboratório:");
        LocalDate validade = LocalDate.parse(JOptionPane.showInputDialog("Digite a data de validade (YYYY-MM-DD):"));

        medicamentoControlador.cadastrarMedicamento(nome, laboratorio, validade);
    }

    @Override
    public void buscar() {
        String nome = JOptionPane.showInputDialog("Digite o nome do medicamento:");
        medicamentoControlador.buscarMedicamento(nome);
    }

    @Override
    public void listar() {
        medicamentoControlador.listarMedicamentos();
    }

    @Override
    public void atualizar() {
        String nome = JOptionPane.showInputDialog("Digite o nome do medicamento que deseja atualizar:");
        String novoNome = JOptionPane.showInputDialog("Digite o novo nome do medicamento:");
        String novoLaboratorio = JOptionPane.showInputDialog("Digite o novo laboratório:");
        LocalDate novaValidade = LocalDate.parse(JOptionPane.showInputDialog("Digite a nova data de validade (YYYY-MM-DD):"));

        medicamentoControlador.atualizarMedicamento(nome, novoNome, novoLaboratorio, novaValidade);
    }

    @Override
    public void deletar() {
        String nome = JOptionPane.showInputDialog("Digite o nome do medicamento:");
        medicamentoControlador.excluirMedicamento(nome);
    }

}
