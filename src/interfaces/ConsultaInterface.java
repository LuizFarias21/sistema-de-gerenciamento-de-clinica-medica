package interfaces;

<<<<<<< Updated upstream
=======
<<<<<<< Updated upstream
=======
>>>>>>> Stashed changes
import java.time.LocalDateTime;
import javax.swing.*;

import controladores.ConsultaControlador;
import entidades.Medico;
import entidades.Paciente;
<<<<<<< Updated upstream

=======
import excecoes.DadoInvalidoException;
import servicos.MedicoServico;
import servicos.PacienteServico;

>>>>>>> Stashed changes
>>>>>>> Stashed changes
public class ConsultaInterface extends GenericoInterface {

    private ConsultaControlador consultaControlador;

    public ConsultaInterface(ConsultaControlador consultaControlador) {
        this.consultaControlador = consultaControlador;
    }

    @Override
    public void exibirInterface() {
        while (true) {
            String[] opcoes = {"Cadastrar Consulta", "Buscar Consulta", "Listar Consultas",
                    "Atualizar Consulta", "Remover Consulta", "Voltar"};

            int escolha = JOptionPane.showOptionDialog(null, "Menu Consulta", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0: // Cadastrar consulta
                    cadastrar();
                    break;
                case 1: // Buscar consulta
                    buscar();
                    break;
                case 2: // Listar consultas
                    listar();
                    break;
                case 3: // Atualizar consulta
                    atualizar();
                    break;
                case 4: // Remover consulta
                    deletar();
                    break;
                case 5: // Voltar
                    return;
            }
        }
    }

    @Override
    public void cadastrar() {

<<<<<<< Updated upstream
    }

//    @Override
//    public void cadastrar() {
//        // Que ID? 🤔
//        String id = JOptionPane.showInputDialog("Digite o ID da consulta:");
//        String cpfPaciente = JOptionPane.showInputDialog("Digite o CPF do paciente:");
//        String cpfMedico = JOptionPane.showInputDialog("Digite o CPF do médico:");
//        LocalDateTime horario = LocalDateTime.parse(JOptionPane.showInputDialog("Digite o horário da consulta (YYYY-MM-DDTHH:MM):"));
//
//        // Paciente e médico não aceitam só 1 parâmetro!
////        Paciente paciente = new Paciente(cpfPaciente);  // Assumindo que há um construtor que aceita apenas CPF
////        Medico medico = new Medico(cpfMedico); // Assumindo o mesmo para Médico
//
//        consultaControlador.criarConsulta(id, paciente, medico, horario);
//    }

    @Override
    public void buscar() {
<<<<<<< Updated upstream
        String id = JOptionPane.showInputDialog("Digite o ID da consulta:");
        consultaControlador.buscarConsulta(id);
=======

=======
        Paciente paciente = PacienteServico.buscarPaciente(cpfPaciente);
        if (paciente == null) {
            JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
            return;
        }

        Medico medico = MedicoServico.buscarMedicoResponsavel(cpfMedico);
        if (medico == null) {
            JOptionPane.showMessageDialog(null, "Médico não encontrado.");
            return;
        }


        consultaControlador.criarConsulta(id, paciente, medico, horario);
    }

    @Override
    public void buscar() throws DadoInvalidoException {
        String id = JOptionPane.showInputDialog("Digite o ID da consulta:");
        consultaControlador.buscarConsulta(id);
>>>>>>> Stashed changes
>>>>>>> Stashed changes
    }

    @Override
    public void listar() {
        JOptionPane.showMessageDialog(null, "Método de listar consultas ainda não implementado.");
    }

    @Override
    public void atualizar() {

<<<<<<< Updated upstream
=======
        Paciente novoPaciente = new Paciente(cpfPaciente, cpfMedico, null, null);
        Medico novoMedico = new Medico(cpfMedico, cpfMedico, null, cpfMedico, cpfMedico, null);

        consultaControlador.atualizarConsulta(id, novoPaciente, novoMedico, novoHorario);
>>>>>>> Stashed changes
    }

//    @Override
//    public void atualizar() {
//        String id = JOptionPane.showInputDialog("Digite o ID da consulta que deseja atualizar:");
//        String cpfPaciente = JOptionPane.showInputDialog("Digite o novo CPF do paciente:");
//        String cpfMedico = JOptionPane.showInputDialog("Digite o novo CPF do médico:");
//        LocalDateTime novoHorario = LocalDateTime.parse(JOptionPane.showInputDialog("Digite o novo horário da consulta (YYYY-MM-DDTHH:MM):"));
//
//        // Paciente e médico não aceitam só 1 parâmetro!
//        //Paciente novoPaciente = new Paciente(cpfPaciente);
//        //Medico novoMedico = new Medico(cpfMedico);
//
//        consultaControlador.atualizarConsulta(id, novoPaciente, novoMedico, novoHorario);
//    }

    @Override
    public void deletar() {
<<<<<<< Updated upstream
        String id = JOptionPane.showInputDialog("Digite o ID da consulta:");
        consultaControlador.removerConsulta(id);
=======
<<<<<<< Updated upstream

=======
        String id = JOptionPane.showInputDialog("Digite o ID da consulta:");
        try {
			consultaControlador.removerConsulta(id);
		} catch (DadoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
>>>>>>> Stashed changes
>>>>>>> Stashed changes
    }
}
