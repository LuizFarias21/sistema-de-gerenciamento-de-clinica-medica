package visoes;

import java.time.LocalDate;
import javax.swing.*;

import controladores.PacienteControlador;

public class PacienteVisao extends GenericoVisao {

    private PacienteControlador pacienteControlador;

    public PacienteVisao(PacienteControlador pacienteControlador) {
        this.pacienteControlador = pacienteControlador;
    }

    @Override
    public void exibirVisao() {
        while (true) {

            String[] opcoes = {"Cadrastar Pacientes", "Buscar Pacientes", "Listar Pacientes",
                    "Atualizar Pacientes", "Remover Pacientes", "Voltar"};

            // Exibe a caixa de texto com a opção selecionada
            int escolha = JOptionPane.showOptionDialog(null, "Menu Paciente", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            // Verificar escolha do usuário
            switch (escolha) {
                case 0: // cadastrar paciente
                    cadastrarVisao();
                    break;
                case 1: // buscar paciente
                    buscarVisao();
                    break;
                case 2: // listar paciente
                    listarVisao();
                    break;
                case 3: // atualiza paciente
                    atualizarVisao();
                    break;
                case 4: // remover paciente
                    excluirVisao();
                    break;
                case 5: // sair
                    return;
            }
        }
    }

    @Override
    public void cadastrarVisao() {
        String nome = JOptionPane.showInputDialog("Digite o nome do paciente:");
        String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente:");
        LocalDate dataNascimento = LocalDate.parse(JOptionPane.showInputDialog("Digite da data de nascimento do paciente (YYYY-MM-DD:)"));

        pacienteControlador.cadastrarPaciente(nome, cpf, dataNascimento);
    }

    @Override
    public void buscarVisao() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente:");
        pacienteControlador.buscarPaciente(cpf);
    }

    @Override
    public void listarVisao() {
        pacienteControlador.listarPaciente();
    }

    @Override
    public void atualizarVisao() {

    }

//    @Override
//    public void atualizar() {
//        String novoCpf = JOptionPane.showInputDialog("Digite o novo CPF do paciente:");
//        String novoNome = JOptionPane.showInputDialog("Digite o novo nome do paciente:");
//        LocalDate novaDataNascimento = LocalDate.parse(JOptionPane.showInputDialog("Digite a nova data de nascimento do paciente (YYYY-MM-DD:)"));
//
//        String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente que deseja atualizar os dados:");
//        pacienteControlador.atualizarPaciente(cpf, novoCpf, novoNome, novaDataNascimento);
//    }

    @Override
    public void excluirVisao() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente:");
        pacienteControlador.excluirPaciente(cpf);
    }

}

