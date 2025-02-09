package servicos;

import entidades.*;
import excecoes.DadoInvalidoException;
import repositorios.ConsultaRepositorio;

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

    // Criação de uma nova consulta
    public void criarConsulta(Consulta consulta) throws DadoInvalidoException {

        // Verifica se o paciente e o médico existem pelo CPF
        if (pacienteServico.buscar(consulta.getPacienteAssociado().getCpf()) == null) {
            throw new DadoInvalidoException("Paciente não encontrado.");
        }
        if (medicoServico.buscar(consulta.getMedicoResponsavel().getCpf()) == null) {
            throw new DadoInvalidoException("Médico não encontrado.");
        }

        // Verifica se há conflito de horário
//        if (verificarConflitoDeHorario(consulta)) {
//            throw new IllegalArgumentException("Horário da consulta conflita com outra.");
//        }

        consultaRepositorio.salvar(consulta);
    }

    // Leitura: Buscar consulta por ID
    public Consulta buscarConsulta(String id) throws DadoInvalidoException {
        Consulta consulta = consultaRepositorio.buscar(id);
        if (consulta == null) {
            throw new DadoInvalidoException("Consulta não encontrada.");
        }
        return consulta;
    }

    // Atualização: Atualizar uma consulta existente
    public void atualizarConsulta(String consultaId, Consulta novaConsulta) throws DadoInvalidoException {
        Consulta consultaExistente = consultaRepositorio.buscar(consultaId);

        if (consultaExistente == null) {
            throw new DadoInvalidoException("Consulta não encontrada para atualização.");
        }

        // Verifica se o novo paciente e médico existem pelo CPF
        if (pacienteServico.buscar(novaConsulta.getPacienteAssociado().getCpf()) == null) {
            throw new DadoInvalidoException("Paciente não encontrado.");
        }
        if (medicoServico.buscar(novaConsulta.getMedicoResponsavel().getCpf()) == null) {
            throw new DadoInvalidoException("Médico não encontrado.");
        }

        // Verifica se há conflito de horário
//        if (verificarConflitoDeHorario(novaConsulta)) {
//            throw new IllegalArgumentException("Horário da consulta conflita com outra.");
//        }

        // Remove a consulta antiga e salva a nova
        consultaRepositorio.remover(consultaExistente);
        consultaRepositorio.salvar(novaConsulta);
    }

    // Faltou o método listar aqui!!

    // Exclusão: Remover uma consulta
    public void removerConsulta(String consultaId) throws DadoInvalidoException {
        Consulta consulta = consultaRepositorio.buscar(consultaId);
        if (consulta == null || !consultaRepositorio.remover(consulta)) {
            throw new DadoInvalidoException("Consulta não encontrada para remoção.");
        }
    }

    // Verificação de conflito de horário (exemplo simples)
//    private boolean verificarConflitoDeHorario(Consulta consulta) {
//        for (Consulta c : consultaRepositorio.listar()) {
//            if (c.getMedicoResponsavel().getCpf().equals(consulta.getMedicoResponsavel().getCpf()) && c.getHorario().equals(consulta.getHorario())) {
//                consultaConflitante = c;
//                return true;
//            }
//        }
//        return false;
//    }
}
