package excecoes;

import entidades.Consulta;
import java.time.LocalTime;

public class HorarioIndisponivelException extends Exception {

    public HorarioIndisponivelException(Consulta consulta) {
		super(String.format(
			"O horário da consulta já está ocupado: De %s a %s; Duração total: %s",
				consulta.getHorarioInicialConsulta(),
				consulta.getHorarioFinalConsulta(),
				consulta.getDuracaoConsulta()
		));
    }

}
