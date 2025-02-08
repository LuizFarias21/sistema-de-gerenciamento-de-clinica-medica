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

}
