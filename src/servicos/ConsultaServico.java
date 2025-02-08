package servicos;

import entidades.*;
import excecoes.EspecialidadeInvalidaException;
import excecoes.HorarioIndisponivelException;
import excecoes.LimiteConsultaAtingidoException;
import excecoes.PacienteIndisponivelException;
import repositorios.ConsultaRepositorio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ConsultaServico {

    private ConsultaRepositorio consultaRepositorio;
    private PacienteServico pacienteServico;
    private MedicoServico medicoServico;
    private Consulta consultaConflitante;

    public ConsultaServico(ConsultaRepositorio consultaRepositorio, PacienteServico pacienteServico, MedicoServico medicoServico) {
        this.consultaRepositorio = consultaRepositorio;
        this.pacienteServico = pacienteServico;
        this.medicoServico = medicoServico;
    }
}
