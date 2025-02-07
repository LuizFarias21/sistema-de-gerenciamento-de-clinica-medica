package interfaces;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controladores.PacienteControlador;
import entidades.Paciente;

public class PacienteInterface extends BaseInterface {

    private PacienteControlador pacienteControlador;

    public PacienteInterface(PacienteControlador pacienteControlador) {
        this.pacienteControlador = pacienteControlador;
    }

    @Override
    public void exibirInterface() {
        while (true) {

            String[] opcoes = {"Cadrastar Pacientes", "Buscar Pacientes", "Listar Pacientes",
                    "Atualizar Pacientes", "Remover Pacientes", "Sair"};

            // Exibe a caixa de texto com a opção selecionada
            int escolha = JOptionPane.showOptionDialog(null, "Menu Paciente", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            // Verificar escolha do usuário
            switch (escolha) {
                case 0: // cadastrar paciente
                    cadastrarPacientes();
                    break;
                case 1: // buscar paciente
                    buscarPacientes();
                    break;
                case 2: // listar paciente
                    listarPaciente();
                    break;
                case 3: // atualiza paciente
                    // atualizarPaciente()
                    break;
                case 4: // remover paciente
                    // removerPaciente()
                    break;
                case 5: // sair
                    return;
            }
        }
    }

    // Método que permite o cadastro do paciente
    private void cadastrarPacientes() {
        String nome = JOptionPane.showInputDialog("Digite o nome do paciente:");
        String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente:");
        LocalDate dataNascimento = LocalDate.parse(JOptionPane.showInputDialog("Digite da data de nascimento do paciente (YYYY-MM-DD:)"));

        pacienteControlador.cadastrarPaciente(nome, cpf, dataNascimento);

    }

    // Método para buscar o paciente pelo CPF dele
    private void buscarPacientes() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente:");

        pacienteControlador.buscarPaciente(cpf);

    }

    private void listarPaciente() {

        String mensagem = pacienteControlador.listarPaciente();

        JOptionPane.showMessageDialog(null, mensagem, "Lista de pacientes:", JOptionPane.INFORMATION_MESSAGE);


    }

}

