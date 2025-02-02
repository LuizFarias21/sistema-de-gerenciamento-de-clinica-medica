package excecoes;

import entidades.Consulta;
import java.time.LocalTime;

public class HorarioIndisponivelException extends Exception {
	private final Consulta consultaConflitante;

    public HorarioIndisponivelException(Consulta consulta, LocalTime horarioInicialConsulta, LocalTime duracaoConsulta) {
		super(String.format(
			"O horário da consulta já está ocupado: De %s a %s; Duração total: %s",
				horarioInicialConsulta,
				//horarioInicialConsulta.plusHours(duracaoConsulta.getHour()).plusMinutes(duracaoConsulta.getMinute()),
				consulta.getHorarioInicialConsulta(),
				duracaoConsulta
		));
		this.consultaConflitante = consulta;
    }

	public Consulta getConsultaConflitante() {
		return consultaConflitante;
	}
}
