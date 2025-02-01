package excecoes;

import entidades.Consulta;

public class HorarioIndisponivelException extends Exception {
	Consulta m_consulta;
	
	public HorarioIndisponivelException(Consulta consulta) {
		super(String.format(
			"O horário da consulta já está ocupado: De %s a %s; Duração total: %s",
			consulta.getHorarioConsulta().toString(),
			consulta.getHorarioFinalConsulta().toString(),
			consulta.getDuracaoConsulta().toString()
		));
		m_consulta = consulta;
	}

	Consulta getConsulta() {
		return m_consulta;
	}
}
