package interfaces;

import java.time.LocalDate;
import javax.swing.*;

import controladores.PacienteControlador;

public class PacienteInterface extends GenericoInterface {

    private PacienteControlador pacienteControlador;

    public PacienteInterface(PacienteControlador pacienteControlador) {
        this.pacienteControlador = pacienteControlador;
    }

    @Override
    public void exibirInterface() {
        while (true) {

            String[] opcoes = {"Cadrastar Pacientes", "Buscar Pacientes", "Listar Pacientes",
                    "Atualizar Pacientes", "Remover Pacientes", "Voltar"};

            // Exibe a caixa de texto com a opção selecionada
            int escolha = JOptionPane.showOptionDialog(null, "Menu Paciente", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            // Verificar escolha do usuário
            switch (escolha) {
                case 0: // cadastrar paciente
                    cadastrar();
                    break;
                case 1: // buscar paciente
                    buscar();
                    break;
                case 2: // listar paciente
                    listar();
                    break;
                case 3: // atualiza paciente
                    atualizar();
                    break;
                case 4: // remover paciente
                    deletar();
                    break;
                case 5: // sair
                    return;
            }
        }
    }

    @Override
    public void cadastrar() {
        String nome = JOptionPane.showInputDialog("Digite o nome do paciente:");
        String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente:");
        LocalDate dataNascimento = LocalDate.parse(JOptionPane.showInputDialog("Digite da data de nascimento do paciente (YYYY-MM-DD:)"));

        pacienteControlador.cadastrarPaciente(nome, cpf, dataNascimento);
    }

    @Override
    public void buscar() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente:");
        pacienteControlador.buscarPaciente(cpf);
    }

    @Override
    public void listar() {
        pacienteControlador.listarPaciente();
    }

    @Override
    public void atualizar() {
        String novoCpf = JOptionPane.showInputDialog("Digite o novo CPF do paciente:");
        String novoNome = JOptionPane.showInputDialog("Digite o novo nome do paciente:");
        LocalDate novaDataNascimento = LocalDate.parse(JOptionPane.showInputDialog("Digite a nova data de nascimento do paciente (YYYY-MM-DD:)"));

        String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente que deseja atualizar os dados:");
        pacienteControlador.atualizarPaciente(cpf, novoCpf, novoNome, novaDataNascimento);
    }

    @Override
    public void deletar() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente:");
        pacienteControlador.excluirPaciente(cpf);
    }

}

