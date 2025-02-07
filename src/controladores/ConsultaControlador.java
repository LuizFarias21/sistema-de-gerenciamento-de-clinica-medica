package controladores;

import entidades.Consulta;
import entidades.Medico;
import entidades.Paciente;
import entidades.Prescricao;
import servicos.ConsultaServico;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConsultaControlador {
    private ConsultaServico consultaServico;

    public ConsultaControlador(ConsultaServico consultaServico) {
        this.consultaServico = consultaServico;
    }

    public void agendarConsulta(
                                LocalDate dataAgendada,
                                LocalTime horarioInicialConsulta,
                                LocalTime duracaoConsulta,
                                Paciente pacienteAssociado,
                                Medico medicoResponsavel,
                                Prescricao prescricao,
                                String especialidadeRequerida,
                                double valor) {

        Consulta novaConsulta = new Consulta(dataAgendada, horarioInicialConsulta, duracaoConsulta, Consulta.Status.AGENDADA, pacienteAssociado, medicoResponsavel, prescricao, especialidadeRequerida, valor);

        if (pacienteAssociado == null || medicoResponsavel == null || especialidadeRequerida == null) {
            throw new IllegalArgumentException("Erro! Você precisa inserir todos os dados corretamente!");
        }
        consultaServico.agendarConsulta(novaConsulta);
    }

    public void cancelarConsulta(Consulta consulta) {

        if (consulta == null) {
            System.out.println("Não existe essa consulta, portanto não pode ser cancelada!");
            return;
        }
        consultaServico.cancelarConsulta(consulta);
    }
}
