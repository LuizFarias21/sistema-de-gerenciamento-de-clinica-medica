package interfaces;

import java.time.LocalDate;
import javax.swing.*;

import controladores.MedicoControlador;

public class MedicoInterface extends GenericoInterface {

    private MedicoControlador medicoControlador;

    public MedicoInterface(MedicoControlador medicoControlador) {
        this.medicoControlador = medicoControlador;
    }

    @Override
    public void exibirInterface() {
        while (true) {

            String[] opcoes = {"Cadastrar Médicos", "Buscar Médicos", "Listar Médicos",
                    "Atualizar Médicos", "Remover Médicos", "Voltar"};

            // Exibe a caixa de texto com a opção selecionada
            int escolha = JOptionPane.showOptionDialog(null, "Menu Médico", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            // Verificar escolha do usuário
            switch (escolha) {
                case 0: // cadastrar médico
                    cadastrar();
                    break;
                case 1: // buscar médico
                    buscar();
                    break;
                case 2: // listar médicos
                    listar();
                    break;
                case 3: // atualizar médico
                    atualizar();
                    break;
                case 4: // remover médico
                    deletar();
                    break;
                case 5: // sair
                    return;
            }
        }
    }

    @Override
    public void cadastrar() {
        String nome = JOptionPane.showInputDialog("Digite o nome do médico:");
        String cpf = JOptionPane.showInputDialog("Digite o CPF do médico:");
        LocalDate dataNascimento = LocalDate.parse(JOptionPane.showInputDialog("Digite a data de nascimento do médico (YYYY-MM-DD):"));
        String crm = JOptionPane.showInputDialog("Digite o CRM do médico:");
        String especialidade = JOptionPane.showInputDialog("Digite a especialidade do médico:");

        medicoControlador.cadastrarMedico(nome, cpf, dataNascimento, crm, especialidade);
    }

    @Override
    public void buscar() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do médico:");
        medicoControlador.buscarMedico(cpf);
    }

    @Override
    public void listar() {
        medicoControlador.listarMedicos();
    }

    @Override
    public void atualizar() {
        String novoCpf = JOptionPane.showInputDialog("Digite o novo CPF do médico:");
        String novoNome = JOptionPane.showInputDialog("Digite o novo nome do médico:");
        LocalDate novaDataNascimento = LocalDate.parse(JOptionPane.showInputDialog("Digite a nova data de nascimento do médico (YYYY-MM-DD):"));
        String novoCrm = JOptionPane.showInputDialog("Digite o novo CRM do médico:");
        String novaEspecialidade = JOptionPane.showInputDialog("Digite a nova especialidade do médico:");

        String cpf = JOptionPane.showInputDialog("Digite o CPF do médico que deseja atualizar os dados:");
        medicoControlador.atualizarMedico(cpf, novoNome, novoCpf, novaDataNascimento, novoCrm, novaEspecialidade);
    }

    @Override
    public void deletar() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do médico:");
        medicoControlador.excluirMedico(cpf);
    }
}
