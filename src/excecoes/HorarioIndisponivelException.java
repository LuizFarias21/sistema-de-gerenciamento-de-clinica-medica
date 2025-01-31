package excecoes;

import java.time.Duration;

import entidades.Consulta;

public class HorarioIndisponivelException extends Exception {
	Consulta m_consulta;
	
	public HorarioIndisponivelException(Consulta consulta) {
		super(String.format(
			"O horário da consulta já está ocupado: De %s a %s; Duração total: %s",
			consulta.getHorarioConsulta().toString(),
			consulta.getHorarioConsulta().plus(Duration.ofMinutes(consulta.getDuracaoConsulta().getMinute())).toString(),
			consulta.getDuracaoConsulta().toString()
		));
		m_consulta = consulta;
	}

	Consulta getConsulta() {
		return m_consulta;
	}
}
